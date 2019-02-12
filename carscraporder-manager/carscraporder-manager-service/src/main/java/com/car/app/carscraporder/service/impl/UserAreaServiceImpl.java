package com.car.app.carscraporder.service.impl;


import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.UserAreaMapper;
import com.car.app.carscraporder.pojo.UserArea;
import com.car.app.carscraporder.service.UserAreaService;

@Service
public class UserAreaServiceImpl  extends BaseServiceImpl<UserArea> implements UserAreaService {
	
	private UserAreaMapper userAreaMapper;

	
}
