package com.car.app.carscraporder.service;

import java.util.List;

import com.car.app.carscraporder.bo.CarScrapOrderSettlementBO;
import com.car.app.carscraporder.pojo.CarScrapOrderSettlement;

/**
 * 
 * 类名称：CarScrapOrderSettlementService   
 * 类描述：汽车报废结算记录服务类   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 下午4:23:09      
 * @version  V1.0
 *
 */
public interface CarScrapOrderSettlementService extends BaseService<CarScrapOrderSettlement> {
	
	
	public Integer saveCarScrapOrderSettlement(CarScrapOrderSettlement carScrapOrderSettlement)throws Exception;
	
	public List<CarScrapOrderSettlementBO>  getCarScrapOrderSettlementByOrderId(String orderid);

}
