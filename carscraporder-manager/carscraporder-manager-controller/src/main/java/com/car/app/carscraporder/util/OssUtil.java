package com.car.app.carscraporder.util;
import java.io.FileInputStream; 
import java.net.URL; 
import java.util.ArrayList; 
import java.util.Date; 
import java.util.List; 
import java.util.PropertyResourceBundle; 
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils; 
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient; 
import com.aliyun.oss.model.CompleteMultipartUploadRequest; 
import com.aliyun.oss.model.CompleteMultipartUploadResult; 
import com.aliyun.oss.model.InitiateMultipartUploadRequest; 
import com.aliyun.oss.model.InitiateMultipartUploadResult; 
import com.aliyun.oss.model.ListMultipartUploadsRequest; 
import com.aliyun.oss.model.ListPartsRequest; 
import com.aliyun.oss.model.MultipartUpload; 
import com.aliyun.oss.model.MultipartUploadListing; 
import com.aliyun.oss.model.ObjectMetadata; 
import com.aliyun.oss.model.PartETag; 
import com.aliyun.oss.model.PartListing; 
import com.aliyun.oss.model.PartSummary; 
import com.aliyun.oss.model.PutObjectResult; 
import com.aliyun.oss.model.UploadPartRequest; 
import com.aliyun.oss.model.UploadPartResult;

public class OssUtil {
	// 阿里云API的内或外网域名
	private static String ENDPOINT;
	// 阿里云API的密钥Access Key ID
	private static String ACCESS_KEY_ID;
	// 阿里云API的密钥Access Key Secret
	private static String ACCESS_KEY_SECRET;

	// init static datas
	static {
	    ResourceBundle bundle = PropertyResourceBundle.getBundle("oss");
	    ENDPOINT = bundle.getString("endpoint").trim();
	    int a = ENDPOINT.length();
	    System.err.println("a=" + a);
	    ACCESS_KEY_ID = bundle.getString("accessKeyId").trim();
	    int b = ACCESS_KEY_ID.length();
	    System.err.println("b=" + b);
	    ACCESS_KEY_SECRET = bundle.getString("accessKeySecret").trim();
	    int c = ACCESS_KEY_SECRET.length();
	    System.err.println("c=" + c);
	}

	/**
	 * 获取阿里云OSS客户端对象
	 * */
	public static OSSClient getOSSClient() {
	    OSSClient ocClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID,
	            ACCESS_KEY_SECRET);
	    return ocClient;
	}

	/**
	 * 上传图片至OSS
	 * 
	 * @param ossClient
	 *            oss连接
	 * @param file
	 *            上传文件（文件全路径如：D:\\image\\cake.jpg）
	 * @param bucketName
	 *            存储空间
	 * @param folder
	 *            模拟文件夹名 如"qj_nanjing/"
	 * @return String 返回的唯一MD5数字签名
	 * */
	public static String uploadObject2OSS(OSSClient ossClient,
	        MultipartFile file, String bucketName, String folder,
	        String fileName) {
	    String resultStr = null;
	    try {
	        // 以输入流的形式上传文件
	        // InputStream is = new FileInputStream(file);
	        // 文件名
	        // String fileName = file.getOriginalFilename();
	        // 文件大小
	        // Long fileSize = file.length();
	        // 创建上传Object的Metadata
	        ObjectMetadata metadata = new ObjectMetadata();
	        // 上传的文件的长度
	        metadata.setContentLength(file.getSize());
	        // 指定该Object被下载时的网页的缓存行为
	        metadata.setCacheControl("no-cache");
	        // 指定该Object下设置Header
	        metadata.setHeader("Pragma", "no-cache");
	        // 指定该Object被下载时的内容编码格式
	        metadata.setContentEncoding("utf-8");
	        // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
	        // 如果没有扩展名则填默认值application/octet-stream
	        // metadata.setContentType(getContentType(fileName));
	        // 指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
	        // metadata.setContentDisposition("filename/filesize=" + fileName
	        // + "/" + fileSize + "Byte.");
	        // 上传文件 (上传文件流的形式)
	        PutObjectResult putResult = ossClient.putObject(bucketName, folder
	                + fileName, file.getInputStream(), metadata);
	        // 解析结果
	        resultStr = putResult.getETag();
	    } catch (Exception e) {
	        e.printStackTrace();

	    }

	    return resultStr;
	}

	/**
	 * 通过文件名判断并获取OSS服务文件上传时文件的contentType
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件的contentType
	 */
	public static String getContentType(String fileName) {
	    // 文件的后缀名
	    String fileExtension = fileName.substring(fileName.lastIndexOf("."));
	    if (".bmp".equalsIgnoreCase(fileExtension)) {
	        return "image/bmp";
	    }
	    if (".gif".equalsIgnoreCase(fileExtension)) {
	        return "image/gif";
	    }
	    if (".jpeg".equalsIgnoreCase(fileExtension)
	            || ".jpg".equalsIgnoreCase(fileExtension)
	            || ".png".equalsIgnoreCase(fileExtension)) {
	        return "image/jpeg";
	    }
	    if (".html".equalsIgnoreCase(fileExtension)) {
	        return "text/html";
	    }
	    if (".txt".equalsIgnoreCase(fileExtension)) {
	        return "text/plain";
	    }
	    if (".vsd".equalsIgnoreCase(fileExtension)) {
	        return "application/vnd.visio";
	    }
	    if (".ppt".equalsIgnoreCase(fileExtension)
	            || "pptx".equalsIgnoreCase(fileExtension)) {
	        return "application/vnd.ms-powerpoint";
	    }
	    if (".doc".equalsIgnoreCase(fileExtension)
	            || "docx".equalsIgnoreCase(fileExtension)) {
	        return "application/msword";
	    }
	    if (".xml".equalsIgnoreCase(fileExtension)) {
	        return "text/xml";
	    }
	    // 默认返回类型
	    return "image/jpeg";
	}

	/**
	 * 获得url链接
	 * 
	 * @param key
	 * @return
	 */
	public static String getUrl(String key) {
	    // 设置URL过期时间为10年 3600l* 1000*24*365*10
	    Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24
	            * 365 * 10);
	    // 生成URL
	    // 初始化OSSClient
	    OSSClient ossClient = OssUtil.getOSSClient();
	    URL url = ossClient.generatePresignedUrl("fsg-video", key, expiration);
	    if (url != null) {
	        return url.toString();
	    }
	    return null;

	}

	/**
	 * 断点续传
	 * 
	 * @param key
	 * @return
	 */
	public static String multipartUploadObject(String bucketName, String key,
	        MultipartFile    partFile) {
	    String tag = null;
	    String uploadid = null;
	    int j = 0;
	    // 初始化一个OSSClient
	    OSSClient client = getOSSClient();
	    ListMultipartUploadsRequest lmur = new ListMultipartUploadsRequest(
	            bucketName);

	    // 获取Bucket内所有上传事件
	    MultipartUploadListing listing = client.listMultipartUploads(lmur);
	    // 新建一个List保存每个分块上传后的ETag和PartNumber
	    List<PartETag> partETags = new ArrayList<PartETag>();

	    // 遍历所有上传事件 设置UploadId
	    for (MultipartUpload multipartUpload : listing.getMultipartUploads()) {
	        if (multipartUpload.getKey().equals(key)) {
	            uploadid = multipartUpload.getUploadId();
	            break;
	        }
	    }

	    if (StringUtils.isEmpty(uploadid)) {
	        // 开始Multipart Upload,InitiateMultipartUploadRequest
	        // 来指定上传Object的名字和所属Bucke
	        InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(
	                bucketName, key);
	        InitiateMultipartUploadResult initiateMultipartUploadResult = client
	                .initiateMultipartUpload(initiateMultipartUploadRequest);
	        uploadid = initiateMultipartUploadResult.getUploadId();
	    } else {
	        ListPartsRequest listPartsRequest = new ListPartsRequest(
	                bucketName, key, uploadid);
	        // listParts 方法获取某个上传事件所有已上传的块
	        PartListing partListing = client.listParts(listPartsRequest);
	        // 遍历所有Part
	        for (PartSummary part : partListing.getParts()) {
	            partETags
	                    .add(new PartETag(part.getPartNumber(), part.getETag()));
	            j++;
	        }
	    }
	    // 设置每块为 5M（最小支持5M）
	    final int partSize = 1024 * 1024 * 10;

	    try {

	        // 计算分块数目
	        int partCount = (int) (partFile.getSize() / partSize);
	        if (partFile.getSize() % partSize != 0) {
	            partCount++;
	        }

	        for (int i = j; i < partCount; i++) {
	            // 获取文件流
	             FileInputStream fis;
	             fis = (FileInputStream) partFile.getInputStream();

	            // 跳到每个分块的开头
	            long skipBytes = partSize * i;
	            fis.skip(skipBytes);

	            // 计算每个分块的大小
	            long size = partSize < partFile.getSize() - skipBytes ? partSize
	                    : partFile.getSize() - skipBytes;

	            // 创建UploadPartRequest，上传分块
	            UploadPartRequest uploadPartRequest = new UploadPartRequest();
	            uploadPartRequest.setBucketName(bucketName);
	            uploadPartRequest.setKey(key);
	            uploadPartRequest.setUploadId(uploadid);
	            uploadPartRequest.setInputStream(fis);
	            uploadPartRequest.setPartSize(size);
	            uploadPartRequest.setPartNumber(i + 1);

	            UploadPartResult uploadPartResult = client
	                    .uploadPart(uploadPartRequest);


	            // 将返回的PartETag保存到List中。
	            partETags.add(uploadPartResult.getPartETag());

	            // 关闭文件
	            fis.close();

	        }
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(
	            bucketName, key, uploadid, partETags);


	    // 完成分块上传
	    CompleteMultipartUploadResult completeMultipartUploadResult = client
	            .completeMultipartUpload(completeMultipartUploadRequest);

	    // 打印Object的ETag（返回的ETag不是md5.具体是什么不详）
	    tag = completeMultipartUploadResult.getETag();
	    return tag;
	}
	
}
