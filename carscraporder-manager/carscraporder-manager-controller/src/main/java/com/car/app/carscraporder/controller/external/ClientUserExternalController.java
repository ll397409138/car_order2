package com.car.app.carscraporder.controller.external;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.ClientBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.exception.UserNamePasswordException;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.ClientService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/external/client")
@Api(value = "External-user-API",tags={"提供外部调用的订单相关接口,(跳过登录校验,按照自定义鉴权逻辑)"} )
public class ClientUserExternalController {
	
	@Autowired
	private ClientService  clientService;
	
	
	@RequestMapping(value="doLogin",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据用户名密码查找用户",notes = "根据用户名密码查找用户")
	public ResultBean<ClientBO> getClient(
			@ApiParam(name = "name", value = "用户名",required = true)
			@RequestParam(value="name",required = true)String  name,
			@ApiParam(name = "password", value = "用户密码",required = true)
			@RequestParam(value="password",required = true)String password) throws Exception{
		    
		    //根据用户名查询用户
		ClientBO user = clientService.queryClientBOByName(name);
		    if(user==null){
		    	  throw new DataException("用户名密码错误");
		      }else {
		    	  String validpassword = StringUtils.createPassword(password, user.getPasswordSalt(), 2);
		    	  String orgiPassword = user.getPassword();
		    	  if(StringUtils.equals(validpassword, orgiPassword)){
		    		  return new ResultBean<ClientBO>(user);
		            }else{
		            	throw new UserNamePasswordException("用户名密码错误");
		            }
		    
		      }
		
		
	}
	
	    @RequestMapping(value = "setPwd/{id}",method = RequestMethod.PUT)
		@ResponseBody
		@ApiOperation(value = "重置密码",notes = "重置密码")
		public ResultBean<Boolean> setPwd(@PathVariable("id")String id,
				@RequestParam(value="oldPassword" ,required=true) String oldPassword,
				@RequestParam(value="newPassword" ,required=true) String newPassword
				,String operator) throws Exception{
	    	
	    	
					return new ResultBean(clientService.resetPassword(id,oldPassword,newPassword,operator));
	    	
	    	
		 
	 }
	
	
	
	

}
