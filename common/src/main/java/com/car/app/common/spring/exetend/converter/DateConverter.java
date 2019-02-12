package com.car.app.common.spring.exetend.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * 
 * 类名称：DateConverter   
 * 类描述：时间转换器，为后台响应时间格式的数据提供转换   
 * 创建人：刘子亮
 * 创建时间：2018年4月3日 上午9:38:08      
 * @version  V1.0
 *
 */
public class DateConverter implements Converter<String, Date>{
	
	private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);
	
	
	 private static final List<String> formarts = new ArrayList<String>(4);
     static{
         formarts.add("yyyy-MM");
         formarts.add("yyyy-MM-dd");
         formarts.add("yyyy-MM-dd HH:mm");
         formarts.add("yyyy-MM-dd HH:mm:ss");
     }


	@Override
	public Date convert(String source) {
		 
	        String value = source.trim();
            if ("".equals(value)) {
                return null;
            }
            if(source.matches("^\\d{4}-\\d{1,2}$")){ 
                return parseDate(source, formarts.get(0));
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
                return parseDate(source, formarts.get(1));
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(2));
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(3));
            }else {
            	try{
            		//其他按时间戳处理
                	Long timeStamp = Long.parseLong(source);
                    return new Date(timeStamp);
            	}catch (Exception e) {
            		 throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
            	}
            	 
            }

	}
	
	 public  Date parseDate(String source, String format) {
         Date date=null;
         try {
             DateFormat dateFormat = new SimpleDateFormat(format);
             date = (Date) dateFormat.parse(source);
         } catch (Exception e) {
        	 logger.error("时间转换错误：{},错误原因：{}",source,e.toString());
         }
         return date;
     }
	 
	
	
	
	

}
