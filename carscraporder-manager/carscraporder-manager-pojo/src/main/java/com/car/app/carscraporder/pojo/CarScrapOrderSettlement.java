package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * 类名称：CarScrapOrderSettlement   
 * 类描述：订单结算历史记录   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 上午11:54:42      
 * @version  V1.0
 *
 */
@Table(name="car_scrap_order_settlement")
public class CarScrapOrderSettlement extends BasePojo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	//@ApiModelProperty(value = "结算流水")
	private Integer settlementFlow;

	@ApiModelProperty(value = "结算类型（1:整车 2:配件）")
    private String settlementType;

	@ApiModelProperty(value = "结算对象id")
    private String settlementObjectId;

	@ApiModelProperty(value = "结算金额")
    private BigDecimal settlementAmount;

	@ApiModelProperty(value = "结算备注")
    private String settlementRemarks;

	@ApiModelProperty(value = "结算操作员")
    private String settlementer;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "结算时间")
    private Date settlementTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    

    public Integer getSettlementFlow() {
		return settlementFlow;
	}

	public void setSettlementFlow(Integer settlementFlow) {
		this.settlementFlow = settlementFlow;
	}

	public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType == null ? null : settlementType.trim();
    }

    public String getSettlementObjectId() {
        return settlementObjectId;
    }

    public void setSettlementObjectId(String settlementObjectId) {
        this.settlementObjectId = settlementObjectId == null ? null : settlementObjectId.trim();
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
        this.settlementRemarks = settlementRemarks == null ? null : settlementRemarks.trim();
    }

   

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
}