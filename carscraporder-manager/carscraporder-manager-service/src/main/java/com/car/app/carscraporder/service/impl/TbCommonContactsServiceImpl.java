package com.car.app.carscraporder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbCommonContactsMapper;
import com.car.app.carscraporder.pojo.TbCommonContacts;
import com.car.app.carscraporder.service.TbCommonContactsService;

@Service
public class TbCommonContactsServiceImpl extends BaseServiceImpl<TbCommonContacts> implements
		TbCommonContactsService {

	@Autowired
	private TbCommonContactsMapper tbCommonContactsMapper;
	

}
