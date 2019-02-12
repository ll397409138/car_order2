package com.car.app.carscraporder.bo;

import java.util.ArrayList;
import java.util.List;

import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.pojo.Role;
import com.car.app.carscraporder.pojo.RolePermission;

public class RoleBO extends Role{
	private List<PermissionBO> permissions = new ArrayList<PermissionBO>();
	
	
	private String permissionsName;
	
	
	

	public String getPermissionsName() {
		return permissionsName;
	}

	public void setPermissionsName(String permissionsName) {
		this.permissionsName = permissionsName;
	}

	public List<PermissionBO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionBO> permissions) {
		this.permissions = permissions;
	}
	
	

}
