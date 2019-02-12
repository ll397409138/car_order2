package com.car.app.carscraporder.util;

import java.io.File; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.List; 
import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutionException; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.Future; 
import java.util.concurrent.ThreadFactory; 
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.model.PartETag; 
import com.aliyun.oss.ClientException; 
import com.aliyun.oss.OSSClient; 
import com.aliyun.oss.OSSErrorCode; 
import com.aliyun.oss.OSSException; 
import com.aliyun.oss.model.CannedAccessControlList; 
import com.aliyun.oss.model.CompleteMultipartUploadRequest; 
import com.aliyun.oss.model.InitiateMultipartUploadRequest; 
import com.aliyun.oss.model.InitiateMultipartUploadResult; 
import com.aliyun.oss.model.ObjectMetadata;


public class OSSUploadFile implements Callable{ 
	private static final Logger logger = LoggerFactory 
			.getLogger(OSSUploadFile.class);
	
	
	    //内层线程池
		private ExecutorService pool ;
		private MultipartFile sourcePath;//原文件路径
		private String bucketName;//bucketName
		private String key;//云端存储路径
	   //外层线程池
	   public static ExecutorService uploadMainPool = null;
	
	
	static{
	    uploadMainPool = Executors.newFixedThreadPool(Constant.CONCURRENT_FILE_NUMBER,new ThreadFactory() {
	        public Thread newThread(Runnable r) {
	            Thread s = Executors.defaultThreadFactory().newThread(r);
	            s.setDaemon(true);
	            return s;
	        }
	    });
	}
	
	/**
	 * oss上传 支持断点续传
	 * @param sourcePath    源文件路径
	 * @param bucketName    bucketName
	 * @param key           存储key  -在oss的存储路径
	 */
	public OSSUploadFile(MultipartFile sourcePath,String bucketName,String key) {
	    //实例化单文件上次线程池
	    pool = Executors.newFixedThreadPool(Constant.SINGLE_FILE_CONCURRENT_THREADS);
	    this.sourcePath = sourcePath;
	    this.bucketName = bucketName;
	    this.key = key;
	}

	/**
	 * 执行当前线程
	 * @return
	 */
	@SuppressWarnings("finally")
	public Integer uploadFile() {
	    Integer r = Global.ERROR;
	     //向uploadMainPool中submit当前线程
	    Future<Integer> result = uploadMainPool.submit(this);
	    try {
	        r=result.get();
	    } catch (ExecutionException e) {
	        e.printStackTrace();
	    } finally{
	        return r;
	    }

	}


	/**
	 * oss上传
	 * @param sourcePath    源文件路径
	 * @param bucketName    bucketName
	 * @param key           存储key  存储路径
	 * @return Integer
	 */
	@Override
	public Integer call(){

	    OSSClient client  = OssUtil.getOSSClient();    

	    //File uploadFile = new File(sourcePath);
	    /*if (!sourcePath.exists()){ 

	        return Global.FILE_NOT_FOUND_ERROR;
	    }*/
	    int result = Global.ERROR;

	    key = key.contains("\\\\")?key.replaceAll("\\\\", "/"):key.contains("\\")?key.replaceAll("\\", "/"):key; 
	    // 准备Bucket
	    result = ensureBucket(client,bucketName);
	    if(result == Global.ERROR )return result;
	    // 使用multipart的方式上传文件
	    result = uploadBigFile(client, bucketName, key, sourcePath);
	    pool = null;
	    return result;
	}


	// 通过Multipart的方式上传一个大文件
	private int uploadBigFile(OSSClient client, String bucketName, String key,
	        MultipartFile uploadFile)  {

	    //自定义的每个上传分块大小
	    Integer partSize = Constant.UPLOAD_PART_SIZE;

	    //需要上传的文件分块数
	    int partCount = calPartCount(uploadFile,partSize);

	    //文件的MD5值
	    String fileDM5Str = "";
	    String uploadId = "";

	    //序列化的文件路径（与上传文件同路径使用.up.temp后缀）

	    String serializationFilePath =File.separator+ "tmp"+File.separator+"vide.mp4"+".up.temp";

	    boolean isSerializationFile = false;

	    //子线程池的线程对象封装类（用于序列化的）
	    UploadPartObj uploadPartObj = null;
	    //获取文件MD5值
	    fileDM5Str = MD5Util.getFileMD5(uploadFile);

	    //若存在上传失败留下的序列化文件则反序列化对象
	    if(new File(serializationFilePath).exists()){
	        uploadPartObj = (UploadPartObj)ObjectSerializableUtil.deserialization(serializationFilePath);
	        isSerializationFile = true;
	    }       

	    //序列化文件不存在，分配分块给子线程池线程对象
	    if(uploadPartObj==null||!isSerializationFile){
	        uploadPartObj = new UploadPartObj();
	        try {
	            //初始化MultipartUpload 返回uploadId  
	            uploadId = initMultipartUpload(client, bucketName, key,fileDM5Str);
	        } catch (Exception e) {
	            e.printStackTrace();

	            return Global.OSS_SUBMIT_ERROR;
	        } 
	        for (int i = 0; i < partCount ; i++) {
	            long start = partSize * i;
	            long curPartSize = partSize < uploadFile.getSize() - start ?
	                    partSize : uploadFile.getSize() - start;
	          //构造上传线程，UploadPartThread是执行每个分块上传任务的线程

	         uploadPartObj.getUploadPartThreads().add(new UploadPartThread(client, bucketName, key,uploadFile, uploadId, i + 1,partSize * i, curPartSize));
	        }
	    }

	    try {
	        int i = 0;
	        //upload方法提交分块上传线程至子线程池上传，while循环用于上传失败重复上传，Constant.RETRY定义重复次数
	        while (upload(uploadPartObj,serializationFilePath).isResult()==false) {
	            if(++i == Constant.RETRY)break;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();

	        return Global.THREAD_ERROR;
	    } 

	    if(!uploadPartObj.isResult()){
	        return Global.NETWORK_ERROR;
	    }
	    try {
	        //完成一个multi-part请求。
	        completeMultipartUpload(client, bucketName, key, uploadPartObj);
	    } catch (Exception e) {
	        e.printStackTrace();
	        logger.error("multi-part请求失败！！");
	       ObjectSerializableUtil.serialization(uploadPartObj,serializationFilePath);
	        return Global.OSS_SUBMIT_ERROR;
	    }
	    return Global.SUCCESS;
	}

	/**
	 * 多线程上传单个文件
	 * @param uploadPartObj
	 * @param serializationFilePath
	 * @return
	 */
	private UploadPartObj upload(UploadPartObj uploadPartObj,String serializationFilePath){

	    try {

	        uploadPartObj.setResult(true);

	        //向子线程池中submit单个文件所有分块上传线程
	        for (int i=0;i<uploadPartObj.getUploadPartThreads().size();i++) {
	            if(uploadPartObj.getUploadPartThreads().get(i).getMyPartETag()==null)
	                pool.submit(uploadPartObj.getUploadPartThreads().get(i));
	        }

	        //shutdown子线程池，池内所上传任务执行结束后停止当前线程池
	        pool.shutdown();
	        while (!pool.isTerminated()) {
	            //循环检查线程池，同时在此序列化uploadPartObj
	            ObjectSerializableUtil.serialization(uploadPartObj,serializationFilePath);
	            pool.awaitTermination(Constant.SERIALIZATION_TIME, TimeUnit.SECONDS);
	        }

	        //判断上传结果
	        for (UploadPartThread uploadPartThread: uploadPartObj.getUploadPartThreads()) {
	            if(uploadPartThread.getMyPartETag()==null)
	                uploadPartObj.setResult(false);

	        }
	        //上传成功 删除序列化文件
	        if (uploadPartObj.isResult()==true) 
	            ObjectSerializableUtil.delSerlzFile(serializationFilePath);
	    } catch (Exception e) {
	       logger.error("多线程上传单个文件异常！！");

	    }
	    return uploadPartObj;


	}

	// 根据文件的大小和每个Part的大小计算需要划分的Part个数。
	private static int calPartCount(MultipartFile f,Integer partSize) {
	    int partCount = (int) (f.getSize() / partSize);
	    if (f.getSize() % partSize != 0){
	        partCount++;
	    }
	    return partCount;
	}

	// 创建Bucket
	private int ensureBucket(OSSClient client, String bucketName){
	        try {
	            // 创建bucket
	            client.createBucket(bucketName);
	            //设置bucket的访问权限，public-read-write权限
	            client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
	        } catch (OSSException e) {
	            e.printStackTrace();

	            return Global.ERROR;
	        } catch (ClientException e) {
	            if (!OSSErrorCode.BUCKET_ALREADY_EXISTS.equals(e.getErrorCode())) {
	                // 如果Bucket已经存在，则忽略

	            }else{
	                e.printStackTrace();

	                return Global.ERROR;
	            }
	        }
	        return Global.SUCCESS;
	}

	// 初始化一个Multi-part upload请求。
	private static String initMultipartUpload(OSSClient client,String bucketName, String key,String fileDM5Str) throws OSSException,ClientException{
	    String uploadId=null;
	   try{ 
	    ObjectMetadata objectMetadata =new ObjectMetadata();
	    objectMetadata.getUserMetadata().put(Global.X_OSS_META_MY_MD5,fileDM5Str);
	    InitiateMultipartUploadRequest initUploadRequest = new InitiateMultipartUploadRequest(bucketName, key, objectMetadata);
	    InitiateMultipartUploadResult initResult = client.initiateMultipartUpload(initUploadRequest);
	    uploadId = initResult.getUploadId();

	    System.err.println(uploadId);
	   }catch (Exception e) {
	    logger.error("初始化Multi-part upload请求失败！！");
	}
	    return uploadId;

	}

	// 完成一个multi-part请求。
	private static void completeMultipartUpload(OSSClient client, String bucketName, String key,UploadPartObj uploadPartObj){
	    List<PartETag> eTags = new ArrayList<PartETag>(); 
	    for (UploadPartThread uploadPartThread : uploadPartObj.getUploadPartThreads()) {
	        eTags.add(new PartETag(uploadPartThread.getMyPartETag().getPartNumber(),uploadPartThread.getMyPartETag().geteTag()));
	    }
	    //为part按partnumber排序
	    Collections.sort(eTags, new Comparator<PartETag>(){
	        public int compare(PartETag arg0, PartETag arg1) {
	            PartETag part1= arg0;
	            PartETag part2= arg1;
	            return part1.getPartNumber() - part2.getPartNumber();
	        }  
	    });
	    try{
	    CompleteMultipartUploadRequest completeMultipartUploadRequest =
	            new CompleteMultipartUploadRequest(bucketName, key, uploadPartObj.getUploadPartThreads().get(0).getUploadId(), eTags);
	    System.err.println(uploadPartObj.getUploadPartThreads().get(0).getUploadId());
	    client.completeMultipartUpload(completeMultipartUploadRequest);
	    }catch (Exception e) {
	        logger.error("合并上传失败！！");
	    }
	}


}
