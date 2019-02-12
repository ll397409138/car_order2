package com.car.app.carscraporder.bo;

import com.car.app.carscraporder.pojo.Company;

public class CompanyBO extends Company {
	
	private String areasName;
	private Integer clientCount;
	
	

	public Integer getClientCount() {
		return clientCount;
	}

	public void setClientCount(Integer clientCount) {
		this.clientCount = clientCount;
	}

	public String getAreasName() {
		return areasName;
	}

	public void setAreasName(String areasName) {
		this.areasName = areasName;
	}

	
	

}
