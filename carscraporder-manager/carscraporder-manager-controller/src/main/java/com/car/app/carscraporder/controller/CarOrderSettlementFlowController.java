package com.car.app.carscraporder.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.CarOrderSettlementFlowBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.CarOrderSettlementFlowService;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarOrderSettlementFlowVO;
import com.car.app.common.bean.ResultBean;


@Controller
@RequestMapping(value="/settlementFlow")
@Api(value = "Order-flow-API",tags={"订单结算流水接口"})
public class CarOrderSettlementFlowController {
	
	@Autowired
	private CarOrderSettlementFlowService carOrderSettlementFlowService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增结算流水记录",notes = "新增结算流水记录" )
	public ResultBean<Boolean> saveSettlement(@RequestBody CarOrderSettlementFlowVO paramter) throws Exception{
		
          User user = UserUtil.getUser();
		   if(user==null){
			   throw new UnloginException();
		    }
		   
		   paramter.setCreater(user.getId());
		 
		   return new ResultBean<Boolean>(carOrderSettlementFlowService.saveFlow(paramter)==1);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询结算流水列表",notes = "查询结算流水列表" )
	public ResultBean<List<CarOrderSettlementFlowBO>> getCarOrderSettlementFlowBO(@RequestBody CarOrderSettlementFlowVO paramter) throws Exception{
		return null;
		
       
	}

}
