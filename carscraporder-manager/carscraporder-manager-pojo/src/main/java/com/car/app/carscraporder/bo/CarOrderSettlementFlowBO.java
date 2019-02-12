package com.car.app.carscraporder.bo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CarOrderSettlementFlowBO {
	
	
	 private String settlementer;

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date settlementTime;
	
	@ApiModelProperty(value = "结算金额")
    private BigDecimal settlementAmount;

	@ApiModelProperty(value = "结算备注")
    private String settlementRemarks;

	public String getSettlementer() {
		return settlementer;
	}

	public void setSettlementer(String settlementer) {
		this.settlementer = settlementer;
	}

	public Date getSettlementTime() {
		return settlementTime;
	}

	public void setSettlementTime(Date settlementTime) {
		this.settlementTime = settlementTime;
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
