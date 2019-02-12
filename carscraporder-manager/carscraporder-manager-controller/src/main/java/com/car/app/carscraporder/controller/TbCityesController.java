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

import com.car.app.carscraporder.pojo.TbCityes;
import com.car.app.carscraporder.service.TbCityesService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/cityes")
@Api(value = "Cityes-API",tags={"城市信息操作接口类"})
public class TbCityesController {
	
	@Autowired
	private TbCityesService tbCityesService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据省份id获取下拉框城市数据",notes = "根据省份id获取下拉框城市数据")
	public List<TbCityes> queryall(
			@ApiParam(name = "provinceid", value = "省份主键id",required = true)
	        @RequestParam(value="provinceid",required = true)String provinceid) throws Exception{
		
		TbCityes record = new TbCityes();
		record.setProvinceid(provinceid);
		return tbCityesService.queryListByWhere(record);
		
	}
	
	
	@RequestMapping(value = "{cityid}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据城市id获取信息信息",notes = "根据城市id获取信息信息")
	public ResultBean<TbCityes> queryTbCityes(
			@PathVariable("cityid")String cityid) throws Exception{
		
		TbCityes record = new TbCityes();
		record.setCityid(cityid);
		
		return new ResultBean<TbCityes>(tbCityesService.queryOne(record));
		
	}

}
