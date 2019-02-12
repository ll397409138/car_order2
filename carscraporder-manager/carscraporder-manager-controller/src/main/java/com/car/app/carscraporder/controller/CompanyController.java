package com.car.app.carscraporder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;






import com.car.app.carscraporder.bo.CompanyBO;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.Company;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.CompanyService;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CompanyVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.spring.exetend.converter.CallbackMappingJackson2HttpMessageConverter;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/company")
@Api(value = "Company-API",tags={"大客户信息操作接口类"})
public class CompanyController {
	Logger logger = LoggerFactory.getLogger(CompanyController.class);

	
	
	@Autowired
	private CompanyService companyService;
	
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
			CompanyVO paramter, HttpServletRequest request) throws Exception{
		
		
			    PageResult pageResult  = new PageResult();
			    Company company = new Company();
			    BeanUtils.copyProperties(paramter, company);
			    PageInfo<CompanyBO> pageInfo =  companyService.queryBOPageListByWhere(page, rows, company);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	
	
	/**
	 * 验证账号是否重复
	 * @param account
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/valid",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "校验客户名称是否存在",notes = "校验客户名称是否存在")
	public ResultBean<Boolean> validaCustomerNameName(@RequestParam(value="customerName") String customerName) throws Exception{
		Company company = new Company();
		company.setCustomerName(customerName);
		List<Company> list = companyService.queryListByWhere(company);
		if(list.size()>0){
			return new ResultBean<Boolean>(false);
		}else{
			return new ResultBean<Boolean>(true);	
		}
	}


	/**
	 * 新增客戶
	 * @param user 保存的user实体类
	 * @return
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增客户公司数据")
	public ResultBean<Boolean> addCompany(@Validated CompanyVO paramter,BindingResult bindingResult) throws Exception{
		
			User u = UserUtil.getUser();
			if(u==null){
				throw new UnloginException();
			}
		 Company company = new Company();
		 BeanUtils.copyProperties(paramter, company);
		 company.setIsvalid(true);
		 company.setCreater(u.getId());
		
		return new ResultBean<Boolean>(companyService.save(company)==1);
	}



	

	
	/**
	 * 根据id更新员工
	 * @param id
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改客户公司数据",notes = "根据id修改客户公司数据信息")
	public ResultBean<Boolean> updateCompany(@PathVariable("id")Integer id,@Validated CompanyVO paramter,BindingResult bindingResult) throws Exception{

		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		Company data = companyService.queryById(id);
		if(data==null){
			throw new DataException("修改客户不存在");
		}else{
			Company company = new Company();
			 BeanUtils.copyProperties(paramter, company);
			 company.setId(id);
			 company.setCreater(data.getCreater());
			 company.setCreatetime(data.getCreatetime());
			 company.setIsvalid(data.getIsvalid());
			 company.setOperator(u.getId());
		    return new ResultBean<Boolean>(companyService.update(company)==1);
		}
		
		
		
		
		
		
	}

	


	/**
	 * 根据主键删除员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除客户公司数据",notes = "根据id删除客户公司数据")
	public ResultBean<Boolean> deleteByIds(@PathVariable("id")Integer id,
			HttpServletRequest request) throws Exception{
		
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		Company company = companyService.queryById(id);
		if(company==null){
			throw new DataException("修改客户不存在");
		}else{
			company.setOperator(u.getId());
			return new ResultBean<Boolean>(companyService.deleteByIds(company)==1);
		}
		

		

	}

	
	
	/**
	 * 根据主键获取员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取客户公司详情",notes = "根据id获取客户公司详情")
	public ResultBean<Company> getCompanyById(@PathVariable("id")Integer id) throws Exception{
		return new ResultBean<>(companyService.queryById(id));

	}
	
	

}
