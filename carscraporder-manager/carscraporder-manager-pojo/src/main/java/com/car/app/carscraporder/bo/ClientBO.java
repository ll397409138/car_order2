package com.car.app.carscraporder.bo;

import com.car.app.carscraporder.pojo.Client;

public class ClientBO extends Client{
	
	private Integer areaid;
	private String areaName;
	private String customerName;
	
	private String bankAccount;
	private String openingBank;
	
	
	
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	public Integer getAreaid() {
		return areaid;
	}
	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
