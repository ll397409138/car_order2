package com.car.app.carscraporder.service;
import java.util.List;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 类名称：BaseService   
 * 类描述：通用数据库 crud的接口定义
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:19:29      
 * @version  V1.0
 *
 */
public interface  BaseService< T> {

  

/**
     * 根据id查询数据
     * 
     * @param id
     * @return
     */
public T queryById(Integer id)throws Exception;

/**
     * 查询所有数据
     * 
     * @return
     */
public List<T> queryAll()throws Exception;

/**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     * 
     * @param record
     * @return
     */
public T queryOne(T record)throws Exception;

/**
     * 根据条件查询数据列表
     * 
     * @param record
     * @return
     */
public List<T> queryListByWhere(T record)throws Exception;

/**
     * 分页查询
     * 
     * @param page
     * @param rows
     * @param record
     * @return
     */
public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record)throws Exception ;
    

/**
     * 新增数据，返回成功的条数
     * 
     * @param record
     * @return
     */
public Integer save(T record)throws Exception;

/**
 * 新增数据，返回持久化对象
 * @param record
 * @return
 * @throws Exception
 */
public T saveReturnPersistentObject(T record)throws Exception;


/**
     * 新增数据，使用不为null的字段，返回成功的条数
     * 
     * @param record
     * @return
     */
public Integer saveSelective(T record)throws Exception ;

/**
     * 修改数据，返回成功的条数
     * 
     * @param record
     * @return
     */
public Integer update(T record)throws Exception;

/**
     * 修改数据，使用不为null的字段，返回成功的条数
     * 
     * @param record
     * @return
     */
public Integer updateSelective(T record)throws Exception;

/**
     * 根据id删除数据
     * 
     * @param id
     * @return
     */
public Integer deleteById(Integer id)throws Exception;

/**
     * 批量删除
     * @param clazz
     * @param property
     * @param values
     * @return
     */
public Integer deleteByIds(Class<T>clazz, String property, List<Object>values)throws Exception;

/**
     * 根据条件做删除
     * 
     * @param record
     * @return
     */
public Integer deleteByWhere(T record)throws Exception ;

  public List<T> queryListByExample(Example example)throws Exception ;
  
  
  
  public Integer selectCountByExample(Example example);
  
  public Integer selectCount(T record);


}

