package com.car.app.carscraporder.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.car.app.carscraporder.mapper.CarScrapOrderAuditMapper;
import com.car.app.carscraporder.pojo.CarScrapOrderAudit;
import com.car.app.carscraporder.service.CarScrapOrderAuditService;
import com.github.abel533.entity.Example;

@Service
public class CarScrapOrderAuditServiceImpl extends BaseServiceImpl<CarScrapOrderAudit> implements CarScrapOrderAuditService {
	@Autowired
	private CarScrapOrderAuditMapper carScrapOrderAuditMapper;
	
	public Integer save(CarScrapOrderAudit record) throws Exception{
		//查询上一次订单id
		Example example =new Example(CarScrapOrderAudit.class);
		example.setOrderByClause("audit_time desc ,id desc");
		example.createCriteria().andEqualTo("orderId", record.getOrderId());
		
		List<CarScrapOrderAudit> carScrapOrderAuditList = super.queryListByExample(example);
		if(carScrapOrderAuditList.size()>0){
			
			CarScrapOrderAudit lastAuditData = carScrapOrderAuditList.get(0);
			
			record.setLasttimeId(lastAuditData.getId());
		}
		
		return super.save(record);
	}
	
	

}
