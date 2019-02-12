package com.car.app.carscraporder.service;

import java.util.List;

import com.car.app.carscraporder.pojo.CarAssessment;
import com.car.app.carscraporder.vo.CarAssessmentVO;
import com.github.pagehelper.PageInfo;

public interface CarAssessmentService extends BaseService<CarAssessment> {
	
	
	public List<CarAssessment> getCarAssessmentsByParam(CarAssessmentVO whereParam);
	
	public PageInfo<CarAssessment> queryPageListByWhere(Integer page, Integer rows, CarAssessmentVO record)throws Exception ;

}
