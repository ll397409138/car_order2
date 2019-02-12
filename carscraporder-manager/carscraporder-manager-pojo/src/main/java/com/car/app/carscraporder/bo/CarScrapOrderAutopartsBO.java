package com.car.app.carscraporder.bo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * 类名称：CarScrapOrderAutoparts   
 * 类描述：配件实体类   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 上午11:51:24      
 * @version  V1.0
 *
 */

public class CarScrapOrderAutopartsBO extends  CarScrapOrderAutoparts {
	
	
	
	private  Integer partsCaregoryId;
	
	@ApiModelProperty(value = "接收备注")
	private String  receiveRemark;

	@ApiModelProperty(value = "入库备注")
	private String   storageRemark;  
	
	@ApiModelProperty(value = "配件大类")
	private  String partsCaregoryName;
	
	@ApiModelProperty(value = "配件类型名称")
    private String partsTypeName;
	
	private String picture;
	
	@ApiModelProperty(value = "二维码生产的原始地址")
	private String qrPic;
	
	@ApiModelProperty(value = "配件照片")
	private List<OrderAttachmentBO> autoPartsPictures= new ArrayList<OrderAttachmentBO>();
	@ApiModelProperty(value = "配件接收照片")
	private List<OrderAttachmentBO>  autoPartsReceivePictures= new ArrayList<OrderAttachmentBO>();
	@ApiModelProperty(value = "配件入库照片")
	private List<OrderAttachmentBO>  autoPartsWarehousingPictures= new ArrayList<OrderAttachmentBO>();
	
	@ApiModelProperty(value = "配件报废照片")
	private List<OrderAttachmentBO>  autoPartsScrapPictures= new ArrayList<OrderAttachmentBO>();
	
	@ApiModelProperty(value = "配件视频")
	private List<OrderAttachmentBO> autoPartsVideo = new ArrayList<OrderAttachmentBO>();
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
	private Date receiveTime;
	
	@ApiModelProperty(value = "已经结算金额")
	private BigDecimal settledAmount;
	
	


	

	public String getPicture() {
		if(autoPartsPictures!=null&&autoPartsPictures.size()>0){
			return autoPartsPictures.get(0).getUrl();
		}else if(autoPartsReceivePictures!=null&&autoPartsReceivePictures.size()>0){
			return autoPartsReceivePictures.get(0).getUrl();
		}else if(autoPartsWarehousingPictures!=null&&autoPartsWarehousingPictures.size()>0){
			return autoPartsWarehousingPictures.get(0).getUrl();
		}
		
		
		return picture;
	}

	
	
	



	







	public List<OrderAttachmentBO> getAutoPartsScrapPictures() {
		return autoPartsScrapPictures;
	}















	public void setAutoPartsScrapPictures(
			List<OrderAttachmentBO> autoPartsScrapPictures) {
		this.autoPartsScrapPictures = autoPartsScrapPictures;
	}















	public List<OrderAttachmentBO> getAutoPartsVideo() {
		return autoPartsVideo;
	}















	public void setAutoPartsVideo(List<OrderAttachmentBO> autoPartsVideo) {
		this.autoPartsVideo = autoPartsVideo;
	}















	public BigDecimal getSettledAmount() {
		return settledAmount;
	}















	public void setSettledAmount(BigDecimal settledAmount) {
		this.settledAmount = settledAmount;
	}















	public Date getReceiveTime() {
		return receiveTime;
	}















	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}















	public Integer getPartsCaregoryId() {
		return partsCaregoryId;
	}





  









	public String getQrPic() {
		return this.getId();
	}















	public void setQrPic(String qrPic) {
		this.qrPic = qrPic;
	}















	public void setPartsCaregoryId(Integer partsCaregoryId) {
		this.partsCaregoryId = partsCaregoryId;
	}















	public String getPartsCaregoryName() {
		return partsCaregoryName;
	}







	public void setPartsCaregoryName(String partsCaregoryName) {
		this.partsCaregoryName = partsCaregoryName;
	}







	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getReceiveRemark() {
		return receiveRemark;
	}

	public void setReceiveRemark(String receiveRemark) {
		this.receiveRemark = receiveRemark;
	}

	public String getStorageRemark() {
		return storageRemark;
	}

	public void setStorageRemark(String storageRemark) {
		this.storageRemark = storageRemark;
	}

	
	

	public List<OrderAttachmentBO> getAutoPartsPictures() {
		return autoPartsPictures;
	}















	public void setAutoPartsPictures(List<OrderAttachmentBO> autoPartsPictures) {
		this.autoPartsPictures = autoPartsPictures;
	}















	public List<OrderAttachmentBO> getAutoPartsReceivePictures() {
		return autoPartsReceivePictures;
	}















	public void setAutoPartsReceivePictures(
			List<OrderAttachmentBO> autoPartsReceivePictures) {
		this.autoPartsReceivePictures = autoPartsReceivePictures;
	}















	public List<OrderAttachmentBO> getAutoPartsWarehousingPictures() {
		return autoPartsWarehousingPictures;
	}















	public void setAutoPartsWarehousingPictures(
			List<OrderAttachmentBO> autoPartsWarehousingPictures) {
		this.autoPartsWarehousingPictures = autoPartsWarehousingPictures;
	}















	public String getPartsTypeName() {
		return partsTypeName;
	}

	public void setPartsTypeName(String partsTypeName) {
		this.partsTypeName = partsTypeName;
	}
	
	


 
}