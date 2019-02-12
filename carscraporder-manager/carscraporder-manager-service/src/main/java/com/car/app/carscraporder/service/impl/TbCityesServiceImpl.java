package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbCityesMapper;
import com.car.app.carscraporder.pojo.TbCityes;
import com.car.app.carscraporder.service.TbCityesService;

@Service
public class TbCityesServiceImpl extends BaseServiceImpl<TbCityes> implements
		TbCityesService {
	
	@Autowired
	private TbCityesMapper tbCityesMapper;


}
