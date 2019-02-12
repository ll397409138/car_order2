package com.car.app.carscraporder.controller.external;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.pojo.TbAppBanner;
import com.car.app.carscraporder.service.TbAppBannerService;
import com.car.app.common.bean.ResultBean;


@Controller
@RequestMapping(value="/external/appbanner")
@Api(value = "External-AppBanner-API",tags={"提供外部调用的订单相关接口,(跳过登录校验,按照自定义鉴权逻辑)"} )
public class TbAppBannerExternalController {
	
	@Autowired
	private TbAppBannerService tbAppBannerService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户分页列表",notes = "获取用户分页列表")
	public ResultBean<List<TbAppBanner>> getAll(@RequestParam(value="type",required = true)String type) throws Exception{
		
		      TbAppBanner whereParam = new TbAppBanner();
		      whereParam.setIsvalid(true);
		      whereParam.setType(type);
		
		      List<TbAppBanner> result =  tbAppBannerService.queryListByWhere(whereParam);
		
		
		     return new ResultBean<List<TbAppBanner>>(result);
		
		
	}

}
