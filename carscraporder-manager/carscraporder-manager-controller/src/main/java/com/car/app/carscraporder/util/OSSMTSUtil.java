package com.car.app.carscraporder.util;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray; 
import com.alibaba.fastjson.JSONObject;
//
//import com.aliyuncs.DefaultAcsClient; 
//import com.aliyuncs.exceptions.ClientException; 
//import com.aliyuncs.exceptions.ServerException; 
//import com.aliyuncs.mts.model.v20140618.SubmitJobsRequest; 
//import com.aliyuncs.mts.model.v20140618.SubmitJobsResponse; 
//import com.aliyuncs.profile.DefaultProfile;

public class OSSMTSUtil {
//	
//	private static final String MTS_REGION = "cn-beijing"; 
//	private static final String OSS_REGION = "oss-cn-beijing";
//	
//	private static final String mtsEndpoint = "mts.cn-beijing.aliyuncs.com";
//
//	private static String waterMarkFilePath = "";// 水印图片的key
//
//	private static String accessKeyId = "";
//	private static String accessKeySecret = "";
//	private static String pipelineId = "";// 转码管道ID
//	private static String transcodeTemplateId = "S00000001-200030";// 预制模板MP4高清
//	// private static String waterMarkTemplateId = "";//自定义水印模板ID
//
//
//	private static String Bucket = ""; // 存储空间名
//
//	private static DefaultAcsClient aliyunClient;
//	private static final Logger logger = LoggerFactory
//	.getLogger(OSSMTSUtil.class);
//	static {
//	    //添加多地区
//	    try {
//	        DefaultProfile.addEndpoint(MTS_REGION, MTS_REGION, "Mts", mtsEndpoint);
//	    } catch (ClientException e) {
//	        logger.error("多地区添加失败！！");
//	        e.printStackTrace();
//	    }
//	    //获取转码连接对象
//	    aliyunClient = new DefaultAcsClient(DefaultProfile.getProfile(
//	            MTS_REGION, accessKeyId, accessKeySecret));
//
//
//	}
//	/*
//	 * 
//	 * 
//	 * 
//	 */
//
//	  //提交转码作业
//	public static String submitTranscodeJob(OSSFileDO inputFile,
//	        OSSFileDO watermarkFile,String MTSFlieName) {
//	    /*JSONObject waterMarkConfig = new JSONObject();
//	    waterMarkConfig.put("InputFile", watermarkFile.toJson());
//	    waterMarkConfig.put("WaterMarkTemplateId", waterMarkTemplateId);
//	    JSONArray waterMarkConfigArray = new JSONArray();
//	    waterMarkConfigArray.add(waterMarkConfig);*/
//
//	    JSONObject jobConfig = new JSONObject();
//	    jobConfig.put("OutputObject", MTSFlieName);
//	    jobConfig.put("TemplateId", transcodeTemplateId);
//	//  jobConfig.put("WaterMarks", waterMarkConfigArray);
//	    JSONArray jobConfigArray = new JSONArray();
//	    jobConfigArray.add(jobConfig);
//
//	    SubmitJobsRequest request = new SubmitJobsRequest();
//
//	    request.setInput(inputFile.toJson().toJSONString());
//	    request.setOutputBucket(Bucket);
//	    request.setOutputs(jobConfigArray.toJSONString());
//	    request.setPipelineId(pipelineId);
//	    request.setOutputLocation(OSS_REGION);
//
//	    Integer outputJobCount = 1;
//
//	    SubmitJobsResponse response = null;
//	    try {
//	        //发送转码请求
//	        response = aliyunClient.getAcsResponse(request);
//	        if (response.getJobResultList().size() != outputJobCount) {
//	            throw new RuntimeException("SubmitJobsRequest Size failed");
//	        }
//
//	        return response.getJobResultList().get(0).getJob().getJobId();
//	    } catch (ServerException e) {
//	        logger.error("转码请求提交失败！！");
//	        throw new RuntimeException("submitTranscodeJob Server failed");
//	    } catch (ClientException e) {
//	        logger.error("转码请求提交失败！！");
//	        throw new RuntimeException("submitTranscodeJob Client failed");
//	    }
//	}
	

}
