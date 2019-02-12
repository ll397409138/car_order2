package com.car.app.carscraporder.pojo;


import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="tb_data_dic")
public class TbDataDic extends BasePojo {
	
	@JsonIgnore
    private Integer id;

	@JsonIgnore
    private String datatype;

	@JsonIgnore
    private String datatypename;

    private String dataname;

    private Integer datavalue;

    @JsonIgnore
    private Byte ordernum;

    @JsonIgnore
    private Byte status;

    @JsonIgnore
    private Integer relevanceid;

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getDatatypename() {
        return datatypename;
    }

    public void setDatatypename(String datatypename) {
        this.datatypename = datatypename == null ? null : datatypename.trim();
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname == null ? null : dataname.trim();
    }

    public Integer getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(Integer datavalue) {
        this.datavalue = datavalue;
    }

    public Byte getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Byte ordernum) {
        this.ordernum = ordernum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getRelevanceid() {
        return relevanceid;
    }

    public void setRelevanceid(Integer relevanceid) {
        this.relevanceid = relevanceid;
    }

   
}