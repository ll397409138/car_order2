package com.car.app.carscraporder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.bo.CompanyBO;
import com.car.app.carscraporder.pojo.Company;
import com.github.abel533.mapper.Mapper;

public interface CompanyMapper extends Mapper<Company> {
	
	List<CompanyBO> queryBOPageListByWhere(@Param("paramter")Company param);

}
