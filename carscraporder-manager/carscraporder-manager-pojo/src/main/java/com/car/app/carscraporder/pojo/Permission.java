package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="sys_permission")
public class Permission extends BasePojo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ApiModelProperty(value = "权限类型(1:虚拟菜单 2：菜单)")
    private String type;
	
	@ApiModelProperty(value = "菜单名称")
    private String name;
	
	@ApiModelProperty(value = "菜单url")
    private String url;

	@ApiModelProperty(value = "权限编码")
    private String percode;

	@ApiModelProperty(value = "父节点id")
    private Integer parentid;

	@ApiModelProperty(value = "排序")
    private Short sortstring;

	@ApiModelProperty(value = "菜单是否可用")
    private Boolean available;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Short getSortstring() {
        return sortstring;
    }

    public void setSortstring(Short sortstring) {
        this.sortstring = sortstring;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

  
}