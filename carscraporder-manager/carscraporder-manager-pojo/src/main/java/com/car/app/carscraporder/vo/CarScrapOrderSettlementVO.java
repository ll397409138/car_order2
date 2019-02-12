package com.car.app.carscraporder.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class CarScrapOrderSettlementVO {
	
	
	@ApiModelProperty(value = "结算类型（1:整车 2:配件）")
    private String settlementType;

	@ApiModelProperty(value = "结算对象id")
    private String settlementObjectId;

	@ApiModelProperty(value = "结算金额")
    private BigDecimal settlementAmount;

	@ApiModelProperty(value = "结算备注")
    private String settlementRemarks;

	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

	public String getSettlementObjectId() {
		return settlementObjectId;
	}

	public void setSettlementObjectId(String settlementObjectId) {
		this.settlementObjectId = settlementObjectId;
	}

	public BigDecimal getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(BigDecimal settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public String getSettlementRemarks() {
		return settlementRemarks;
	}

	public void setSettlementRemarks(String settlementRemarks) {
		this.settlementRemarks = settlementRemarks;
	}

	

}
