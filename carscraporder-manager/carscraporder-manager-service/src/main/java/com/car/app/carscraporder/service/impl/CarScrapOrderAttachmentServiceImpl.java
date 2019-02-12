package com.car.app.carscraporder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.CarScrapOrderAttachmentBO;
import com.car.app.carscraporder.bo.OrderAttachmentBO;
import com.car.app.carscraporder.mapper.CarScrapOrderAttachmentMapper;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachment;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachmentExample;
import com.car.app.carscraporder.pojo.TbAttachment;
import com.car.app.carscraporder.service.CarScrapOrderAttachmentService;
import com.car.app.carscraporder.service.TbAttachmentService;
import com.car.app.carscraporder.util.CheckUtil;

@Service
public class CarScrapOrderAttachmentServiceImpl implements
		CarScrapOrderAttachmentService {
	
	@Autowired
	private TbAttachmentService  tbAttachmentService;
	
	
	
	@Autowired
	private CarScrapOrderAttachmentMapper  carScrapOrderAttachmentMapper;
	
	
	
	
	
	
	
	

	@Override
	public int countByExample(CarScrapOrderAttachmentExample example) {
		
		return carScrapOrderAttachmentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CarScrapOrderAttachmentExample example) {
		
		return carScrapOrderAttachmentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return carScrapOrderAttachmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CarScrapOrderAttachment record) {
		record.setId(null);
		return carScrapOrderAttachmentMapper.insert(record);
	}

	@Override
	public int insertSelective(CarScrapOrderAttachment record) {
		record.setId(null);
		return carScrapOrderAttachmentMapper.insertSelective(record);
	}

	@Override
	public List<CarScrapOrderAttachment> selectByExample(
			CarScrapOrderAttachmentExample example) {
		
		return carScrapOrderAttachmentMapper.selectByExample(example);
	}

	@Override
	public CarScrapOrderAttachment selectByPrimaryKey(Integer id) {
		return carScrapOrderAttachmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(CarScrapOrderAttachment record,
			CarScrapOrderAttachmentExample example) {
		
		return carScrapOrderAttachmentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CarScrapOrderAttachment record,
			CarScrapOrderAttachmentExample example) {
		
		return carScrapOrderAttachmentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CarScrapOrderAttachment record) {
		
		return carScrapOrderAttachmentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CarScrapOrderAttachment record) {
		
		return carScrapOrderAttachmentMapper.updateByPrimaryKey(record);
	}
	
	public List<CarScrapOrderAttachmentBO> getArrachmentByOrderByid(String orderid){
		  CheckUtil.notEmpty(orderid, "param is null");
		  return carScrapOrderAttachmentMapper.getArrachmentByOrderByid(orderid);
	  }
	
	public List<OrderAttachmentBO> getArrachmentByOrderIdAndAttachmentType(String orderid,String attachmentType,String buniessType){
		  CheckUtil.notEmpty(orderid, "param is null");
		  CheckUtil.notEmpty(attachmentType, "param is null");
		  return carScrapOrderAttachmentMapper.getArrachmentByOrderIdAndAttachmentType(orderid,attachmentType,buniessType);
	  }
	
	
	 public Boolean deleteAttachmentByPrimaryKey(Integer id,String operator)throws Exception{
		 
		 CarScrapOrderAttachment carScrapOrderAttachment = this.selectByPrimaryKey(id);
		 if(carScrapOrderAttachment!=null){
			 
			 TbAttachment tbAttachment = tbAttachmentService.queryById(carScrapOrderAttachment.getAttachmentId());
			 
			 if(tbAttachment!=null){
				 carScrapOrderAttachment.setIsvalid(false);
				 this.updateByPrimaryKey(carScrapOrderAttachment);
				 tbAttachment.setOperator(operator);
				 tbAttachment.setIsvalid(false);
				 tbAttachmentService.update(tbAttachment);
				 return true;
				 
			 }
		 }
		return true;
		
		
		
		 
	 }

}
