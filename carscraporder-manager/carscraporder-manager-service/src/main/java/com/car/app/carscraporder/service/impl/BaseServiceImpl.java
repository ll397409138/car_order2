package com.car.app.carscraporder.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.car.app.carscraporder.pojo.BasePojo;
import com.car.app.carscraporder.service.BaseService;

/**
 * 
 * 类名称：BaseServiceImpl   
 * 类描述：抽象实现通用crud接口定义的实现   
 * 创建人：刘子亮
 * 创建时间：2018年5月17日 上午10:20:49      
 * @version  V1.0
 *
 */
public abstract class BaseServiceImpl<T extends BasePojo> implements BaseService<T> {

 
	
	@Autowired
	private Mapper<T> mapper;

	/**
	 * 根据id查询数据
	 * 
	 * @param id
	 * @return
	 */
	public T queryById(Integer id)throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询所有数据
	 * 
	 * @return
	 */
	public List<T> queryAll()throws Exception {
		return mapper.select(null);
	}

	/**
	 * 根据条件查询一条数据，如果有多条数据会抛出异常
	 * 
	 * @param record
	 * @return
	 */
	public T queryOne(T record)throws Exception {
		return mapper.selectOne(record);
	}

	/**
	 * 根据条件查询数据列表
	 * 
	 * @param record
	 * @return
	 */
	public List<T> queryListByWhere(T record)throws Exception {
		
		
		return mapper.select(record);
	}
	
	
	/**
	 * 
	 */
    public List<T> queryListByExample(Example example)throws Exception {
		return mapper.selectByExample(example);
		
	}
    
    
   public Integer selectCountByExample(Example example){
	  
	   return mapper.selectCountByExample(example);
   }
   
   public Integer selectCount(T record){
	   return  mapper.selectCount(record);
   }

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param rows
	 * @param record
	 * @return
	 */
	public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record)throws Exception {
		// 设置分页条件
		PageHelper.startPage(page, rows);
		List<T> list = this.queryListByWhere(record);
		return new PageInfo<T>(list);
	}
	
	
	public PageInfo<T> queryPageListByExample(Integer page, Integer rows, Example example)throws Exception {
		// 设置分页条件
		PageHelper.startPage(page, rows);
		List<T> list = this.queryListByExample(example);
		return new PageInfo<T>(list);
	}

	/**
	 * 新增数据，返回成功的条数
	 * 
	 * @param record
	 * @return
	 */
	public Integer save(T record)throws Exception {
		record.setCreatetime(new Date());
		record.setOperatortime(new Date());
		return mapper.insert(record);
	}
	
	/**
	 * 新增数据，返回持久化对象
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public T saveReturnPersistentObject(T record)throws Exception{
		
		Integer count = save(record);
		if(count==1){
			return record;
		}else{
			throw new RuntimeException("插入失败");
		}
		
		
	}

	/**
	 * 新增数据，使用不为null的字段，返回成功的条数
	 * 
	 * @param record
	 * @return
	 */
	public Integer saveSelective(T record)throws Exception {
		record.setCreatetime(new Date());
		record.setOperatortime(new Date());
		return mapper.insertSelective(record);
	}

	/**
	 * 修改数据，返回成功的条数
	 * 
	 * @param record
	 * @return
	 */
	public Integer update(T record)throws Exception {
		record.setOperatortime(new Date());
		return mapper.updateByPrimaryKey(record);
	}

	/**
	 * 修改数据，使用不为null的字段，返回成功的条数
	 * 
	 * @param record
	 * @return
	 */
	public Integer updateSelective(T record) throws Exception{
		record.setOperatortime(new Date());
		
		return mapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据id删除数据
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteById(Integer id)throws Exception {
		// record.setUpdated(new Date());
		return mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 * 
	 * @param clazz
	 * @param property 类的属性名
	 * @param values
	 * @return
	 */
	public Integer deleteByIds(Class<T> clazz, String property,
			List<Object> values)throws Exception {
		Example example = new Example(clazz);
		example.createCriteria().andIn(property, values);
		return mapper.deleteByExample(example);
	}

	/**
	 * 根据条件做删除
	 * 
	 * @param record
	 * @return
	 */
	public Integer deleteByWhere(T record)throws Exception {
		return mapper.delete(record);
	}
}


 
