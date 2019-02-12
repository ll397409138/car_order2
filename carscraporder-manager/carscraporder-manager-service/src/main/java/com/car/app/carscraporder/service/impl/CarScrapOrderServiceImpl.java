package com.car.app.carscraporder.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.bo.CarScrapOrderAttachmentBO;
import com.car.app.carscraporder.bo.CarScrapOrderAuditBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsPageBO;
import com.car.app.carscraporder.bo.CarScrapOrderBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.CarScrapOrderSettlementBO;
import com.car.app.carscraporder.bo.OrderAduitBO;
import com.car.app.carscraporder.bo.OrderAttachmentBO;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.mapper.CarScrapOrderMapper;
import com.car.app.carscraporder.pojo.Areas;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachment;
import com.car.app.carscraporder.pojo.CarScrapOrderAudit;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.pojo.CarScrapOrderExample;
import com.car.app.carscraporder.pojo.CarScrapOrderExample.Criteria;
import com.car.app.carscraporder.pojo.CarScrapOrderSettlement;
import com.car.app.carscraporder.pojo.TbCommonContacts;
import com.car.app.carscraporder.pojo.TbCommonMailinginfo;
import com.car.app.carscraporder.pojo.TbCommonPayeeaccount;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.AreasService;
import com.car.app.carscraporder.service.CarScrapOrderAttachmentService;
import com.car.app.carscraporder.service.CarScrapOrderAuditService;
import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.service.CarScrapOrderSettlementService;
import com.car.app.carscraporder.service.TbCommonContactsService;
import com.car.app.carscraporder.service.TbCommonMailinginfoService;
import com.car.app.carscraporder.service.TbCommonPayeeaccountService;
import com.car.app.carscraporder.service.UserService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UUIDUtil;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsVO;
import com.car.app.carscraporder.vo.CarScrapOrderBaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.carscraporder.vo.CarScrapOrderPictureVO;
import com.car.app.carscraporder.vo.CarScrapOrderSimple2BaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderSimple3BaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderSimpleBaseVO;
import com.car.app.carscraporder.vo.CarScrapOrderVO;
import com.car.app.carscraporder.vo.CarScrapOrderWhereParamterVO;
import com.car.app.common.service.RedisService;
import com.car.app.common.util.DateUtil;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarScrapOrderServiceImpl extends BaseServiceImpl<CarScrapOrder> implements
		CarScrapOrderService {
	
	@Autowired
	private CarScrapOrderMapper carScrapOrderMapper;
	
	
	@Autowired
	private CarScrapOrderAutopartsService carScrapOrderAutopartsService;
	
	@Autowired
	private CarScrapOrderAuditService carScrapOrderAuditService;
	
	
	@Autowired
	private TbCommonContactsService tbCommonContactsService;
	
	@Autowired
	private  TbCommonPayeeaccountService tbCommonPayeeaccountService;

	@Autowired
	private  TbCommonMailinginfoService tbCommonMailinginfoService;
	
	@Autowired
	private CarScrapOrderSettlementService carScrapOrderSettlementService;
	
	
	 @Autowired
	 private CarScrapOrderAttachmentService  carScrapOrderAttachmentService;
	@Autowired
     private UserService userService;
	
	
	@Autowired
    private AreasService   areasService;
	@Autowired
	private RedisService redisService;
	
	/**
	 * 新增订单
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer save(CarScrapOrderVO carScrapOrderVO)throws Exception {
		
		CheckUtil.notNull(carScrapOrderVO, "param.is.null");
		
		
		CarScrapOrder record = new CarScrapOrder();
		BeanUtils.copyProperties(carScrapOrderVO, record);
		 //校验订单
		 boolean issuccuss = valid(record);
		 
		 
		 
		if(issuccuss){
			//生产订单id
			String id = UUIDUtil.getUUID();
			
			record.setId(id);
			  //生产订单编号
		    record.setOrderNo(getOrderNo(record.getOrderAreasId(),record.getOrderType()));
			  //订单产生时间
			record.setOrderTime(new Date());
			   //订单初始状态
			record.setOrderStatus(CommonSystemParamter.ORDER_CREATE_STATUS);
			record.setIsremove(false);
			
			
			//判断订单类型
			if(StringUtils.equals(carScrapOrderVO.getOrderType(), CommonSystemParamter.ORDER_OLDPARTS_TYPE)){
				//获取配件数据
				List<CarScrapOrderAutopartsVO> carScrapOrderAutopartsList = carScrapOrderVO.getCarScrapOrderAutopartsList();
				if(carScrapOrderAutopartsList!=null&& carScrapOrderAutopartsList.size()>0){
					for(int i=0;i<carScrapOrderAutopartsList.size();i++){
						CarScrapOrderAutopartsVO partsvo = carScrapOrderAutopartsList.get(i);
						partsvo.setCreater(carScrapOrderVO.getCreater());
						partsvo.setOrderId(id);
						partsvo.setQrPic(record.getOrderNo()+"-0"+i);
						carScrapOrderAutopartsService.saveAutoparts(partsvo);
					}
				}
				
			}else{
				//获取整车订单的上传图片
				List<CarScrapOrderPictureVO> pictures = carScrapOrderVO.getPictures();
				if(pictures!=null&& pictures.size()>0){
					for(CarScrapOrderPictureVO picture:pictures){
						if(StringUtils.equals(picture.getPritureCategory(), "1")||StringUtils.equals(picture.getPritureCategory(), "2")){
							if(StringUtils.isNotBlank(picture.getAttachmentId())){
								     CarScrapOrderAttachment attachment = new CarScrapOrderAttachment();
						    		 attachment.setAttachmentId(Integer.parseInt(picture.getAttachmentId()));
						    		 attachment.setOrderId(id);
						    		 attachment.setOrderType(CommonSystemParamter.ORDER_WhOLECAR_TYPE);
						    		 attachment.setAttachmentType(picture.getPritureCategory());
						    		 attachment.setCarPictureType(picture.getPritureType());
						    		 carScrapOrderAttachmentService.insert(attachment);
						    		 
						    	
							}
							
						  
							
						}
						
					}
				}
				
			}
			
			
			
		    //新增订单审核节点历史记录
			CarScrapOrderAudit auditData = new CarScrapOrderAudit();
			auditData.setOrderId(id);
			auditData.setStauts(CommonSystemParamter.ORDER_CREATE_STATUS);
			auditData.setAuditor(carScrapOrderVO.getCreater());
			auditData.setAuditTime(new Date());
			auditData.setRemark("下单");
			auditData.setBusinessType(CommonSystemParamter.BUSINESS_TYPE_ORDER);
			auditData.setCreater(record.getCreater());
			carScrapOrderAuditService.save(auditData);
			
			
			
			//设置常用联系人
			if(carScrapOrderVO.getIsSetUpContacts()==true){
				TbCommonContacts contacts = new TbCommonContacts();
				if(StringUtils.isNotBlank(record.getTakeCarContacts())){
					contacts.setContactName(record.getTakeCarContacts());
					contacts.setContactTelephone(record.getTakeCarContactNumber());
					contacts.setClientid(record.getClientId());
					//首先查询是否有相同数据
					int count = tbCommonContactsService.selectCount(contacts);
					if(count==0)
					    tbCommonContactsService.save(contacts);
					
				}
				
			}
		  if(StringUtils.equals(carScrapOrderVO.getOrderType(), CommonSystemParamter.ORDER_WhOLECAR_TYPE)){
			  if(carScrapOrderVO.getIsSetUpMailing()==true){
				  TbCommonMailinginfo mailing = new TbCommonMailinginfo();
					if(StringUtils.isNotBlank(record.getMailingAddressName())){
						mailing.setMailingAddressName(record.getMailingAddressName());
						mailing.setMailingAddressTelephone(record.getMailingAddressTelephone());
						mailing.setProvince(record.getProvince());
						mailing.setCity(record.getCity());
						mailing.setCounty(record.getCounty());
						mailing.setDetailedAddress(record.getDetailedAddress());
						mailing.setClientid(record.getClientId());
						//首先查询是否有相同数据
						int count = tbCommonMailinginfoService.selectCount(mailing);
						if(count==0){
							mailing.setCreater(record.getCreater());
							tbCommonMailinginfoService.save(mailing);
						}
							
						
					}
				  
				  
			  }
			  
			  
             if(carScrapOrderVO.getIsSetUpPayee()==true){
            	 TbCommonPayeeaccount payee = new TbCommonPayeeaccount();
            	 if(StringUtils.isNotBlank(record.getPayeeName())){
            		 payee.setPayeeName(record.getPayeeName());
            		 payee.setOpeningBank(record.getOpeningBank());
            		 payee.setBankAccount(record.getBankAccount());
            		 payee.setClientid(record.getClientId());
            		//首先查询是否有相同数据
				   int count = tbCommonPayeeaccountService.selectCount(payee);
				  if(count==0){
					  payee.setCreater(record.getCreater());
					  tbCommonPayeeaccountService.save(payee);
				  }
					 
            	 }
				  
			  }
			  
				
			}
			
			
		}else{
			throw new DataException("订单数据异常");
		}
	
		
		return super.save(record);
		
		
		
	}
	
	
	private boolean valid(CarScrapOrder carScrapOrder){
		if(carScrapOrder.getOrderAreasId()==null){
			carScrapOrder.setOrderAreasId(2);//默认北京区域
		}
		
		//TODO 订单数据校验
		CheckUtil.notNull(carScrapOrder, "param.is.null");
		//CheckUtil.notNull(carScrapOrder.getOrderAreasId(), "param.is.null");
		CheckUtil.notNull(carScrapOrder.getOrderType(), "param.is.null");
		CheckUtil.check((0<Integer.parseInt(carScrapOrder.getOrderType())), "param.is.null");
		CheckUtil.check((Integer.parseInt(carScrapOrder.getOrderType())<3), "param.is.null");
		return true;
	}
	
	/**
	 * 订单修改
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public Integer update(CarScrapOrderVO record) throws Exception{
		CarScrapOrder order = this.queryById(record.getId());
		record.setCreater(order.getCreater());
		BeanUtils.copyProperties(record, order);
		
		return super.update(order);
	}
	
	
	public CarScrapOrder queryById(String id){
		return carScrapOrderMapper.selectByPrimaryKey(id);
	}
	
	
	/**
	 * 根据订单id获取订单数据
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public CarScrapOrderBO queryBOById(String id) throws Exception{
		
		//查询订单信息
		CarScrapOrderBO bo = carScrapOrderMapper.queryBOById(id);
		
		if(bo!=null){
			//判断订单类型
			if(StringUtils.equals(bo.getOrderType(), CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS)){
				List<CarScrapOrderAutopartsBO>   autopartsBoList = carScrapOrderAutopartsService.queryListByOrderId(id);
				bo.setCarScrapOrderAutopartsList(autopartsBoList);
				
				
				
			}else{
				
				 fillPrictureToOrder(bo);
				
				
//				//查询整车图片返回的结构[{orderType:1,storagePaths:"201810251625111/fdsfd3eredsfd233fse.png,201810251625111/eefddsterdredsfd233fse.png"}]
//				List<CarScrapOrderAttachmentBO> attachmentList = carScrapOrderAttachmentService.getArrachmentByOrderByid(id);
//				if(attachmentList!=null&&attachmentList.size()>0){
//					for(CarScrapOrderAttachmentBO attachment:attachmentList){
//						if(StringUtils.isBlank(attachment.getAttachmentType())) break;
//						List<String> attachement = new ArrayList<String>();
//						 if(attachment.getUrl()!=null){
//							 if(StringUtils.indexOf(attachment.getUrl(), ",")>0){
//								 
//								 String[] paths = StringUtils.split(attachment.getUrl(), ",");
//								 attachement = Arrays.asList(paths);
//							 }else{
//								 attachement.add(attachment.getUrl());
//							 }
//							 fillPrictureToOrder(bo,attachment.getAttachmentType(),attachement);
//						 }
//					}
//					
//				}
//				
//			}	
	}
		
		//根据订单id查询审核历史记录
		Example example = new Example(CarScrapOrderAudit.class);
		example.setOrderByClause("auditTime");
		example.createCriteria().andEqualTo("orderId", id).andEqualTo("businessType", "1");
		List<CarScrapOrderAudit> carScrapOrderAuditList = carScrapOrderAuditService.queryListByExample(example);
		for(CarScrapOrderAudit audit :carScrapOrderAuditList){
			if(CommonSystemParamter.ORDER_CREATE_STATUS==audit.getStauts() ){
				//下单日期
				bo.setCreateOrderDate(audit.getAuditTime());
			}else if(CommonSystemParamter.ORDER_DISTRIBUTION_STATUS == audit.getStauts()){
				//派单日期
				bo.setPiesNote(audit.getRemark());
			}else if(CommonSystemParamter.ORDER_RECEIVE_STATUS == audit.getStauts()){
				//接收日期
				bo.setReceiveCarDate(audit.getAuditTime());
			}else if(CommonSystemParamter.ORDER_STORAGE_STATUS == audit.getStauts()){
				//入库日期
				bo.setInStorageDate(audit.getAuditTime());
			}else if(CommonSystemParamter.ORDER_SCRAP_STATUS  == audit.getStauts()){
				//报废日期
				bo.setFormalitiesDate(audit.getAuditTime());
			}else if(CommonSystemParamter.ORDER_SETTLEMENT_STATUS == audit.getStauts()){
				//结算日期
				bo.setSettlementDate(audit.getAuditTime());
			} 
		}
		
		
		 List<CarScrapOrderSettlementBO> settlementList = carScrapOrderSettlementService.getCarScrapOrderSettlementByOrderId(id);
			
		 bo.setSettlementList(settlementList);
				
		}
		
		
		
		

		
		
		
		return bo;
		
	}
	

	
	

	
	public OrderAduitBO getOrderAuditInfo(String orderId) throws Exception{
		OrderAduitBO bo = null;
		//查询订单信息 
		CarScrapOrder order = carScrapOrderMapper.selectByPrimaryKey(orderId);
		if(order==null){
			return bo;
		}else{
			bo = new OrderAduitBO();
			BeanUtils.copyProperties(order, bo);
			//查询订单配件数
			CarScrapOrderAutoparts whereParam = new CarScrapOrderAutoparts();
			whereParam.setOrderId(orderId);
			whereParam.setIsValid(true);
			Integer count = carScrapOrderAutopartsService.selectCount(whereParam);
		    bo.setPartsCount(count);
		    
		    
			//查询审核进度
		    Map<Integer,CarScrapOrderAuditBO>  auditMap = new HashMap<Integer,CarScrapOrderAuditBO>();
			Example example = new Example(CarScrapOrderAudit.class);
			example.setOrderByClause("auditTime");
			example.createCriteria().andEqualTo("orderId", orderId).andEqualTo("businessType", "1");
			List<CarScrapOrderAudit> carScrapOrderAuditList = carScrapOrderAuditService.queryListByExample(example);
			for(CarScrapOrderAudit audit :carScrapOrderAuditList){
				if(CommonSystemParamter.ORDER_RECEIVE_STATUS == audit.getStauts()){
					//接收日期
//					CarScrapOrderAuditBO auditBo = new CarScrapOrderAuditBO();
//					BeanUtils.copyProperties(audit, auditBo);
//					//查询审核人姓名
//					User user = userService.queryById(audit.getAuditor());
//					if(user!=null){
//						auditBo.setAuditorName(user.getRealName());
//					}
//					auditMap.put(audit.getStauts(), auditBo);
					
					bo.setReceiveOrderTime(audit.getAuditTime());
					User user = userService.queryById(audit.getAuditor());
					bo.setRecipient(user.getRealName());
					
				}else if(CommonSystemParamter.ORDER_SETTLEMENT_STATUS == audit.getStauts()){
					//结算日期
//					CarScrapOrderAuditBO auditBo = new CarScrapOrderAuditBO();
//					BeanUtils.copyProperties(audit, auditBo);
//					auditMap.put(audit.getStauts(), auditBo);
					bo.setSettlementTime(audit.getAuditTime());
				} else if(CommonSystemParamter.ORDER_END_STATUS == audit.getStauts()){
					
//					CarScrapOrderAuditBO auditBo = new CarScrapOrderAuditBO();
//					BeanUtils.copyProperties(audit, auditBo);
//					auditMap.put(audit.getStauts(), auditBo);
					bo.setEndTime(audit.getAuditTime());
				}
			}
			
			
			
			
			return bo;
			
		}
		
		
	}
	
	
	
	private void fillPrictureToOrder(CarScrapOrderBO bo){
		 List<OrderAttachmentBO> attachmentBo1 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.ORDER_PICTURE_CAR,CommonSystemParamter.ORDER_WhOLECAR_TYPE);
			
		 bo.setVehiclePictures(attachmentBo1);
			
		 List<OrderAttachmentBO> attachmentBo2 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.ORDER_PICTURE_CAR_FORMALITIES,CommonSystemParamter.ORDER_WhOLECAR_TYPE);
		 bo.setFormalitiesPictures(attachmentBo2);
		  List<OrderAttachmentBO> attachmentBo3 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.ORDER_PICTURE_CAR_DESTROY,CommonSystemParamter.ORDER_WhOLECAR_TYPE);
		  bo.setDestroyPictures(attachmentBo3);
		  List<OrderAttachmentBO> attachmentBo4 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.ORDER_PICTURE_CAR_CERTIFICATE,CommonSystemParamter.ORDER_WhOLECAR_TYPE);
		  bo.setCertificatePictures(attachmentBo4);
		
		
		
		
		
//		if(StringUtils.equals(attachmentType, CommonSystemParamter.ORDER_PICTURE_CAR)){
//			
//			bo.setVehiclePictures(pictures);
//		}else if(StringUtils.equals(attachmentType, CommonSystemParamter.ORDER_PICTURE_CAR_FORMALITIES)){
//			
//			bo.setFormalitiesPictures(pictures);
//		}else if(StringUtils.equals(attachmentType, CommonSystemParamter.ORDER_PICTURE_CAR_DESTROY)){
//			bo.setDestroyPictures(pictures);
//		}else if(StringUtils.equals(attachmentType, CommonSystemParamter.ORDER_PICTURE_CAR_CERTIFICATE)){
//			bo.setCertificatePictures(pictures);
//		}
		
		
		
	}
	
	
	/**
	 * 删除订单
	 * 状态删除:保存操作人、操作时间
	 */
      public int deleteByPrimaryKey(String id,String operator){
    	  CarScrapOrder carScrapOrder = new CarScrapOrder();
    	  carScrapOrder.setOperatortime(new Date());
    	  carScrapOrder.setOperator(operator);
    	  carScrapOrder.setId(id);
    	  carScrapOrder.setIsremove(true);
    	  //TODO  删除旧件订单时级联删除配件数据
		return carScrapOrderMapper.updateByPrimaryKeySelective(carScrapOrder);
		
	}
      
     
     
	
	
	
	/**
	 * 订单为维度进行审核操作
	 */
	public Integer saveOrderAuditingRecord(String id,Integer orderStatus,String remark,String operator,CarScrapOrder orderParam) throws Exception{
		
		CarScrapOrder order = this.queryById(id);
        if(order!=null){
        	CheckUtil.check(orderStatus>=order.getOrderStatus(), "param.is.null");
        	if(orderParam!=null){
    			 BeanUtils.copyProperties(orderParam, order);
    		 }
        	
        	
	         order.setOperator(operator);
	    		
	  		  //判断订单类型
	  		if(StringUtils.equals(order.getOrderType(), CommonSystemParamter.ORDER_WhOLECAR_TYPE)){
	  			   
	  			  if(CommonSystemParamter.PARTS_CREATE_STATUS == orderStatus){
	  				   //整车订单初始化
	  				  saveauditHistory(order.getId(),CommonSystemParamter.PARTS_CREATE_STATUS,"下单",CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  
	  				  
	  			  }else if(CommonSystemParamter.ORDER_DISTRIBUTION_STATUS == orderStatus){
	  				  //整车订单接单派单
	  				  saveauditHistory(order.getId(),CommonSystemParamter.ORDER_DISTRIBUTION_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  order.setOrderStatus(orderStatus);
	  				  //保存订单信息
	  				  super.updateSelective(order);
	  			  }else if(CommonSystemParamter.ORDER_RECEIVE_STATUS == orderStatus){
	  				  //整车订单接收车辆
	  				  saveauditHistory(order.getId(),CommonSystemParamter.ORDER_RECEIVE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  order.setOrderStatus(orderStatus);
	  				  //保存订单信息
	  				  super.updateSelective(order);
	  			  }else if(CommonSystemParamter.ORDER_STORAGE_STATUS == orderStatus){
	  				//整车订单入场
	  				  saveauditHistory(order.getId(),CommonSystemParamter.ORDER_STORAGE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  order.setOrderStatus(orderStatus);
	  				  //保存订单信息
	  				  super.updateSelective(order);
	  			  }else if(CommonSystemParamter.ORDER_SCRAP_STATUS == orderStatus){
	  				//整车订单报废
	  				  saveauditHistory(order.getId(),CommonSystemParamter.ORDER_STORAGE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  order.setOrderStatus(orderStatus);
	  				  //保存订单信息
	  				  super.updateSelective(order);
	  			  }else if(CommonSystemParamter.ORDER_SETTLEMENT_STATUS == orderStatus){
	  				  //整车订单结算
	  				  saveauditHistory(order.getId(),CommonSystemParamter.ORDER_STORAGE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  order.setOrderStatus(orderStatus);
	  				  //保存订单信息
	  				  super.updateSelective(order);
	  			  }else if(CommonSystemParamter.ORDER_END_STATUS == orderStatus){
	  				//整车订单结束
	  				  saveauditHistory(order.getId(),CommonSystemParamter.ORDER_STORAGE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  order.setOrderStatus(orderStatus);
	  				  //保存订单信息
	  				  super.updateSelective(order);
	  			  }else if(CommonSystemParamter.ORDER_ERROR_STATUS == orderStatus){
	  				  //整车订单异常
	  				  saveauditHistory(order.getId(),CommonSystemParamter.ORDER_STORAGE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				  order.setOrderStatus(orderStatus);
	  				  //保存订单信息
	  				  super.update(order);
	  			  }
	  		    
	  		    
	  			
	  		}else if(StringUtils.equals(order.getOrderType(), CommonSystemParamter.ORDER_OLDPARTS_TYPE)){
	  			
	  			if(CommonSystemParamter.PARTS_CREATE_STATUS == orderStatus){
	  				//旧件订单初始化
	  				saveauditHistory(order.getId(),CommonSystemParamter.PARTS_CREATE_STATUS,"下单",CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  				
	  			  }else if(CommonSystemParamter.ORDER_DISTRIBUTION_STATUS == orderStatus){
	  				//旧件订单接单派单
	  				    //配件订单新增历史
	  					List<CarScrapOrderAutoparts> partsList = getCarScrapOrderAutopartsByOrderId(id);
	  					for(CarScrapOrderAutoparts parts:partsList){
	  						saveauditHistory(parts.getId(),CommonSystemParamter.ORDER_DISTRIBUTION_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS,operator);
	  						//更新配件订单状态
	  						parts.setOrderAutopartsStatus(CommonSystemParamter.PARTS_RECEIPT_STATUS);
	  						parts.setOperator(operator);
	  						carScrapOrderAutopartsService.updateSelective(parts);
	  					}
	  					//保存订单业务
	  					saveauditHistory(order.getId(),CommonSystemParamter.ORDER_DISTRIBUTION_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  					order.setOrderStatus(CommonSystemParamter.ORDER_DISTRIBUTION_STATUS);
	  					super.updateSelective(order);
	  			  }else if(CommonSystemParamter.ORDER_RECEIVE_STATUS == orderStatus){
	  				    //旧件订单接收
	  					saveauditHistory(order.getId(),CommonSystemParamter.ORDER_RECEIVE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  					
	  			  }else if(CommonSystemParamter.PARTS_NO_RECEIVE_STATUS == orderStatus){
	  				//旧件订单无法入库
	  				  saveauditHistory(order.getId(),CommonSystemParamter.PARTS_NO_RECEIVE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  					
	  			  }else if(CommonSystemParamter.PARTS_STORAGE_STATUS == orderStatus){
	  				  //旧件订单入库
	  				  saveauditHistory(order.getId(),CommonSystemParamter.PARTS_STORAGE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  					
	  			  }
	  			  
	  			  else if(CommonSystemParamter.PARTS_OUT_STORAGE_STATUS == orderStatus){
	  				//旧件订单出库
	  				  saveauditHistory(order.getId(),CommonSystemParamter.PARTS_OUT_STORAGE_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  					
	  			  }else if(CommonSystemParamter.PARTS_SETTLEMENT_STATUS == orderStatus){
	  				//旧件订单结算
	  				  saveauditHistory(order.getId(),CommonSystemParamter.PARTS_SETTLEMENT_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  					
	  			  }else if(CommonSystemParamter.PARTS_END_STATUS == orderStatus){
	  				  //旧件订单结束
	  				  saveauditHistory(order.getId(),CommonSystemParamter.PARTS_END_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
	  					
	  			  }else if(CommonSystemParamter.PARTS_ERROR_STATUS == orderStatus){ 
	  				List<CarScrapOrderAutoparts> partsList = getCarScrapOrderAutopartsByOrderId(id);
  					for(CarScrapOrderAutoparts parts:partsList){
  						saveauditHistory(parts.getId(),CommonSystemParamter.PARTS_ERROR_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS,operator);
  						//更新配件订单状态
  						parts.setOrderAutopartsStatus(CommonSystemParamter.PARTS_ERROR_STATUS);
  						parts.setOperator(operator);
  						carScrapOrderAutopartsService.updateSelective(parts);
  					}
  					//保存订单业务
  					saveauditHistory(order.getId(),CommonSystemParamter.PARTS_ERROR_STATUS,remark,CommonSystemParamter.BUSINESS_TYPE_ORDER,operator);
  					order.setOrderStatus(CommonSystemParamter.PARTS_ERROR_STATUS);
  					super.updateSelective(order);
	  				  
	  				  
	  			  }
	  			
	  		   }
		 
         }
		
		
	
		return 1;
		
		  	
			
		
			
		
		
	}
	
	
	
	private List<CarScrapOrderAutoparts> getCarScrapOrderAutopartsByOrderId(String orderid) throws Exception{
		CarScrapOrderAutoparts whereparam = new CarScrapOrderAutoparts();
		whereparam.setOrderId(orderid);
		whereparam.setIsValid(true);
		return carScrapOrderAutopartsService.queryListByWhere(whereparam);
	}
	
	private void saveauditHistory(String orderid,Integer orderStatus,String auditRemark,String orderType, String operator) throws Exception{
		
		//新增审核历史记录
		CarScrapOrderAudit auditData = new CarScrapOrderAudit();
		auditData.setOrderId(orderid);
		auditData.setStauts(orderStatus);
		auditData.setAuditor(operator);
		auditData.setAuditTime(new Date());
		auditData.setRemark(auditRemark);
		auditData.setBusinessType(orderType);
		auditData.setCreater(operator);
		carScrapOrderAuditService.save(auditData);
		
	}
	
	
	
	
	

	
	/**
	 * 生成订单编号
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private String getOrderNo(Integer areaid,String orderType) throws  Exception{
		StringBuffer sbuff = new StringBuffer();
		if(StringUtils.equals(orderType, CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS)){
			sbuff.append("P");
		}else{
			sbuff.append("A");
		}
		
		Areas areas = areasService.queryById(areaid);
		if(areas == null){
			throw new DataException("区域数据不存在");
		}
		
		sbuff.append(areas.getAreasCode());
		
		String dateStr = DateUtil.getFormatDate();
		sbuff.append(dateStr);
		//每天从1开始的编码
		
		String num = redisService.get(dateStr);
		Long serialNumber = null;
		if(StringUtils.isNotBlank(num)){
			serialNumber = redisService.incr(dateStr);
		}else{
			redisService.set(dateStr, "0",86400);//一天有效
			serialNumber=redisService.incr(dateStr);
		}
		
		
		
		sbuff.append(formatserialNumber(serialNumber));
		return sbuff.toString();
		
	}
	
	public String formatserialNumber(Long serialNumber){
		StringBuffer sbuff = new StringBuffer();
		if(serialNumber<10){
			sbuff.append("000").append(serialNumber);
		}else if(serialNumber<100){
			sbuff.append("00").append(serialNumber);
		}else if(serialNumber<1000){
			sbuff.append("0").append(serialNumber);
		}else{
			sbuff.append(serialNumber);
		}
		
		return sbuff.toString();
		
	}
	

	

	
	/**
	 * 获取订单列表
	 * @param page
	 * @param rows
	 * @param paramater
	 * @return
	 */
	@Override
	public PageInfo<CarScrapOrderPageBO>  queryPageListByWhere(Integer page,Integer rows,CarScrapOrderWhereParamterVO paramter) {
		PageHelper.startPage(page, rows);
		CarScrapOrderExample example = new CarScrapOrderExample();
		Criteria  criteria = example.createCriteria();
		
		if(paramter.getOrderStatus()!=null){
		  criteria.andOrderStatusEqualTo(paramter.getOrderStatus());
		}
		
		if(paramter.getCarFrameNumber()!=null){
			criteria.andCarFrameNumberEqualTo(paramter.getCarFrameNumber());
		}
		
		if(paramter.getOrderNo()!=null){
			criteria.andOrderNoEqualTo(paramter.getOrderNo());
		}
		
		if(paramter.getCarNumber()!=null){
			criteria.andCarNumberEqualTo(paramter.getCarNumber());
		}
		
		if(paramter.getTakeCarContacts()!=null){
			criteria.andTakeCarContactsEqualTo(paramter.getTakeCarContacts());
		}
		if(paramter.getTakeCarContactNumber()!=null){
			criteria.andTakeCarContactNumberEqualTo(paramter.getTakeCarContactNumber());
		}
		
		if(paramter.getClientId()!=null){
			criteria.andClientIdEqualTo(paramter.getClientId());
		}
		
		if(paramter.getAgentUserid()!=null){
			criteria.andAgentUseridEqualTo(paramter.getAgentUserid());
		}
		
		
		List<CarScrapOrderPageBO> data = carScrapOrderMapper.queryPageListByWhere(example);
		
		

		
		
		return new PageInfo<CarScrapOrderPageBO>(data);
	}
	
	
	public PageInfo<CarScrapOrderPageBO>  queryPageListByKeyword(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception{
		if(paramter!=null){
			if(StringUtils.isNotBlank(paramter.getAraesids())){
				if(StringUtils.indexOf(paramter.getAraesids(), ",")>0){
					String[] arrayAraes = StringUtils.split(paramter.getAraesids(), ",");
					
					paramter.setAraesidList(Arrays.asList(arrayAraes));
				}else{
					paramter.setAraesidList(new ArrayList());
					paramter.getAraesidList().add(paramter.getAraesids());
				}
			}
			
			if(StringUtils.isNotBlank(paramter.getOrderStatus())){
				if(StringUtils.indexOf(paramter.getOrderStatus(), ",")>0){
					String[] arrayOrderStatus = StringUtils.split(paramter.getOrderStatus(), ",");
					paramter.setOrderStatusList(Arrays.asList(arrayOrderStatus));
				}else{
					paramter.setOrderStatusList(new ArrayList());
					paramter.getOrderStatusList().add(paramter.getOrderStatus());
				}
			}
			
			
			PageHelper.startPage(page, rows);
			if(StringUtils.equals(CommonSystemParamter.ORDER_OLDPARTS_TYPE, paramter.getOrderType())){
				//旧件订单查询
				
	        	List<CarScrapOrderPageBO> data = carScrapOrderMapper.queryOldPartsWillReceivePageListByKeyword(paramter);
	        	return new PageInfo<CarScrapOrderPageBO>(data);
			}else{
				List<CarScrapOrderPageBO> data  = carScrapOrderMapper.queryPageListByKeyword(paramter);
	        	return new PageInfo<CarScrapOrderPageBO>(data);

				
			}
		}
		return null;
		 
		
	}
	
	
	public PageInfo<CarScrapOrderPageBO>  queryAll(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception{
		
		if(paramter!=null){
			if(StringUtils.isNotBlank(paramter.getAraesids())){
				if(StringUtils.indexOf(paramter.getAraesids(), ",")>0){
					String[] arrayAraes = StringUtils.split(paramter.getAraesids(), ",");
					
					paramter.setAraesidList(Arrays.asList(arrayAraes));
				}else{
					paramter.setAraesidList(new ArrayList());
					paramter.getAraesidList().add(paramter.getAraesids());
				}
			}
			
			if(StringUtils.isNotBlank(paramter.getOrderStatus())){
				if(StringUtils.indexOf(paramter.getOrderStatus(), ",")>0){
					String[] arrayOrderStatus = StringUtils.split(paramter.getOrderStatus(), ",");
					paramter.setOrderStatusList(Arrays.asList(arrayOrderStatus));
				}else{
					paramter.setOrderStatusList(new ArrayList());
					paramter.getOrderStatusList().add(paramter.getOrderStatus());
				}
			}
		}
		
			PageHelper.startPage(page, rows);
			List<CarScrapOrderPageBO> data = carScrapOrderMapper.queryAll(paramter);
			
			
			return new PageInfo<CarScrapOrderPageBO>(data);
			
	}
	
	/**
	 * 查询操作过的订单
	 */
	public PageInfo<CarScrapOrderPageBO>  queryPageHistoryListByKeyword(Integer page,Integer rows,CarScrapOrderKeywordVO paramter)throws Exception{
		PageHelper.startPage(page, rows);
		List<CarScrapOrderPageBO> data = carScrapOrderMapper.queryPageHistoryListByKeyword(paramter);
		
		
		
		return new PageInfo<CarScrapOrderPageBO>(data);
		
		
	}


	
	
	
	
	


	
	
	
}
