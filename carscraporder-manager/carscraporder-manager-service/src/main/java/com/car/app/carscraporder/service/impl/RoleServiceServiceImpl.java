package com.car.app.carscraporder.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.PermissionBO;
import com.car.app.carscraporder.bo.RoleBO;
import com.car.app.carscraporder.mapper.RoleMapper;
import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.pojo.Role;
import com.car.app.carscraporder.pojo.RolePermission;
import com.car.app.carscraporder.pojo.UserRole;
import com.car.app.carscraporder.service.PermissionService;
import com.car.app.carscraporder.service.RolePermissionService;
import com.car.app.carscraporder.service.RoleService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.vo.RoleVO;
import com.car.app.common.exception.DataException;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private PermissionService permissionService;
	
	
	
	
	public PageInfo<RoleBO> queryBOPageListByWhere(int page, int rows, Role paramter)throws Exception {
		PageHelper.startPage(page, rows);
		List<RoleBO> data = roleMapper.queryBOPageListByWhere(paramter);
		return new PageInfo<RoleBO>(data);
	
	
	}
			
		
	
	
	
    public RoleBO queryRoleInfoById(Integer id) throws Exception{
		Role role = super.queryById(id);
		RoleBO roleBO = new RoleBO();
		BeanUtils.copyProperties(role, roleBO);
		List<PermissionBO> perssion = permissionService.queryPermissionsByRoleid(id);
		roleBO.setPermissions(perssion);
		
		return roleBO;
		
	}
	
	
	public Integer save(RoleVO roleVO) throws Exception{
		//校验角色名称是否存在
		Role roleWhereParamter = new Role();
		roleWhereParamter.setRolename(roleVO.getRolename());
		List<Role> roleList = super.queryListByWhere(roleWhereParamter);
		if(roleList.size()>0){
			throw new DataException("重复的角色名称");
		}
		Role role = new Role();
		BeanUtils.copyProperties(roleVO, role);
		role = super.saveReturnPersistentObject(role);
		//保存角色权限中间表
		String permissionids = roleVO.getPermissionIds();
		if(StringUtils.isNotBlank(permissionids)){
			String[] permissionArray = permissionids.split(",");
			for(String permissionid:permissionArray){
				RolePermission rp = new RolePermission();
				rp.setRoleid(role.getId());
				rp.setPermissionid(Integer.parseInt(permissionid));
				rolePermissionService.save(rp);
				
			}	
			
		}
		
		
		
		return 1;
		
	}
	
	
	public Integer update(RoleVO roleVO) throws Exception{
		//校验角色名称是否存在
		Example example = new Example(Role.class);
		example.createCriteria().andEqualTo("rolename", roleVO.getRolename()).andNotEqualTo("id", roleVO.getId());
		List<Role> roleList = super.queryListByExample(example);
		if(roleList.size()>0){
			throw new DataException("重复的角色名称");
		}
		Role role = new Role();
		BeanUtils.copyProperties(roleVO, role);
		super.update(role);
		
		//删除角色权限中间表
		 RolePermission rpWhereParamter = new RolePermission();
		 rpWhereParamter.setRoleid(roleVO.getId());
		 rolePermissionService.deleteByWhere(rpWhereParamter);
		
		//保存角色权限中间表
		String permissionids = roleVO.getPermissionIds();
		if(StringUtils.isNotBlank(permissionids)){
			String[] permissionArray = permissionids.split(",");
			for(String permissionid:permissionArray){
				RolePermission rp = new RolePermission();
				rp.setRoleid(role.getId());
				rp.setCreater(roleVO.getCreater());
				rp.setPermissionid(Integer.parseInt(permissionid));
				rolePermissionService.save(rp);
				
			}	
			
		}
				
	  return 1;
	}

}
