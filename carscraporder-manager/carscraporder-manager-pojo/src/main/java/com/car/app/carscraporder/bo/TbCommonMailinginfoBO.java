package com.car.app.carscraporder.bo;





public class TbCommonMailinginfoBO   {
	
    private Integer id;

    private String mailingAddressName;

    private String mailingAddressTelephone;

    private Integer province;

    private Integer city;

    private Integer county;

    private String detailedAddress;

    private String clientid;
    
    private String provinceName;
    private String cityName;
    private String countyName;
    
    
    

  
    public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

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