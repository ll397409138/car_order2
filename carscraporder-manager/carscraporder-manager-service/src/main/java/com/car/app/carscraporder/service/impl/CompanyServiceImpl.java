package com.car.app.carscraporder.service.impl;



import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.CompanyBO;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.mapper.CompanyMapper;
import com.car.app.carscraporder.pojo.Client;
import com.car.app.carscraporder.pojo.Company;
import com.car.app.carscraporder.service.ClientService;
import com.car.app.carscraporder.service.CompanyService;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.common.bean.ResultBean;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements
		CompanyService {
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private ClientService clientService;
	
	public PageInfo<CompanyBO> queryBOPageListByWhere(Integer page, Integer rows, Company company)throws Exception{
		PageHelper.startPage(page, rows);
		List<CompanyBO> CompanyBOs = companyMapper.queryBOPageListByWhere(company);
		return new PageInfo<CompanyBO>(CompanyBOs);
		
	}
	
	public Integer save(Company company)throws Exception{
		CheckUtil.notNull(company, "param.is.null");
		
		//校验客户名称是否重复
		Company companyparam = new Company();
		companyparam.setCustomerName(company.getCustomerName());
		List<Company> list = this.queryListByWhere(companyparam);
		if(list.size()>0){
			throw new DataException("客户名称重复");
		}else{
		
			return super.save(company);
		}
		
		
		
	}
	
	
	
	@Override
	public Integer update(Company company) throws Exception{
		//判断company是否为空
		CheckUtil.notNull(company, "param.is.null");
		CheckUtil.notEmpty(company.getCustomerName(), "param.is.null","客户名称");
		//校验客户名是否存在
		Example example = new Example(Company.class);
		example.createCriteria().andEqualTo("customerName", company.getCustomerName()).andNotEqualTo("id", company.getId());
		
		List<Company> list =this.queryListByExample(example);
		if(list.size()>0){
			throw new DataException("客户名称重复");
		}else{
			Company data = companyMapper.selectByPrimaryKey(company.getId());
			
			if(data==null){
				throw new DataException("修改客户不存在");
			}else{
				return super.update(company);
				
			}
			
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	@Override
	public Integer deleteByIds(Company company) throws Exception{
		
		//校验公司下是否还有有效的用户存在
		Client param = new Client();
		param.setCompanyid(company.getId());
		param.setStatus("1");
		int count = clientService.selectCount(param);
		if(count>0){
			throw new DataException("删除客户公司,先删除客户管理人员");
		}
		company.setIsvalid(false);
		
		return super.update(company);
		
	}

	
	
	

	

}
