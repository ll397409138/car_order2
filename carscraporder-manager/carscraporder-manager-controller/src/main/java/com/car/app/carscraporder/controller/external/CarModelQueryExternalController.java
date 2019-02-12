package com.car.app.carscraporder.controller.external;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.car.app.carscraporder.mapper.TbCarInformationStoreMapper;
import com.car.app.carscraporder.pojo.TbCarInformationStore;
import com.car.app.carscraporder.service.CarModelQueryService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.common.bean.ResultBean;



@Controller
@RequestMapping(value="/external/carModel")
@Api(value = "CARMODEL-API",tags={"力洋接口API"})
public class CarModelQueryExternalController {
	
	@Autowired
	private CarModelQueryService carModelQueryService;
	
	@Autowired
	private TbCarInformationStoreMapper  tbCarInformationStoreMapper;
	

	
    @RequestMapping(value="{vin}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据车架后查询车辆信息",notes = "根据车架后查询车辆信息")
	public ResultBean<String> queryCarModelData(@PathVariable("vin")String vin) throws Exception{
    	
    	StringBuffer sbpp = new StringBuffer();
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
    			
    			  if(StringUtils.isNotBlank(carInfo.getCarBrand())){
                	  sbpp.append(carInfo.getCarBrand()+" ");
        			}
                  if(StringUtils.isNotBlank(carInfo.getCarModel())){
                	  sbpp.append(carInfo.getCarModel()+" ");
        			}
                  
                  if(StringUtils.isNotBlank(carInfo.getSalesName())){
                	  sbpp.append(carInfo.getSalesName()+" ");
                  }
                  

                  if(StringUtils.isNotBlank(carInfo.getYear())){
               	   sbpp.append(carInfo.getYear()+"款");
                 }
                  
    			
    		}
    		
    		
    	}
    	
    	
    	return new ResultBean(sbpp.toString());
		
	}

}
