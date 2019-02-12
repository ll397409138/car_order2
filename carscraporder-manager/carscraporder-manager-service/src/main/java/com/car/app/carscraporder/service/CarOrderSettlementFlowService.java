package com.car.app.carscraporder.service;

import com.car.app.carscraporder.pojo.CarOrderSettlementFlow;
import com.car.app.carscraporder.vo.CarOrderSettlementFlowVO;

public interface CarOrderSettlementFlowService extends BaseService<CarOrderSettlementFlow> {
	
	public Integer saveFlow(CarOrderSettlementFlowVO flow)throws Exception;

}
