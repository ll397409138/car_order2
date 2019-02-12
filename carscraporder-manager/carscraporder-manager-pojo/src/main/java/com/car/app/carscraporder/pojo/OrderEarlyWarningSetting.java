package com.car.app.carscraporder.pojo;



import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="order_early_warning_setting")
public class OrderEarlyWarningSetting extends BasePojo{
	
	@JsonIgnore
    private Integer id;

    private String earlyWarningCode;

    private Double earlyWarningValue;

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEarlyWarningCode() {
        return earlyWarningCode;
    }

    public void setEarlyWarningCode(String earlyWarningCode) {
        this.earlyWarningCode = earlyWarningCode == null ? null : earlyWarningCode.trim();
    }

    public Double getEarlyWarningValue() {
        return earlyWarningValue;
    }

    public void setEarlyWarningValue(Double earlyWarningValue) {
        this.earlyWarningValue = earlyWarningValue;
    }

 
}