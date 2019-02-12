package com.car.app.carscraporder.vo;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class CarScrapOrderAutopartsKeyWordVO {
	
	@ApiModelProperty(value = "查询关键字")
	private String keyWord;
	
	@ApiModelProperty(value = "查询配件状态")
	private String orderStatus;
	
	@ApiParam(hidden = true)
	private List<String> araesidList = new ArrayList<String>();
	
	private String userid;
	
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public List<String> getAraesidList() {
		return araesidList;
	}

	public void setAraesidList(List<String> araesidList) {
		this.araesidList = araesidList;
	}
	
	

}
