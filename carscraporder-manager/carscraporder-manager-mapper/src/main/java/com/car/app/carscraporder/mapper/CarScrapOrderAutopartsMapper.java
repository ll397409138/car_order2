package com.car.app.carscraporder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.bo.CarScrapOrderAutopartsBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsDetailBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.github.abel533.mapper.Mapper;

public interface CarScrapOrderAutopartsMapper extends Mapper<CarScrapOrderAutoparts>{
	
	public CarScrapOrderAutopartsBO  queryBOById(String id);
	public CarScrapOrderAutopartsDetailBO getOrderAutopartsDetailById(String id);
	
	
	public  List<CarScrapOrderAutopartsBO> queryListByOrderId(String orderid);
	public List<CarScrapOrderPageBO> queryBOPageList(@Param("vo")CarScrapOrderKeywordVO paramter);
	
	public List<CarScrapOrderPageBO> getSortingParts(@Param("vo")CarScrapOrderKeywordVO paramter);
	
	public List<CarScrapOrderPageBO> queryHistoryBOPageList(@Param("vo")CarScrapOrderKeywordVO paramter);
	
	public Long  queryBOPageListCount(@Param("vo")CarScrapOrderKeywordVO paramter);
	
	
	public Integer queryPendingOrder(@Param("agentUserid")String agentUserid,@Param("partsStauts")Integer partsStauts,@Param("areasids")List<String> areasids,@Param("isSorting")Boolean isSorting);

	public Integer selectPartCount(@Param("vo")CarScrapOrderKeywordVO paramter);


}
