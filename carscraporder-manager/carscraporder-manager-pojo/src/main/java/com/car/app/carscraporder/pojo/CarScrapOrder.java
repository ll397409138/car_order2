package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * 类名称：CarScrapOrder   
 * 类描述：汽车报废订单   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 上午10:29:04      
 * @version  V1.0
 *
 */
@Table(name="car_scrap_order")
public class CarScrapOrder extends BasePojo {
	@Id
    private String id;
    
	@ApiModelProperty(value = "订单号,系统生产订单号")
	//@NotEmpty(message="用户名不能为空")
	//@Pattern(regexp = "[0-9a-zA-Z]{4,23}", message = "用户名只能输入字母或数字")
    private String orderNo;
	
	@ApiModelProperty(value = "报案号")
	private String reportNo;
	
	@ApiModelProperty(value = "订单产生时间,系统当前时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTime;

	@ApiModelProperty(value = "报案时间")
    private Date reportTime;

	@ApiModelProperty(value = "车牌号")
    private String carNumber;

	@ApiModelProperty(value = "车架号")
    private String carFrameNumber;
	
	@ApiModelProperty(value = "车辆型号(数据来源车型号数据字典)")
    private String carModelNumber;
	
	@ApiModelProperty(value = "车辆归属(1:个人,2:客户)")
    private String carAscription="1";
	
	@ApiModelProperty(value = "车主姓名")
    private String carOwner;
	
	//@ApiModelProperty(value = "下单所在区域")
	private Integer orderAreasId;

	@ApiModelProperty(value = "能否行驶(1:否,2:是 3:严重事故)")
    private String isdrive;

	@ApiModelProperty(value = "订单状态（1.未接单(提交订单)、2.接单派单、3.业务员接收车辆、4.入场、5.报废(出库)、6.邮寄手续证明(入场后订单结束前填写)、7.财务结算、8.订单结束、9、订单异常）")
    private Integer orderStatus;
	
	@ApiModelProperty(value = "订单派单业务员id")
	//@JsonIgnore
    private String agentUserid;
    
    @ApiModelProperty(value = "车辆证明日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String carScrapDate;

	@ApiModelProperty(value = "订单类型（1:整车，2:旧件）")
    private String orderType;
	
	@ApiModelProperty(value = "取车人联系人")
    private String takeCarContacts;

	@ApiModelProperty(value = "取车联系电话")
    private String takeCarContactNumber;
	
	@ApiModelProperty(value = "取车时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date takeCarTime;

	@ApiModelProperty(value = "取车地址")
    private String takeCarAddress;

	@ApiModelProperty(value = "取车地址经纬度",hidden = true)
	private String coordinate;

	
	@ApiModelProperty(value = "快递公司")
    private String expressCompany;

	@ApiModelProperty(value = "快递单号")
    private String expressNumber;
	
	@ApiModelProperty(value = "快递邮递人明细")
	private String mailingAddressName;
	
	@ApiModelProperty(value = "快递邮寄电话")
	private String mailingAddressTelephone;
	
	@ApiModelProperty(value = "快递邮递省份主键")
	private Integer province;
	
	@ApiModelProperty(value = "快递邮寄市区主键")
	private Integer city;
	
	@ApiModelProperty(value = "快递邮递县/地区之间")
	private Integer county;
	
	@ApiModelProperty(value = "快递详细地址")
	private String detailedAddress;

	@ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

	//@ApiModelProperty(value = "委托方(当前登录用户id)")
	
    private String clientId;
	
	//"申请订单客户类型（1：各人 2：大客户）")
	@JsonIgnore
	private String clientType;

	@ApiModelProperty(value = "收款人姓名")
    private String payeeName;

	@ApiModelProperty(value = "银行账户")
    private String bankAccount;
	
	@ApiModelProperty(value = "开户行")
    private String openingBank;

	//@ApiModelProperty(value = "客户账户是否删除，默认是：false 有效账户")
	@JsonIgnore
    private Boolean isremove=false;

	//@ApiModelProperty(value = "数据来源（1.web 2.小程序,3：其他）")
	@JsonIgnore
    private String sourceType;
	private String auditRemark;

   
	
	
	

    public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getAgentUserid() {
		return agentUserid;
	}

	public void setAgentUserid(String agentUserid) {
		this.agentUserid = agentUserid;
	}

	public String getCarScrapDate() {
		return carScrapDate;
	}

	public void setCarScrapDate(String carScrapDate) {
		this.carScrapDate = carScrapDate;
	}

	

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public String getCarFrameNumber() {
        return carFrameNumber;
    }

    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber == null ? null : carFrameNumber.trim();
    }

  

    public String getCarModelNumber() {
		return carModelNumber;
	}

	public void setCarModelNumber(String carModelNumber) {
		this.carModelNumber = carModelNumber;
	}

	public String getCarAscription() {
        return carAscription;
    }

    public void setCarAscription(String carAscription) {
        this.carAscription = carAscription == null ? null : carAscription.trim();
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner == null ? null : carOwner.trim();
    }

    
    
   

	public Integer getOrderAreasId() {
		return orderAreasId;
	}

	public void setOrderAreasId(Integer orderAreasId) {
		this.orderAreasId = orderAreasId;
	}

	public String getIsdrive() {
        return isdrive;
    }

    public void setIsdrive(String isdrive) {
        this.isdrive = isdrive;
    }

    

    public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getTakeCarContacts() {
        return takeCarContacts;
    }

    public void setTakeCarContacts(String takeCarContacts) {
        this.takeCarContacts = takeCarContacts == null ? null : takeCarContacts.trim();
    }

    public String getTakeCarContactNumber() {
        return takeCarContactNumber;
    }

    public void setTakeCarContactNumber(String takeCarContactNumber) {
        this.takeCarContactNumber = takeCarContactNumber == null ? null : takeCarContactNumber.trim();
    }

    public Date getTakeCarTime() {
        return takeCarTime;
    }

    public void setTakeCarTime(Date takeCarTime) {
        this.takeCarTime = takeCarTime;
    }

    public String getTakeCarAddress() {
        return takeCarAddress;
    }

    public void setTakeCarAddress(String takeCarAddress) {
        this.takeCarAddress = takeCarAddress == null ? null : takeCarAddress.trim();
    }

   

    public String getMailingAddressName() {
		return mailingAddressName;
	}

	public void setMailingAddressName(String mailingAddressName) {
		this.mailingAddressName = mailingAddressName;
	}

	public String getMailingAddressTelephone() {
		return mailingAddressTelephone;
	}

	public void setMailingAddressTelephone(String mailingAddressTelephone) {
		this.mailingAddressTelephone = mailingAddressTelephone;
	}

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getCounty() {
		return county;
	}

	public void setCounty(Integer county) {
		this.county = county;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber == null ? null : expressNumber.trim();
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }
    
    

    public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType == null ? null : clientType.trim();
	}

	public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank == null ? null : openingBank.trim();
    }

    public Boolean getIsremove() {
        return isremove;
    }

    public void setIsremove(Boolean isremove) {
        this.isremove = isremove;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    

}