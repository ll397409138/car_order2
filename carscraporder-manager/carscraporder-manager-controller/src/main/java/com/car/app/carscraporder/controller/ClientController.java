package com.car.app.carscraporder.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.mapper.ClientMapper;
import com.car.app.carscraporder.pojo.Client;
import com.car.app.carscraporder.pojo.Company;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.ClientService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CompanyVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.DataException;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/client")
@Api(value = "client-API",tags={"客户管理人员"})
public class ClientController {

	
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientMapper clientMapper;
	
	
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
	@ApiOperation(value = "获取客户管理人员分页列表",notes = "获取客户管理人员分页列表")
	public ResultBean<PageResult> getCompanyList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			@RequestParam(value="companyid",required = true)Integer companyid, HttpServletRequest request) throws Exception{
			    PageResult pageResult  = new PageResult();
			    Client client = new Client();
			    client.setCompanyid(companyid);
			    client.setUserType("2");
			    client.setStatus("1");
			    PageInfo<Client> pageInfo =  clientService.queryPageListByWhere(page, rows, client);
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
	@ApiOperation(value = "校验客户管理人员登录名是否存在",notes = "校验客户管理人员登录名是否存在")
	public ResultBean<Boolean> validaCustomerNameName(@RequestParam(value="loginName") String loginName) throws Exception{
		Client client = new Client();
		client.setLoginName(loginName);
		List<Client> list = clientService.queryListByWhere(client);
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
	@ApiOperation(value = "新增客户管理人员数据")
	public ResultBean<Boolean> addCompany(@Validated Client paramter,BindingResult bindingResult) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		Client client = new Client();
		client.setLoginName(paramter.getLoginName());
		List<Client> list = clientService.queryListByWhere(client);
		
		if(list.size()>0){
			throw new DataException("用户名重复");
		}
		String id= UUID.randomUUID().toString().replaceAll("-", "");
		paramter.setId(id);
		paramter.setUserType("2");
		String salt = UUID.randomUUID().toString().replaceAll("-", "");
		paramter.setPasswordSalt(salt);
		paramter.setPassword(StringUtils.createPassword(paramter.getPassword(), salt, 2));
		paramter.setStatus("1");
		paramter.setCreater(u.getId());
		
		return new ResultBean<Boolean>(clientService.save(paramter)==1);
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
	@ApiOperation(value = "客户管理人员数据",notes = "客户管理人员数据信息")
	public ResultBean<Boolean> updateCompany(@PathVariable("id")String id,@Validated Client paramter,BindingResult bindingResult) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		 
		Client client = clientMapper.selectByPrimaryKey(id);
		if(client==null){
			throw new DataException("用户不存在");
		}
		paramter.setUserType("2");
		paramter.setLoginName(client.getLoginName());
		paramter.setCompanyid(client.getCompanyid());
		paramter.setWeixincode(client.getWeixincode());
		paramter.setStatus(client.getStatus());
		paramter.setPassword(client.getPassword());
		paramter.setPasswordSalt(client.getPasswordSalt());
		paramter.setCreater(client.getCreater());
		paramter.setCreatetime(client.getCreatetime());
		paramter.setOperator(u.getId());
		  
		return new ResultBean<Boolean>(clientService.update(paramter)==1);
	}

	


	/**
	 * 根据主键删除员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除客户管理人员数据",notes = "根据id删除客户管理人员数据")
	public ResultBean<Boolean> deleteById(@PathVariable("id")String id,
			HttpServletRequest request) throws Exception{

		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		Client client = clientMapper.selectByPrimaryKey(id);
		if(client==null){
			throw new DataException("用户不存在");
		}
		client.setStatus("2");
		client.setOperator(u.getId());
		return new ResultBean<>(clientService.update(client)==1);

	}

	
	
	/**
	 * 根据主键获取员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取客户管理人员详情",notes = "根据id获取客户管理人员详情")
	public ResultBean<Client> getCompanyById(@PathVariable("id")String id) throws Exception{
		return new ResultBean<>(clientMapper.selectByPrimaryKey(id));

	}
	
	@RequestMapping(value = "setPwd/{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "重置密码",notes = "重置密码")
	public ResultBean<Boolean> setPwd(@PathVariable("id")String id,@RequestParam(value="newPassword" ,required=true) String newPassword) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		Client client =   clientMapper.selectByPrimaryKey(id);
		if(client==null){
			throw new DataException("修改的客户管理人员不存在");
		}
		
		String salt = UUID.randomUUID().toString().replaceAll("-", "");
		client.setPasswordSalt(salt);
		client.setPassword(StringUtils.createPassword(newPassword, salt, 2));
		client.setOperator(u.getId());
		
			return new ResultBean<Boolean>(clientService.update(client)==1);
		
	}
	
	
	
}
