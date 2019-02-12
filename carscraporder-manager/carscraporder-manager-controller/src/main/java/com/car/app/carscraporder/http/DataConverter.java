package com.car.app.carscraporder.http;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.common.exception.DataException;


public class DataConverter {
	
	
	
	public static <T> void convert(T t, HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, DataException {
		
		 
		// 获取类对象
		Class<?> c = t.getClass();
		
		//获取请求参数map
		Map<String,String> paramMap = getParameterMap(request);
		for(Map.Entry<String, String> entry :paramMap.entrySet()){
			Field[] fs = c.getDeclaredFields();
			for (Field f : fs) {
				// 获得属性名
				String name = f.getName();
				
				if(StringUtils.equals(entry.getKey(), name)){
					// 设置为可访问
					f.setAccessible(true);
					// 获得属性的类型名
					Class<?> type = f.getType();
					
					fillValue(type,f,t,entry.getValue());
					break;
					
				}
				
			}
			
			
		}
		
		
			
	}
	
	public static Map getParameterMap(HttpServletRequest request) {
	    // 参数Map
	    Map properties = request.getParameterMap();
	    // 返回值Map
	    Map returnMap = new HashMap();
	    Iterator entries = properties.entrySet().iterator();
	    Map.Entry entry;
	    String name = "";
	    String value = "";
	    while (entries.hasNext()) {
	        entry = (Map.Entry) entries.next();
	        name = (String) entry.getKey();
	        Object valueObj = entry.getValue();
	        if(null == valueObj){
	            value = "";
	        }else if(valueObj instanceof String[]){
	            String[] values = (String[])valueObj;
	            for(int i=0;i<values.length;i++){
	                value = values[i] + ",";
	            }
	            value = value.substring(0, value.length()-1);
	        }else{
	            value = valueObj.toString();
	        }
	        returnMap.put(name, value);
	    }
	    return returnMap;
	}
	
	
	
 
	
	
	
	public static <T> void fillValue(Class type,Field f,T t,String str) throws IllegalArgumentException, IllegalAccessException, DataException{
		if(StringUtils.isBlank(str)){
			str = null;
		}
		// String类型
		if (type == String.class) {
			f.set(t, str);
		} else if (type == int.class || type == Integer.class) {// 整型
			if(StringUtils.isNotBlank(str)){
				f.set(t, Integer.valueOf(str));
			}else{
				f.set(t, null);
			}
			
		} else if (type == Float.class || type == float.class) {// float类型
			if(StringUtils.isNotBlank(str)){
				f.setFloat(t, Float.valueOf(str));
			}else{
				f.setFloat(t, (Float) null);
			}
			
		} else if (type == Double.class || type == double.class) {// double类型
			if(StringUtils.isNotBlank(str)){
				f.setDouble(t, Double.valueOf(str));
			}else{
				f.setDouble(t, (Double) null);
			}
			
		} else if (type == java.math.BigDecimal.class) {// BigDecimal类型
			if(StringUtils.isNotBlank(str)){
				java.math.BigDecimal value = new java.math.BigDecimal(str);
				f.set(t, value);
			}else{
				f.set(t, null);
			}
		}else if(type==java.util.Date.class){//java.util.Date类型转换
			java.util.Date date;
			try {
				if(StringUtils.isNotBlank(str)){
					if(str.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){ 
						  date= new SimpleDateFormat("yyyy-MM-dd").parse(str);
						  f.set(t, date);
					  }else if(str.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
						  date= new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(str);
						  f.set(t, date);
					  }else if(str.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
						  date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
						  f.set(t, date);
					  }else{
						  throw new DataException("请求时间格式错误");
					  }
				}else{
					f.set(t, null);
				}
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	
    
	
	
	public static CarScrapOrder copyRequestParamToOrdermedel(CarScrapOrder carScrapOrder,HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, DataException{
		CarScrapOrder copyCarScrapOrder = new CarScrapOrder();
		
		BeanUtils.copyProperties(carScrapOrder, copyCarScrapOrder);
		
		convert(copyCarScrapOrder,request);
		
		copyCarScrapOrder.setId(carScrapOrder.getId());
		copyCarScrapOrder.setOrderNo(carScrapOrder.getOrderNo());
		copyCarScrapOrder.setOrderTime(carScrapOrder.getOrderTime());
		copyCarScrapOrder.setOrderAreasId(carScrapOrder.getOrderAreasId());
		copyCarScrapOrder.setOrderStatus(carScrapOrder.getOrderStatus());
		copyCarScrapOrder.setOrderType(carScrapOrder.getOrderType());
		copyCarScrapOrder.setClientId(carScrapOrder.getClientId());
		copyCarScrapOrder.setClientType(carScrapOrder.getClientType());
		copyCarScrapOrder.setIsremove(carScrapOrder.getIsremove());
		copyCarScrapOrder.setSourceType(carScrapOrder.getSourceType());
		copyCarScrapOrder.setCreater(carScrapOrder.getCreater());
		copyCarScrapOrder.setCreatetime(carScrapOrder.getCreatetime());
		
		
		return copyCarScrapOrder;
		
	}
	
	public static CarScrapOrderAutoparts copyRequestParamToCarScrapOrderAutopartsdel(CarScrapOrderAutoparts parts,HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException, DataException{
		CarScrapOrderAutoparts copyParts = new CarScrapOrderAutoparts();
		
		BeanUtils.copyProperties(parts, copyParts);
		
		convert(copyParts,request);
		
		copyParts.setId(parts.getId());
		copyParts.setOrderId(parts.getOrderId());
		copyParts.setOrderAutopartsStatus(parts.getOrderAutopartsStatus());
		copyParts.setQrPic(parts.getQrPic());
		copyParts.setCreater(parts.getCreater());
		copyParts.setCreatetime(parts.getCreatetime());
		
		
		return copyParts;
		
	}

}
