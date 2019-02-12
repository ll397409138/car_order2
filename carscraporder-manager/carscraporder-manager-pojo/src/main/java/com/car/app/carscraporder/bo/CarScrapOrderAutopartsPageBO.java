package com.car.app.carscraporder.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarScrapOrderAutopartsPageBO {
	
	private String id;
	
	//订单号
	 private String orderNO;
	//订单时间
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	 private Date orderTime;
	
	//车牌号
	 private String carNumber;
	//车架号
	 private String carFrameNumber;
	//车型
	 private String carModelNumberName;
	//金额
	private String amount;
	@ApiModelProperty(value = "配件类型名称")
    private String partsTypeName;
	
	@ApiModelProperty(value = "配件名称")
    private String partsName;
	
	@ApiModelProperty(value = "配件编号")
    private String partsNum;
	//图片
	private String pictures;
	
	
	

	public String getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
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

	public String getCarModelNumberName() {
		return carModelNumberName;
	}

	public void setCarModelNumberName(String carModelNumberName) {
		this.carModelNumberName = carModelNumberName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPartsTypeName() {
		return partsTypeName;
	}

	public void setPartsTypeName(String partsTypeName) {
		this.partsTypeName = partsTypeName;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public String getPartsNum() {
		return partsNum;
	}

	public void setPartsNum(String partsNum) {
		this.partsNum = partsNum;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	
	
	

}
