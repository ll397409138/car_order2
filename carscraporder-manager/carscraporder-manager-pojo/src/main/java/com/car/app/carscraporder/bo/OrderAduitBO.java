package com.car.app.carscraporder.bo;


import java.util.Date;

import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderAduitBO extends CarScrapOrder {
	
	
	private Integer partsCount;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date receiveOrderTime;
	
	
	private String recipient;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date settlementTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;
	
	//private List<CarScrapOrderAuditBO> carScrapOrderAuditBO = new ArrayList<CarScrapOrderAuditBO>();

	public Integer getPartsCount() {
		return partsCount;
	}

	public void setPartsCount(Integer partsCount) {
		this.partsCount = partsCount;
	}



	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getReceiveOrderTime() {
		return receiveOrderTime;
	}

	public void setReceiveOrderTime(Date receiveOrderTime) {
		this.receiveOrderTime = receiveOrderTime;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public Date getSettlementTime() {
		return settlementTime;
	}

	public void setSettlementTime(Date settlementTime) {
		this.settlementTime = settlementTime;
	}

	
	
//	public List<CarScrapOrderAuditBO> getCarScrapOrderAuditBO() {
//		return carScrapOrderAuditBO;
//	}
//
//	public void setCarScrapOrderAuditBO(
//			List<CarScrapOrderAuditBO> carScrapOrderAuditBO) {
//		this.carScrapOrderAuditBO = carScrapOrderAuditBO;
//	}
	
	
	
	

}
