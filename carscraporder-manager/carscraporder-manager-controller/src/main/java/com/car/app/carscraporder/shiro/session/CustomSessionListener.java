package com.car.app.carscraporder.shiro.session;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.subject.Subject;
import org.crazycake.shiro.RedisManager;

import com.car.app.carscraporder.shiro.cache.ShiroRedisClient;
import com.car.app.carscraporder.util.LoggerUtils;


/**
 * 
 * 类名称：CustomSessionListener   
 * 类描述：shiro的session的监听器，按配置的时间监听过期session   
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:06:08      
 * @version  V1.0
 *
 */
public class CustomSessionListener implements SessionListener{
	
	private  RedisManager redisManager;
	
	/**
	 * The Redis key prefix for the sessions 
	 */
	private String keyPrefix = "shiro_redis_session:";
	
	
	
	public RedisManager getRedisManager() {
		return redisManager;
	}

	public void setRedisManager(RedisManager redisManager) {
		this.redisManager = redisManager;
	}

	@Override
	public void onStart(Session session) {
		 //TODO
        System.out.println("on start");
		
	}

	@Override
	public void onStop(Session session) {
		  //TODO
        System.out.println("on stop");
		
	}

	/**
	 * 重写父类onExpiration，过期的session做redis上次
	 */
	@Override
	public void onExpiration(Session session) {
		if(session == null || session.getId() == null){
			LoggerUtils.error(CustomSessionListener.class,"session or session id is null");
			return;
		}
		
		redisManager.del(this.getByteKey(session.getId()));
		
	}
	
	/**
	 * 获得byte[]型的key
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(Serializable sessionId){
		String preKey = this.keyPrefix + sessionId;
		return preKey.getBytes();
	}

}
