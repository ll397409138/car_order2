package com.car.app.carscraporder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.pojo.CarAssessment;
import com.car.app.carscraporder.vo.CarAssessmentVO;
import com.github.abel533.mapper.Mapper;

public interface CarAssessmentMapper extends Mapper<CarAssessment> {
	
	public List<CarAssessment> getCarAssessmentsByParam(@Param("vo")CarAssessmentVO whereParam);
	
	
	public List<CarAssessment> queryPageListByWhere(@Param("vo")CarAssessmentVO record);

}
