package com.car.app.carscraporder.controller.external;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncListenableTaskExecutor;
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
import com.car.app.carscraporder.bo.CarScrapOrderSimpleInfo;
import com.car.app.carscraporder.bo.OrderAduitBO;
import com.car.app.carscraporder.exception.CheckException;
import com.car.app.carscraporder.http.DataConverter;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarScrapOrderExternalVO;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.carscraporder.vo.CarScrapOrderVO;
import com.car.app.carscraporder.vo.CarScrapOrderWhereParamterVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.DataException;
import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/external/order")
@Api(value = "External-Order-API",tags={"提供外部调用的订单相关接口,(跳过登录校验,按照自定义鉴权逻辑)"} )
public class CarScrapOrderExternalController {
	
	@Autowired
	private CarScrapOrderService  carScrapOrderService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取用户分页列表",notes = "获取用户分页列表")
	public ResultBean<PageResult<CarScrapOrderPageBO>> getOrderList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		         
			    PageResult<CarScrapOrderPageBO> pageResult = null;
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderService.queryPageListByKeyword(page, rows, paramter);
			    if(pageInfo!=null){
			    	pageResult  = new PageResult<CarScrapOrderPageBO>();
			    	pageResult.setRows(pageInfo.getList());
					pageResult.setTotal(pageInfo.getTotal());
			    }
			   
		     return new ResultBean<PageResult<CarScrapOrderPageBO>>(pageResult);
		
		
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
		         
			    PageResult pageResult  = new PageResult();
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderService.queryPageHistoryListByKeyword(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取所有操作的订单和待处理的订单",notes = "获取所有操作的订单和待处理的订单")
	public ResultBean<PageResult> getAll(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		         
			    PageResult pageResult  = new PageResult();
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderService.queryAll(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	

	
	/**
	 * 新增订单
	 * @param carScrapOrderVO 页面传递订单数据
	 * @return
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增订单")
	public ResultBean<Boolean> addOrder(@RequestBody CarScrapOrderExternalVO carScrapOrderVO,BindingResult bindingResult) throws Exception{
		
	
		
		return new ResultBean<Boolean>(carScrapOrderService.save(carScrapOrderVO)==1);
		
	}
	
	
	/**
	 * 根据订单id删除订单
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据ids删除订单",notes = "根据ids删除订单")
	public ResultBean<Integer> deleteOrderById(
			@ApiParam(name = "id", value = "订单id",required = true)
			@RequestParam(required=true) String id,@RequestParam(value="operator")String operator,
			HttpServletRequest request) throws Exception{
		
		
		return new ResultBean(carScrapOrderService.deleteByPrimaryKey(id,operator));

		
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
		return new ResultBean(carScrapOrderService.queryBOById(id));
		
	}
	
	
	
	/**
	 * 根据订单获取订单的简单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getSimpleInfo/{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取订单详情",notes = "根据id获取User详情")
	public ResultBean<CarScrapOrderSimpleInfo> getCarScrapOrderSimpleInfo(@PathVariable("id")String id) throws Exception{
		CarScrapOrderSimpleInfo simpleInfo = new CarScrapOrderSimpleInfo();
		CarScrapOrderBO bo = carScrapOrderService.queryBOById(id);
		if(bo!=null){
			BeanUtils.copyProperties(bo, simpleInfo);
		}else{
			return new ResultBean(bo);
		}
		
		return new ResultBean(simpleInfo);
		
	}
	
	/**
	 * 根据id更新订单
	 * @param id
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改订单",notes = "根据id修改订单信息")
	public ResultBean<Integer> updateOrder(@PathVariable("id")String id,HttpServletRequest request) throws Exception{
         CarScrapOrder carScrapOrder = carScrapOrderService.queryById(id);
	     carScrapOrder = DataConverter.copyRequestParamToOrdermedel(carScrapOrder,request);
		 return new ResultBean(carScrapOrderService.update(carScrapOrder));
		
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
			@RequestParam(value="auditRemark",required = false)String auditRemark,@RequestParam(value="auditer")String auditer,CarScrapOrder order, HttpServletRequest request) throws Exception{
		
	     
	     CarScrapOrder carScrapOrder = carScrapOrderService.queryById(id);
	     if(carScrapOrder!=null){
	    	 carScrapOrder = DataConverter.copyRequestParamToOrdermedel(carScrapOrder,request);
			 carScrapOrder.setOperator(auditer);
			 int result = carScrapOrderService.saveOrderAuditingRecord(id,auditorderStatus,auditRemark,auditer,carScrapOrder);
			 return new ResultBean<Boolean>(result==1);
	     }
	    
	    
	     
		return new ResultBean<Boolean>(false);
		
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
	 * 
	 * @param agentUserid
	 * @param orderStauts
	 * @param areas
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryToDoHndleOrder",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询待处理的订单数",notes = "审核订单")
	public ResultBean<Integer> queryPendingOrder(String agentUserid,Integer orderStauts,String areas)throws Exception{
		List<Object> areasArray = new ArrayList<Object>();
		if(StringUtils.isNotBlank(areas)){
			String[] areasids = StringUtils.split(areas, ",");
			areasArray = Arrays.asList(areasids);
		}
		Example example = new Example(CarScrapOrder.class);
		Criteria criteria  = example.createCriteria();
		
		
		if(CommonSystemParamter.ORDER_DISTRIBUTION_STATUS==orderStauts){
			CheckUtil.notEmpty(agentUserid, "param is null");
			
			criteria.andEqualTo("orderStatus", CommonSystemParamter.ORDER_DISTRIBUTION_STATUS);
			criteria.andEqualTo("agentUserid", agentUserid);
			criteria.andEqualTo("isremove", false);
			criteria.andEqualTo("orderType", "1");
			
		}else if(CommonSystemParamter.ORDER_RECEIVE_STATUS==orderStauts){
			criteria.andEqualTo("orderStatus", CommonSystemParamter.ORDER_RECEIVE_STATUS);
			criteria.andEqualTo("isremove", false);
			criteria.andEqualTo("orderType", "1");
			
		}else if(CommonSystemParamter.ORDER_STORAGE_STATUS==orderStauts){
			criteria.andEqualTo("orderStatus", CommonSystemParamter.ORDER_STORAGE_STATUS);
			criteria.andEqualTo("isremove", false);
			criteria.andEqualTo("orderType", "1");
		}
		
		if(areasArray!=null&&areasArray.size()>0){
			criteria.andIn("orderAreasId", areasArray);
		}
		
		
		return new ResultBean<Integer>(carScrapOrderService.selectCountByExample(example));
		
	}
	
	
	
	


}
