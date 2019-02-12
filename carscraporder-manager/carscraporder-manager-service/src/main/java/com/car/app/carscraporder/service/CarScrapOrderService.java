package com.car.app.carscraporder.service;

import com.car.app.carscraporder.bo.CarScrapOrderBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.OrderAduitBO;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.vo.CarScrapOrderBaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.carscraporder.vo.CarScrapOrderSimple2BaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderSimple3BaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderSimpleBaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderVO;
import com.car.app.carscraporder.vo.CarScrapOrderWhereParamterVO;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 类名称：CarScrapOrderService   
 * 类描述： 汽车报废订单服务类  
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 下午4:18:13      
 * @version  V1.0
 *
 */
public interface CarScrapOrderService extends BaseService<CarScrapOrder> {
	
	
	public PageInfo<CarScrapOrderPageBO>  queryPageListByWhere(Integer page,Integer rows,CarScrapOrderWhereParamterVO paramter)throws Exception;
	
	public PageInfo<CarScrapOrderPageBO>  queryPageListByKeyword(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;
	
	public PageInfo<CarScrapOrderPageBO>  queryPageHistoryListByKeyword(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;
	
	public PageInfo<CarScrapOrderPageBO>  queryAll(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception;
	
	
	public CarScrapOrderBO queryBOById(String id)throws Exception;
	
	/**
	 * 状态删除
	 * @param id 主键id
	 * @param operator 操作人id
	 * @return
	 * @throws Exception
	 */
	public int deleteByPrimaryKey(String id,String operator)throws Exception;
	
	public Integer update(CarScrapOrderVO record) throws Exception;
	public Integer save(CarScrapOrderVO record)throws Exception ;
	
	
	public CarScrapOrder queryById(String id);
	
	public Integer saveOrderAuditingRecord(String id,Integer orderStatus,String remark,String operator,CarScrapOrder order) throws Exception;
	
	public OrderAduitBO getOrderAuditInfo(String orderId) throws Exception;

	

	
	
	
	
	
	
}
