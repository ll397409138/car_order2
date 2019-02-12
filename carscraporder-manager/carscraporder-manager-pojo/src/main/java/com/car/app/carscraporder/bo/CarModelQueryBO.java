package com.car.app.carscraporder.bo;



public class CarModelQueryBO {
	private String queryCarModelUrl;
	
	
	private String queryMethod;
	
	
	private String requestforma;
	
	private String AppKey;
	
	private String AppSecret;

	public String getQueryCarModelUrl() {
		return queryCarModelUrl;
	}

	public void setQueryCarModelUrl(String queryCarModelUrl) {
		this.queryCarModelUrl = queryCarModelUrl;
	}

	public String getQueryMethod() {
		return queryMethod;
	}

	public void setQueryMethod(String queryMethod) {
		this.queryMethod = queryMethod;
	}

	public String getRequestforma() {
		return requestforma;
	}

	public void setRequestforma(String requestforma) {
		this.requestforma = requestforma;
	}

	public String getAppKey() {
		return AppKey;
	}

	public void setAppKey(String appKey) {
		AppKey = appKey;
	}

	public String getAppSecret() {
		return AppSecret;
	}

	public void setAppSecret(String appSecret) {
		AppSecret = appSecret;
	}

	public CarModelQueryBO(String queryCarModelUrl, String queryMethod,
			String requestforma, String appKey, String appSecret) {
		super();
		this.queryCarModelUrl = queryCarModelUrl;
		this.queryMethod = queryMethod;
		this.requestforma = requestforma;
		AppKey = appKey;
		AppSecret = appSecret;
	}
	
	

}
