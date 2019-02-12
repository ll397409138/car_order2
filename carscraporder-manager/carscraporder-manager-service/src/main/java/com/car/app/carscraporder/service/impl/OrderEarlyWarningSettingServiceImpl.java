package com.car.app.carscraporder.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.OrderEarlyWarningSettingMapper;
import com.car.app.carscraporder.pojo.OrderEarlyWarningSetting;
import com.car.app.carscraporder.service.OrderEarlyWarningSettingService;

@Service
public class OrderEarlyWarningSettingServiceImpl extends BaseServiceImpl<OrderEarlyWarningSetting>
		implements OrderEarlyWarningSettingService {
	
	@Autowired
	private OrderEarlyWarningSettingMapper  orderEarlyWarningSettingMapper;

	

}
