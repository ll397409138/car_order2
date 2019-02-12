package com.car.app.carscraporder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.bo.CarScrapOrderBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderExample;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.carscraporder.vo.CarScrapOrderWhereParamterVO;
import com.github.abel533.mapper.Mapper;


public interface CarScrapOrderMapper extends Mapper<CarScrapOrder>{
	
	public List<CarScrapOrderPageBO>  queryPageListByWhere(CarScrapOrderExample example);
	
	public List<CarScrapOrderPageBO>  queryPageListByKeyword(@Param("vo")CarScrapOrderKeywordVO vo);
	
	public List<CarScrapOrderPageBO>  queryOldPartsWillReceivePageListByKeyword(@Param("vo")CarScrapOrderKeywordVO vo);
	
	public List<CarScrapOrderPageBO> queryAll(@Param("vo")CarScrapOrderKeywordVO vo);
	
	
	
	public List<CarScrapOrderPageBO>  queryPageHistoryListByKeyword(@Param("vo")CarScrapOrderKeywordVO vo);
	
	public CarScrapOrderBO queryBOById(String id);
	
	

}
