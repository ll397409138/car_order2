package com.car.app.common.service;


/**
 * 
 * 类名称：Function   
 * 类描述：redisService调用回调接口函数    
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午9:46:51      
 * @version  V1.0
 *
 */
public interface Function<E, T> {

    public T callBack(E e);

}
