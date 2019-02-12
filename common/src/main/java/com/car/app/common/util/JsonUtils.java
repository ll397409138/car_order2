package com.car.app.common.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
	
	public static String read(String data,String key){
		
		JSONObject json = JSONObject.parseObject(data);
		String value = (String) json.get(key);
		return value;
		
	}
	

}
