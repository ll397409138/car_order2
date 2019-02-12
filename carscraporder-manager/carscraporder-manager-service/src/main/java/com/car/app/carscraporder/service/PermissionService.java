package com.car.app.carscraporder.service;

import java.util.List;

import com.car.app.carscraporder.bo.PermissionBO;
import com.car.app.carscraporder.pojo.Permission;

public interface PermissionService extends BaseService<Permission> {
	
	public List<Permission> getPermosssionsCodeByUserid(String userid);
	
	public List<PermissionBO> queryPermissionsByRoleid(Integer roleid)throws Exception;
	
	public List<PermissionBO> getPermissionTree()throws Exception;
	
	
	public List<Permission>  getAppPermissionByBusinessCode(String businessCode,String userid)throws Exception;
	
	public List<Permission>  getWebPermission(String userid)throws Exception;
	

    public List<Permission>  getSubPermissionList(String percode,String userid)throws Exception;
	
	

}
