package com.car.app.carscraporder.controller;

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
import com.car.app.carscraporder.pojo.TbCommonMailinginfo;
import com.car.app.carscraporder.pojo.TbCommonPayeeaccount;
import com.car.app.carscraporder.service.TbCommonMailinginfoService;
import com.car.app.carscraporder.service.TbCommonPayeeaccountService;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping(value="/commonPayee")
@Api(value = "commonMailingin-API",tags={"收件人"})
public class TbCommonPayeeaccountController {

	
	@Autowired
	private TbCommonPayeeaccountService  tbCommonPayeeaccountService;
	
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
	@ApiOperation(value = "获取常用收件人列表",notes = "获取常用收件人列表")
	public ResultBean<TbCommonPayeeaccount> getTbCommonPayeeaccountList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			
			@ApiParam(name = "clientid", value = "下单客户id",required = true)
			@RequestParam(value="clientid",required = true)
			String clientid, HttpServletRequest request) throws Exception{
		        PageResult pageResult  = new PageResult();
		        TbCommonPayeeaccount paramter = new TbCommonPayeeaccount();
		        paramter.setClientid(clientid);
			    PageInfo<TbCommonPayeeaccount> pageInfo =  tbCommonPayeeaccountService.queryPageListByWhere(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
}
