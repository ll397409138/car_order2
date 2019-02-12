package com.car.app.carscarporder.service;





import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.car.app.carscraporder.bo.CarScrapOrderBO;
import com.car.app.carscraporder.service.CarScrapOrderService;


public class CarScrapOrderServiceImplTest extends BaseTest{
	
	
	@Autowired
	private CarScrapOrderService carScrapOrderService;
	
	@Test
	public void saveTest() throws Exception{
		
		
		CarScrapOrderBO record = new CarScrapOrderBO();
		record.setReportTime(new Date());
		record.setCarNumber("京A23848");
		record.setCarFrameNumber("821dsa9343w");
		record.setCarModelNumber("2");
		record.setCarAscription("1");
		record.setCarOwner("李小小");
		record.setOrderType("record");
		record.setTakeCarContacts("");
		
		
		carScrapOrderService.save(record);
		
	}
	
	
	

}
