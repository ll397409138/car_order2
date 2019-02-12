package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbCarPartsMapper;
import com.car.app.carscraporder.pojo.TbCarParts;
import com.car.app.carscraporder.service.TbCarPartsService;

@Service
public class TbCarPartsServiceImpl extends BaseServiceImpl<TbCarParts> implements
		TbCarPartsService {

	@Autowired
	private TbCarPartsMapper tbCarPartsMapper;


}
