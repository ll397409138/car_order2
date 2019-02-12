package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * 类名称：client   
 * 类描述： 用户实体类
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 下午12:07:41      
 * @version  V1.0
 *
 */
@Table(name="sys_client")
public class Client extends BasePojo{
	
	
	@Id
    private String id;

	@ApiModelProperty(value = "客户姓名")
    private String userName;

	@ApiModelProperty(value = "客户类型（1.个人 2.大客户）")
    private String userType;

	@ApiModelProperty(value = "微信号")
    private String weixincode;

	@ApiModelProperty(value = "登录名")
    private String loginName;

	@ApiModelProperty(hidden=true)
	@JsonIgnore
    private String password;

	//@ApiModelProperty(value = "密码盐")
	@ApiModelProperty(hidden=true)
	@JsonIgnore
    private String passwordSalt;

	@ApiModelProperty(value = "大客户用户所属公司")
    private Integer companyid;
	
	@ApiModelProperty(value = "大客户用户角色类型（1:整车报废管理员 2:旧件回收管理员）")
	//@ApiModelProperty(hidden=true)
    private String businessType;

	//@ApiModelProperty(value = "数据状态,1:正常,2:删除,3:禁用账号")
	@ApiModelProperty(hidden=true)
	@JsonIgnore
    private String status;

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getWeixincode() {
        return weixincode;
    }

    public void setWeixincode(String weixincode) {
        this.weixincode = weixincode == null ? null : weixincode.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
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

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

   
}