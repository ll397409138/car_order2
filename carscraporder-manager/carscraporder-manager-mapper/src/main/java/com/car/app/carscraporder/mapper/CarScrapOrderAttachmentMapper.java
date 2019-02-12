package com.car.app.carscraporder.mapper;

import com.car.app.carscraporder.bo.CarScrapOrderAttachmentBO;
import com.car.app.carscraporder.bo.OrderAttachmentBO;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachment;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachmentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CarScrapOrderAttachmentMapper {
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
    
     List<CarScrapOrderAttachmentBO> getArrachmentByOrderByid(String orderid);
     
     
     List<OrderAttachmentBO> getArrachmentByOrderIdAndAttachmentType(@Param("orderid") String orderid,@Param("attachmentType")String attachmentType,@Param("buniessType")String buniessType);
}