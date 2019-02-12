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
import com.car.app.carscraporder.pojo.TbCarParts;
import com.car.app.carscraporder.pojo.TbCarPartsCategory;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.TbCarPartsService;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/carParts")
@Api(value = "Cityes-API",tags={"汽车配件名称"})
public class TbCarPartsController {
	
	
	@Autowired
	private TbCarPartsService tbCarPartsService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据大类id获取配件名称数据",notes = "根据大类id获取配件名称数据")
	public ResultBean<List<TbCarParts>> getCarPartsByCategoryId(@RequestParam(value="categoryId",required = true)Integer categoryId) throws Exception{
		
		TbCarParts param = new TbCarParts();
		param.setPartsCategoryId(categoryId);
		param.setIsvalid(true);
		List<TbCarParts> carPartsList = tbCarPartsService.queryListByWhere(param);
		return new ResultBean<List<TbCarParts>> (carPartsList);
		
	}
	
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件名称列表",notes = "获取配件名称分页列表")
	public ResultBean<List<TbCarParts>> getTbCarPartsPageList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
	        @RequestParam(value="page",required = true,defaultValue="1")Integer page,
	        @ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
	        @RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
	        TbCarParts param) throws Exception{
		
			CheckUtil.notNull(param, "param.is.null");
			CheckUtil.notNull(param.getPartsCategoryId(), "param.is.null");
			param.setIsvalid(true);
			List<TbCarParts> carPartsList = tbCarPartsService.queryListByWhere(param);
	
		   return new ResultBean<List<TbCarParts>>(carPartsList);
	}
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据Id获取配件名称数据",notes = "根据Id获取配件名称数据")
	public ResultBean<TbCarParts> getTbCarParts(@PathVariable("id")Integer id) throws Exception{
		return new ResultBean<TbCarParts> (tbCarPartsService.queryById(id));
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增配件名称",notes = "新增配件名称")
	public ResultBean<Boolean> addTbCarParts(TbCarParts tbCarParts) throws Exception{
		CheckUtil.notNull(tbCarParts, "param.is.null");
		CheckUtil.notNull(tbCarParts.getPartsCategoryId(), "param.is.null");
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		tbCarParts.setCreater(u.getId());
		return new ResultBean<Boolean> (tbCarPartsService.save(tbCarParts)==1);
		
	}
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改配件名称",notes = "修改配件名称")
	public ResultBean<Boolean> updateCarPartsCategory(@PathVariable("id")Integer id,TbCarParts tbCarParts) throws Exception{
		
		CheckUtil.notNull(tbCarParts, "param.is.null");
		
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		TbCarParts tbCarPartsData  = tbCarPartsService.queryById(id);
		if(tbCarParts==null){
			throw new DataException("请求数据不存在");
		}
		
		
		tbCarPartsData.setPartsName(tbCarParts.getPartsName());
		tbCarPartsData.setOperator(u.getId());
		
		
	
		return new ResultBean<Boolean>(tbCarPartsService.update(tbCarPartsData)==1);
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除配件名称",notes = "删除配件名称")
	public ResultBean<Boolean> DeleteCarPartsCategory(@PathVariable("id")Integer id) throws Exception{
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		TbCarParts tbCarParts  = tbCarPartsService.queryById(id);
		if(tbCarParts==null){
			throw new DataException("请求数据不存在");
		}
		tbCarParts.setOperator(u.getId());
		tbCarParts.setIsvalid(false);
		
		
	
		return new ResultBean<Boolean>(tbCarPartsService.update(tbCarParts)==1);
	}
	
	

}
