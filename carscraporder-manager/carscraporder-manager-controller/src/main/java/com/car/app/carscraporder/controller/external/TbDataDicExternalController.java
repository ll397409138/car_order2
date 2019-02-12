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
import com.car.app.carscraporder.pojo.TbDataDic;
import com.car.app.carscraporder.service.TbDataDicService;
import com.car.app.common.bean.ResultBean;
import com.github.abel533.entity.Example;


@Controller
@RequestMapping(value="/external/dic")
@Api(value = "dic",tags={"字典"})
public class TbDataDicExternalController {
	
	@Autowired
	private TbDataDicService  tbDataDicService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据类型获取字典列表",notes = "根据类型获取字典列表")
	public ResultBean<List<TbDataDic>> getCompanyList(
			@RequestParam(value="dataType",required = true)String dataType) throws Exception{
		
		
		Example example = new Example(TbDataDic.class);
		example.setOrderByClause("orderNum");
		example.createCriteria().andEqualTo("datatype", dataType).andEqualTo("status", true);
		
		List<TbDataDic> data = tbDataDicService.queryListByExample(example);
		        
     return new ResultBean(data);
		
		
	}

	
	

}
