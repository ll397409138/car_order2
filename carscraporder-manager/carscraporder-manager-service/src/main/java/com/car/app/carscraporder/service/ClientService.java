package com.car.app.carscraporder.service;

import com.car.app.carscraporder.bo.ClientBO;
import com.car.app.carscraporder.pojo.Client;

/**
 * 
 * 类名称：ClientService   
 * 类描述：   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 下午4:23:31      
 * @version  V1.0
 *
 */
public interface ClientService extends BaseService<Client>{
	
	public ClientBO queryClientBOByName(String loginname)throws Exception;
	
	public Boolean resetPassword(String id,String oldpassword,String newpassword,String operator)throws Exception;

}
