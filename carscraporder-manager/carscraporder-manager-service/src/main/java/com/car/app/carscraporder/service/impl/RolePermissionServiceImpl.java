package com.car.app.carscraporder.service.impl;


import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.RolePermissionMapper;
import com.car.app.carscraporder.pojo.RolePermission;
import com.car.app.carscraporder.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission> implements
		RolePermissionService {
	
	private RolePermissionMapper rolePermissionMapper;

}
