package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.car.app.carscraporder.mapper.AreasMapper;
import com.car.app.carscraporder.pojo.Areas;
import com.car.app.carscraporder.service.AreasService;

@Service
public class AreasServiceImpl extends BaseServiceImpl<Areas> implements
		AreasService {
	
	@Autowired
	private AreasMapper areasMapper;


}
