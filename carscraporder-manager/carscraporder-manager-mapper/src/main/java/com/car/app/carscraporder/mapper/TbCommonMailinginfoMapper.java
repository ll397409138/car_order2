package com.car.app.carscraporder.mapper;

import java.util.List;

import com.car.app.carscraporder.pojo.TbCommonMailinginfo;
import com.github.abel533.mapper.Mapper;


public interface TbCommonMailinginfoMapper extends Mapper<TbCommonMailinginfo> {
	
	public List<TbCommonMailinginfo> queryListByWhere(TbCommonMailinginfo paramter);

}
