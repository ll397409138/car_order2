package com.car.app.carscraporder.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.CompanyBO;
import com.car.app.carscraporder.mapper.TbCommonMailinginfoMapper;
import com.car.app.carscraporder.pojo.TbCommonMailinginfo;
import com.car.app.carscraporder.service.TbCommonMailinginfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class TbCommonMailinginfoServiceImpl extends BaseServiceImpl<TbCommonMailinginfo>
		implements TbCommonMailinginfoService {
	
	
	@Autowired
	private TbCommonMailinginfoMapper  tbCommonMailinginfoMapper;

	@Override
	public PageInfo<TbCommonMailinginfo> queryListByWhere(Integer page,
			Integer rows, TbCommonMailinginfo paramter) {
		PageHelper.startPage(page, rows);
		List<TbCommonMailinginfo> tbCommonMailinginfos = tbCommonMailinginfoMapper.queryListByWhere(paramter);
		return new PageInfo<TbCommonMailinginfo>(tbCommonMailinginfos);
	}



}
