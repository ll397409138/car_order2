package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 类名称：CarScrapMailingAddress   
 * 类描述: 订单手续邮寄地址
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 上午11:22:02      
 * @version  V1.0
 *
 */
@Table(name="car_scrap_mailing_address")
public class CarScrapMailingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ApiModelProperty(value = "收件人姓名")
    private String addresseeName;

	@ApiModelProperty(value = "收件人电话")
    private String addresseeTelephone;

	@ApiModelProperty(value = "省")
    private Integer province;

	@ApiModelProperty(value = "市")
    private Integer city;

	@ApiModelProperty(value = "县/地区")
    private Integer county;

	@ApiModelProperty(value = "详细地址")
    private String detailedAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName == null ? null : addresseeName.trim();
    }

    public String getAddresseeTelephone() {
        return addresseeTelephone;
    }

    public void setAddresseeTelephone(String addresseeTelephone) {
        this.addresseeTelephone = addresseeTelephone == null ? null : addresseeTelephone.trim();
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
}