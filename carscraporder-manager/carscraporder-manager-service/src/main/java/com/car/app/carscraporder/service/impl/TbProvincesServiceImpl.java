package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.car.app.carscraporder.mapper.TbProvincesMapper;
import com.car.app.carscraporder.pojo.TbProvinces;
import com.car.app.carscraporder.service.TbProvincesService;

@Service
public class TbProvincesServiceImpl extends BaseServiceImpl<TbProvinces> implements
		TbProvincesService {
	
	@Autowired
	private TbProvincesMapper tbProvincesMapper;

	


}
