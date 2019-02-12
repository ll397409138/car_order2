package com.car.app.common.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.common.bean.HttpResult;



/**
 * 
 * 类名称：ApiService   
 * 类描述： 负责和外部系统做接口的交互  
 * 创建人：刘子亮
 * 创建时间：2018年4月3日 上午9:33:53      
 * @version  V1.0
 *
 */
@Service
public class ApiService {
	
	private Logger logger = LoggerFactory.getLogger(ApiService.class);
	
	 // 创建Httpclient对象
    @Autowired(required = false)
    private CloseableHttpClient httpclient;

    @Autowired(required = false)
    private RequestConfig requestConfig;

   
    
    public HttpResult doGet(String url) throws URISyntaxException, ClientProtocolException, IOException {
        return doGet(url, null);
    }

   
    
    
   
    
    public HttpResult doGet(String url, Map<String, Object> params) throws URISyntaxException,ClientProtocolException, IOException {
		URI uri = null;
		if (params != null) {
		    // 定义请求的参数
		    URIBuilder builder = new URIBuilder(url);
		    for (Map.Entry<String, Object> entry : params.entrySet()) {
		    	if(entry.getValue()!=null){
		    		 builder.addParameter(entry.getKey(), String.valueOf(entry.getValue()));
		    	}
		    	
		       
		    }
		    uri = builder.build();
		}
		
		// 创建http GET请求
		HttpGet httpGet = null;
		if (uri != null) {
		    httpGet = new HttpGet(uri);
		} else {
		    httpGet = new HttpGet(url);
		}
		
		httpGet.setConfig(this.requestConfig);
		
		CloseableHttpResponse response = null;
		try {
			 // 执行请求
            response = httpclient.execute(httpGet);
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(response.getStatusLine().getStatusCode());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                httpResult.setContent(EntityUtils.toString(response.getEntity(), "UTF-8"));
                return httpResult;
            }else{
		    	logger.error("HTTP服务接口调用失败,请求URL:"+url+",请求参数："+params.toString()+",请求响应编码："+response.getStatusLine().getStatusCode()+","
		    			+ "请求影响数据："+EntityUtils.toString(response.getEntity(), "UTF-8"));
		    	
		    }
		 
		} finally {
		    if (response != null) {
		        response.close();
		    }
		}
		return null;
		
		}
    
    
    public HttpResult doDelete(String url) throws URISyntaxException, ClientProtocolException, IOException {
        return doDelete(url, null);
    }
    
    public HttpResult doDelete(String url, Map<String, Object> params) throws URISyntaxException,ClientProtocolException, IOException {
		URI uri = null;
		if (params != null) {
		    // 定义请求的参数
		    URIBuilder builder = new URIBuilder(url);
		    for (Map.Entry<String, Object> entry : params.entrySet()) {
		    	if(entry.getValue()!=null)
		        builder.addParameter(entry.getKey(), String.valueOf(entry.getValue()));
		    }
		    uri = builder.build();
		}
		
		// 创建http GET请求
		HttpDelete httpDelete = null;
		if (uri != null) {
			httpDelete = new HttpDelete(uri);
		} else {
			httpDelete = new HttpDelete(url);
		}
		
		httpDelete.setConfig(this.requestConfig);
		
		CloseableHttpResponse response = null;
		try {
			 // 执行请求
            response = httpclient.execute(httpDelete);
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(response.getStatusLine().getStatusCode());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                httpResult.setContent(EntityUtils.toString(response.getEntity(), "UTF-8"));
                return httpResult;
            }else{
		    	logger.error("HTTP服务接口调用失败,请求URL:"+url+",请求参数："+params.toString()+",请求响应编码："+response.getStatusLine().getStatusCode()+","
		    			+ "请求影响数据："+EntityUtils.toString(response.getEntity(), "UTF-8"));
		    	
		    }
		 
		} finally {
		    if (response != null) {
		        response.close();
		    }
		}
		return null;
		
		}

    
    
    

    /**
     * 发送POST请求
     * 
     * @param url
     * @param params
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPost(String url, Map<String, Object> params) throws ClientProtocolException, IOException {
        // 创建http GET请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.requestConfig);
        if (null != params) {
            // 构造表单
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
            	if(entry.getValue()!=null){
            		 parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            	}
               
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(response.getStatusLine().getStatusCode());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                httpResult.setContent(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }else{
            	logger.error("HTTP服务接口调用失败,请求URL:"+url+",请求参数："+params.toString()+",请求响应编码："+response.getStatusLine().getStatusCode()+","
            			+ "请求影响数据："+EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
            return httpResult;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
    
    /**
     * 提交json的POST请求
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPostJson(String url, String json) throws ClientProtocolException, IOException {
        // 创建http GET请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.requestConfig);
        if (null != json) {
            // 构造字符串
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(response.getStatusLine().getStatusCode());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                httpResult.setContent(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }else{
            	logger.error("HTTP服务接口调用失败,请求URL:"+url+",请求参数："+json+",请求响应编码："+response.getStatusLine().getStatusCode()+","
            			+ "请求影响数据："+EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
            return httpResult;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
    
    
    /**
     * 发送POST请求
     * 
     * @param url
     * @param params
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPut(String url, Map<String, String> params) throws ClientProtocolException, IOException {
        // 创建http GET请求
        HttpPut httpPut = new HttpPut(url);
        httpPut.setConfig(this.requestConfig);
        if (null != params) {
            // 构造表单
            List<NameValuePair> parameters = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
            	if(entry.getValue()!=null)
                parameters.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters,"UTF-8");
            httpPut.setEntity(urlEncodedFormEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPut);
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(response.getStatusLine().getStatusCode());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                httpResult.setContent(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }else{
            	logger.error("HTTP服务接口调用失败,请求URL:"+url+",请求参数："+params.toString()+",请求响应编码："+response.getStatusLine().getStatusCode()+","
            			+ "请求影响数据："+EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
            return httpResult;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
    
    /**
     * 提交json的POST请求
     * @param url
     * @param json
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public HttpResult doPutJson(String url, String json) throws ClientProtocolException, IOException {
        // 创建http GET请求
        HttpPut httpPut = new HttpPut(url);
        httpPut.setConfig(this.requestConfig);
        if (null != json) {
            // 构造字符串
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPut.setEntity(stringEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPut);
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(response.getStatusLine().getStatusCode());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                httpResult.setContent(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }else{
            	logger.error("HTTP服务接口调用失败,请求URL:"+url+",请求参数："+json+",请求响应编码："+response.getStatusLine().getStatusCode()+","
            			+ "请求影响数据："+EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
            return httpResult;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }


}
