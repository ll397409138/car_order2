package com.car.app.carscraporder.service.impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.RemindBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.pojo.OrderEarlyWarningSetting;
import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.service.IndexService;
import com.car.app.carscraporder.service.OrderEarlyWarningSettingService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;

@Service
public class IndexServiceImpl implements IndexService {
	
	
	@Autowired
	private CarScrapOrderService  carScrapOrderService;
	
	@Autowired
	private CarScrapOrderAutopartsService  carScrapOrderAutopartsService;
	
	@Autowired
	private OrderEarlyWarningSettingService  orderEarlyWarningSettingService;
	
	public List<RemindBO>  getIndexData()throws Exception{
		
		UserBO user = UserUtil.getUser();
        if(user==null){
	         throw new UnloginException();
        } 
        List<RemindBO>  data = new ArrayList<RemindBO>();
        
        Subject subject = SecurityUtils.getSubject();
        if(subject.isPermitted("index:untreated_order_remind")){
        	//是否有未处理权限
        	RemindBO bo = new RemindBO();
        	bo.setCode(1);
        	//判断是否全数据权限
        	Example example = new Example(CarScrapOrder.class);
        	Criteria criteria = example.createCriteria();
        	if(!user.getIsAllDataPermisssion()){
        		if(StringUtils.isNotBlank(user.getAreasids())){
        			criteria.andIn("orderAreasId", Arrays.asList(StringUtils.split(user.getAreasids(), ",")));
        		}
        		
        	}
        	criteria.andEqualTo("isremove", false);
        	criteria.andEqualTo("orderStatus", CommonSystemParamter.ORDER_CREATE_STATUS);
        	bo.setRemindNum(carScrapOrderService.selectCountByExample(example));
        	data.add(bo);             
        }
        if(subject.isPermitted("index:unreceive_carorder_remind")){
        	//是否有未接收报废汽车权限
        	RemindBO bo = new RemindBO();
        	bo.setCode(2);
        	//判断是否全数据权限
        	Example example = new Example(CarScrapOrder.class);
        	Criteria criteria = example.createCriteria();
        	if(!user.getIsAllDataPermisssion()){
        		if(StringUtils.isNotBlank(user.getAreasids())){
        			criteria.andIn("orderAreasId", Arrays.asList(StringUtils.split(user.getAreasids(), ",")));
        		}
        		criteria.andEqualTo("agentUserid", user.getId());
        		
        		
        	}
        	criteria.andEqualTo("orderType", "1");
           	criteria.andEqualTo("orderStatus", CommonSystemParamter.ORDER_DISTRIBUTION_STATUS);
        	criteria.andEqualTo("isremove", false);
        	bo.setRemindNum(carScrapOrderService.selectCountByExample(example));
        	
        	data.add(bo);
        	
        	
        }
        if(subject.isPermitted("index:unreceive_partorder_remind")){
        	//是否未接收旧件权限
        	RemindBO bo = new RemindBO();
        	bo.setCode(3);
        	CarScrapOrderKeywordVO whereParam = new CarScrapOrderKeywordVO();
        	
        	if(!user.getIsAllDataPermisssion()){
        		if(StringUtils.isNotBlank(user.getAreasids())){
        			whereParam.setAraesidList(Arrays.asList(StringUtils.split(user.getAreasids(), ",")));
        		}
        		whereParam.setUserid(user.getId());
        		
        		
        	}
        	whereParam.setOrderStatus(CommonSystemParamter.PARTS_RECEIPT_STATUS+"");
        
        	
        	bo.setRemindNum(carScrapOrderAutopartsService.selectCount(whereParam));
        	
        	data.add(bo);
        }
        if(subject.isPermitted("index:untreated_overtimer_remind")){
        	//是否超时未处理订单权限
        	RemindBO bo = new RemindBO();
        	bo.setCode(4);
        	
        	//1.查询超时未接单系统设置
        	OrderEarlyWarningSetting whereParam = new OrderEarlyWarningSetting();
        	whereParam.setEarlyWarningCode("unprocessed_orders");
        	OrderEarlyWarningSetting earlyWarning = orderEarlyWarningSettingService.queryOne(whereParam);
        	//获取系统超时时间配置
        	Double timeOutSetting = earlyWarning.getEarlyWarningValue();
        	
        	
        	Example example = new Example(CarScrapOrder.class);
        	Criteria criteria = example.createCriteria();
        	if(!user.getIsAllDataPermisssion()){
        		if(StringUtils.isNotBlank(user.getAreasids())){
        			criteria.andIn("orderAreasId", Arrays.asList(StringUtils.split(user.getAreasids(), ",")));
        		}
        		criteria.andEqualTo("agentUserid", user.getId());
        		
        		
        	}
        	
        	criteria.andEqualTo("isremove", false);
        	criteria.andEqualTo("orderStatus", CommonSystemParamter.ORDER_CREATE_STATUS);
        	//当前时间减去 超时时间设置
        	   //获取当前时间
        	   DateTime time = new DateTime();
        	   time = time.plusHours((int)-timeOutSetting);
        	criteria.andLessThanOrEqualTo("orderTime", time.toDate());
        	
            bo.setRemindNum(carScrapOrderService.selectCountByExample(example));
        	
        	data.add(bo);
        	
        	
        	
        	
        }
        if(subject.isPermitted("index:unreceive_overtimercar_remind")){
        	//是否超时未接收报废车辆
        	
        	RemindBO bo = new RemindBO();
        	bo.setCode(5);
        	
        	//1.查询超时未接单系统设置
        	OrderEarlyWarningSetting whereParam = new OrderEarlyWarningSetting();
        	whereParam.setEarlyWarningCode("unreceived_wholecartype_orders");
        	OrderEarlyWarningSetting earlyWarning = orderEarlyWarningSettingService.queryOne(whereParam);
        	//获取系统超时时间配置
        	Double timeOutSetting = earlyWarning.getEarlyWarningValue();
        	
        	
        	Example example = new Example(CarScrapOrder.class);
        	Criteria criteria = example.createCriteria();
        	if(!user.getIsAllDataPermisssion()){
        		if(StringUtils.isNotBlank(user.getAreasids())){
        			criteria.andIn("orderAreasId", Arrays.asList(StringUtils.split(user.getAreasids(), ",")));
        		}
        		criteria.andEqualTo("agentUserid", user.getId());
        		
        		
        	}
        	
        	criteria.andEqualTo("isremove", false);
        	criteria.andEqualTo("orderType", "1");
        	criteria.andEqualTo("orderStatus", CommonSystemParamter.ORDER_DISTRIBUTION_STATUS);
        	//当前时间减去 超时时间设置
        	   //获取当前时间
        	   DateTime time = new DateTime();
        	   time = time.plusHours((int)-timeOutSetting);
        	criteria.andLessThanOrEqualTo("operatortime", time.toDate());
        	
            bo.setRemindNum(carScrapOrderService.selectCountByExample(example));
        	
        	data.add(bo);
        	
        	
        	
        }
        if(subject.isPermitted("index:unreceive_overtimerparts_remind")){
        	//是否有超时未接收旧件权限
        	RemindBO bo = new RemindBO();
        	bo.setCode(6);
        	
        	//1.查询超时未接单系统设置
        	OrderEarlyWarningSetting whereParam = new OrderEarlyWarningSetting();
        	whereParam.setEarlyWarningCode("unreceived_carpartstype_orders");
        	OrderEarlyWarningSetting earlyWarning = orderEarlyWarningSettingService.queryOne(whereParam);
        	//获取系统超时时间配置
        	Double timeOutSetting = earlyWarning.getEarlyWarningValue();
        	//获取当前时间
     	   DateTime time = new DateTime();
     	   time = time.plusHours((int)-timeOutSetting);
     	   
     	  CarScrapOrderKeywordVO whereParam2 = new CarScrapOrderKeywordVO();
     	   //预警时间
     	  whereParam2.setEarlyWarningDate(time.toDate());
        	if(!user.getIsAllDataPermisssion()){
      		   if(StringUtils.isNotBlank(user.getAreasids())){
      			  whereParam2.setAraesidList(Arrays.asList(StringUtils.split(user.getAreasids(), ",")));
      		   }
      		  whereParam2.setUserid(user.getId());
      		
      		
      	   }
         	whereParam2.setOrderStatus(CommonSystemParamter.PARTS_RECEIPT_STATUS+"");
      
      	
      	  bo.setRemindNum(carScrapOrderAutopartsService.selectCount(whereParam2));
      	
          data.add(bo);
        	
        	
        	
        }
		
		return data;
		
	}
	
	

}
