package com.car.app.carscraporder.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.RoleBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.Role;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.RoleService;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.RoleVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.DataException;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping(value="/role")
@Api(value = "Role-API",tags={"角色相关操作接口"})
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取角色分页列表",notes = "获取角色分页列表")
	public ResultBean<PageResult> getRoleList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			Role paramter) throws Exception{
		    
			    PageResult pageResult  = new PageResult();
			    PageInfo<RoleBO> pageInfo =  roleService.queryBOPageListByWhere(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	
	
	/**
	 * 验证角色是否重复
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/valid/{roleName}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "校验角色名是否存在",notes = "校验角色名是否存在")
	public ResultBean<Boolean> validaRoleName(@RequestParam(value="roleName") String roleName) throws Exception{
		Role user = new Role();
		user.setRolename(roleName);
		List<Role> list = roleService.queryListByWhere( user);
		if(list.size()>0){
			return new ResultBean<Boolean>(false);
		}else{
			return new ResultBean<Boolean>(true);	
		}
	}
	
	
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询所有角色")
	public ResultBean<List<Role>> getAll() throws Exception{
		Example example = new Example(Role.class);
		example.createCriteria().andEqualTo("available", true);
		
		return new ResultBean<>(roleService.queryListByExample(example));
		
		
	}
	
	/**
	 * 新增角色
	 * @param roleVO 保存的user实体类
	 * @return
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增角色")
	public ResultBean<Boolean> addRole(@Validated RoleVO roleVO,BindingResult bindingResult) throws Exception{
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		roleVO.setAvailable(true);
		roleVO.setCreater(u.getId());
		
		return new ResultBean<>(roleService.save(roleVO)==1);
		
		
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改角色",notes = "根据id修改角色信息")
	public ResultBean<Boolean> updateRole(@PathVariable("id")Integer id,@Validated RoleVO roleVO,BindingResult bindingResult) throws Exception{
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		Role role = roleService.queryById(id);
		if(role==null){
			throw new DataException("数据不存在");
		}
		
		roleVO.setOperator(u.getId());
		roleVO.setCreater(role.getCreater());
		roleVO.setCreatetime(role.getCreatetime());
		roleVO.setAvailable(true);
		return new ResultBean<>(roleService.update(roleVO)==1);
	}
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除用户",notes = "根据ids批量删除")
	public ResultBean<Boolean> deleteByIds(@PathVariable("id")Integer id) throws Exception{

		return new ResultBean<>(roleService.deleteById(id)==1);
   }
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取角色详情",notes = "根据id获取角色详情")
	public ResultBean<RoleBO> getRoleById(@PathVariable("id")Integer id) throws Exception{
		return new ResultBean<>(roleService.queryRoleInfoById(id));

	}
	


}
