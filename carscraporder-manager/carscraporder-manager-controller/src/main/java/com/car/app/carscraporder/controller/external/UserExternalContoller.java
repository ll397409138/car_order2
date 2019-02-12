package com.car.app.carscraporder.controller.external;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.UserService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UUIDUtil;
import com.car.app.carscraporder.vo.UserVO;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/external/salesman")
@Api(value = "External-user-API",tags={"提供外部调用的订单相关接口,(跳过登录校验,按照自定义鉴权逻辑)"} )
public class UserExternalContoller {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="doLogin",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据用户名密码查找用户",notes = "根据用户名密码查找用户")
	public ResultBean<User> getOrderList(
			@ApiParam(name = "name", value = "用户名",required = true)
			@RequestParam(value="name",required = true)String  name,
			@ApiParam(name = "password", value = "用户密码",required = true)
			@RequestParam(value="password",required = true)String password) throws Exception{
		    
		    //根据用户名查询用户
		UserBO user = userService.queryUserBOByName(name);
		    if(user==null){
		    	  throw new DataException("用户名密码错误");
		      }else {
		    	  String validpassword = StringUtils.createPassword(password, user.getPasswordSalt(), 2);
		    	  String orgiPassword = user.getPassword();
		    	  if(StringUtils.equals(validpassword, orgiPassword)){
		    		  if(StringUtils.isNotBlank(user.getAreasids())){
		    		    	String[] areaidArray = StringUtils.split(user.getAreasids(), ",");
		    		    	for(String areaid:areaidArray){
		    		    		if(StringUtils.equals(areaid, "1")){
		    		    			user.setIsAllDataPermisssion(true);
		    		    			break;
		    		    		}
		    		    	}
		    		    	
		    		    	
		    		    }
		    		  
		    		  
		    		  return new ResultBean<User>(user);
		            }else{
		            	throw new DataException("用户名密码错误");
		            }
		    
		      }
		
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "重置密码",notes = "重置密码")
	public ResultBean<Boolean> setpwd( UserVO  vo
			) throws Exception{
		CheckUtil.notNull(vo, "param.is.null");
		CheckUtil.notEmpty(vo.getLoginName(), "param.is.null");
		CheckUtil.notEmpty(vo.getPassword(),"param.is.null");
		CheckUtil.notEmpty(vo.getNewpassword(),"param.is.null");
		
		UserBO user = userService.queryUserBOByName(vo.getLoginName());
		
		if(user==null){
			return new ResultBean(false);
			
		}else{
			String hashpass = StringUtils.createPassword(vo.getPassword(),user.getPasswordSalt(),CommonSystemParamter.HASHITERATIONS);
			
			if(StringUtils.equals(user.getPassword(), hashpass)){
				User userModel = new User();
				BeanUtils.copyProperties(user, userModel);
				 String salt = UUIDUtil.getUUID();
				 userModel.setPasswordSalt(salt);
				 String hashnewpassword = StringUtils.createPassword(vo.getNewpassword(),salt,CommonSystemParamter.HASHITERATIONS);
				 userModel.setPassword(hashnewpassword);
				 userModel.setOperator(vo.getOperator());
				userService.updateSelective(userModel);
				
				return new ResultBean(true);
				
			}else{
				return new ResultBean(false);
			}
			
		}
	}
		
		
	
}
