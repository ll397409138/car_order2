package com.car.app.carscraporder.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.bo.PermissionBO;
import com.car.app.carscraporder.pojo.Permission;
import com.github.abel533.mapper.Mapper;

public interface PermissionMapper extends Mapper<Permission> {
	
	public List<Permission> getPermosssionsCodeByUserid(String userid);
	
	public Set<Integer> queryPermissionsByRoleid(Integer roleid);
	
	public List<PermissionBO> queryRoot();
	
	public List<PermissionBO> queryBOByParentId(Integer parentid);
	
	public List<Permission>  getAppPermissionByBusinessCode(@Param("businessCode")String businessCode,@Param("userid")String userid);
	
	
	public List<Permission>  getWebPermission(String userid);
	
	public List<Permission>  getSubPermissionList(@Param("userid")String userid,@Param("parentid")int parentid);
	

	
	
}
