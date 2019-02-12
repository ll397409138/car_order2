package com.car.app.carscraporder.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.service.CarModelQueryService;
import com.car.app.common.bean.HttpResult;
import com.car.app.common.bean.ResultBean;

@Service
public class CarModelQueryServiceImpl implements CarModelQueryService {
	
	@Value("${query_carmodel_data_url}")
	private String queryCarModelUrl;
	
	
	@Value("${query_carmodel_method}")
	private String queryMethod;
	
	@Value("${requestforma}")
	private String requestforma;
	
	@Value("${AppKey}")
	private String AppKey;
	
	@Value("${AppSecret}")
	private String AppSecret;
	
	@Value("${paramTemplate}")
	private String paramTemplate;
	
	
	 // 创建Httpclient对象
    @Autowired(required = false)
    private CloseableHttpClient httpclient;

    @Autowired(required = false)
    private RequestConfig requestConfig;
	
	public String queryCarModelData(String vin)throws Exception{
        String xmlInput  = MessageFormat.format(paramTemplate,AppKey,AppSecret,queryMethod,requestforma,vin);
		
		xmlInput = xmlInput.replace("<", "&lt;");
		xmlInput = xmlInput.replace(">", "&gt;");
		String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
				+ "<soap12:Body>"
				+ " <LevelData xmlns=\"http://www.dat881.com/\">" 
				+  "<xmlInput>" + xmlInput + "</xmlInput>" + "</LevelData>" // 接口传入参数
				+ "  </soap12:Body>" + "</soap12:Envelope>";
				    
		
		 HttpPost httpPost = new HttpPost(queryCarModelUrl);
	     httpPost.setConfig(this.requestConfig);
	     
	     byte[] b = null;
	     try {
	     b = soapRequestData.getBytes("utf-8");
	     } catch (UnsupportedEncodingException e) {
	     e.printStackTrace();
	     }
	     InputStream is = new ByteArrayInputStream(b, 0, b.length);
	     ContentType type = ContentType.create("application/soap+xml; charset=utf-8");
	     InputStreamEntity re = new InputStreamEntity(is,b.length,type);
	     httpPost.setEntity(re);
	     
	     CloseableHttpResponse response = null;
	     try {
	            // 执行请求
	            response = httpclient.execute(httpPost);
	            HttpResult httpResult = new HttpResult();
	            httpResult.setCode(response.getStatusLine().getStatusCode());
	            // 判断返回状态是否为200
	            if (response.getStatusLine().getStatusCode() == 200) {
	                httpResult.setContent(EntityUtils.toString(response.getEntity(), "UTF-8"));
	                 return httpResult.getContent();
	            }else{
	            	   
	            }
	           
	        } finally {
	            if (response != null) {
	                response.close();
	            }
	        }
	     
		return null;
		
		
	}

}
