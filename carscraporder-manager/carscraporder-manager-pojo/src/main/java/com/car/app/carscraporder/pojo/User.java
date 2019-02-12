package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Table(name="sys_user")
public class User extends BasePojo {
	@Id
    private String id;

	@ApiModelProperty(value = "用户的登录名称，比如'zhangsan',用户名只能输入字母或数字")
	@NotEmpty(message="用户名不能为空")
	@Pattern(regexp = "[0-9a-zA-Z]{4,23}", message = "用户名只能输入字母或数字")
    private String loginName;

	@ApiModelProperty(value = "用户真实姓名")
    private String realName;

	@ApiModelProperty(value = "用户密码,密码不能为空")
	@NotEmpty(message="用户名不能为空")
	@JsonIgnore
    private String password;

	@ApiModelProperty(value = "用户密码加密盐,不用输入系统随机生成")
	@JsonIgnore
    private String passwordSalt;

	@ApiModelProperty(value = "用户状态(1:正常 2:删除 3:禁用),默认：'正常'")
    private String status="1";

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }

  
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


}