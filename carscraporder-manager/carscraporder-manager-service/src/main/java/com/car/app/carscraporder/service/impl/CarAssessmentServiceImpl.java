package com.car.app.carscraporder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.mapper.CarAssessmentMapper;
import com.car.app.carscraporder.pojo.CarAssessment;
import com.car.app.carscraporder.service.CarAssessmentService;
import com.car.app.carscraporder.vo.CarAssessmentVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarAssessmentServiceImpl extends BaseServiceImpl<CarAssessment> implements
		CarAssessmentService {
	
	@Autowired
	private  CarAssessmentMapper  carAssessmentMapper;

	@Override
	public List<CarAssessment> getCarAssessmentsByParam(
			CarAssessmentVO whereParam) {
		
		return carAssessmentMapper.getCarAssessmentsByParam(whereParam);
	}

	
	public PageInfo<CarAssessment> queryPageListByWhere(Integer page, Integer rows, CarAssessmentVO record)throws Exception {
		PageHelper.startPage(page, rows);
		return new PageInfo<CarAssessment>(carAssessmentMapper.queryPageListByWhere(record));
	}
	

}
