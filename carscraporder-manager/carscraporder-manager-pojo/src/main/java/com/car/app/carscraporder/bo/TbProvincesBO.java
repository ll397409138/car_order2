package com.car.app.carscraporder.bo;

import java.util.ArrayList;
import java.util.List;

import com.car.app.carscraporder.pojo.TbProvinces;

public class TbProvincesBO extends TbProvinces{
	
	private List<TbCityesBO>  cityesList = new ArrayList<TbCityesBO>();

	public List<TbCityesBO> getCityesList() {
		return cityesList;
	}

	public void setCityesList(List<TbCityesBO> cityesList) {
		this.cityesList = cityesList;
	}
	
	
	

}
