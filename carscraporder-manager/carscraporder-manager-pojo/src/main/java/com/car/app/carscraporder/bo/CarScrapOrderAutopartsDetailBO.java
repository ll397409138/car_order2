package com.car.app.carscraporder.bo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

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

public class CarScrapOrderAutopartsDetailBO extends  CarScrapOrderAutopartsBO {
	
	
	   //订单编号
	   private String orderNo;
		
	    @ApiModelProperty(value = "报案号")
	    private String reportNo;

		@ApiModelProperty(value = "车牌号")
	    private String carNumber;
	
		@ApiModelProperty(value = "车架号")
	    private String carFrameNumber;
		
		
		
		
	    private String carModelNumberName;
	    
	    private String custormName;
	  //业务员
		private String saleName;
		
		@ApiModelProperty(value = "取车人联系人")
	    private String takeCarContacts;

		@ApiModelProperty(value = "取车联系电话")
	    private String takeCarContactNumber;
		
		@ApiModelProperty(value = "取车时间")		
		@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	    private Date takeCarTime;

		@ApiModelProperty(value = "取车地址")
	    private String takeCarAddress;
		
		@ApiModelProperty(value = "配件类型名称")
	    private String partsTypeName;
	
	
	
     
	 	@ApiModelProperty(value = "派单备注")
		private String   	dispatchRemark;
	
		@ApiModelProperty(value = "接收备注")
		private String  receiveRemark;
	
		 //接受配件时间
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
		private Date acceptTime;
		
		
		@ApiModelProperty(value = "入库备注")
		private String   storageRemark;  
		
		@ApiModelProperty(value = "入库时间")
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Date storageTime;
     
		@ApiModelProperty(value = "出库备注")
		private String outageRemark;
		
		//下单时间
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Date orderTime;
		
        //配件出库时间
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Date outageTime;
		
		//配件返款时间
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		private Date repaymentTime;
		
		@ApiModelProperty(value = "收款人姓名")
	    private String payeeName;

		@ApiModelProperty(value = "银行账户")
	    private String bankAccount;
		
		@ApiModelProperty(value = "开户行")
	    private String openingBank;
		
	
		
		@ApiModelProperty(value = "无法接收原因")
		private String unableReceiveReason_str;
	
	
	
	
	
	
	
	  public Date getOrderTime() {
			return orderTime;
		}
		public void setOrderTime(Date orderTime) {
			this.orderTime = orderTime;
		}
		
		
		
		
		
	   public String getUnableReceiveReason_str() {
			return unableReceiveReason_str;
		}
		public void setUnableReceiveReason_str(String unableReceiveReason_str) {
			this.unableReceiveReason_str = unableReceiveReason_str;
		}
	public String getPayeeName() {
			return payeeName;
		}
		public void setPayeeName(String payeeName) {
			this.payeeName = payeeName;
		}
		public String getBankAccount() {
			return bankAccount;
		}
		public void setBankAccount(String bankAccount) {
			this.bankAccount = bankAccount;
		}
		public String getOpeningBank() {
			return openingBank;
		}
		public void setOpeningBank(String openingBank) {
			this.openingBank = openingBank;
		}
	public String getSaleName() {
			return saleName;
		}
		public void setSaleName(String saleName) {
			this.saleName = saleName;
		}
	public Date getStorageTime() {
			return storageTime;
		}
		public void setStorageTime(Date storageTime) {
			this.storageTime = storageTime;
		}
		
	public String getOutageRemark() {
			return outageRemark;
		}
		public void setOutageRemark(String outageRemark) {
			this.outageRemark = outageRemark;
		}
	public String getPartsTypeName() {
		return partsTypeName;
	}
	public void setPartsTypeName(String partsTypeName) {
		this.partsTypeName = partsTypeName;
	}
	
	public String getCustormName() {
		return custormName;
	}
	public void setCustormName(String custormName) {
		this.custormName = custormName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarFrameNumber() {
		return carFrameNumber;
	}
	public void setCarFrameNumber(String carFrameNumber) {
		this.carFrameNumber = carFrameNumber;
	}
	
	public String getCarModelNumberName() {
		return carModelNumberName;
	}
	public void setCarModelNumberName(String carModelNumberName) {
		this.carModelNumberName = carModelNumberName;
	}
	public String getDispatchRemark() {
		return dispatchRemark;
	}
	public void setDispatchRemark(String dispatchRemark) {
		this.dispatchRemark = dispatchRemark;
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
	public String getTakeCarContacts() {
		return takeCarContacts;
	}
	public void setTakeCarContacts(String takeCarContacts) {
		this.takeCarContacts = takeCarContacts;
	}
	public String getTakeCarContactNumber() {
		return takeCarContactNumber;
	}
	public void setTakeCarContactNumber(String takeCarContactNumber) {
		this.takeCarContactNumber = takeCarContactNumber;
	}
	public Date getTakeCarTime() {
		return takeCarTime;
	}
	public void setTakeCarTime(Date takeCarTime) {
		this.takeCarTime = takeCarTime;
	}
	public String getTakeCarAddress() {
		return takeCarAddress;
	}
	public void setTakeCarAddress(String takeCarAddress) {
		this.takeCarAddress = takeCarAddress;
	}
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	public Date getOutageTime() {
		return outageTime;
	}
	public void setOutageTime(Date outageTime) {
		this.outageTime = outageTime;
	}
	public Date getRepaymentTime() {
		return repaymentTime;
	}
	public void setRepaymentTime(Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	


 
}