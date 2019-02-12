package com.car.app.carscraporder.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.car.app.carscraporder.pojo.Advertisement;
import com.car.app.carscraporder.service.AdvertisementService;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/advertisement")
@Api(value = "Advertisement-API",tags={"前台轮播广告信息操作接口类"})
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	
	/**
	 * 
	 * @param page
	 * @param rows
	 * @param paramter
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取轮播广告分页列表",notes = "获取轮播广告分页列表")
	public ResultBean<PageResult> getAdvertisementList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			Advertisement paramter) throws Exception{
		    
		         
		     return new ResultBean(advertisementService.queryPageListByWhere(page, rows, paramter));
		
		
	}
	
	
	
	
	
	/**
	 * 
	 * @param areas
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增轮播广告")
	public ResultBean<Integer> addAdvertisement(@Validated Advertisement advertisement,BindingResult bindingResult) throws Exception{
		
		return new ResultBean<>(advertisementService.save(advertisement));
		
		
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改轮播广告",notes = "修改轮播广告")
	public ResultBean<Integer> updateAdvertisement(@PathVariable("id")Integer id,@Validated Advertisement advertisement,BindingResult bindingResult) throws Exception{
		
		return new ResultBean<>(advertisementService.update(advertisement));
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除轮播广告",notes = "根据id删除轮播广告")
	public ResultBean<Integer> deleteByIds(@PathVariable("id")Integer id) throws Exception{

		return new ResultBean<>(advertisementService.deleteById(id));
   }
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取轮播广告",notes = "根据id获取轮播广告")
	public ResultBean<Advertisement> getAreasById(@PathVariable("id")Integer id) throws Exception{
		return new ResultBean<>(advertisementService.queryById(id));

	}

}
