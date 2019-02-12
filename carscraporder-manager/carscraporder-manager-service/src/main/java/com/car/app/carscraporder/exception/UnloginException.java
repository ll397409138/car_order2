package com.car.app.carscraporder.exception;


/**
 * 
 * 类名称：UnloginException   
 * 类描述： 自定义异常,没有登录异常  
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:18:56      
 * @version  V1.0
 *
 */
public class UnloginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnloginException() {
	}

	public UnloginException(String message) {
		super(message);
	}

	public UnloginException(Throwable cause) {
		super(cause);
	}

	public UnloginException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnloginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause);
	}

}
