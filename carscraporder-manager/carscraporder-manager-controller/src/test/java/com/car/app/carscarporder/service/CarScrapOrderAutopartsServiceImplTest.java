package com.car.app.carscarporder.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsVO;

public class CarScrapOrderAutopartsServiceImplTest extends BaseTest{

	@Autowired
	private CarScrapOrderAutopartsService  carScrapOrderAutopartsService;
	
	public void saveAutoparts() throws Exception{
		CarScrapOrderAutopartsVO  carScrapOrderAutopartsVO = new CarScrapOrderAutopartsVO();
		
		carScrapOrderAutopartsVO.setPartsNum("xxxxx");
		carScrapOrderAutopartsVO.setPartsType(1);
		carScrapOrderAutopartsVO.setRemark("dddd");
		
		carScrapOrderAutopartsService.saveAutoparts(carScrapOrderAutopartsVO);
	}
}
