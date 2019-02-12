package com.car.app.carscraporder.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.util.CookieUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 类名称：UserHandlerInterceptor   
 * 类描述：  登录后将用户信息放入 ThreadLocal和slf4j的变量MDC中，ThreadLocal为后续service方法记录操作人。MDC记录帮助日志记录现场操作人
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午9:59:23      
 * @version  V1.0
 *
 */
public class UserHandlerInterceptor  implements HandlerInterceptor{
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	Logger logger = LoggerFactory.getLogger(UserHandlerInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// 由于tomcat线程重用，记得清空	
		   clearAllUserInfo();
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		// 如何检查用户是否登录
        String ticket = CookieUtils.getCookieValue(request, "v_v-s-ticket");
//        if (StringUtils.isBlank(ticket)) {
//        	 ResultBean result = new ResultBean();
//        	 result.setCode(201);
//        	 result.setMsg("未登陆系统");
//        	 returnJson(response,result);
//        	 return false;
//        	
//        }
//        
//        Subject subject = SecurityUtils.getSubject();
//		UserBO user = (UserBO) subject.getPrincipal();
//        if (user == null) {
//            // 登录超时
//        	 ResultBean result = new ResultBean();
//        	 result.setCode(201);
//        	 result.setMsg("未登陆系统");
//        	 returnJson(response,result);
//        	 return  false;
//        }
		
		
		
		// 得到用户个人相关的信息（登陆的用户）
		fillUserInfo();
		
		// 语言信息
		String locale = getLocaleFromCookies(request);
		
		// 放入到threadlocal，同一个线程任何地方都可以拿出来
		if (locale != null) {
			 UserUtil.setLocale(locale);
				}
        return true;
	}
	
	
	private String getLocaleFromCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			return null;
		}

		for (int i = 0; i < cookies.length; i++) {
			if (UserUtil.KEY_LANG.equals(cookies[i].getName())) {
				return cookies[i].getValue();
			}
		}

		return null;
	}
	
	private void returnJson(HttpServletResponse response, ResultBean result) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
        	
        	
            writer = response.getWriter();
            writer.print(MAPPER.writeValueAsString(result));
 
        } catch (IOException e) {
            logger.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
	
	private void fillUserInfo() {
		// 用户信息
//		 Subject subject = SecurityUtils.getSubject();
//		 UserBO user = (UserBO) subject.getPrincipal();
		UserBO user  = new UserBO();
		user.setRoleName("超级管理员");
		user.setAreaName("总部");
		user.setRoleids("1,2,3,4");
		user.setAreasids("1,2,3");
		user.setIsAllDataPermisssion(true);
		user.setId("36249ab6b0f54b668567fbc2864790a6");
		user.setRealName("管理员");
		
		
		if (user != null) {
			UserUtil.setUser(user);
		}
	}

	private void clearAllUserInfo() {
		UserUtil.clearAllUserInfo();
	}

}
