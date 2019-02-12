package com.car.app.carscraporder.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

import com.car.app.carscraporder.pojo.User;

public class UserVO {
	
	
	private String id;
	
	@NotEmpty(message="用户名不能为空")
	@Pattern(regexp = "[0-9a-zA-Z]{4,23}", message = "用户名只能输入字母或数字")
    private String loginName;
	
	@ApiModelProperty(value = "用户真实姓名")
    private String realName;
	
	@ApiModelProperty(value = "用户真实姓名")
	private String password;
	
	
	
	@ApiModelProperty(value = "用户角色ids,表单页面有多个角色选择拼接角色id逗号分隔(例如：'1,2,3')")
	private String roleids;
	@ApiModelProperty(value = "用户管理区域,表单页面有多个区域选择拼接区域id逗号分隔(例如：'1,2,3')")
	private String  areasids;
	
	private String newpassword;
	
	private String operator;
	
	 private String creater;;
	
	
	
	
	
	
	
	
	
	
	
	
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleids() {
		return roleids;
	}
	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}
	public String getAreasids() {
		return areasids;
	}
	public void setAreasids(String areasids) {
		this.areasids = areasids;
	}
	
	
	

}
