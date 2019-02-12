package com.car.app.carscraporder.util;

import java.io.Serializable; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;
public class UploadPartObj {
	private static final long serialVersionUID = 1L;

	List<UploadPartThread> uploadPartThreads = Collections.synchronizedList(new ArrayList<UploadPartThread>());

	boolean result = true;

	public List<UploadPartThread> getUploadPartThreads() {
	    return uploadPartThreads;
	}
	public void setUploadPartThreads(List<UploadPartThread> uploadPartThreads) {
	    this.uploadPartThreads = uploadPartThreads;
	}
	public boolean isResult() {
	    return result;
	}
	public void setResult(boolean result) {
	    this.result = result;
	}


}
