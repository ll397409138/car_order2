package com.car.app.carscraporder.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tb_attachment")
public class TbAttachment extends BasePojo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String originalName;

    private String storagePath;
    
    private String ossKey;

	private Boolean isvalid=true;
	
	

    public String getOssKey() {
		return ossKey;
	}

	public void setOssKey(String ossKey) {
		this.ossKey = ossKey;
	}

	public Boolean getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Boolean isvalid) {
		this.isvalid = isvalid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath == null ? null : storagePath.trim();
    }

 
}