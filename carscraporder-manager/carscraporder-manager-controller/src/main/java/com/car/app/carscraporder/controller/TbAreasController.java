package com.car.app.carscraporder.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.pojo.TbAreas;
import com.car.app.carscraporder.pojo.TbProvinces;
import com.car.app.carscraporder.service.TbAreasService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/areas")
@Api(value = "Cityes-API",tags={"地区信息操作接口类"})
public class TbAreasController {
	
	@Autowired
	private TbAreasService tbAreasService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据城市id获取下拉框地区/县数据",notes = "根据城市id获取下拉框地区/县数据")
	public List<TbAreas> queryall(
			@ApiParam(name = "cityid", value = "城市主键id",required = true)
	        @RequestParam(value="cityid",required = true)String cityid) throws Exception{
		
		TbAreas record = new TbAreas();
		record.setCityid(cityid);
		return tbAreasService.queryListByWhere(record);
		
	}
	
	@RequestMapping(value = "{areaid}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据县id获取详细信息",notes = "根据县id获取详细信息")
	public ResultBean<TbAreas> queryTbAreas(
			@PathVariable("areaid")String areaid) throws Exception{
		
		TbAreas record = new TbAreas();
		record.setAreaid(areaid);
		
		return new ResultBean<TbAreas>(tbAreasService.queryOne(record));
		
	}

}
