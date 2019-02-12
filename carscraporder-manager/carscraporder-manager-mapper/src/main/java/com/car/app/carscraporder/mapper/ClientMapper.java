package com.car.app.carscraporder.mapper;

import java.util.List;

import com.car.app.carscraporder.bo.ClientBO;
import com.car.app.carscraporder.pojo.Client;
import com.github.abel533.mapper.Mapper;

public interface ClientMapper extends Mapper<Client>{
	
	public List<ClientBO> queryClientBOByName(String loginname);

}
