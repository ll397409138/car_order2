package com.car.app.carscraporder.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Table(name="sys_role")
public class Role extends BasePojo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rolename;
    @JsonIgnore
    private Boolean available;

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

   
}