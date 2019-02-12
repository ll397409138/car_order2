package com.car.app.carscraporder.util;

import com.aliyun.oss.model.PartETag;

/** 
* @Description: 封装PartETag 用于序列化 
* @author: zrk 
* @time: 2015年4月1日 上午10:52:50 
*/ 
public class MyPartETag {
	private static final long serialVersionUID = 1L;

	private int partNumber;

	private String eTag;


	public MyPartETag(PartETag partETag ) {
	    super();
	    this.partNumber = partETag.getPartNumber();
	    this.eTag = partETag.getETag();
	}

	public int getPartNumber() {
	    return partNumber;
	}

	public void setPartNumber(int partNumber) {
	    this.partNumber = partNumber;
	}

	public String geteTag() {
	    return eTag;
	}

	public void seteTag(String eTag) {
	    this.eTag = eTag;
	}
	
}
