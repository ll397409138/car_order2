package com.car.app.carscraporder.controller;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.CarScrapOrderSettlementBO;
import com.car.app.carscraporder.exception.CheckException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.pojo.CarScrapOrderSettlement;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.service.CarScrapOrderSettlementService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarScrapOrderSettlementVO;
import com.car.app.carscraporder.vo.CarScrapOrderVO;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/settlement")
@Api(value = "Order-settlement-API",tags={"订单结算接口"})
public class CarScrapOrderSettlementController {

	
	@Autowired
	private CarScrapOrderSettlementService carScrapOrderSettlementService;
	
	@Autowired
	private CarScrapOrderService  carScrapOrderService;
	
	@Autowired
	private CarScrapOrderAutopartsService  carScrapOrderAutopartsService;
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增结算记录",notes = "新增结算记录" )
	public ResultBean<Boolean> saveSettlement(CarScrapOrderSettlementVO paramter) throws Exception{
		
          User user = UserUtil.getUser();
		   if(user==null){
			   throw new UnloginException();
		    }
		   
		   CarScrapOrderSettlement settlement = new CarScrapOrderSettlement();
		   
		   structureCarScrapOrderSettlement(user.getId(),settlement,paramter);
		   return new ResultBean<Boolean>(carScrapOrderSettlementService.saveCarScrapOrderSettlement(settlement)==1);
	}
	
	private void structureCarScrapOrderSettlement(String creater,CarScrapOrderSettlement settlement, CarScrapOrderSettlementVO source){
		BeanUtils.copyProperties(source, settlement);
		settlement.setCreater(creater);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据订单id查询订单结算记录列表",notes = "根据订单id查询订单结算记录列表" )
	public ResultBean<List<CarScrapOrderSettlementBO>> saveSettlement(String orderid) throws Exception{
		
          User user = UserUtil.getUser();
		   if(user==null){
			   throw new UnloginException();
		    }
		   
		   return new ResultBean<List<CarScrapOrderSettlementBO>>(carScrapOrderSettlementService.getCarScrapOrderSettlementByOrderId(orderid));
	}
	
	
}
