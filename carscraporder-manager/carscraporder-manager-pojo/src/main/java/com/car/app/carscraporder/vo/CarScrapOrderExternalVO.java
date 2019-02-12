package com.car.app.carscraporder.vo;

import io.swagger.annotations.ApiModelProperty;

public class CarScrapOrderExternalVO extends CarScrapOrderVO{
	
	@ApiModelProperty(value = "委托方(当前登录用户id)")
    private String clientId;
	
	@ApiModelProperty(value = "申请客户类型（1：各人 2：大客户）,系统根据登录人判断")
	private String clientType;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	


}
