package com.car.app.common.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * 
 * 类名称：RedisService   
 * 类描述：redis客户端服务接口   
 * 创建人：刘子亮
 * 创建时间：2018年4月3日 上午9:35:14      
 * @version  V1.0
 *
 */
@Service
public class RedisService {

	    @Autowired(required = false)
	    private JedisPool jedisPool;

	    private <T> T execute(Function<Jedis, T> fun) {
	        Jedis jedis = null;
	        try {
	            // 从连接池中获取到jedis分片对象
	            jedis = jedisPool.getResource();
	            return fun.callBack(jedis);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (null != jedis) {
	                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
	            	jedis.close();
	            }
	        }
	        return null;
	    }

	    /**
	     * 执行set方法
	     * 
	     * @param key
	     * @param value
	     * @return
	     */
	    public String set(final String key, final String value) {
	        return this.execute(new Function<Jedis, String>() {
	            @Override
	            public String callBack(Jedis Jedis) {
	                return Jedis.set(key, value);
	            }
	        });
	    }

	    /**
	     * 执行set方法,并且设置生存时间
	     * 
	     * @param key
	     * @param value
	     * @param seconds 时间，单位是：秒
	     * @return
	     */
	    public String set(final String key, final String value, final Integer seconds) {
	        return this.execute(new Function<Jedis, String>() {
	            @Override
	            public String callBack(Jedis Jedis) {
	                String str = Jedis.set(key, value);
	                Jedis.expire(key, seconds);
	                return str;
	            }
	        });
	    }

	    /**
	     * 执行get方法
	     * 
	     * @param key
	     * @return
	     */
	    public String get(final String key) {
	        return this.execute(new Function<Jedis, String>() {
	            @Override
	            public String callBack(Jedis e) {
	                return e.get(key);
	            }
	        });
	    }

	    /**
	     * 删除key
	     * 
	     * @param key
	     * @return
	     */
	    public Long del(final String key) {
	        return this.execute(new Function<Jedis, Long>() {
	            @Override
	            public Long callBack(Jedis e) {
	                return e.del(key);
	            }
	        });
	    }

	    /**
	     * 设置生存时间
	     * 
	     * @param key
	     * @return
	     */
	    public Long expire(final String key, final Integer seconds) {
	        return this.execute(new Function<Jedis, Long>() {
	            @Override
	            public Long callBack(Jedis e) {
	                return e.expire(key, seconds);
	            }
	        });
	    }
	    
	    public Long incr(String key) {
	    	return this.execute(new Function<Jedis, Long>() {
	    		
	    		
	            @Override
	            public Long callBack(Jedis e) {
	                return e.incr(key);
	            }
	        });
	    	
	    	
	       
	    }


	    /**
	     * Hash结构的获取值
	     * 
	     * @param key redis中的值的key
	     * @param field Hash结构中的字段
	     * @return
	     */
	    public String hget(final String key, final String field) {
	        return this.execute(new Function<Jedis, String>() {
	            @Override
	            public String callBack(Jedis e) {
	                return e.hget(key, field);
	            }
	        });
	    }

	    /**
	     * Hash结构的设置值
	     * 
	     * @param key
	     * @param field
	     * @param value
	     * @return
	     */
	    public Long hset(final String key, final String field, final String value) {
	        return this.execute(new Function<Jedis, Long>() {
	            @Override
	            public Long callBack(Jedis e) {
	                return e.hset(key, field, value);
	            }
	        });
	    }

	    /**
	     * Hash结构的设置值并且设置生存时间
	     * 
	     * @param key
	     * @param field
	     * @param value
	     * @param seconds
	     * @return
	     */
	    public Long hset(final String key, final String field, final String value, final Integer seconds) {
	        return this.execute(new Function<Jedis, Long>() {
	            @Override
	            public Long callBack(Jedis e) {
	                Long count = e.hset(key, field, value);
	                e.expire(key, seconds);
	                return count;
	            }
	        });
	    }

	    /**
	     * Hash结构的数据删除
	     * 
	     * @param key
	     * @param fields
	     * @return
	     */
	    public Long hdel(final String key, final String... fields) {
	        return this.execute(new Function<Jedis, Long>() {
	            @Override
	            public Long callBack(Jedis e) {
	                return e.hdel(key, fields);
	            }
	        });
	    }

	    /**
	     * Hash结构查询所有数据
	     * 
	     * @param key
	     * @return
	     */
	    public Map<String, String> hgetAll(final String key) {
	        return this.execute(new Function<Jedis, Map<String, String>>() {
	            @Override
	            public Map<String, String> callBack(Jedis e) {
	                return e.hgetAll(key);
	            }
	        });
	    }
	    
	    
	    
	    
	    public byte[] get(final byte[] key) {
	    	return this.execute(new Function<Jedis,byte[]>(){

				@Override
				public byte[] callBack(Jedis e) {
					return e.get(key);
				}
	    		
	    	});
	    	
	    }
	    
	    
	    public byte[] set(final byte[] key, final byte[] value){
	    	return this.execute(new Function<Jedis,byte[]>(){
				@Override
				public byte[] callBack(Jedis e) {
					 e.set(key, value);
                     return value; 
				}
	    		
	    	});
	    }
	    
	    
	    public Long expire(final byte[] key, final Integer seconds){
	    	return this.execute(new Function<Jedis,Long>(){
				@Override
				public Long callBack(Jedis e) {
					return e.expire(key, seconds);
				}
	    		
	    	});
	    }
	    
	    public byte[] set(final byte[] key, final byte[] value, final int expire){
	    	return this.execute(new Function<Jedis,byte[]>(){
				@Override
				public byte[] callBack(Jedis e) {
					 e.set(key, value);
					 e.expire(key, expire);
					return value;
				}
	    		
	    	});
	    }
	    
	    public Long del(final byte[] key){
	    	return this.execute(new Function<Jedis,Long>(){
				@Override
				public Long callBack(Jedis e) {
					return e.del(key);
					
				}
	    		
	    	});
	    }
	    
	    
	  
}
