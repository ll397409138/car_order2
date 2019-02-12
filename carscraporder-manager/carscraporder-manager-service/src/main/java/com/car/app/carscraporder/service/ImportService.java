package com.car.app.carscraporder.service;



import org.springframework.web.multipart.MultipartFile;

public interface ImportService {
	
	public String ImportDataByExcel(MultipartFile file) throws Exception;

}
