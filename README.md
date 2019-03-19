# 项目描述   
   该工程是使用springmvc+spring+mybaties搭建的，项目使用了shiro实现用户的认证和鉴权，使用swagger-ui生产接口测试文档，使用redis做session记录
使用ngnix做负载均衡和简单的图片服务器
# 接口定义规范(参考https://zhuanlan.zhihu.com/p/28708259)
1. 所有接口都必须返回ResultBean。
2. 一开始就要考虑成功和失败二种场景。
3. ResultBean只允许出现在controller，不允许到处传。
4. 不要出现 map ，json 等复杂对象做为输入和输出。
# controller
使用 `AOP` 统一处理异常，并根据不同异常返回不同返回码。尤其关注非用户自己抛出的异常。其他调用层出现异常统一向上抛出不处理，有contoller处理。
```Java
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
  			  result.setMsg("数据错误 "+e.getMessage());
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
             }else if(e instanceof DataExistException) {
     			  result.setCode(209);
      			  result.setMsg("数据已存在 "+e.getMessage());
                  //账号不存在
             }else {
        	  result.setCode(500);
        	  result.setMsg("未知异常");
          }
		
		return result;
		
	}
   ```
   # service
 抽象单表crud的抽象接口BaseService,BaseServiceImpl抽象类实现单表crud
 ```java
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
 ```
 ```java
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
  ```
