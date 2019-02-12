package com.car.app.carscraporder.mapper;

import java.util.List;

import com.car.app.carscraporder.bo.CarScrapOrderSettlementBO;
import com.car.app.carscraporder.pojo.CarScrapOrderSettlement;
import com.github.abel533.mapper.Mapper;

public interface CarScrapOrderSettlementMapper extends Mapper<CarScrapOrderSettlement>{
	
	public List<CarScrapOrderSettlementBO>  getCarScrapOrderSettlementByOrderId(String orderid);
	
	
	public List<CarScrapOrderSettlementBO>  getCarScrapOrderOfOldSettlementByOrderId(String orderid);

}
