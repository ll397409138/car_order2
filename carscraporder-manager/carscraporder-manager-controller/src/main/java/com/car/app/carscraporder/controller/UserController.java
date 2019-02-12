package com.car.app.carscraporder.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.bo.UserSimpleBO;
import com.car.app.carscraporder.exception.CheckException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.UserService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarScrapOrderWhereParamterVO;
import com.car.app.carscraporder.vo.UserVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.DataException;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 类名称：UserController   
 * 类描述： 前台用户controller
 * 创建人：刘子亮
 * 创建时间：2018年10月10日 下午4:09:11      
 * @version  V1.0
 *
 */
@Controller
@RequestMapping(value="/user")
@Api(value = "User-API",tags={"用户管理操作接口"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	
	/**
	 * 
	 * @param page
	 * @param rows
	 * @param paramter
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户分页列表",notes = "获取用户分页列表")
	public ResultBean<PageResult> getUserList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			UserVO paramter) throws Exception{
		    
			    PageResult pageResult  = new PageResult();
			    PageInfo<UserBO> pageInfo =  userService.queryPageListUser(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	
	
	/**
	 * 验证账号是否重复
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/valid/{loginName}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "校验账号是否存在",notes = "校验账号是否存在")
	public ResultBean<Boolean> validaUserName(@RequestParam(value="loginName") String loginName) throws Exception{
		User user = new User();
		user.setLoginName(loginName);
		List<User> list = userService.queryListByWhere( user);
		if(list.size()>0){
			return new ResultBean<Boolean>(false);
		}else{
			return new ResultBean<Boolean>(true);	
		}
	}


	/**
	 * 新增用户
	 * @param user 保存的user实体类
	 * @return
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增用户")
	public ResultBean<Boolean> addUser(@Validated UserVO user,BindingResult bindingResult) throws Exception{
		

		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		user.setCreater(u.getId());
		
		return new ResultBean<Boolean>(userService.saveUserAndRoleAndAreas(user)==1);
	}
	
	
	

	@RequestMapping(value = "setPwd/{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "重置密码",notes = "重置密码")
	public ResultBean<Boolean> setPwd(@PathVariable("id")String id,@RequestParam(value="newPassword" ,required=true) String newPassword) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		User userModel = userService.queryById(id);
		
		if(userModel==null){
			throw new DataException("用户名不存在");
		}
		
		
			String salt = UUID.randomUUID().toString().replaceAll("-", "");
			userModel.setPasswordSalt(salt);
			userModel.setPassword(StringUtils.createPassword(newPassword, salt, 2));
			userModel.setOperator(u.getId());
		
			return new ResultBean<Boolean>(userService.update(userModel)==1);
		
	}


	

	
	/**
	 * 根据id更新员工
	 * @param id
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改用户",notes = "根据id修改User信息")
	public ResultBean<Boolean> updateUser(@PathVariable("id")String id,@Validated UserVO user,BindingResult bindingResult) throws Exception{
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		User userModel = userService.queryById(id);
		if(userModel==null){
			throw new DataException("用户名不存在");
		}
		user.setOperator(u.getId());
		return new ResultBean<Boolean>(userService.updateUserAndRoleAndAreas(user)==1);
	}

	


	/**
	 * 根据主键删除员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除用户",notes = "根据ids批量删除")
	public ResultBean<Boolean> deleteByIds(@PathVariable("id")String id,
			HttpServletRequest request) throws Exception{
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		User userModel = userService.queryById(id);
		if(userModel==null){
			throw new DataException("用户名不存在");
		}
		userModel.setOperator(u.getId());
		userModel.setStatus("2");
		
		return new ResultBean<Boolean>(userService.update(userModel)==1);

	}

	
	
	/**
	 * 根据主键获取员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取User详情",notes = "根据id获取User详情")
	public ResultBean<UserBO> getUserById(@PathVariable("id")String id) throws Exception{
		return new ResultBean<>(userService.queryUserBOById(id));

	}
	
	/**
	 * 查询有接收权限的业务员
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryReceiveUser",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据业务类型查询有接收订单权限的用户",notes = "根据业务类型查询有接收订单权限的用户")
	public ResultBean<List<UserSimpleBO>> getReceiveOrderPermissionUser(@RequestParam(value="businessType",required=true)String businessType,
			@RequestParam(value="areaid",required=true)String areaid) throws Exception{
	
		if(StringUtils.equals(businessType, CommonSystemParamter.ORDER_WhOLECAR_TYPE)){
	          String	permisscode = "order_car_whole:accept";
			return new ResultBean<List<UserSimpleBO>>(userService.getReceiveOrderPermissionUser(permisscode,areaid));
			
			
		}else if (StringUtils.equals(businessType, CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS)){
			 String	permisscode = "order_car_parts:accept";
			 return new ResultBean<List<UserSimpleBO>>(userService.getReceiveOrderPermissionUser(permisscode,areaid));
		}else{
			throw new  CheckException("请求参数错误");
		}
		
		
		
	}
	
	
	
	






	










}
