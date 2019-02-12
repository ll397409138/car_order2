package com.car.app.carscraporder.controller.external;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.pojo.Advertisement;
import com.car.app.carscraporder.service.AdvertisementService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/external/advertisement")
@Api(value = "CARMODEL-API",tags={"获取官网首页轮播"})
public class AdvertisementExternalController {
	
	@Autowired
	private AdvertisementService  advertisementService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取官网首页轮播",notes = "获取官网首页轮播")
	public ResultBean<List<Advertisement>>  getAll() throws Exception{
		Advertisement paramWhere = new Advertisement();
		paramWhere.setIsvalid(true);
		
		return new ResultBean<List<Advertisement>>(advertisementService.queryListByWhere(paramWhere));
		
	}

}
