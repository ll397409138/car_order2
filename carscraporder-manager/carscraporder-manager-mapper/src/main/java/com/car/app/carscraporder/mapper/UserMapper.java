package com.car.app.carscraporder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.bo.UserSimpleBO;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.vo.UserVO;
import com.github.abel533.mapper.Mapper;

public interface UserMapper extends Mapper<User> {
	
	
	public UserBO queryUserBOById(String id);
	
	public List<UserBO> queryPageUser(UserVO paramter);
	
	
	public UserBO queryUserBOByNameAndPassword(String loginname);
	
	public List<UserSimpleBO> getReceiveOrderPermissionUser(@Param("permisscode")String permisscode,@Param("areid")String areid);

}
