package com.car.app.carscraporder.controller;

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

import com.car.app.carscraporder.bo.PermissionBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.PermissionService;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/permission")
@Api(value = "Role-API",tags={"权限管理操作接口"})
public class PermissionController {
	
	
	@Autowired
	private PermissionService permissionService;
	
	
	
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
	@ApiOperation(value = "获取权限分页列表",notes = "获取权限分页列表")
	public ResultBean<PageResult> getPermissionList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			Permission paramter) throws Exception{
		    
		         
		     return new ResultBean( permissionService.queryPageListByWhere(page, rows, paramter));
		
		
	}

			
	
	
	
	
	
	/**
	 * 
	 * @param areas
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增权限")
	public ResultBean<Integer> addPermission(@Validated Permission permission,BindingResult bindingResult) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		permission.setCreater(u.getId());
		return new ResultBean<>(permissionService.save(permission));
		
		
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改权限",notes = "修改权限")
	public ResultBean<Boolean> updatePermission(@PathVariable("id")Integer id,@Validated Permission permission,BindingResult bindingResult) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		//根据id获取数据
		Permission permissionData  = permissionService.queryById(id);
		if(permissionData!=null){
			permission.setCreater(permissionData.getCreater());
			permission.setCreatetime(permissionData.getCreatetime());
			permission.setOperator(u.getId());
			return new ResultBean<>(permissionService.update(permission)==1);
		}else{
			return new ResultBean<>(false);
		}
		
		
		
	}
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除权限",notes = "根据id删除权限")
	public ResultBean<Integer> deleteByIds(@PathVariable("id")Integer id) throws Exception{

		return new ResultBean<>(permissionService.deleteById(id));
   }
	

	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据主键id获取权限配置详情",notes = "根据主键id获取权限配置详情")
	public ResultBean<Permission> getPermissionById(@PathVariable("id")Integer id) throws Exception{
		return new ResultBean<>(permissionService.queryById(id));

	}
	
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="gettree",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取权限树结构",notes = "获取权限树结构")
	public ResultBean<PermissionBO> getPermissionList() throws Exception{   
		     return new ResultBean( permissionService.getPermissionTree());
		
		
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getpermissiontree",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取权限树结构",notes = "获取权限树结构")
	public ResultBean<PermissionBO> getPermissionTree(
			@ApiParam(name = "roleid", value = "角色id",required = true)
	        @RequestParam(value="roleid",required = true)Integer roleid) throws Exception{   
		     return new ResultBean( permissionService.queryPermissionsByRoleid(roleid));
		
		
	}
	
	@RequestMapping(value="getsub",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据权限编码获取叶子权限",notes = "根据权限编码获取叶子权限")
	public ResultBean<PermissionBO> getSubPermissionList(
			@ApiParam(name = "percode", value = "权限编码",required = true)
            @RequestParam(value="percode",required = true)String percode) throws Exception{   
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		
		     return new ResultBean( permissionService.getSubPermissionList(percode,u.getId()));
		
		
	}
	
	
	

}
