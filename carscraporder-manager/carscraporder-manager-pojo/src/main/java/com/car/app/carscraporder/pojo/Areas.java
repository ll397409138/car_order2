package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="sys_areas")
public class Areas extends BasePojo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String areasCode;

	@ApiModelProperty(value = "用户管理区域名称")
    private String areasName;

	@ApiModelProperty(hidden = true)
	@JsonIgnore
    private String status;
	
	
	@ApiModelProperty(value = "用户管理区域经纬度")
	private String coordinate;
	
	
	@ApiModelProperty(hidden = true)
	@JsonIgnore
	private Boolean isVirtualField;

    

	

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getAreasCode() {
		return areasCode;
	}

	public void setAreasCode(String areasCode) {
		this.areasCode = areasCode;
	}

	public Boolean getIsVirtualField() {
		return isVirtualField;
	}

	public void setIsVirtualField(Boolean isVirtualField) {
		this.isVirtualField = isVirtualField;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreasName() {
        return areasName;
    }

    public void setAreasName(String areasName) {
        this.areasName = areasName == null ? null : areasName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

  
}