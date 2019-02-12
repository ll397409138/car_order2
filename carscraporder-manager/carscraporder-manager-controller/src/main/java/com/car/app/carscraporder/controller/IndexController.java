package com.car.app.carscraporder.controller;

import java.util.Arrays;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.RemindBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.OrderEarlyWarningSetting;
import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.service.IndexService;
import com.car.app.carscraporder.service.OrderEarlyWarningSettingService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/index")
@Api(value = "Index-API",tags={"首页数据加载"})
public class IndexController {
	
	@Autowired
	private CarScrapOrderService  carScrapOrderService;
	
	@Autowired
	private CarScrapOrderAutopartsService  carScrapOrderAutopartsService;
	
	@Autowired
	private OrderEarlyWarningSettingService  orderEarlyWarningSettingService;
	
	
	@Autowired
	private IndexService indexService;
	
	//未处理订单、未接收车辆、未接受旧件、超时未处理订单、超时未报废汽车、超时未接收旧件
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "首页数据加载",notes = "首页数据加载")
	public ResultBean<List<RemindBO>> getIndexData() throws Exception{
		    
		         
		     return new ResultBean<List<RemindBO>>(indexService.getIndexData());
		
		
	}
	
	
	@RequestMapping(value="getList",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据卡片查询列表数据",notes = "根据卡片查询列表数据")
	public ResultBean<PageResult<CarScrapOrderPageBO>> getListByCode(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			@RequestParam(value="code",required=true) Integer code) throws Exception{
		
		
		UserBO user = UserUtil.getUser();
	      if(user==null){
             throw new UnloginException();
          }  
	  	CarScrapOrderKeywordVO whereParam = new CarScrapOrderKeywordVO();
		  	if(!user.getIsAllDataPermisssion()){
	    		if(StringUtils.isNotBlank(user.getAreasids())){
	    			whereParam.setAraesidList(Arrays.asList(StringUtils.split(user.getAreasids(), ",")));
	    		}
	    		whereParam.setUserid(user.getId());
	    		
	    		
	    	}
		
		  PageResult<CarScrapOrderPageBO> pageResult  = new PageResult<CarScrapOrderPageBO>();
		  PageInfo<CarScrapOrderPageBO> pageInfo = null;
		
		
		  switch(code){
		    case 1:
		    	whereParam.setOrderStatus("1");
		    	pageInfo = carScrapOrderService.queryPageListByKeyword(page,rows,whereParam);
		    	pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
			    break;
		    case 2:
		    	whereParam.setOrderStatus("2");
		    	whereParam.setOrderType("1");
		    	pageInfo = carScrapOrderService.queryPageListByKeyword(page,rows,whereParam);
		    	pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		        break;
		       
		    case 3:
		    	whereParam.setOrderStatus("2");
		    	whereParam.setOrderType("1");
		    	pageInfo = carScrapOrderAutopartsService.queryBOPageListByWhere(page,rows,whereParam);
		    	pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		        break;
			       
		    case 4:
		    	whereParam.setOrderStatus("1");
				    	//1.查询超时未接单系统设置
			        	OrderEarlyWarningSetting earlywhereParam = new OrderEarlyWarningSetting();
			        	earlywhereParam.setEarlyWarningCode("unprocessed_orders");
			        	OrderEarlyWarningSetting earlyWarning = orderEarlyWarningSettingService.queryOne(earlywhereParam);
			        	//获取系统超时时间配置
			        	Double timeOutSetting = earlyWarning.getEarlyWarningValue();
			        	DateTime time = new DateTime();
			        	time = time.plusHours((int)-timeOutSetting);
			     whereParam.setEarlyWarningDate(time.toDate());
		    	 pageInfo = carScrapOrderService.queryPageListByKeyword(page,rows,whereParam);
		    	 pageResult.setRows(pageInfo.getList());
			     pageResult.setTotal(pageInfo.getTotal());
		         break;    
			       
		    case 5:
		    	whereParam.setOrderStatus("2");
		    	whereParam.setOrderType("1");
					    	//1.查询超时未接单系统设置
				        	OrderEarlyWarningSetting earlywhereParam2 = new OrderEarlyWarningSetting();
				        	earlywhereParam2.setEarlyWarningCode("unreceived_wholecartype_orders");
				        	OrderEarlyWarningSetting earlyWarning2 = orderEarlyWarningSettingService.queryOne(earlywhereParam2);
				        	//获取系统超时时间配置
				        	Double timeOutSetting2 = earlyWarning2.getEarlyWarningValue();
				        	DateTime time2 = new DateTime();
				        	time2 = time2.plusHours((int)-timeOutSetting2);
		          whereParam.setEarlyWarningDate(time2.toDate());
	    	      pageInfo = carScrapOrderService.queryPageListByKeyword(page,rows,whereParam);
	    	      pageResult.setRows(pageInfo.getList());
		          pageResult.setTotal(pageInfo.getTotal());
			      break;
			       
			 case 6:
				 whereParam.setOrderStatus("2");
			     whereParam.setOrderType("2");
					    	//1.查询超时未接单系统设置
				        	OrderEarlyWarningSetting earlywhereParam3 = new OrderEarlyWarningSetting();
				        	earlywhereParam3.setEarlyWarningCode("unreceived_carpartstype_orders");
				        	OrderEarlyWarningSetting earlyWarning3 = orderEarlyWarningSettingService.queryOne(earlywhereParam3);
				        	//获取系统超时时间配置
				        	Double timeOutSetting3 = earlyWarning3.getEarlyWarningValue();
				        	DateTime time3 = new DateTime();
				        	time3 = time3.plusHours((int)-timeOutSetting3);
		          whereParam.setEarlyWarningDate(time3.toDate());
	    	      pageInfo = carScrapOrderAutopartsService.queryBOPageListByWhere(page,rows,whereParam);
	    	      pageResult.setRows(pageInfo.getList());
		          pageResult.setTotal(pageInfo.getTotal());
			       
			       break;
				       
			   
		    
		  }
		
		
		         
		      return new ResultBean<PageResult<CarScrapOrderPageBO>>(pageResult);
		
		
	}

}
