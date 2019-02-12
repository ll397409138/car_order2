package com.car.app.carscraporder.vo;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CarScrapOrderSimpleBaseVO extends CarScrapOrderBaseVO {

	
	@ApiModelProperty(value = "车辆归属(1:个人,2:客户)")
    private String carAscription="1";
	
	@ApiModelProperty(value = "车主姓名")
    private String carOwner;
	
	@ApiModelProperty(value = "能否行驶(1:否,2:是 3:严重事故)")
    private String isdrive;
	
	@ApiModelProperty(value = "车辆证明日期")
    private String carScrapDate;
	
	@ApiModelProperty(value = "取车人联系人")
    private String takeCarContacts;

	@ApiModelProperty(value = "取车联系电话")
    private String takeCarContactNumber;
	
	@ApiModelProperty(value = "取车时间")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date takeCarTime;

	@ApiModelProperty(value = "取车地址")
    private String takeCarAddress;

	public String getCarAscription() {
		return carAscription;
	}

	public void setCarAscription(String carAscription) {
		this.carAscription = carAscription;
	}

	public String getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}

	public String getIsdrive() {
		return isdrive;
	}

	public void setIsdrive(String isdrive) {
		this.isdrive = isdrive;
	}

	public String getCarScrapDate() {
		return carScrapDate;
	}

	public void setCarScrapDate(String carScrapDate) {
		this.carScrapDate = carScrapDate;
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

	public Date getTakeCarTime() {
		return takeCarTime;
	}

	public void setTakeCarTime(Date takeCarTime) {
		this.takeCarTime = takeCarTime;
	}

	public String getTakeCarAddress() {
		return takeCarAddress;
	}

	public void setTakeCarAddress(String takeCarAddress) {
		this.takeCarAddress = takeCarAddress;
	}
	
	


}
