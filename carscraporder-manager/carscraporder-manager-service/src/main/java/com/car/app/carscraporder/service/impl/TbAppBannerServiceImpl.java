package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbAppBannerMapper;
import com.car.app.carscraporder.pojo.TbAppBanner;
import com.car.app.carscraporder.service.TbAppBannerService;


@Service
public class TbAppBannerServiceImpl extends BaseServiceImpl<TbAppBanner> implements
		TbAppBannerService {
	
	@Autowired
	private TbAppBannerMapper tbAppBannerMapper;

	

}
