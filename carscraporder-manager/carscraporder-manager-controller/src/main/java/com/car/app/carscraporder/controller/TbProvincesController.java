package com.car.app.carscraporder.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.pojo.TbCityes;
import com.car.app.carscraporder.pojo.TbProvinces;
import com.car.app.carscraporder.service.TbProvincesService;
import com.car.app.common.bean.ResultBean;


@Controller
@RequestMapping(value="/provinces")
@Api(value = "Provinces-API",description="省份信息操作接口类")
public class TbProvincesController {
	
	@Autowired
	private TbProvincesService tbProvincesService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取下拉框省份数据",notes = "获取下拉框省份数据")
	public List<TbProvinces> queryall() throws Exception{
		return tbProvincesService.queryAll();
		
	}
	
	@RequestMapping(value = "{provinceid}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据省id获取下拉框城市数据",notes = "根据省id获取下拉框城市数据")
	public ResultBean<TbProvinces> queryTbProvince(
			@PathVariable("provinceid")String provinceid) throws Exception{
		
		TbProvinces record = new TbProvinces();
		record.setProvinceid(provinceid);
		
		return new ResultBean<TbProvinces>(tbProvincesService.queryOne(record));
		
	}

	
	
	
	

}
