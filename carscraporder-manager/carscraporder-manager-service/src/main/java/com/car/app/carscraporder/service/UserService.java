package com.car.app.carscraporder.service;
import java.util.List;

import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.bo.UserSimpleBO;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.vo.UserVO;
import com.github.pagehelper.PageInfo;
public interface UserService extends BaseService<User> {
	
	
	public Integer saveUserAndRoleAndAreas(UserVO uservo)throws Exception;
	
	public Integer updateUserAndRoleAndAreas(UserVO uservo)throws Exception;
	
	
	public Integer deleteById(String id)throws Exception;
	
	
	public UserBO queryUserBOById(String id)throws Exception;
	
	public User queryById(String id)throws Exception;
	
	public PageInfo<UserBO> queryPageListUser(Integer page, Integer rows,UserVO user) throws Exception;
	
	public UserBO queryUserBOByName(String loginname)throws Exception;
	
	
	public List<UserSimpleBO> getReceiveOrderPermissionUser(String permisscode,String areid);

}
