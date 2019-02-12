package com.car.app.carscraporder.vo;

import io.swagger.annotations.ApiModelProperty;

public class CarScrapOrderAutopartsWhereParamter {
	
	 //报案号
	 @ApiModelProperty(value = "报案号")
     private String reportNo;
	//车牌号
	@ApiModelProperty(value = "车牌号")
    private String carNumber;
	//车架号
	@ApiModelProperty(value = "车架号")
    private String carFrameNumber;
	//车型
	@ApiModelProperty(value = "车辆型号(数据来源车型号数据字典)")
    private String carModelNumberName;
	//联系电话
	private String takeCarContactNumber;
	//车主
    private String carOwner;
	//配件名称
    @ApiModelProperty(value = "配件名称")
    private String partsName;
	//配件状态
    @ApiModelProperty(value = "配件状态")
	private String orderAutopartsStatus;
    
    

	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
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
	public String getTakeCarContactNumber() {
		return takeCarContactNumber;
	}
	public void setTakeCarContactNumber(String takeCarContactNumber) {
		this.takeCarContactNumber = takeCarContactNumber;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getOrderAutopartsStatus() {
		return orderAutopartsStatus;
	}
	public void setOrderAutopartsStatus(String orderAutopartsStatus) {
		this.orderAutopartsStatus = orderAutopartsStatus;
	}
    
    
    

}
