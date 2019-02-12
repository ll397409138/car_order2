package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="tb_common_contacts")
public class TbCommonContacts extends BasePojo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ApiModelProperty(value = "联系人姓名")
    private String contactName;

	@ApiModelProperty(value = "联系人电话")
    private String contactTelephone;

	@ApiModelProperty(value = "所属用户")
    private String clientid;

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone == null ? null : contactTelephone.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

 
}