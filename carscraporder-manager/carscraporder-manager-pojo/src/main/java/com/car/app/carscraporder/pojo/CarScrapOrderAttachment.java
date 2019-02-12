package com.car.app.carscraporder.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 类名称：CarScrapOrderAttachment   
 * 类描述：汽车报废订单附件实体类   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 上午11:32:19      
 * @version  V1.0
 *
 */

public class CarScrapOrderAttachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ApiModelProperty(value = "附件存储表id")
    private Integer attachmentId;

	@ApiModelProperty(value = "订单id")
    private String orderId;
	
	@ApiModelProperty(value = "订单附件类型（1:整车 2:配件）")
	private String orderType;

	@ApiModelProperty(value = "附件类型：照片类型（1:车辆照片、2：手续照片、3：车辆毁型照片、4：报废证明）配件：1:配件照片、2:配件接收照片、3:配件入库照片）")
    private String attachmentType;

	
	@ApiModelProperty(value = "整车订单车辆基图片小类:1,左前 2,正前3.右前 4.左后 5,正后6,右后 7,车架号 8,发动机 9,仪表 10.行驶证 11，登记台12，车主身份正正前方 13，车主身份正正后")
	private Integer carPictureType;
	
	private Boolean isvalid=true;
	
	
	
	
	
    public Boolean getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Boolean isvalid) {
		this.isvalid = isvalid;
	}

	public Integer getCarPictureType() {
		return carPictureType;
	}

	public void setCarPictureType(Integer carPictureType) {
		this.carPictureType = carPictureType;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType == null ? null : attachmentType.trim();
    }

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	
    
    
}