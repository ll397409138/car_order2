package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbCommonPayeeaccountMapper;
import com.car.app.carscraporder.pojo.TbCommonPayeeaccount;
import com.car.app.carscraporder.service.TbCommonPayeeaccountService;


@Service
public class TbCommonPayeeaccountServiceImpl extends BaseServiceImpl<TbCommonPayeeaccount>
		implements TbCommonPayeeaccountService {
	
	@Autowired
	private TbCommonPayeeaccountMapper tbCommonPayeeaccountMapper;



}
