package com.car.app.carscraporder.vo;

import io.swagger.annotations.ApiModelProperty;

public class CarScrapOrderWhereParamterVO {
	
	private String orderStatus;
	@ApiModelProperty(value = "订单号")
	private String orderNo;
	@ApiModelProperty(value = "车牌号")
	private String carNumber;
	@ApiModelProperty(value = "车架号")
	private String carFrameNumber;
	
	@ApiModelProperty(value = "车型")
	private String carModelNumberName;
	@ApiModelProperty(value = "联系人")
	private String takeCarContacts;
	@ApiModelProperty(value = "联系电话")
	private String takeCarContactNumber;

	@ApiModelProperty(value = "订单委托人")
	private String clientId;
	
	@ApiModelProperty(value = "订单代办人")
	private String agentUserid;
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarFrameNumber() {
		return carFrameNumber;
	}
	public void setCarFrameNumber(String carFrameNumber) {
		this.carFrameNumber = carFrameNumber;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getCarModelNumberName() {
		return carModelNumberName;
	}
	public void setCarModelNumberName(String carModelNumberName) {
		this.carModelNumberName = carModelNumberName;
	}
	public String getTakeCarContacts() {
		return takeCarContacts;
	}
	public void setTakeCarContacts(String takeCarContacts) {
		this.takeCarContacts = takeCarContacts;
	}
	public String getTakeCarContactNumber() {
		return takeCarContactNumber;
	}
	public void setTakeCarContactNumber(String takeCarContactNumber) {
		this.takeCarContactNumber = takeCarContactNumber;
	}
	public String getAgentUserid() {
		return agentUserid;
	}
	public void setAgentUserid(String agentUserid) {
		this.agentUserid = agentUserid;
	}
	
	

}
