package com.car.app.carscraporder.service.impl;



import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.bo.UserSimpleBO;
import com.car.app.carscraporder.mapper.UserMapper;
import com.car.app.carscraporder.pojo.Role;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.pojo.UserArea;
import com.car.app.carscraporder.pojo.UserRole;
import com.car.app.carscraporder.service.UserAreaService;
import com.car.app.carscraporder.service.UserRoleService;
import com.car.app.carscraporder.service.UserService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.vo.UserVO;
import com.car.app.common.exception.DataException;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserAreaService userAreaService;
	@Autowired
	private UserRoleService userRoleService;
	
	
	
	  /**
     * 保存用户信息和角色相关，同步企业微信成员
     * @param user
     * @return
     * @throws Exception
     */
	public Integer saveUserAndRoleAndAreas(UserVO uservo)throws Exception{
		//校验名称是否重复
		User userquery = new User();
		userquery.setLoginName(uservo.getLoginName());
		List<User> userList = super.queryListByWhere(userquery);
		if(userList.size()>0){
			throw new DataException("用户名重复");
		}
		User user = new User();
		BeanUtils.copyProperties(uservo,user);
		
		
		String id= UUID.randomUUID().toString().replaceAll("-", "");
		user.setId(id);
		
		String salt = UUID.randomUUID().toString().replaceAll("-", "");
		user.setPasswordSalt(salt);
		user.setPassword(StringUtils.createPassword(uservo.getPassword(), salt, 2));
		user.setStatus("1");
		user = super.saveReturnPersistentObject(user);
		
		//保存用户角色中间表
		String roleids = uservo.getRoleids();
		if(StringUtils.isNotBlank(roleids)){
			String[] roleidArray = roleids.split(",");
			//插入用户角色中间表
			for(String roleid:roleidArray){
				UserRole ur = new UserRole();
				ur.setRoleid(Integer.parseInt(roleid));
				ur.setUserid(user.getId());
				ur.setCreater(user.getCreater());
				userRoleService.save(ur);
			}
			
		}
		
		
		//保存用户区域中间表
		String areasIds = uservo.getAreasids();
        if(StringUtils.isNotBlank(areasIds)){
        	String[] areasidArray = areasIds.split(",");
        	//插入用户角色中间表
        	for(String areasid:areasidArray){
        		UserArea ua = new UserArea();
        		ua.setAreaid(Integer.parseInt(areasid));
        		ua.setUserid(user.getId());
        		ua.setCreater(user.getCreater());
        		userAreaService.save(ua);
        	}
        	
        }
		return 1;

	}
	
	
	public Integer updateUserAndRoleAndAreas(UserVO uservo)throws Exception{
		User user = userMapper.selectByPrimaryKey(uservo.getId());
		if(user==null){
			throw new DataException("修改用户不存在");
		}
		User saveuser = new User();
		BeanUtils.copyProperties(uservo,saveuser);
		saveuser.setCreater(user.getCreater());
		saveuser.setCreatetime(user.getCreatetime());
		saveuser.setPassword(user.getPassword());
		saveuser.setPasswordSalt(user.getPasswordSalt());
		saveuser.setLoginName(user.getLoginName());
		saveuser.setStatus(user.getStatus());
	    super.update(saveuser);
	    
	    //删除原来关联角色中间表
	    UserRole urWhereParamter = new UserRole();
	    urWhereParamter.setUserid(user.getId());
	    userRoleService.deleteByWhere(urWhereParamter);
	    
		//保存用户角色中间表
		 String roleids = uservo.getRoleids();
			if(StringUtils.isNotBlank(roleids)){
				String[] roleidArray = roleids.split(",");
				//插入用户角色中间表
				for(String roleid:roleidArray){
					UserRole ur = new UserRole();
					ur.setRoleid(Integer.parseInt(roleid));
					ur.setUserid(user.getId());
					ur.setCreater(user.getCreater());
					userRoleService.save(ur);
				}
				
			}
		//删除原来关联的用户区域中间表	
		UserArea uaWhereParamter = new 	UserArea();
		uaWhereParamter.setUserid(user.getId());
		userAreaService.deleteByWhere(uaWhereParamter);
		
		String areasIds = uservo.getAreasids();
		        if(StringUtils.isNotBlank(areasIds)){
		        	String[] areasidArray = areasIds.split(",");
		        	//插入用户角色中间表
		        	for(String areasid:areasidArray){
		        		UserArea ua = new UserArea();
		        		ua.setAreaid(Integer.parseInt(areasid));
		        		ua.setUserid(user.getId());
		        		ua.setCreater(user.getCreater());
		        		userAreaService.save(ua);
		        	}
		        	
		        }
				return 1;
		
		
	}
	
	

	
	public User queryById(String id)throws Exception{
		
		
		return userMapper.selectByPrimaryKey(id);
	}
	
	public UserBO queryUserBOById(String id)throws Exception{
		return userMapper.queryUserBOById(id);
	}
	
	
	public Integer deleteById(String id)throws Exception{
		User user = queryById(id);
		if(user==null){
			throw new RuntimeException("用户不存在");
		}
		user.setStatus(CommonSystemParamter.USER_STATUS_DELETE);
		return userMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public PageInfo<UserBO> queryPageListUser(Integer page, Integer rows,UserVO user) {
		
		PageHelper.startPage(page, rows);
		
		
		
		List<UserBO> listData = userMapper.queryPageUser(user);
	
		return new PageInfo<UserBO>(listData);
	}
	
	
	public UserBO queryUserBOByName(String loginname)throws Exception{
		return userMapper.queryUserBOByNameAndPassword(loginname);
		
		
	}
	
	public List<UserSimpleBO> getReceiveOrderPermissionUser(String permisscode,String areid){
		return userMapper.getReceiveOrderPermissionUser(permisscode,areid);
	}
	
	

	

}
