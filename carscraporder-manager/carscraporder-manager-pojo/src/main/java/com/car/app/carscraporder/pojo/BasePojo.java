package com.car.app.carscraporder.pojo;

import java.util.Date;

import springfox.documentation.annotations.ApiIgnore;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * 类名称：BasePojo   
 * 类描述：系统pojo的基类  
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:36:23      
 * @version  V1.0
 *
 */
@ApiIgnore
public abstract class BasePojo implements java.io.Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	
	@JsonIgnore
    private Date createtime;
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JsonIgnore
    private Date operatortime;
	@JsonIgnore
	private String creater;
	@JsonIgnore
    private String operator;
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getOperatortime() {
		return operatortime;
	}
	public void setOperatortime(Date operatortime) {
		this.operatortime = operatortime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
	
	
	
	
    
    
  
    
    

}
