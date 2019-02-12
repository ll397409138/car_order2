package com.car.app.carscraporder.vo;

import java.util.ArrayList;
import java.util.List;

import com.car.app.carscraporder.pojo.CarOrderSettlementFlow;
import com.car.app.carscraporder.pojo.CarScrapOrderSettlement;

public class CarOrderSettlementFlowVO extends CarOrderSettlementFlow{
	
	
	private List<CarScrapOrderSettlement>  settlementInfos = new ArrayList<CarScrapOrderSettlement>();

	public List<CarScrapOrderSettlement> getSettlementInfos() {
		return settlementInfos;
	}

	public void setSettlementInfos(List<CarScrapOrderSettlement> settlementInfos) {
		this.settlementInfos = settlementInfos;
	}
	
	
	

}
