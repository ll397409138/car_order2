package com.car.app.carscraporder.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name="tb_common_mailinginfo")
public class TbCommonMailinginfo  extends BasePojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mailingAddressName;

    private String mailingAddressTelephone;

    private Integer province;

    private Integer city;

    private Integer county;

    private String detailedAddress;

    private String clientid;

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMailingAddressName() {
        return mailingAddressName;
    }

    public void setMailingAddressName(String mailingAddressName) {
        this.mailingAddressName = mailingAddressName == null ? null : mailingAddressName.trim();
    }

    public String getMailingAddressTelephone() {
        return mailingAddressTelephone;
    }

    public void setMailingAddressTelephone(String mailingAddressTelephone) {
        this.mailingAddressTelephone = mailingAddressTelephone == null ? null : mailingAddressTelephone.trim();
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

  
}