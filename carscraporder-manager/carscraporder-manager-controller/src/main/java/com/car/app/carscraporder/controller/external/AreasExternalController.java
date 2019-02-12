package com.car.app.carscraporder.controller.external;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.pojo.Areas;
import com.car.app.carscraporder.service.AreasService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/external/areas")
@Api(value = "CARMODEL-API",tags={"力洋接口API"})
public class AreasExternalController {

	@Autowired
	private AreasService  areasService;

	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取区域详情",notes = "根据id获取区域详情")
	public ResultBean<Areas> getAreasById(@PathVariable("id")Integer id) throws Exception{
		
		Areas whereParam = new Areas();
		whereParam.setStatus("1");
		whereParam.setIsVirtualField(false);
		whereParam.setId(id);
		return new ResultBean<Areas>(areasService.queryOne(whereParam));

	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询所有区域",notes = "查询所有区域")
	public ResultBean<List<Areas>> getAll() throws Exception{
		Areas whereParam = new Areas();
		whereParam.setStatus("1");
		whereParam.setIsVirtualField(false);
		
		return new ResultBean<List<Areas>>(areasService.queryListByWhere(whereParam));

	}
}
