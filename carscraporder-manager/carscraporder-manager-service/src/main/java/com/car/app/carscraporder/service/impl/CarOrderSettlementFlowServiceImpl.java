package com.car.app.carscraporder.service.impl;



import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.CarOrderSettlementFlowMapper;
import com.car.app.carscraporder.pojo.CarOrderSettlementFlow;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderSettlement;
import com.car.app.carscraporder.service.CarOrderSettlementFlowService;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.service.CarScrapOrderSettlementService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.vo.CarOrderSettlementFlowVO;

@Service
public class CarOrderSettlementFlowServiceImpl extends BaseServiceImpl<CarOrderSettlementFlow> implements
		CarOrderSettlementFlowService  {

	
	@Autowired
	private CarOrderSettlementFlowMapper carOrderSettlementFlowMapper;
	@Autowired
	private CarScrapOrderService  carScrapOrderService;
	
	@Autowired
	private CarScrapOrderSettlementService  carScrapOrderSettlementService;
	
	public Integer saveFlow(CarOrderSettlementFlowVO flow) throws Exception{
		//根据订单id查询订单信息
		CarScrapOrder carScrapOrder = carScrapOrderService.queryById(flow.getOrderid());
		if(carScrapOrder!=null){
			//保存流水
			CarOrderSettlementFlow data = new CarOrderSettlementFlow();
			BeanUtils.copyProperties(flow, data);
			data.setSettlementer(flow.getCreater());
			data.setSettlementTime(new Date());
			data = super.saveReturnPersistentObject(data);
			if(StringUtils.equals(CommonSystemParamter.ORDER_WhOLECAR_TYPE, carScrapOrder.getOrderType())){
				//整车
				if(flow.getSettlementInfos()!=null&& flow.getSettlementInfos().size()>0){
					for(CarScrapOrderSettlement settment:flow.getSettlementInfos()){
						settment.setCreater(flow.getCreater());
						settment.setSettlementer(flow.getCreater());
						settment.setSettlementType("1");
						settment.setSettlementFlow(data.getId());
						settment.setSettlementObjectId(flow.getOrderid());
						carScrapOrderSettlementService.saveCarScrapOrderSettlement(settment);
					}
					
					
				}
				
				
				
			}else{
				if(flow.getSettlementInfos()!=null&& flow.getSettlementInfos().size()>0){
					for(CarScrapOrderSettlement settment:flow.getSettlementInfos()){
						settment.setCreater(flow.getCreater());
						settment.setSettlementer(flow.getCreater());
						settment.setSettlementType("2");
						settment.setSettlementFlow(data.getId());
						carScrapOrderSettlementService.saveCarScrapOrderSettlement(settment);
					}
					
					
				}
				
			}
			
			return 1;
		}else{
			return 0;
		}
		
		
		
		
		
		
		
		
	
		
		
		
	}
	
	
	

}
