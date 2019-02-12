package com.car.app.carscraporder.bo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 类名称：CarScrapOrderPageBO   
 * 类描述：   整车列表业务类 和旧件列表公用类
 * 创建人：刘子亮
 * 创建时间：2018年10月27日 下午7:48:26      
 * @version  V1.0
 *
 */
public class CarScrapOrderPageBO {
	
	
	 private String id;
	 private String orderNo;
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	 private Date orderTime;;
	 private String carNumber;
	 private String carFrameNumber;
	 private String carModelNumberName;
	 private String reportNo;
	  
	 private Integer orderStatus;
	 private String orderType;
	 
	 private String custormName;
	 
	 private String orderAmount;
	 
	 private String settlementAmount;
	 
	 private String expressNumber;
	 
	 private String isdrive;
	 
	
	 private String carOwner;
	 @ApiModelProperty(value = "取车时间")
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	 private Date takeCarTime;
	 @ApiModelProperty(value = "取车人联系人")
	 private String takeCarContacts;

	 @ApiModelProperty(value = "取车联系电话")
	 private String takeCarContactNumber;
	 
	 
	 @ApiModelProperty(value = "配件类型名称")
	 private String partsTypeName;
	 
	 @ApiModelProperty(value = "配件大类")
     private  String partsCaregoryName;
		
	 @ApiModelProperty(value = "配件名称")
	 private String partsName;
		
	 @ApiModelProperty(value = "配件编号")
	 private String partsNum;
	 
	 private String amount;
	 
	 private String receivedCount;
	 private String totalPartsCount;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public String getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(String settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public String getIsdrive() {
		return isdrive;
	}
	public void setIsdrive(String isdrive) {
		this.isdrive = isdrive;
	}
	public String getExpressNumber() {
		return expressNumber;
	}
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
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
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getReceivedCount() {
		return receivedCount;
	}
	public void setReceivedCount(String receivedCount) {
		this.receivedCount = receivedCount;
	}
	public String getTotalPartsCount() {
		return totalPartsCount;
	}
	public void setTotalPartsCount(String totalPartsCount) {
		this.totalPartsCount = totalPartsCount;
	}
	public String getPartsCaregoryName() {
		return partsCaregoryName;
	}
	public void setPartsCaregoryName(String partsCaregoryName) {
		this.partsCaregoryName = partsCaregoryName;
	}
	public String getPartsTypeName() {
		return partsTypeName;
	}
	public void setPartsTypeName(String partsTypeName) {
		this.partsTypeName = partsTypeName;
	}
	public String getPartsName() {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(this.getPartsCaregoryName())){
			sb.append(this.getPartsCaregoryName()+"-");
		}
		
		if(StringUtils.isNotBlank(this.getPartsCaregoryName())){
			sb.append(this.getPartsTypeName());
		}
		
		return sb.toString();
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	private String picture;
	 
	 
	 
	 
	
	
	public String getOrderAmount() {
		return orderAmount;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getCustormName() {
		return custormName;
	}
	public void setCustormName(String custormName) {
		this.custormName = custormName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
	
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getTakeCarTime() {
		return takeCarTime;
	}
	public void setTakeCarTime(Date takeCarTime) {
		this.takeCarTime = takeCarTime;
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
	
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	
	
	

}
