package com.car.app.carscraporder.util;






import java.util.Locale;

import org.slf4j.MDC;

import com.car.app.carscraporder.bo.ClientBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.pojo.User;



/**
 * 
 * 类名称：UserUtil   
 * 类描述：用户相关的工具类 , 将登录的信息放入 ThreadLocal和MDC
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:09:28      
 * @version  V1.0
 *
 */
public class UserUtil {

	private final static ThreadLocal<UserBO> tlUser = new ThreadLocal<UserBO>();
	
	private final static ThreadLocal<Locale> tlLocale = new ThreadLocal<Locale>() {
		protected Locale initialValue() {
			// 语言的默认值
			return Locale.CHINESE;
		};
	};
	



	public static final String KEY_USER = "user";
	public static final String KEY_LANG = "lang";

	public static void setUser(UserBO user) {
		tlUser.set(user);
		// 把用户信息放到log4j
		MDC.put(KEY_USER, user.getId());
	}



	/**
	 * 如果没有登录会抛出异常
	 * 
	 * @return
	 */
	public static UserBO getUser() {
		UserBO user = tlUser.get();

		if (user == null) {
			throw new UnloginException();
		}

		return user;
	}
	
	
	
	public static void setLocale(String locale) {
		setLocale(new Locale(locale));
	}

	public static void setLocale(Locale locale) {
		tlLocale.set(locale);
	}

	public static Locale getLocale() {
		return tlLocale.get();
	}



	public static void clearAllUserInfo() {
		tlUser.remove();
	

		MDC.remove(KEY_USER);
	}
}
