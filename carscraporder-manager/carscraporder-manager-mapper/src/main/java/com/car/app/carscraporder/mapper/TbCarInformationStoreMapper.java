package com.car.app.carscraporder.mapper;

import com.car.app.carscraporder.pojo.TbCarInformationStore;
import com.car.app.carscraporder.pojo.TbCarInformationStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCarInformationStoreMapper {
    int countByExample(TbCarInformationStoreExample example);

    int deleteByExample(TbCarInformationStoreExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbCarInformationStore record);

    int insertSelective(TbCarInformationStore record);

    List<TbCarInformationStore> selectByExample(TbCarInformationStoreExample example);

    TbCarInformationStore selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbCarInformationStore record, @Param("example") TbCarInformationStoreExample example);

    int updateByExample(@Param("record") TbCarInformationStore record, @Param("example") TbCarInformationStoreExample example);

    int updateByPrimaryKeySelective(TbCarInformationStore record);

    int updateByPrimaryKey(TbCarInformationStore record);
}