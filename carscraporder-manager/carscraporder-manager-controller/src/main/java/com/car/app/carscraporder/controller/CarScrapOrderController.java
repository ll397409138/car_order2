package com.car.app.carscraporder.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.CarScrapOrderBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.OrderAduitBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.http.DataConverter;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.carscraporder.vo.CarScrapOrderVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.DataException;
import com.github.pagehelper.PageInfo;



@Controller
@RequestMapping(value="/order")
@Api(value = "Order-API",tags={"订单操作接口"})
public class CarScrapOrderController {
	
	
	private Logger logger = LoggerFactory.getLogger(CarScrapOrderController.class);
	
	
	@Autowired
	private CarScrapOrderService  carScrapOrderService;
	
	
	
	
	
	/**
	 * 
	 * @param page
	 * @param rows
	 * @param paramter
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户分页列表",notes = "获取用户分页列表" )
	public ResultBean<PageResult> getOrderList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		    UserBO user = UserUtil.getUser();
	          if(user==null){
		         throw new UnloginException();
	          }   
	          //查询是否有查询全区域数据的权限
	          if(!user.getIsAllDataPermisssion()) paramter.setAraesids(user.getAreasids());
			  PageResult pageResult  = null;
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderService.queryPageListByKeyword(page, rows, paramter);
			    if(pageInfo!=null){
			    	pageResult = new PageResult();
			    	pageResult.setRows(pageInfo.getList());
				    pageResult.setTotal(pageInfo.getTotal());
				    new ResultBean<>(pageResult);
			    }   
		     return new ResultBean<>(pageResult);
		
		
	}
	
	
	@RequestMapping(value="/history",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取订单历史分页列表",notes = "获取订单历史分页列表")
	public ResultBean<PageResult> getOrderHistoryList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		     UserBO user = UserUtil.getUser();
		      if(user==null){
			      throw new UnloginException();
		       } 
		       if(!user.getIsAllDataPermisssion()) paramter.setUserid(user.getId());
			    PageResult pageResult  = new PageResult();
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderService.queryPageHistoryListByKeyword(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	
	@RequestMapping(value="getAll",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户分页列表",notes = "获取用户分页列表" )
	public ResultBean<PageResult> getAll(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		    UserBO user = UserUtil.getUser();
	          if(user==null){
		         throw new UnloginException();
	          }
	          
	          if(!user.getIsAllDataPermisssion()){
	        	  paramter.setAraesids(user.getAreasids());
		          paramter.setUserid(user.getId());
	          }
	         
	          
	          
			  PageResult pageResult  = null;
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderService.queryAll(page, rows, paramter);
			    if(pageInfo!=null){
			    	pageResult = new PageResult();
			    	pageResult.setRows(pageInfo.getList());
				    pageResult.setTotal(pageInfo.getTotal());
				    new ResultBean<>(pageResult);
			    }   
		     return new ResultBean<>(pageResult);
		
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增订单",notes = "新增订单" )
	public ResultBean<Boolean> saveOrder(CarScrapOrderVO paramter) throws Exception{
		
		UserBO user = UserUtil.getUser();
		   if(user==null){
			   throw new UnloginException();
		    }
		   paramter.setCreater(user.getId());
		   paramter.setClientId(user.getId());
		   paramter.setOrderAreasId(2);
			  int result = carScrapOrderService.save(paramter);
			  if(result==1){
				  return new ResultBean<>(true);
			  }else{
				  return new ResultBean<>(false);
			  }
			  
		     
		
		
	}
	

	
	
	
	/**
	 * 根据订单id删除订单
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除订单",notes = "根据id删除订单")
	public ResultBean<Boolean> deleteOrderById(
			@ApiParam(name = "id", value = "订单id",required = true)
			@RequestParam(required=true) String id,
			HttpServletRequest request) throws Exception{
		
		User user = UserUtil.getUser();
		
		if(user==null){
			throw new UnloginException();
		}
		
		return new ResultBean<Boolean>(carScrapOrderService.deleteByPrimaryKey(id,user.getId())==1);

		
	}
	
	
	

	
	/**
	 * 根据订单id获取订单详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取订单详情",notes = "根据id获取User详情")
	public ResultBean<CarScrapOrderBO> getOrderById(@PathVariable("id")String id) throws Exception{
		return new ResultBean<CarScrapOrderBO>(carScrapOrderService.queryBOById(id));
		
	}
	
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getOrderAuditInfo/{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取订单审核进度详情",notes = "根据id获取订单审核进度详情")
	public ResultBean<OrderAduitBO> getOrderAuditInfo(@PathVariable("id")String id) throws Exception{
		return new ResultBean<OrderAduitBO>(carScrapOrderService.getOrderAuditInfo(id));
		
	}
	
	/**
	 * 根据传递的参数更新字段
	 * @param id
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}/updateSelective",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改订单",notes = "根据id修改订单信息")
	public ResultBean<Boolean> updateOrderSelective(@PathVariable("id")String id,@Validated CarScrapOrderVO carScrapOrderVo,BindingResult bindingResult
			, HttpServletRequest request
			
			) throws Exception{
		User u = UserUtil.getUser();
		
		CarScrapOrder carScrapOrder = carScrapOrderService.queryById(id);
		carScrapOrder = DataConverter.copyRequestParamToOrdermedel(carScrapOrder,request);
		carScrapOrder.setOperator(u.getId());
		
		
		
		return new ResultBean<Boolean>(carScrapOrderService.update(carScrapOrder)==1);
		
	}
	
	/**
	 * 全数据更新
	 * @param id
	 * @param carScrapOrderVo
	 * @param bindingResult
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改订单",notes = "根据id修改订单信息")
	public ResultBean<Boolean> updateOrder(@PathVariable("id")String id,CarScrapOrderVO carScrapOrderVo
			, HttpServletRequest request) throws Exception{
          User u = UserUtil.getUser();
		  CarScrapOrder carScrapOrder = carScrapOrderService.queryById(id);
		  carScrapOrder = DataConverter.copyRequestParamToOrdermedel(carScrapOrder,request);
		  carScrapOrder.setOperator(u.getId());
		
		int count = carScrapOrderService.update(carScrapOrder);
		
		
		return new ResultBean(count==1);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 订单审核
	 * @param id
	 * @param orderStatus
	 * @param remark
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/audit/{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "审核订单",notes = "审核订单")
	public ResultBean<Boolean> saveOrderAuditingRecord(@PathVariable("id")String id,
			@RequestParam(required = true)Integer auditorderStatus,
			String auditRemark,CarScrapOrder order, HttpServletRequest request) throws Exception{
		User user = UserUtil.getUser();
	     if(user == null){
	    	 throw new DataException("未登录系统");
	     }
	     
	     CarScrapOrder carScrapOrder = carScrapOrderService.queryById(id);
		 
	     carScrapOrder = DataConverter.copyRequestParamToOrdermedel(carScrapOrder,request);
		 carScrapOrder.setOperator(user.getId());
	    
	     
		return new ResultBean<Boolean> (carScrapOrderService.saveOrderAuditingRecord(id,auditorderStatus,auditRemark,user.getId(),carScrapOrder)==1);
		
	}
	
	
	
	
	
	

	
	
	
	






}
