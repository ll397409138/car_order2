package com.car.app.carscraporder.util;




import java.util.UUID;

public class UUIDUtil {

	/***
	 * 获得随机数字UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	

}
