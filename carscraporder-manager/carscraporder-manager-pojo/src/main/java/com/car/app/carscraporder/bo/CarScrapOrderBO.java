package com.car.app.carscraporder.bo;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderSettlement;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 类名称：CarScrapOrder   
 * 类描述：汽车报废订单   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 上午10:29:04      
 * @version  V1.0
 *
 */

public class CarScrapOrderBO extends  CarScrapOrder{
	
	//车辆型号名称
	private String carModelNumberName;
	
	

	//委托公司
	private String custormName;
	
	//业务员
	private String saleName;
	
	
	 @ApiModelProperty(value = "派单备注")
     private String piesNote;
	 
	 
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	 //@ApiModelProperty(value = "下单日期")
	 private Date createOrderDate;
	 
	 //@ApiModelProperty(value = "接收日期")
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	 private Date receiveCarDate;
	 
	 //@ApiModelProperty(value = "入场日期")
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	 private Date inStorageDate;
	 
	 //@ApiModelProperty(value = "手续完成日期")
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	 private Date formalitiesDate;
	 
	 //@ApiModelProperty(value = "残值发放日期")
	 @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	 private Date settlementDate;
	
	
	
	//车辆照片集合
	@ApiModelProperty(value = "车辆照片")
	private List<OrderAttachmentBO> vehiclePictures = new ArrayList<OrderAttachmentBO>();
	//手续照片集合
	@ApiModelProperty(value = "车辆手续照片")
	private List<OrderAttachmentBO> formalitiesPictures= new ArrayList<OrderAttachmentBO>();
	//车辆毁型照片
	@ApiModelProperty(value = "车辆毁型照片")
	private List<OrderAttachmentBO> destroyPictures= new ArrayList<OrderAttachmentBO>();
	//报废证明照片
	@ApiModelProperty(value = "车辆报废证明照片")
	private List<OrderAttachmentBO> certificatePictures= new ArrayList<OrderAttachmentBO>();
	
	
	
	 List<CarScrapOrderAutopartsBO> carScrapOrderAutopartsList = new ArrayList<CarScrapOrderAutopartsBO>();
	 
	 
	 List<CarScrapOrderSettlementBO>  settlementList = new ArrayList<CarScrapOrderSettlementBO>();

	 
	
	 
	 
	 

	

	public List<CarScrapOrderSettlementBO> getSettlementList() {
		return settlementList;
	}

	public void setSettlementList(List<CarScrapOrderSettlementBO> settlementList) {
		this.settlementList = settlementList;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getPiesNote() {
		return piesNote;
	}

	public void setPiesNote(String piesNote) {
		this.piesNote = piesNote;
	}

	public Date getCreateOrderDate() {
		return createOrderDate;
	}

	public void setCreateOrderDate(Date createOrderDate) {
		this.createOrderDate = createOrderDate;
	}

	public Date getReceiveCarDate() {
		return receiveCarDate;
	}

	public void setReceiveCarDate(Date receiveCarDate) {
		this.receiveCarDate = receiveCarDate;
	}

	public Date getInStorageDate() {
		return inStorageDate;
	}

	public void setInStorageDate(Date inStorageDate) {
		this.inStorageDate = inStorageDate;
	}

	public Date getFormalitiesDate() {
		return formalitiesDate;
	}

	public void setFormalitiesDate(Date formalitiesDate) {
		this.formalitiesDate = formalitiesDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getCustormName() {
		return custormName;
	}

	public void setCustormName(String custormName) {
		this.custormName = custormName;
	}

	public String getCarModelNumberName() {
		return carModelNumberName;
	}

	public void setCarModelNumberName(String carModelNumberName) {
		this.carModelNumberName = carModelNumberName;
	}

	

	

	public List<CarScrapOrderAutopartsBO> getCarScrapOrderAutopartsList() {
		return carScrapOrderAutopartsList;
	}

	public void setCarScrapOrderAutopartsList(
			List<CarScrapOrderAutopartsBO> carScrapOrderAutopartsList) {
		this.carScrapOrderAutopartsList = carScrapOrderAutopartsList;
	}

	public List<OrderAttachmentBO> getVehiclePictures() {
		return vehiclePictures;
	}

	public void setVehiclePictures(List<OrderAttachmentBO> vehiclePictures) {
		this.vehiclePictures = vehiclePictures;
	}

	public List<OrderAttachmentBO> getFormalitiesPictures() {
		return formalitiesPictures;
	}

	public void setFormalitiesPictures(List<OrderAttachmentBO> formalitiesPictures) {
		this.formalitiesPictures = formalitiesPictures;
	}

	public List<OrderAttachmentBO> getDestroyPictures() {
		return destroyPictures;
	}

	public void setDestroyPictures(List<OrderAttachmentBO> destroyPictures) {
		this.destroyPictures = destroyPictures;
	}

	public List<OrderAttachmentBO> getCertificatePictures() {
		return certificatePictures;
	}

	public void setCertificatePictures(List<OrderAttachmentBO> certificatePictures) {
		this.certificatePictures = certificatePictures;
	}



	
	 
	 
	 
	 
    

}