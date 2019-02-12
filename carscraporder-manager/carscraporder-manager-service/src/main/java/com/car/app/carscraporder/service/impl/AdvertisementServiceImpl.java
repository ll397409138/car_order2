package com.car.app.carscraporder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.AdvertisementMapper;
import com.car.app.carscraporder.pojo.Advertisement;
import com.car.app.carscraporder.service.AdvertisementService;

@Service
public class AdvertisementServiceImpl extends BaseServiceImpl<Advertisement>  implements AdvertisementService {
	
	@Autowired
	private AdvertisementMapper advertisementMapper;


}
