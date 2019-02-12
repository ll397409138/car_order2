package com.car.app.carscraporder.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Table(name="tb_car_parts_category")
public class TbCarPartsCategory extends BasePojo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String partsCategoryName;

    @JsonIgnore
    private Boolean isvalid;

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartsCategoryName() {
        return partsCategoryName;
    }

    public void setPartsCategoryName(String partsCategoryName) {
        this.partsCategoryName = partsCategoryName == null ? null : partsCategoryName.trim();
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

 
}