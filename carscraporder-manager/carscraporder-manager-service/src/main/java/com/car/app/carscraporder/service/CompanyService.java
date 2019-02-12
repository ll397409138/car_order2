package com.car.app.carscraporder.service;

import com.car.app.carscraporder.bo.CompanyBO;
import com.car.app.carscraporder.pojo.Company;
import com.github.pagehelper.PageInfo;

public interface CompanyService extends BaseService<Company> {
	
	
	public PageInfo<CompanyBO> queryBOPageListByWhere(Integer page, Integer rows, Company company)throws Exception;
	
	public Integer save(Company company)throws Exception;
	
	public Integer deleteByIds(Company company) throws Exception;

}
