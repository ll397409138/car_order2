package com.car.app.carscraporder.controller;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.service.RedisService;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.PermissionService;
import com.car.app.carscraporder.service.UserService;
import com.car.app.carscraporder.shiro.realm.SampleRealm;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.systemparameter.WeixinParameter;
import com.car.app.carscraporder.util.LoggerUtils;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UUIDUtil;
import com.car.app.carscraporder.util.UserUtil;

/**
 * 
 * 类名称：AccountController   
 * 类描述：账号相关的Controller   
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午9:48:20      
 * @version  V1.0
 *
 */
@Controller
@RequestMapping(value="/account")
@Api(value = "User-API",tags={"登录登出相关接口"} )
public class AccountController {
	
	
	@Autowired
	private WeixinParameter  weixinParameter;
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService permissionService;
	
	
	
	 @Autowired
	 private RedisService redisService;
	 
	@SuppressWarnings("unused")
	private static final ObjectMapper MAPPER = new ObjectMapper();
	 
	
	 
	
	
	
	
	
	/**
	 * 登出系统
	 * @return  ResultBean 登出方法返回包装信息
	 * @throws Exception 
	 */
	@RequestMapping(value="logout",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "退出系统",notes = "退出系统")
	public ResultBean<Boolean> logout() throws Exception{
		
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		//情况该用户的缓存
		RealmSecurityManager rsm = (RealmSecurityManager)SecurityUtils.getSecurityManager();
		SampleRealm realm = (SampleRealm)rsm.getRealms().iterator().next();
		realm.clearAuthz();


		
	
		return new ResultBean(ResultBean.SUCCESS,null,"登出成功");
	}
	
	
	/**
	 * 
	 * @param password
	 * @param newpassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改密码",notes = "修改密码")
	public ResultBean<Boolean> resetpw(
			@ApiParam(name = "password", value = "密码",required = true)
	        @RequestParam(value="password",required = true)String password,
	        @ApiParam(name = "newpassword", value = "新密密码",required = true)
	        @RequestParam(value="newpassword",required = true)String newpassword
			) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException("没有登录系统");
		}
		
		String hashpass = StringUtils.createPassword(password,u.getPasswordSalt(),CommonSystemParamter.HASHITERATIONS);
		if(StringUtils.equals(hashpass, u.getPassword())){
			 String salt = UUIDUtil.getUUID();
			 u.setPasswordSalt(salt);
			 String hashnewpassword = StringUtils.createPassword(newpassword,salt,CommonSystemParamter.HASHITERATIONS);
			 u.setPassword(hashnewpassword);
			 u.setOperator(u.getId());
			userService.updateSelective(u);
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
		}else{
			throw new DataException("密码输入错误");
		}
		
		
	
		return new ResultBean(ResultBean.SUCCESS,null,"密码修改成功");
	}
	
	
	

	
	
	/**
	 * 根据用户名密码登录
	 * @param name 用户名
	 * @param password 密码
	 * @return ResultBean<UserBo> 请求方法响应信息包装类
	 * @throws Exception
	 */
	@RequestMapping(value="login",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据用户名密码登录",notes = "根据用户名密码登录")
	public ResultBean<UserBO> login(
			@ApiParam(name = "name", value = "用户名",required = true)
			@RequestParam(value="name",required = true)String name,
			@ApiParam(name = "password", value = "密码",required = true)
			@RequestParam(value="password",required = true)String password,
			@ApiParam(name = "rememberMe", value = "记住我",required = false)
			@RequestParam(value="rememberMe",required = false)boolean rememberMe
			) throws Exception{
		ResultBean<UserBO> result = new ResultBean<UserBO>();
		
		if (name == null) {
            return new ResultBean(ResultBean.CHECK_FAIL,null,"用户名不能为空");
        }
        if (password == null) {
        	 return new ResultBean(ResultBean.CHECK_FAIL,null,"密码不能为空");
       
        }
		
		Subject subject = SecurityUtils.getSubject();
	    subject.login(new UsernamePasswordToken(name, password,rememberMe));
	    
	 
	    
	    LoggerUtils.debug(AccountController.class, "登录成功");
	    
	    //取身份信息
	    UserBO userbo = (UserBO) subject.getPrincipal();
	    if(StringUtils.isNotBlank(userbo.getAreasids())){
	    	String[] areaidArray = StringUtils.split(userbo.getAreasids(), ",");
	    	for(String areaid:areaidArray){
	    		if(StringUtils.equals(areaid, "1")){
	    			userbo.setIsAllDataPermisssion(true);
	    			break;
	    		}
	    	}
	    	
	    	
	    }
	    
	    //查询该用户的权限
	    List<Permission> permissions = permissionService.getWebPermission(userbo.getId());
	    userbo.setPermissions(permissions);
	    
	    userbo.setSessionId(subject.getSession().getId().toString());
	    result.setData(userbo);
	   return result;
		
	}
	
	
	
	
	
	

}
