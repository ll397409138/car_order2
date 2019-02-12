package com.car.app.carscraporder.vo;

import io.swagger.annotations.ApiModelProperty;

public class CarScrapOrderSimple2BaseVO extends CarScrapOrderSimpleBaseVO {
	
	
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

}
