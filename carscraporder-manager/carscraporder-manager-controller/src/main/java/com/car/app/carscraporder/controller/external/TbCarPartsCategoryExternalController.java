package com.car.app.carscraporder.controller.external;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.pojo.TbCarPartsCategory;
import com.car.app.carscraporder.service.TbCarPartsCategoryService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/external/carPartsCategory")
@Api(value = "Cityes-API",tags={"汽车配件名称"})
public class TbCarPartsCategoryExternalController {
	@Autowired
	private TbCarPartsCategoryService tbCarPartsCategoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件下拉框数据",notes = "退出系统")
	public ResultBean<List<TbCarPartsCategory>> getCarPartsCategory() throws Exception{
		
		TbCarPartsCategory param = new TbCarPartsCategory();
		param.setIsvalid(true);
		List<TbCarPartsCategory> carPartsCategoryList = tbCarPartsCategoryService.queryListByWhere(param);
		
		
	
		return new ResultBean(carPartsCategoryList);
	}
}
