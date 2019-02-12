package com.car.app.carscraporder.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.mapper.OrderEarlyWarningSettingMapper;
import com.car.app.carscraporder.pojo.OrderEarlyWarningSetting;
import com.car.app.carscraporder.service.OrderEarlyWarningSettingService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.common.bean.ResultBean;
import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;


@Controller
@RequestMapping(value="/earlyWarningSetting")
@Api(value = "earlyWarning-API",tags={"预警设置相关"} )
public class OrderEarlyWarningSettingController {
	
	@Autowired
	private OrderEarlyWarningSettingService  orderEarlyWarningSettingService;
	
	@Autowired
	private OrderEarlyWarningSettingMapper  orderEarlyWarningSettingMapper;
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询所有预警数据",notes = "查询所有预警数据")
	public ResultBean<List<OrderEarlyWarningSetting>> getAll() throws Exception{
		
		
		
		return new  ResultBean<List<OrderEarlyWarningSetting>>(orderEarlyWarningSettingService.queryAll()) ;
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "更新预警页面数据",notes = "更新预警页面数据")
	public ResultBean<Boolean> update(@RequestBody List<OrderEarlyWarningSetting> datas) throws Exception{
		
		
		UserBO user = UserUtil.getUser();
	      if(user==null){
             throw new UnloginException();
          }  
		
		if(datas!=null&&datas.size()>0){
			
			for(OrderEarlyWarningSetting orderEarlyWarningSetting:datas){
				orderEarlyWarningSetting.setOperator(user.getId());
				if(StringUtils.equals(orderEarlyWarningSetting.getEarlyWarningCode(), "unprocessed_orders")){
					
					Example example = new Example(OrderEarlyWarningSetting.class);
					Criteria criteria = example.createCriteria();
					criteria.andEqualTo("earlyWarningCode", orderEarlyWarningSetting.getEarlyWarningCode());
					List<OrderEarlyWarningSetting> data = orderEarlyWarningSettingMapper.selectByExample(example);
					if(data!=null&& data.size()>0){
						
						orderEarlyWarningSetting.setId(data.get(0).getId());
						orderEarlyWarningSetting.setCreater(data.get(0).getCreater());
						orderEarlyWarningSetting.setCreatetime(data.get(0).getCreatetime());
						orderEarlyWarningSettingMapper.updateByExample(orderEarlyWarningSetting, example);
					}
					
					
					
				}else if(StringUtils.equals(orderEarlyWarningSetting.getEarlyWarningCode(), "unreceived_wholecartype_orders")){
					
					Example example = new Example(OrderEarlyWarningSetting.class);
					Criteria criteria = example.createCriteria();
					criteria.andEqualTo("earlyWarningCode", orderEarlyWarningSetting.getEarlyWarningCode());
					List<OrderEarlyWarningSetting> data = orderEarlyWarningSettingMapper.selectByExample(example);
                    if(data!=null&& data.size()>0){
						
						orderEarlyWarningSetting.setId(data.get(0).getId());
						orderEarlyWarningSetting.setCreater(data.get(0).getCreater());
						orderEarlyWarningSetting.setCreatetime(data.get(0).getCreatetime());
						orderEarlyWarningSettingMapper.updateByExample(orderEarlyWarningSetting, example);
					}
				
					
					
				}else if(StringUtils.equals(orderEarlyWarningSetting.getEarlyWarningCode(), "unreceived_carpartstype_orders")){
					
					Example example = new Example(OrderEarlyWarningSetting.class);
					Criteria criteria = example.createCriteria();
					criteria.andEqualTo("earlyWarningCode", orderEarlyWarningSetting.getEarlyWarningCode());
					List<OrderEarlyWarningSetting> data = orderEarlyWarningSettingMapper.selectByExample(example);
                    if(data!=null&& data.size()>0){
						
						orderEarlyWarningSetting.setId(data.get(0).getId());
						orderEarlyWarningSetting.setCreater(data.get(0).getCreater());
						orderEarlyWarningSetting.setCreatetime(data.get(0).getCreatetime());
						orderEarlyWarningSettingMapper.updateByExample(orderEarlyWarningSetting, example);
					}
				
					
				}
				
			}
			
		}
		
		
		return new  ResultBean<Boolean>(true) ;
		
	}
	

}
