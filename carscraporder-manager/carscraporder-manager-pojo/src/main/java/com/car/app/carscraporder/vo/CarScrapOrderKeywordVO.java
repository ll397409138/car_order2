package com.car.app.carscraporder.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class CarScrapOrderKeywordVO {
	
	@ApiModelProperty(value = "查询关键字")
	private String keyWord;
	
	@ApiModelProperty(value = "查询订单状态")
	private String orderStatus;
	
	//@ApiModelProperty(value = "代办人主键")
	@ApiParam(hidden = true)
	private String userid;
	
	//@ApiModelProperty(value = "订单委托人")
	@ApiParam(hidden = true)
	private String clientId;
	
	
	@ApiModelProperty(value = "订单类型：1整车 2.旧件")
	private String orderType;
	
	@ApiParam(hidden = true)
	private String araesids;
	
	@ApiParam(hidden = true)
	private List<String> araesidList;
	
	@ApiParam(hidden = true)
	private List<String> orderStatusList;
	
	@ApiModelProperty(value = "分拣状态")
	private Integer sortingState;
	
	private Boolean isSorting;
	
	@ApiParam(hidden = true)
	private Date earlyWarningDate;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Date getEarlyWarningDate() {
		return earlyWarningDate;
	}
	public void setEarlyWarningDate(Date earlyWarningDate) {
		this.earlyWarningDate = earlyWarningDate;
	}
	public Boolean getIsSorting() {
		return isSorting;
	}
	public void setIsSorting(Boolean isSorting) {
		this.isSorting = isSorting;
	}
	public Integer getSortingState() {
		return sortingState;
	}
	public void setSortingState(Integer sortingState) {
		this.sortingState = sortingState;
	}
	public List<String> getOrderStatusList() {
		return orderStatusList;
	}
	public void setOrderStatusList(List<String> orderStatusList) {
		this.orderStatusList = orderStatusList;
	}
	public List<String> getAraesidList() {
		return araesidList;
	}
	public void setAraesidList(List<String> araesidList) {
		this.araesidList = araesidList;
	}
	public String getAraesids() {
		return araesids;
	}
	public void setAraesids(String araesids) {
		this.araesids = araesids;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	

}
