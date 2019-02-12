package com.car.app.carscraporder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbDataDicMapper;
import com.car.app.carscraporder.pojo.TbDataDic;
import com.car.app.carscraporder.service.TbDataDicService;


@Service
public class TbDataDicServiceImpl extends BaseServiceImpl<TbDataDic> implements
		TbDataDicService {
	
	@Autowired
	private TbDataDicMapper tbDataDicMapper;

	

}
