package com.car.app.carscraporder.service.impl;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.PermissionBO;
import com.car.app.carscraporder.exception.CheckException;
import com.car.app.carscraporder.mapper.PermissionMapper;
import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.service.PermissionService;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.StringUtils;


@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements
		PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	
	
	public List<Permission> getPermosssionsCodeByUserid(String userid){
		
		return permissionMapper.getPermosssionsCodeByUserid(userid);
	}
	
	
	
	
	
	
	
    /**
     * 1.根据角色查询该角色拥有哪些权限
     * 2.查询权限结构树
     * 3.用拥有的权限遍历匹配结构树赋值checked,ture:有权限，false:无权限
     *  
     */
	@Override
	public List<PermissionBO> queryPermissionsByRoleid(Integer roleid)throws Exception {
		//该角色拥有的权限集合
		Set<Integer> permissionData = permissionMapper.queryPermissionsByRoleid(roleid);
		//系统权限集合树
		List<PermissionBO> permissiontree = getPermissionTree();
		//填充拥有的权限
		ConstructionPermissionStructure(permissiontree,permissionData);
		
		return permissiontree;
	}
	
	/**
	 * 
	 * @param permissiontree  拥有权限集合
	 * @param permissionData  系统权限结构树
	 */
	private void ConstructionPermissionStructure(List<PermissionBO> permissiontree,Set<Integer> permissionData){
		
		for(PermissionBO bo:permissiontree){
			recursionPermissionTree(bo,permissionData);
		}
		
	}
	
	/**
	 * 递归权限数
	 * @param bo
	 * @param permissionData
	 */
	private void recursionPermissionTree(PermissionBO bo,Set<Integer> permissionData){
		if(permissionData.contains(bo.getId())){
			bo.setChecked(true);
		}
		List<PermissionBO> subPermisssion = bo.getSub();
		if(subPermisssion.size()>0){
			for(PermissionBO permission:subPermisssion){
				recursionPermissionTree(permission,permissionData);
//				Integer permissionId = permission.getId();
//				//判断permissionId是否在permissionData存在
//				if(compare(permissionId,permissionData)){
//					permission.setChecked(true);
//				}
				
			}
		}
		
		
	}
	
	private boolean compare(Integer permissionId,Set<Integer> permissionData){
		
		if(permissionData.contains(permissionId)){
			return true;
		}
		
		return false;
		
		
		
		
	}
	

	@Override
	public List<PermissionBO> getPermissionTree() throws Exception {
		//获取跟节点
		List<PermissionBO> roots = permissionMapper.queryRoot();
		
		for(PermissionBO root:roots){
			recursionPermission(root);
			
		}
			
		return roots;
	}
	
	/**
	 *根据根节点对象递归所有叶子节点
	 * @param bo
	 * @throws Exception
	 */
	private void recursionPermission(PermissionBO bo) throws Exception{
		//根据id获取Permisssion对象
		
		if(bo!=null){
			//查询Permisssion是否有叶子节点
			List<PermissionBO> subPermisssion = this.permissionMapper.queryBOByParentId(bo.getId());
			if(subPermisssion.size()>0){
				for(PermissionBO permission:subPermisssion){
					recursionPermission(permission);
					
				}
					
				bo.setSub(subPermisssion);
			}
			
		 
		  
		}
		
		

	}

	@Override
	public List<Permission> getAppPermissionByBusinessCode(String businessCode,String userid) {
		
		
		return permissionMapper.getAppPermissionByBusinessCode(businessCode, userid);
	}
	
	
	public List<Permission>  getWebPermission(String userid){
		
		
		return permissionMapper.getWebPermission(userid);
		
		
	}
	
    public List<Permission>  getSubPermissionList(String percode,String userid)throws Exception{
    	
    	if(StringUtils.isNotBlank(percode)){
    		Permission record = new Permission();
    		record.setPercode(percode);
    		Permission result = this.queryOne(record);
    		if(result!=null){
    			return permissionMapper.getSubPermissionList(userid,result.getId());
    		}
    		
    		
    		
    	}else{
    		new CheckException("请求参数错误");
    	}
		return null;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
