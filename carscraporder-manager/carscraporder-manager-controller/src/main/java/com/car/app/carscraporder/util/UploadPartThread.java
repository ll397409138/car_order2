package com.car.app.carscraporder.util;

import java.io.InputStream; 
import java.io.Serializable; 
import java.util.concurrent.Callable;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.model.UploadPartResult;

import com.aliyun.oss.OSSClient; 
import com.aliyun.oss.model.UploadPartRequest;

/** 
* @Description: 上传每个part的线程类 可序列化 用于上传的断点续传 
* @author: zrk 
* @time: 2015年4月1日 上午10:35:34 
*/ 

public class UploadPartThread implements Callable ,Serializable {
	private static final long serialVersionUID = 1L;

	private MultipartFile uploadFile;
	private String bucket;
	private String object;
	private long start;
	private long size;
	private int partId;
	private String uploadId;

	private MyPartETag myPartETag; 

	public UploadPartThread(OSSClient client,String bucket, String object,
	        MultipartFile uploadFile,String uploadId, int partId,
	        long start, long partSize) {
	    this.uploadFile = uploadFile;
	    this.bucket = bucket;
	    this.object = object;
	    this.start = start;
	    this.size = partSize; 
	    this.partId = partId;
	    this.uploadId = uploadId;
	}

	@SuppressWarnings("finally")
	@Override
	public UploadPartThread call() {

	    InputStream in = null;
	    try {
	        //in = new FileInputStream(uploadFile);
	        in=uploadFile.getInputStream();
	        in.skip(start);

	        UploadPartRequest uploadPartRequest = new UploadPartRequest();
	        uploadPartRequest.setBucketName(bucket);
	        uploadPartRequest.setKey(object);
	        uploadPartRequest.setUploadId(uploadId);
	        uploadPartRequest.setInputStream(in);
	        uploadPartRequest.setPartSize(size);
	        uploadPartRequest.setPartNumber(partId);
	        //MyPartETag是对uploadPartResult.getPartETag()的返回值PartETag的封装，主要是为了能序列化PartETag，MyPartETag仅比PartETag多实现了Serializable接口
	        UploadPartResult uploadPartResult = OssUtil.getOSSClient().uploadPart(uploadPartRequest); 
	        myPartETag = new MyPartETag(uploadPartResult.getPartETag());
	    } catch (Exception e) {
	        e.printStackTrace();

	    } finally {
	        if (in != null){
	            try {
	                in.close();
	            } catch (final Exception e) {

	            }
	        }
	        return this;
	    }
	}

	public String getUploadId() {
	    return uploadId;
	}

	public void setUploadId(String uploadId) {
	    this.uploadId = uploadId;
	}

	public MyPartETag getMyPartETag() {
	    return myPartETag;
	}

	public void setMyPartETag(MyPartETag myPartETag) {
	    this.myPartETag = myPartETag;
	}
	
}
