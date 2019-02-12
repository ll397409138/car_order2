package com.car.app.common.bean;

import java.util.List;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 类名称：ResultBean   
 * 类描述：所有请求统一响应格式类   
 * 创建人：刘子亮
 * 创建时间：2018年4月3日 上午9:37:26      
 * @version  V1.0
 *
 */
@ApiModel(value = "请求响应结果bean")
public class ResultBean<T> {
   
	//系统错误
	public static final int FAIL=500;
	//请求成功
	public static final int SUCCESS=200;
	//
	public static final int NO_PERMISSION=404;
	//校验失败
	public static final int CHECK_FAIL=400;
	
	//数据重复校验
	public static final int DATA_REPEAT=401;
	
	
	
	
	
	
	//响应的消息
	@ApiModelProperty(value = "响应message")
	private String msg="success";
	//响应的业务状态码
	@ApiModelProperty(value = "响应业务编码")
	private int code = SUCCESS;
	//响应的数据
	@ApiModelProperty(value = "响应业务数据")
	private T data;
	
	
	
	public ResultBean(T data){
		this.data=data;
	}
	
	public ResultBean(){
	}
	
	public ResultBean(int code,T data,String msg){
		this.msg = msg;
		this.data = data;
		this.code = code;
	}
	
	

	
	
	public ResultBean(Throwable e){
		this.msg=e.toString();
		this.code=FAIL;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
	
	
	

}
