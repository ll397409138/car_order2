package com.car.app.common.exception;

/**
 * 发送http请求异常
 * 类名称：HttpException   
 * 类描述：   
 * 创建人：刘子亮
 * 创建时间：2018年9月5日 下午4:20:02      
 * @version  V1.0
 *
 */
public class HttpException extends Exception {
	public HttpException(String msg)  
    {  
        super(msg);  
    } 
}
