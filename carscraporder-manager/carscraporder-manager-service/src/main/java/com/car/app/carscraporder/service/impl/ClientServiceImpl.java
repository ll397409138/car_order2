package com.car.app.carscraporder.service.impl;



import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.ClientBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.AccountException;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.exception.UserNamePasswordException;
import com.car.app.carscraporder.mapper.ClientMapper;
import com.car.app.carscraporder.pojo.Client;
import com.car.app.carscraporder.service.ClientService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.StringUtils;


@Service
public class ClientServiceImpl extends BaseServiceImpl<Client> implements
		ClientService {
	@Autowired
	private ClientMapper clientMapper;
	
	public ClientBO queryClientBOByName(String loginname)throws Exception{
		
		List<ClientBO> client = clientMapper.queryClientBOByName(loginname);
		
		if(client==null){
			//用戶名密码错误
			throw new UserNamePasswordException("用户名密码错误");
		}else if(client.size()==0){
			//用戶名密码错误
			throw new UserNamePasswordException("用户名密码错误");
		}else if (client.size()>1){
			//账号异常
			throw new AccountException("账号异常");
		}else{
			return client.get(0);
		}
		
	
		
	}
	
	
	public Boolean resetPassword(String id,String oldpassword,String newpassword,String operator)throws Exception{
		
		Client client = clientMapper.selectByPrimaryKey(id);
		
		if(client==null){
			throw new DataException("数据不存在");
		}
		
		
		String hashpass = StringUtils.createPassword(oldpassword,client.getPasswordSalt(),CommonSystemParamter.HASHITERATIONS);
		if(StringUtils.equals(hashpass, client.getPassword())){
			String salt = UUID.randomUUID().toString().replaceAll("-", "");
			client.setPasswordSalt(salt);
			client.setPassword(StringUtils.createPassword(newpassword, salt, 2));
			client.setOperator(operator);
			
			return true;
		}else{
			throw new UserNamePasswordException("密码输入错误");
		}
		
		
		
	}
	
	
	
	
	
	

	

}
