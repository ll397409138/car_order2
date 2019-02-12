package com.car.app.carscraporder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.bo.RoleBO;
import com.car.app.carscraporder.pojo.Role;
import com.github.abel533.mapper.Mapper;

public interface RoleMapper extends Mapper<Role> {
	
	public List<RoleBO> queryBOPageListByWhere(@Param("paramter")Role paramter)throws Exception;

}
