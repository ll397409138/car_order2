package com.car.app.carscraporder.service;

import com.car.app.carscraporder.bo.RoleBO;
import com.car.app.carscraporder.pojo.Role;
import com.car.app.carscraporder.service.BaseService;
import com.car.app.carscraporder.vo.RoleVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

public interface RoleService extends BaseService<Role> {
	
	public Integer save(RoleVO roleVO) throws Exception;
	
	public Integer update(RoleVO roleVO) throws Exception;
	
	public RoleBO queryRoleInfoById(Integer id) throws Exception;
	
	
	public PageInfo<RoleBO> queryBOPageListByWhere(int page, int rows, Role paramter)throws Exception;
	
	
}
