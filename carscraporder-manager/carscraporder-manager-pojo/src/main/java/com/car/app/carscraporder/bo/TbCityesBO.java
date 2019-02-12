package com.car.app.carscraporder.bo;

import java.util.ArrayList;
import java.util.List;

import com.car.app.carscraporder.pojo.TbAreas;
import com.car.app.carscraporder.pojo.TbCityes;

public class TbCityesBO extends  TbCityes{
	
	private List<TbAreas> areasList = new ArrayList<TbAreas>();

	public List<TbAreas> getAreasList() {
		return areasList;
	}

	public void setAreasList(List<TbAreas> areasList) {
		this.areasList = areasList;
	}
	
	

}
