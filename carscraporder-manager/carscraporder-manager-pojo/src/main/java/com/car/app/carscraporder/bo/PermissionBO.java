package com.car.app.carscraporder.bo;

import java.util.ArrayList;
import java.util.List;

import com.car.app.carscraporder.pojo.Permission;

public class PermissionBO extends Permission{
	
	private List<PermissionBO> sub = new ArrayList<PermissionBO>();
	
	private Boolean checked = false;
	
	
	

	public List<PermissionBO> getSub() {
		return sub;
	}

	public void setSub(List<PermissionBO> sub) {
		this.sub = sub;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	
	
	

}
