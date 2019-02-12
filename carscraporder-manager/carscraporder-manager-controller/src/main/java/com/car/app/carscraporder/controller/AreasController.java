package com.car.app.carscraporder.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.CheckException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.Areas;
import com.car.app.carscraporder.pojo.Company;
import com.car.app.carscraporder.pojo.Role;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.AreasService;
import com.car.app.carscraporder.service.CompanyService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.DataException;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/userarea")
@Api(value = "Area-API",tags={"用户区域管理相关接口"})
public class AreasController {
	
	@Autowired
	private AreasService areasService;
	
	
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
	@ApiOperation(value = "获取用户管理区域分页列表",notes = "获取用户管理区域分页列表")
	public ResultBean getAreasList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			Areas paramter) throws Exception{
		    
		    PageResult<Areas> pageResult  = new PageResult<Areas>();
		    paramter.setStatus("1");
		    PageInfo<Areas> pageInfo = areasService.queryPageListByWhere(page, rows, paramter);
		    pageResult.setRows(pageInfo.getList());
		    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean<>(pageResult);
		
		
	}
	/**
	 * 
	 * @param areasName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/valid/{areasName}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "校验用户管理区域是否存在",notes = "校验用户管理区域是否存在")
	public ResultBean<Boolean> validaAreasName(@RequestParam(value="areasName",required=true) String areasName) throws Exception{
		Areas areas = new Areas();
		areas.setAreasName(areasName);
		List<Areas> list = areasService.queryListByWhere(areas);
		if(list.size()>0){
			return new ResultBean<Boolean>(false);
		}else{
			return new ResultBean<Boolean>(true);	
		}
	}
	
	
	@RequestMapping(value="getAll",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询所有区域数据")
	public ResultBean<List<Areas>> getAll(@RequestParam(value="sysuser",required=false) String sysuser) throws Exception{
		Example example = new Example(Areas.class);
		if(StringUtils.equals(sysuser, "1")){
			example.createCriteria().andEqualTo("status", "1");
		}else{
			example.createCriteria().andEqualTo("status", "1").andEqualTo("isVirtualField", false);
		}
		
		
		
		return new ResultBean<>(areasService.queryListByExample(example));
		
		
	}
	
	/**
	 * 
	 * @param areas
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增管理区域")
	public ResultBean<Boolean> addAreas(@Validated Areas areas,BindingResult bindingResult) throws Exception{
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		areas.setIsVirtualField(false);
		areas.setStatus("1");
		areas.setCreater(u.getId());
		
		return new ResultBean<>(areasService.save(areas)==1);
		
		
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改管理区域",notes = "修改管理区域")
	public ResultBean<Boolean> updateAreas(@PathVariable("id")Integer id,@Validated Areas areas,BindingResult bindingResult) throws Exception{
		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		Areas data = areasService.queryById(id);
		if(data==null){
			throw new DataException("数据不存在");
		}
		areas.setOperator(u.getId());
		areas.setCreater(data.getCreater());
		areas.setCreatetime(data.getCreatetime());
		areas.setStatus(data.getStatus());
		areas.setIsVirtualField(data.getIsVirtualField());
		return new ResultBean<>(areasService.update(areas)==1);
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "根据id删除区域",notes = "根据ids删除管理区域,删除之前校验是否该区域是否有用户")
	public ResultBean<Boolean> deleteByIds(@PathVariable("id")Integer id) throws Exception{

		User u = UserUtil.getUser();
		if(u==null){
			throw new UnloginException();
		}
		
		Areas data = areasService.queryById(id);
		if(data==null){
			throw new DataException("数据不存在");
		}
		
		
		Company record = new Company();
		record.setAreaid(id);
		record.setIsvalid(true);
		int count = companyService.selectCount(record);
		if(count>0){
			throw new CheckException("该区域下有客户数据无法删除该区域");
		}
		
		data.setStatus("2");
		data.setOperator(u.getId());
		
		return new ResultBean<>(areasService.update(data)==1);
   }
	
	
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取区域详情",notes = "根据id获取区域详情")
	public ResultBean<Areas> getAreasById(@PathVariable("id")Integer id) throws Exception{
		return new ResultBean<>(areasService.queryById(id));

	}

}
