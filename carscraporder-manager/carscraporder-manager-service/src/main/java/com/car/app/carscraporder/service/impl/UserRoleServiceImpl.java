package com.car.app.carscraporder.service.impl;


import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.UserRoleMapper;
import com.car.app.carscraporder.pojo.UserRole;
import com.car.app.carscraporder.service.UserRoleService;


@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements
		UserRoleService {

	private UserRoleMapper userRoleMapper;
	

}
