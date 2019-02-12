package com.car.app.carscraporder.bo;

import io.swagger.annotations.ApiModelProperty;

public class OrderAttachmentBO {
	
	private int id;
	
	private String url; 
	
	@ApiModelProperty(value = "整车订单车辆基图片小类:1,左前 2,正前3.右前 4.左后 5,正后6,右后 7,车架号 8,发动机 9,仪表 10.行驶证 11，登记台12，车主身份正正前方 13，车主身份正正后")
	private String carPictureType;
	

	private String carPictureName;
	
	private Boolean isVerify;

	

	public Boolean getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(Boolean isVerify) {
		this.isVerify = isVerify;
	}

	public String getCarPictureName() {

    if(null!=this){
    	if(null!=this.getCarPictureType()){
			 switch(this.getCarPictureType()){
		     case "1":
			      this.carPictureName = "左前45度";
			      break;
		     case "2":
			      this.carPictureName = "正前方";
			      break;     
		     case "3":
			      this.carPictureName = "左前45度";
			      break; 
		     case "4":
			      this.carPictureName = "左后45度";
			      break;
		     case "5":
			      this.carPictureName = "正后方";
			      break;     
		     case "6":
			      this.carPictureName = "左后方45度";
			      break;  
		     case "7":
			      this.carPictureName = "车架号";
			      break;
		     case "8":
			      this.carPictureName = "发动机舱";
			      break;     
		     case "9":
			      this.carPictureName = "仪表台";
			      break;
		     case "10":
			      this.carPictureName = "行驶证";
			      break;
		     case "11":
			      this.carPictureName = "登记卡";
			      break;     
		     case "12":
			      this.carPictureName = "车主身份证后面";
			      break;  
		     case "13":
			      this.carPictureName = "车主身份证后面";
			      break; 
		     default:
		    	 this.carPictureName = "";
			      break; 
			      
		      
		 }
	 }
    }
		
	 
		
		
		
		
		return carPictureName;
	}

	public void setCarPictureName(String carPictureName) {
		this.carPictureName = carPictureName;
	}

	
	

	public OrderAttachmentBO(String url, String carPictureType, boolean isVerify) {
		super();
		this.url = url;
		this.carPictureType = carPictureType;
		this.isVerify = isVerify;
	}

	public OrderAttachmentBO(String url, String carPictureType) {
		super();
		this.url = url;
		this.carPictureType = carPictureType;
	}
	

	public OrderAttachmentBO() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarPictureType() {
		return carPictureType;
	}

	public void setCarPictureType(String carPictureType) {
		this.carPictureType = carPictureType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	
	
	

}
