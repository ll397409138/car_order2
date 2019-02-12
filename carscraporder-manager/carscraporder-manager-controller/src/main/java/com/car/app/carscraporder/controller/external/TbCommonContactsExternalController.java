package com.car.app.carscraporder.controller.external;

import javax.servlet.http.HttpServletRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.car.app.carscraporder.pojo.TbCommonContacts;
import com.car.app.carscraporder.service.TbCommonContactsService;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/external/commonContacts")
@Api(value = "commonContacts-API",tags={"常用联系人"})
public class TbCommonContactsExternalController {
	
	
	@Autowired
	private TbCommonContactsService tbCommonContactsService;
	
	
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
	@ApiOperation(value = "获取大客户分页列表",notes = "获取用户分页列表")
	public ResultBean<PageResult> getCompanyList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			TbCommonContacts paramter, HttpServletRequest request) throws Exception{
		        PageResult pageResult  = new PageResult();
			    PageInfo<TbCommonContacts> pageInfo =  tbCommonContactsService.queryPageListByWhere(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}

}
