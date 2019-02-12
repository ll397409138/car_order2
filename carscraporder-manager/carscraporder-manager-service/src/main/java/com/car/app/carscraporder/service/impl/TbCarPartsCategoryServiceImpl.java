package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbCarPartsCategoryMapper;
import com.car.app.carscraporder.pojo.TbCarPartsCategory;
import com.car.app.carscraporder.service.TbCarPartsCategoryService;
@Service
public class TbCarPartsCategoryServiceImpl extends BaseServiceImpl<TbCarPartsCategory> implements
		TbCarPartsCategoryService {
	
	@Autowired
	private TbCarPartsCategoryMapper tbCarPartsCategoryMapper;

	

}
