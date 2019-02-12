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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.car.app.carscraporder.mapper.TbCarInformationStoreMapper;
import com.car.app.carscraporder.pojo.CarAssessment;
import com.car.app.carscraporder.pojo.TbCarInformationStore;
import com.car.app.carscraporder.service.CarAssessmentService;
import com.car.app.carscraporder.service.CarModelQueryService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.vo.CarAssessmentVO;
import com.car.app.common.bean.ResultBean;


@Controller
@RequestMapping(value="/external/carAssessment")
@Api(value = "externalCarAssessment-API",tags={"车辆估值相关"})
public class CarAssessmentExternalController {
	
	
	@Autowired
	private CarModelQueryService carModelQueryService;
	
	@Autowired
	private TbCarInformationStoreMapper  tbCarInformationStoreMapper;
	
	@Autowired
	private  CarAssessmentService carAssessmentService;
	
	

    @RequestMapping(value="getCarPrice",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据车架后查询车辆信息",notes = "根据车架后查询车辆信息")
	public ResultBean<String> getCarPrice(@RequestParam(name="vin",required=true)String vin,@RequestParam(name="areaName",required=false)String areaName) throws Exception{
    	
    	String result = carModelQueryService.queryCarModelData(vin);
    	
    	if(StringUtils.isNotBlank(result)){
    		
    		result = result.replace( "&lt;","<");
    		result = result.replace("&gt;", ">");
    		
    	}
		
    	int start = StringUtils.indexOf(result, "{");
    	int end = StringUtils.lastIndexOf(result, "}");
    
    	
    	String jsonstr = StringUtils.substring(result, start, end+1);
    	JSONObject  json = JSON.parseObject(jsonstr);
    	JSONArray array = json.getJSONArray("Result");
    	
    	if(array!=null&& array.size()>0){
    		String key =(String) array.get(0);
    		//
    		TbCarInformationStore carInfo = tbCarInformationStoreMapper.selectByPrimaryKey(key);
    		if(carInfo!=null){
    			CarAssessmentVO whereParam = new CarAssessmentVO();
    			//车型拼接规则 名牌+空格+车型+空格+年款+“款”
    			StringBuffer sb = new StringBuffer();
    			if(StringUtils.isNotBlank(carInfo.getCarBrand())){
    				sb.append(carInfo.getCarBrand()).append(" ");
    			}
    			
    			if(StringUtils.isNotBlank(carInfo.getCarModel())){
    				sb.append(carInfo.getCarModel()).append(" ");
    			}
    			

    			if(StringUtils.isNotBlank(carInfo.getYear())){
    				sb.append(carInfo.getYear()).append("款");
    			}
    			
    			//车型
    			if(sb.length()>0){
    				whereParam.setKeyword(sb.toString());
    			}
    			 
                  //年份
                   if(StringUtils.isNotBlank(carInfo.getYear())){
                	   whereParam.setDatesofproduction(carInfo.getYear());
                 }
                   
                  //变速箱 
                   if(StringUtils.isNotBlank(carInfo.getTransmissionDescription())){
                	   if(StringUtils.indexOf(carInfo.getTransmissionDescription(), "手动")>0){
                		   whereParam.setGearbox("手动");
                	   }else{
                		   whereParam.setGearbox("自动");
                	   }
                	   
                 }
                   //排量
                   if(StringUtils.isNotBlank(carInfo.getDisplacement())){
                	   whereParam.setDisplacement(carInfo.getDisplacement());
                 }
                   //燃油
                   if(StringUtils.isNotBlank(carInfo.getFuelType())){
                	   whereParam.setFueltype(carInfo.getFuelType());
                 }
                   //区域
                   if(StringUtils.isNotBlank(areaName)){
                	   whereParam.setRegion(areaName);
                 }
              
                List<CarAssessment> carAssessments = carAssessmentService.getCarAssessmentsByParam(whereParam);
                
                if(carAssessments!=null&&carAssessments.size()>0){
                	
                	return new ResultBean<String>(carAssessments.get(0).getPrice());
                }
    			
    		}
    		
    		
    		
    		
    	}
    	
    	
    	return new ResultBean("");
    	
    	
    	
		
    	
    	
    }

}
