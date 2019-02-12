package com.car.app.carscraporder.vo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

import com.fasterxml.jackson.annotation.JsonFormat;
public class CarScrapOrderVO {
	
	
    private String id;
    
    @ApiModelProperty(value = "报案号")
	private String reportNo;
    
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
	
	@ApiModelProperty(hidden = true)
	private Integer orderAreasId;
	
	@ApiModelProperty(hidden = true)
    private String clientId;
	
	//"申请订单客户类型（1：各人 2：大客户）")
	@ApiModelProperty(hidden = true)
	private String clientType;

	@ApiModelProperty(value = "能否行驶(0:否,1:是)")
    private String isdrive;

	@ApiModelProperty(value = "订单类型（1:整车，2:旧件）")
	private String orderType;
	
	@ApiModelProperty(value = "取车人联系人")
    private String takeCarContacts;

	@ApiModelProperty(value = "取车联系电话")
    private String takeCarContactNumber;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "取车时间")
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

	

	@ApiModelProperty(value = "收款人姓名")
    private String payeeName;

	@ApiModelProperty(value = "银行账户")
    private String bankAccount;
	
	@ApiModelProperty(value = "开户行")
    private String openingBank;
	
	//@ApiModelProperty(value = "数据创建人(系统获取登录session填充)")
	@ApiModelProperty(hidden = true)
	private String creater;
	
	//@ApiModelProperty(value = "修改人(系统获取登录session填充)")
	@ApiModelProperty(hidden = true)
    private String operator;
	
	@ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;
	
	private String auditRemark;
	
	private String agentUserid;
	
	
	
	
	
	List<CarScrapOrderAutopartsVO> carScrapOrderAutopartsList = new ArrayList<CarScrapOrderAutopartsVO>();
	//是否设置常用联系人
	private Boolean isSetUpContacts=false;
	
	//是否设置常用收款账户
	private Boolean isSetUpPayee=false;
	
	//是否设置常用收件人
	private Boolean isSetUpMailing=false;
	
	
	private List<CarScrapOrderPictureVO> pictures = new ArrayList<CarScrapOrderPictureVO>();
	
	
	
	

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getAgentUserid() {
		return agentUserid;
	}

	public void setAgentUserid(String agentUserid) {
		this.agentUserid = agentUserid;
	}

	public Boolean getIsSetUpPayee() {
		return isSetUpPayee;
	}

	public void setIsSetUpPayee(Boolean isSetUpPayee) {
		this.isSetUpPayee = isSetUpPayee;
	}

	public Boolean getIsSetUpMailing() {
		return isSetUpMailing;
	}

	public void setIsSetUpMailing(Boolean isSetUpMailing) {
		this.isSetUpMailing = isSetUpMailing;
	}

	public Integer getOrderAreasId() {
		return orderAreasId;
	}

	public void setOrderAreasId(Integer orderAreasId) {
		this.orderAreasId = orderAreasId;
	}

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

	public List<CarScrapOrderAutopartsVO> getCarScrapOrderAutopartsList() {
		return carScrapOrderAutopartsList;
	}

	public void setCarScrapOrderAutopartsList(
			List<CarScrapOrderAutopartsVO> carScrapOrderAutopartsList) {
		this.carScrapOrderAutopartsList = carScrapOrderAutopartsList;
	}

	public List<CarScrapOrderPictureVO> getPictures() {
		return pictures;
	}

	public void setPictures(List<CarScrapOrderPictureVO> pictures) {
		this.pictures = pictures;
	}

	

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public Boolean getIsSetUpContacts() {
		return isSetUpContacts;
	}

	public void setIsSetUpContacts(Boolean isSetUpContacts) {
		this.isSetUpContacts = isSetUpContacts;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarFrameNumber() {
		return carFrameNumber;
	}

	public void setCarFrameNumber(String carFrameNumber) {
		this.carFrameNumber = carFrameNumber;
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
		this.carAscription = carAscription;
	}

	public String getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}

	

	public String getIsdrive() {
		return isdrive;
	}

	public void setIsdrive(String isdrive) {
		this.isdrive = isdrive;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getTakeCarContacts() {
		return takeCarContacts;
	}

	public void setTakeCarContacts(String takeCarContacts) {
		this.takeCarContacts = takeCarContacts;
	}

	public String getTakeCarContactNumber() {
		return takeCarContactNumber;
	}

	public void setTakeCarContactNumber(String takeCarContactNumber) {
		this.takeCarContactNumber = takeCarContactNumber;
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
		this.takeCarAddress = takeCarAddress;
	}

	
	
	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

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

	

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getOpeningBank() {
		return openingBank;
	}

	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "CarScrapOrderVO [id=" + id + ", reportNo=" + reportNo
				+ ", reportTime=" + reportTime + ", carNumber=" + carNumber
				+ ", carFrameNumber=" + carFrameNumber + ", carModelNumber="
				+ carModelNumber + ", carAscription=" + carAscription
				+ ", carOwner=" + carOwner + ", orderAreasId=" + orderAreasId
				+ ", clientId=" + clientId + ", clientType=" + clientType
				+ ", isdrive=" + isdrive + ", orderType=" + orderType
				+ ", takeCarContacts=" + takeCarContacts
				+ ", takeCarContactNumber=" + takeCarContactNumber
				+ ", takeCarTime=" + takeCarTime + ", takeCarAddress="
				+ takeCarAddress + ", expressCompany=" + expressCompany
				+ ", expressNumber=" + expressNumber + ", mailingAddressName="
				+ mailingAddressName + ", mailingAddressTelephone="
				+ mailingAddressTelephone + ", province=" + province
				+ ", city=" + city + ", county=" + county
				+ ", detailedAddress=" + detailedAddress + ", payeeName="
				+ payeeName + ", bankAccount=" + bankAccount + ", openingBank="
				+ openingBank + ", creater=" + creater + ", operator="
				+ operator + ", carScrapOrderAutopartsList="
				+ carScrapOrderAutopartsList + ", isSetUpContacts="
				+ isSetUpContacts + ", pictures=" + pictures + "]";
	}

	
	
	
	

	
	
	

}
