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

import com.car.app.carscraporder.pojo.Permission;
import com.car.app.carscraporder.service.PermissionService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/external/permission")
@Api(value = "External-user-API",tags={"提供外部调用的订单相关接口,(跳过登录校验,按照自定义鉴权逻辑)"} )
public class PermissionExternalController {
	
	@Autowired
	private PermissionService permissionService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户分页列表",notes = "获取用户分页列表")
	public ResultBean<List<Permission>> getPermissionByCode(
			@RequestParam(value="userid",required = true)String userid,
			@RequestParam(value="functionCode",required = true)String functionCode) throws Exception{
		     List<Permission>  permission = permissionService.getAppPermissionByBusinessCode(functionCode,userid);
		    return new ResultBean(permission);
		
		
		
		
		
		
		
	}

}
