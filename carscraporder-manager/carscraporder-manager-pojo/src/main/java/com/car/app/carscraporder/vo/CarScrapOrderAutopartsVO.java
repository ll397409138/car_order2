package com.car.app.carscraporder.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class CarScrapOrderAutopartsVO {
	
	
    private String id;
    
    @ApiModelProperty(value = "订单id")
    private String orderId;
	
	@ApiModelProperty(value = "配件类型")
    private Integer partsType;

	@ApiModelProperty(value = "配件名称")
    private String partsName;
	
	@ApiModelProperty(value = "配件编号")
    private String partsNum;
	
	@ApiModelProperty(value = "配件备注")
    private String remark;
	
	private String qrPic;
	
	@ApiModelProperty(value = "无法接收原因")
	private Integer unableReceiveReason;
	
	

	@ApiModelProperty(value = "配件金额")
    private BigDecimal amount;
	
	@ApiModelProperty(value = "数据操作人记录")
	private String operator;
	private String creater;
	
	
	private List<CarScrapOrderPictureVO> pictures = new ArrayList<CarScrapOrderPictureVO>();
	
	
	

	public Integer getUnableReceiveReason() {
		return unableReceiveReason;
	}

	public void setUnableReceiveReason(Integer unableReceiveReason) {
		this.unableReceiveReason = unableReceiveReason;
	}

	public String getQrPic() {
		return qrPic;
	}

	public void setQrPic(String qrPic) {
		this.qrPic = qrPic;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<CarScrapOrderPictureVO> getPictures() {
		return pictures;
	}

	public void setPictures(List<CarScrapOrderPictureVO> pictures) {
		this.pictures = pictures;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Integer getPartsType() {
		return partsType;
	}

	public void setPartsType(Integer partsType) {
		this.partsType = partsType;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public String getPartsNum() {
		return partsNum;
	}

	public void setPartsNum(String partsNum) {
		this.partsNum = partsNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	

}
