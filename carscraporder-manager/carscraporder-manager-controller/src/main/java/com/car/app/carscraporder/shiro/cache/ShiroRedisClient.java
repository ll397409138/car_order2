package com.car.app.carscraporder.shiro.cache;

import java.util.Set;
import org.crazycake.shiro.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * 
 * 类名称：ShiroRedisClient   
 * 类描述： 重写org.crazycake.shiro.RedisManager的所用操作redis的方法，父类方法在redis释放有问题
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:02:36      
 * @version  V1.0
 *
 */
public class ShiroRedisClient extends RedisManager{

	 private static final Logger LOGGER = LoggerFactory.getLogger(ShiroRedisClient.class);

	    private static JedisPool jedisPool = null;

	    public ShiroRedisClient(JedisPool jedisPool) {
	        this.jedisPool = jedisPool;
	    }

	    public void init() {
	        super.init();
	    }

	    @Override
	    public byte[] get(byte[] key) {
	        Jedis jedis = jedisPool.getResource();
	        byte[] value;

	        try {
	            value = jedis.get(key);
	        } catch (Exception e) {
	            LOGGER.error("redis key:{} get value occur exception", new String(key));
	            throw new RuntimeException("redis operation error:", e);
	        } finally {
	            jedis.close();
	        }

	        return value;
	    }

	    @Override
	    public byte[] set(byte[] key, byte[] value) {
	        Jedis jedis = jedisPool.getResource();

	        try {
	            jedis.set(key, value);
	            Integer expire = getExpire();
	            if(expire != 0) {
	                jedis.expire(key, expire);
	            }
	        } catch (Exception e) {
	            LOGGER.error("redis key:{} set value:{} occur exception", new String(key), new String(value));
	            throw new RuntimeException("redis operation error:", e);
	        } finally {
	            jedis.close();
	        }

	        return value;
	    }

	    @Override
	    public byte[] set(byte[] key, byte[] value, int expire) {
	    	LOGGER.debug("根据 key [" + key.toString() + "],存储value[" + value.toString() + "]");
	    	
	        Jedis jedis = jedisPool.getResource();

	        try {
	            jedis.set(key, value);
	            if(expire != 0) {
	                jedis.expire(key, expire);
	            }
	        } catch (Exception e) {
	            LOGGER.error("redis key:{} set value:{} in expire:{} occur exception", new String(key), new String(value), expire);
	            throw new RuntimeException("redis operation error:", e);
	        } finally {
	            jedis.close();
	        }

	        return value;
	    }

	    @Override
	    public void del(byte[] key) {
	        Jedis jedis = jedisPool.getResource();

	        try {
	            jedis.del(key);
	        } catch (Exception e) {
	            LOGGER.error("redis key:{} del value occur exception", new String(key));
	            throw new RuntimeException("redis operation error:", e);
	        } finally {
	            jedis.close();
	        }
	    }

	    @Override
	    public void flushDB() {
	        Jedis jedis = jedisPool.getResource();

	        try {
	            jedis.flushDB();
	        } catch (Exception e) {
	            LOGGER.error("redis flushDB occur exception");
	            throw new RuntimeException("redis operation error:", e);
	        } finally {
	            jedis.close();
	        }

	    }

	    @Override
	    public Long dbSize() {
	        Long dbSize = Long.valueOf(0L);
	        Jedis jedis = jedisPool.getResource();

	        try {
	            dbSize = jedis.dbSize();
	        } catch (Exception e) {
	            LOGGER.error("redis get dbSize occur exception");
	            throw new RuntimeException("redis operation error:", e);
	        } finally {
	            jedis.close();
	        }

	        return dbSize;
	    }

	    @Override
	    public Set<byte[]> keys(String pattern) {
	        Set keys = null;
	        Jedis jedis = jedisPool.getResource();

	        try {
	            keys = jedis.keys(pattern.getBytes());
	        } catch (Exception e) {
	            LOGGER.error("redis get keys in pattern:{} occur exception", pattern);
	            throw new RuntimeException("redis operation error:", e);
	        } finally {
	            jedis.close();
	        }

	        return keys;
	    }
	    
	    
	   
	    
	    
	    
}
