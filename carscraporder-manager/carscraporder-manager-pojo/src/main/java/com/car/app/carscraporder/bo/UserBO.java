package com.car.app.carscraporder.bo;

import java.util.ArrayList;
import java.util.List;

import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.pojo.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserBO extends User {
	
	private String roleName;
	
	private String areaName;
	
	//区域主键
	private String areasids;
	private String roleids;
	private String sessionId;
	
	@JsonIgnore
	private Boolean isAllDataPermisssion=false;
	
	
	private List<Permission> permissions = new ArrayList<Permission>();
	
	
	
	
	
	
	
	

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Boolean getIsAllDataPermisssion() {
		return isAllDataPermisssion;
	}

	public void setIsAllDataPermisssion(Boolean isAllDataPermisssion) {
		this.isAllDataPermisssion = isAllDataPermisssion;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAreasids() {
		return areasids;
	}

	public void setAreasids(String areasids) {
		this.areasids = areasids;
	}

	public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
	

}
