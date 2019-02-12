package com.car.app.carscraporder.vo;

import io.swagger.annotations.ApiModelProperty;

public class CarScrapOrderSimple3BaseVO extends CarScrapOrderSimple2BaseVO {
	
	@ApiModelProperty(value = "快递公司")
    private String expressCompany;

	@ApiModelProperty(value = "快递单号")
    private String expressNumber;

	public String getExpressCompany() {
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	
	
	

}
