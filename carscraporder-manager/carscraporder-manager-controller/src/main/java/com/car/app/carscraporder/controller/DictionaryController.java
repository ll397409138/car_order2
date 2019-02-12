package com.car.app.carscraporder.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.DictionaryBO;
import com.car.app.carscraporder.pojo.TbAreas;
import com.car.app.carscraporder.pojo.TbCityes;
import com.car.app.carscraporder.pojo.TbProvinces;
import com.car.app.carscraporder.service.TbAreasService;
import com.car.app.carscraporder.service.TbCityesService;
import com.car.app.carscraporder.service.TbProvincesService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/dictionary")
@Api(value = "dictionary-API",tags={"提供外部调用的订单相关接口,(跳过登录校验,按照自定义鉴权逻辑)"} )
public class DictionaryController {
	
	@Autowired
	private TbProvincesService tbProvincesService;
	
	@Autowired
	private  TbCityesService tbCityesService;
	
	@Autowired
	private TbAreasService tbAreasService;
	

	@RequestMapping(value="/getAllProvince",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询所有省份数据",notes = "查询所有省份数据")
	public ResultBean<List<DictionaryBO>> getAllProvince() throws Exception{
		
		
		List<TbProvinces> result =  tbProvincesService.queryAll();
		
		if(result!=null){
			List<DictionaryBO> dictionaryBOs = new ArrayList<DictionaryBO>();
			for(TbProvinces t:result){
				DictionaryBO bo = new DictionaryBO();
				bo.setId(t.getProvinceid());
				bo.setName(t.getProvince());
				dictionaryBOs.add(bo);
			}
			
			return new ResultBean(dictionaryBOs);
			
		}else{
			return new ResultBean(result);
		}
		
		
		

	}
	
	
	

	@RequestMapping(value="/getAllCityByProvinceId/{provinceid}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取区域详情",notes = "根据id获取区域详情")
	public ResultBean<List<DictionaryBO>> getAllAreaByCityId(@PathVariable("provinceid")String provinceid) throws Exception{
		TbCityes whereParam = new TbCityes();
		whereParam.setProvinceid(provinceid);
		List<TbCityes> result = tbCityesService.queryListByWhere(whereParam);
		if(result!=null){
			List<DictionaryBO> dictionaryBOs = new ArrayList<DictionaryBO>();
			for(TbCityes t:result){
				DictionaryBO bo = new DictionaryBO();
				bo.setId(t.getCityid());
				bo.setName(t.getCity());
				dictionaryBOs.add(bo);
			}
			
			return new ResultBean<List<DictionaryBO>>(dictionaryBOs);
			
		}else{
			return new ResultBean(result);
		}

	}

	
	

	
	
	@RequestMapping(value="/getAllAreaByCityId/{cityid}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取区域详情",notes = "根据id获取区域详情")
	public ResultBean<List<DictionaryBO>> getAllCityByProvinceId(@PathVariable("cityid")String cityid) throws Exception{
		TbAreas whereParam = new TbAreas();
		whereParam.setCityid(cityid);
		List<TbAreas> result = tbAreasService.queryListByWhere(whereParam);
		if(result!=null){
			List<DictionaryBO> dictionaryBOs = new ArrayList<DictionaryBO>();
			for(TbAreas t:result){
				DictionaryBO bo = new DictionaryBO();
				bo.setId(t.getAreaid());
				bo.setName(t.getArea());
				dictionaryBOs.add(bo);
			}
			return new ResultBean<List<DictionaryBO>>(dictionaryBOs);
			
		}else{
			return new ResultBean(result);
		}
		

		

	}
	
	
}
