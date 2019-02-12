package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * 类名称：CarScrapOrderAudit   
 * 类描述： 订单审核记录表
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 上午11:42:00      
 * @version  V1.0
 *
 */
@Table(name="car_scrap_order_audit")
public class CarScrapOrderAudit extends BasePojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ApiModelProperty(value = "订单id")
    private String orderId;

	@ApiModelProperty(value = "上次审核id")
    private Integer lasttimeId;

	@ApiModelProperty(value = "订单状态")
    private Integer stauts;

	@ApiModelProperty(value = "审核备注")
    private String remark;

	@ApiModelProperty(value = "审核人")
    private String auditor;

	@ApiModelProperty(value = "审核时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime;
	
	@ApiModelProperty(value = "业务类型")
	private String businessType;

   

    public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getLasttimeId() {
        return lasttimeId;
    }

    public void setLasttimeId(Integer lasttimeId) {
        this.lasttimeId = lasttimeId;
    }

   
    public Integer getStauts() {
		return stauts;
	}

	public void setStauts(Integer stauts) {
		this.stauts = stauts;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    
}