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

import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.Role;
import com.car.app.carscraporder.pojo.TbCarParts;
import com.car.app.carscraporder.pojo.TbCarPartsCategory;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.TbCarPartsCategoryService;
import com.car.app.carscraporder.service.TbCarPartsService;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/carPartsCategory")
@Api(value = "Cityes-API",tags={"汽车配件大类"})
public class TbCarPartsCategoryController {
	
	@Autowired
	private TbCarPartsCategoryService tbCarPartsCategoryService;
	
	@Autowired
	private TbCarPartsService tbCarPartsService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件下拉框数据",notes = "获取配件下拉框数据")
	public ResultBean<List<TbCarPartsCategory>> getCarPartsCategory() throws Exception{
		
		TbCarPartsCategory param = new TbCarPartsCategory();
		param.setIsvalid(true);
		List<TbCarPartsCategory> carPartsCategoryList = tbCarPartsCategoryService.queryListByWhere(param);
		
		
	
		return new ResultBean(carPartsCategoryList);
	}
	

	@RequestMapping(value="list",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件分页列表",notes = "获取配件分页列表")
	public ResultBean<List<TbCarPartsCategory>> getCarPartsCategoryPageList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
	        @RequestParam(value="page",required = true,defaultValue="1")Integer page,
	        @ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
	        @RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
	        TbCarPartsCategory param) throws Exception{
		
		
		param.setIsvalid(true);
		List<TbCarPartsCategory> carPartsCategoryList = tbCarPartsCategoryService.queryListByWhere(param);
		
		
	
		return new ResultBean<List<TbCarPartsCategory>>(carPartsCategoryList);
	}
	
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取配件大类",notes = "根据id获取配件大类")
	public ResultBean<TbCarPartsCategory> getCarPartsCategory(@PathVariable("id")Integer id) throws Exception{
		
		return new ResultBean<TbCarPartsCategory>(tbCarPartsCategoryService.queryById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增配件大类列表",notes = "新增配件大类列表")
	public ResultBean<Boolean> addCarPartsCategory(TbCarPartsCategory param) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		param.setIsvalid(true);
		param.setCreater(u.getId());
		
		
	
		return new ResultBean<Boolean>(tbCarPartsCategoryService.save(param)==1);
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改配件大类列表",notes = "修改配件大类列表")
	public ResultBean<Boolean> updateCarPartsCategory(@PathVariable("id")Integer id,TbCarPartsCategory param) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		param.setOperator(u.getId());
		
		
	
		return new ResultBean<Boolean>(tbCarPartsCategoryService.updateSelective(param)==1);
	}
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除配件大类列表",notes = "删除配件大类列表")
	public ResultBean<Boolean> deleteCarPartsCategory(@PathVariable("id")Integer id) throws Exception{
	
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		//查询大类下是否有有效的配件名称
		TbCarParts whereParam = new TbCarParts();
		whereParam.setPartsCategoryId(id);
		whereParam.setIsvalid(true);
		
		
		int count = tbCarPartsService.selectCount(whereParam);	
		if(count>0){
			throw new DataException("配件大类下有有效的配件名称，请删除配件名称后再删除配件大类");
		}
		
		TbCarPartsCategory tbCarPartsCategory =  tbCarPartsCategoryService.queryById(id);
		if(tbCarPartsCategory!=null){
			tbCarPartsCategory.setIsvalid(false);
			
			tbCarPartsCategory.setOperator(u.getId());
			return new ResultBean<Boolean>(tbCarPartsCategoryService.updateSelective(tbCarPartsCategory)==1);
		}
		return new ResultBean<Boolean>(false);
		
		
		
		
	
		
	}
	
	

}
