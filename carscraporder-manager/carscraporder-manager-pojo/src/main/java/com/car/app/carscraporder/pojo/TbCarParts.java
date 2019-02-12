package com.car.app.carscraporder.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="tb_car_parts")
public class TbCarParts extends BasePojo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String partsName;

    
    private Integer partsCategoryId;
    @JsonIgnore
    private Boolean isvalid;

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName == null ? null : partsName.trim();
    }

    public Integer getPartsCategoryId() {
        return partsCategoryId;
    }

    public void setPartsCategoryId(Integer partsCategoryId) {
        this.partsCategoryId = partsCategoryId;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

   
}