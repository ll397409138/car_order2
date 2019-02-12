package com.car.app.common.bean;

/**
 * 
 * 类名称：HttpResult   
 * 类描述：http响应封装类   
 * 创建人：刘子亮
 * 创建时间：2018年4月3日 上午9:36:57      
 * @version  V1.0
 *
 */
public class HttpResult {
	
	  //响应状态码
    private Integer code;
    
    //响应内容
    private String content;
    
    public HttpResult(){
        
    }

    public HttpResult(Integer code, String content) {
        this.code = code;
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
