package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="sys_user_area")
public class UserArea extends BasePojo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ApiModelProperty(value = "用户id")
    private String userid;

	@ApiModelProperty(value = "区域id")
    private Integer areaid;

    private String creater;

    private String operator;

    private Date createtime;

    private Date operatortime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getOperatortime() {
        return operatortime;
    }

    public void setOperatortime(Date operatortime) {
        this.operatortime = operatortime;
    }
}