package com.car.app.carscraporder.controller;

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

import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.CarAssessment;
import com.car.app.carscraporder.pojo.TbCarParts;
import com.car.app.carscraporder.pojo.TbCarPartsCategory;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.CarAssessmentService;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarAssessmentVO;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping(value="/carAssessment")
@Api(value = "carAssessment-API",tags={"车辆估值相关"})
public class CarAssessmentController {
	
	
	@Autowired
	private CarAssessmentService  carAssessmentService;
	
	
	/**
	 * 配件分页列表
	 * @param page
	 * @param rows
	 * @param paramter
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取车辆估值列表",notes = "获取车辆估值列表")
	public ResultBean<PageResult<CarAssessment>> getUserList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarAssessmentVO paramter) throws Exception{
		
				PageInfo<CarAssessment>  data = carAssessmentService.queryPageListByWhere(page, rows, paramter);
				PageResult result = new PageResult();
				result.setRows(data.getList());
				result.setTotal(data.getTotal());
		
		     return new ResultBean<PageResult<CarAssessment>>(result);
		
		
	}
	
	

	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取车辆估值详情",notes = "根据id获取车辆估值详情")
	public ResultBean<CarAssessment> getCarAssessment(@PathVariable("id")Integer id) throws Exception{
		
		return new ResultBean<CarAssessment>(carAssessmentService.queryById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增车辆估值",notes = "新增车辆估值")
	public ResultBean<Boolean> addCarAssessment(CarAssessment param) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		param.setCreater(u.getId());
		
		
	
		return new ResultBean<Boolean>(carAssessmentService.save(param)==1);
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改车辆估值",notes = "修改车辆估值")
	public ResultBean<Boolean> updateCarAssessment(@PathVariable("id")Integer id,CarAssessment param) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		CarAssessment  carAssessment = carAssessmentService.queryById(id);
		
		param.setOperator(u.getId());
		param.setCreater(carAssessment.getCreater());
		param.setCreatetime(carAssessment.getCreatetime());
		
		
		return new ResultBean<Boolean>(carAssessmentService.update(param)==1);
	}
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除车辆估值",notes = "删除车辆估值")
	public ResultBean<Boolean> deleteCarAssessment(@PathVariable("id")Integer id) throws Exception{
	
		
		CarAssessment carAssessment = carAssessmentService.queryById(id);
		if(carAssessment!=null){
			return new ResultBean<Boolean>(carAssessmentService.deleteById(id)==1);
		}
		
		return new ResultBean<Boolean>(false);
		
	
		
	}

}
