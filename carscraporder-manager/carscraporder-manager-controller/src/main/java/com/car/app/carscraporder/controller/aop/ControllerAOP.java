package com.car.app.carscraporder.controller.aop;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;









import com.car.app.carscraporder.exception.AccountException;
import com.car.app.carscraporder.exception.CheckException;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.exception.UserNamePasswordException;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.ExcelException;
import com.car.app.common.exception.FileTooLargeException;

/**
 * AOP配置切面后拦截所有controller请求,规范Controller返回数据格式,和异常处理机制
 * 类名称：ControllerAOP   
 * 类描述：   
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:14:56      
 * @version  V1.0
 *
 */
public class ControllerAOP {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);
	
	/**
	 * 对  com.jbr365.app.controller下所用的类的所有public方法都做拦截 
	 * @param point
	 * @return
	 */
	public Object handlerControllerMethod(ProceedingJoinPoint point){
		long startTime = System.currentTimeMillis();
		 ResultBean<?>  result = null;
		 
		 try{
			 result = (ResultBean<?>)point.proceed();
			 logger.debug(point.getSignature()+"use time"+(System.currentTimeMillis()-startTime));
			 
		 }catch(Throwable e){
			 e.printStackTrace();
			 result =handlerException(point,e);
		 }
		
		
		return result;
		
	}
	/**
	 * 拦截 目标抛出异常统一处理
	 * @param point
	 * @param e
	 * @return
	 */
	public ResultBean<?> handlerException(ProceedingJoinPoint point,Throwable e){
		logger.error(e.getMessage());
		ResultBean<?>  result = new ResultBean(e);
		
		   //密码错误
		  if (e instanceof UnloginException) {
			  result.setCode(201);
			  result.setMsg("未登录系统");
            //账号不存在
           }
		  else if(e instanceof CheckException) {
			  result.setCode(202);
			  result.setMsg("请求参数错误");
            //账号不存在
           } else if(e instanceof AccountException) {
 			  result.setCode(203);
 			  result.setMsg("账号错误");
             //账号不存在
            } else if(e instanceof DataException) {
  			  result.setCode(204);
  			  result.setMsg("数据错误");
              //账号不存在
            }else if(e instanceof UserNamePasswordException) {
     			  result.setCode(205);
      			  result.setMsg("用户名密码错误");
                  //账号不存在
             }else if(e instanceof FileTooLargeException) {
     			  result.setCode(206);
      			  result.setMsg("上传附件过大");
                  //账号不存在
             }else if(e instanceof ExcelException) {
     			  result.setCode(208);
      			  result.setMsg("Excel 导入失败");
                  //账号不存在
             }else {
        	  result.setCode(500);
        	  result.setMsg("未知异常");
          }
		
		return result;
		
	}
	
	

}
