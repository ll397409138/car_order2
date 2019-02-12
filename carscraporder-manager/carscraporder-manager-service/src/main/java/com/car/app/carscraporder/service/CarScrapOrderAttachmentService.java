package com.car.app.carscraporder.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.app.carscraporder.bo.CarScrapOrderAttachmentBO;
import com.car.app.carscraporder.bo.OrderAttachmentBO;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachment;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachmentExample;

/**
 * 
 * 类名称：CarScrapOrderAttachmentService   
 * 类描述： 订单附件服务类
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 下午4:18:40      
 * @version  V1.0
 *
 */
public interface CarScrapOrderAttachmentService {
	
	int countByExample(CarScrapOrderAttachmentExample example);

    int deleteByExample(CarScrapOrderAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarScrapOrderAttachment record);

    int insertSelective(CarScrapOrderAttachment record);

    List<CarScrapOrderAttachment> selectByExample(CarScrapOrderAttachmentExample example);

    CarScrapOrderAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarScrapOrderAttachment record, @Param("example") CarScrapOrderAttachmentExample example);

    int updateByExample(@Param("record") CarScrapOrderAttachment record, @Param("example") CarScrapOrderAttachmentExample example);

    int updateByPrimaryKeySelective(CarScrapOrderAttachment record);

    int updateByPrimaryKey(CarScrapOrderAttachment record);
    
    public List<CarScrapOrderAttachmentBO> getArrachmentByOrderByid(String orderid);
    public List<OrderAttachmentBO> getArrachmentByOrderIdAndAttachmentType(String orderid,String attachmentType,String buniessType);
    
    
    public Boolean deleteAttachmentByPrimaryKey(Integer id,String operator)throws Exception;
    
    
    
	
	
	
	
	

}
