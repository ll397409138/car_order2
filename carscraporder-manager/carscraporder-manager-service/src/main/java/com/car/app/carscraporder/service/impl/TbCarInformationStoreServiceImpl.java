package com.car.app.carscraporder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbCarInformationStoreMapper;
import com.car.app.carscraporder.service.TbCarInformationStoreService;

/**
 * 
 * 类名称：TbCarInformationStoreServiceImpl   
 * 类描述：   
 * 创建人：刘子亮
 * 创建时间：2018年11月5日 下午8:00:31      
 * @version  V1.0
 *
 */
@Service
public class TbCarInformationStoreServiceImpl implements
		TbCarInformationStoreService {
	
	@Autowired
	private TbCarInformationStoreMapper  tbCarInformationStoreMapper;

}
