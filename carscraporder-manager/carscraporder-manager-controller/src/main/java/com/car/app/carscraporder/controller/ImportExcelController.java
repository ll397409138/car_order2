package com.car.app.carscraporder.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.car.app.carscraporder.service.ImportService;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping("/excel")
@Api(value = "excel-API",tags={"Excel导入"} )
public class ImportExcelController {
	
	@Autowired
	private ImportService importService;
	
	@RequestMapping(value="importData",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "通过excel导入车辆估值数据",notes = "通过excel导入车辆估值数据")
	public ResultBean<Map<String, Object>> importData(@RequestParam(value="file",required = false) MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String, Object> map = new HashMap<String, Object> ();
		String message = importService.ImportDataByExcel(file);
		map.put("state", true);
		map.put("msg", message);
		return new ResultBean<Map<String, Object>>(map);
	}

}
