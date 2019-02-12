package com.car.app.carscraporder.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CompleteMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadResult;
import com.aliyun.oss.model.PartETag;
import com.aliyun.oss.model.UploadPartRequest;
import com.aliyun.oss.model.UploadPartResult;
import com.car.app.carscraporder.bo.CarScrapOrderAttachmentBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsDetailBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsPageBO;
import com.car.app.carscraporder.bo.CarScrapOrderBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.OrderAttachmentBO;
import com.car.app.carscraporder.exception.CheckException;
import com.car.app.carscraporder.exception.DataException;
import com.car.app.carscraporder.mapper.CarScrapOrderAutopartsMapper;
import com.car.app.carscraporder.pojo.CarScrapOrder;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachment;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachmentExample;
import com.car.app.carscraporder.pojo.CarScrapOrderAudit;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.pojo.TbAttachment;
import com.car.app.carscraporder.pojo.TbDataDic;
import com.car.app.carscraporder.service.CarScrapOrderAttachmentService;
import com.car.app.carscraporder.service.CarScrapOrderAuditService;
import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.service.CarScrapOrderService;
import com.car.app.carscraporder.service.TbAttachmentService;
import com.car.app.carscraporder.service.TbDataDicService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.UUIDUtil;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsKeyWordVO;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsVO;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsWhereParamter;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.carscraporder.vo.CarScrapOrderPictureVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.service.QRCodeService;
import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CarScrapOrderAutopartsServiceImpl extends BaseServiceImpl<CarScrapOrderAutoparts> implements CarScrapOrderAutopartsService {

	@Autowired
	private CarScrapOrderAutopartsMapper carScrapOrderAutopartsMapper;
	
	@Autowired
	private CarScrapOrderAuditService  carScrapOrderAuditService;
	
	@Autowired
	private CarScrapOrderAttachmentService carScrapOrderAttachmentService;
	
	@Autowired
	private  TbDataDicService  tbDataDicService;
	
	@Autowired
	private TbAttachmentService  tbAttachmentService;
	
	
	@Autowired
	private CarScrapOrderService  carScrapOrderService;
	
	@Value("${REPOSITORY_PATH}")
	private  String REPOSITORY_PATH;
	@Value("${PICURL}")
	private String PICURL;
	
	@Value("${BUCKETNAME}")
	private  String BUCKETNAME;
	
	@Value("${ENDPOINT}")
	public  String ENDPOINT;
	
	@Value("${ACCESSKEYID}")
	public  String ACCESSKEYID;
	
	@Value("${ACCESSKEYSECRET}")
	public  String ACCESSKEYSECRET;
	

	
	
	/**
	 * 根据id获取配件业务对象
	 */
	public CarScrapOrderAutopartsBO  queryBOById(String id)throws Exception{
		CarScrapOrderAutopartsBO bo = carScrapOrderAutopartsMapper.queryBOById(id);
		if(bo!=null){
			//
			CarScrapOrderAudit paramter = new CarScrapOrderAudit();
			paramter.setBusinessType(CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS);
			paramter.setOrderId(bo.getId());
			List<CarScrapOrderAudit> audit = carScrapOrderAuditService.queryListByWhere(paramter);
			
			for(CarScrapOrderAudit orderaudit :audit){
				//接收时间
				if(CommonSystemParamter.ORDER_RECEIVE_STATUS == orderaudit.getStauts()){
					
					bo.setReceiveRemark(orderaudit.getRemark());
				}
				//入场时间
	            if(CommonSystemParamter.ORDER_STORAGE_STATUS == orderaudit.getStauts()){
					
					bo.setStorageRemark(orderaudit.getRemark());
				}
	            
	           
			}
			
			fillPrictureToOrder(bo);
		}
		
		
		return bo;
		
	}
	
	
    /**
     * 根据id获取配件的详细信息
     */
	public CarScrapOrderAutopartsDetailBO  getOrderAutopartsDetailById(String id)throws Exception{
		CarScrapOrderAutopartsDetailBO bo = carScrapOrderAutopartsMapper.getOrderAutopartsDetailById(id);
		if(bo!=null){
			//查询无法接收订单原因
			if(bo.getOrderAutopartsStatus()==CommonSystemParamter.PARTS_NO_RECEIVE_STATUS){
				TbDataDic whereParam = new TbDataDic();
				whereParam.setDatatype("Situation");
				whereParam.setDatavalue(bo.getUnableReceiveReason());
				List<TbDataDic> data = tbDataDicService.queryListByWhere(whereParam);
				if(data!=null&& data.size()>0){
					bo.setUnableReceiveReason_str(data.get(0).getDataname());
				}
				
			}
			
			
			
			
			//查询订单审核历史记录列表
			CarScrapOrderAudit paramter = new CarScrapOrderAudit();
			paramter.setBusinessType(CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS);
			paramter.setOrderId(bo.getId());
			List<CarScrapOrderAudit> audit = carScrapOrderAuditService.queryListByWhere(paramter);
			for(CarScrapOrderAudit orderaudit :audit){
				
				if(CommonSystemParamter.ORDER_DISTRIBUTION_STATUS == orderaudit.getStauts()){
					bo.setDispatchRemark(orderaudit.getRemark());
				}
				
				//接收时间
				if(CommonSystemParamter.ORDER_RECEIVE_STATUS == orderaudit.getStauts()){
					bo.setAcceptTime(orderaudit.getAuditTime());
					bo.setReceiveRemark(orderaudit.getRemark());
				}
				//入场时间
	            if(CommonSystemParamter.ORDER_STORAGE_STATUS == orderaudit.getStauts()){
					bo.setStorageTime(orderaudit.getAuditTime());
					bo.setStorageRemark(orderaudit.getRemark());
				}
	            if(CommonSystemParamter.ORDER_SCRAP_STATUS == orderaudit.getStauts()){
					bo.setOutageTime(orderaudit.getAuditTime());
					bo.setOutageRemark(orderaudit.getRemark());
				}
	            
	           if(CommonSystemParamter.ORDER_SETTLEMENT_STATUS == orderaudit.getStauts()){
	        	   bo.setRepaymentTime(orderaudit.getAuditTime());
				}
			}
			
			//查询附件
//			List<CarScrapOrderAttachmentBO> attachmentList = carScrapOrderAttachmentService.getArrachmentByOrderByid(id);
//			if(attachmentList!=null&&attachmentList.size()>0){
//				for(CarScrapOrderAttachmentBO attachment:attachmentList){
//					if(StringUtils.isBlank(attachment.getAttachmentType())) break;
//					List<String> attachement = new ArrayList<String>();
//					 if(attachment.getUrl()!=null){
//						 if(StringUtils.indexOf(attachment.getUrl(), ",")>0){
//							 
//							 String[] paths = StringUtils.split(attachment.getUrl(), ",");
//							 attachement = Arrays.asList(paths);
//						 }else{
//							 attachement.add(attachment.getUrl());
//						 }
//						 fillPrictureToOrder(bo,attachment.getAttachmentType(),attachement);
//					 }
//				}
//				
//			}
//		}
		
		 fillPrictureToOrder(bo);
	    
		}
		return bo;
	}
	
	/**
	 * 根据id获取持久化对象
	 */
    public CarScrapOrderAutoparts queryById(String id){
		
		return carScrapOrderAutopartsMapper.selectByPrimaryKey(id);
	}
    
	/**
	 * 根据订单id获取配件的业务对象
	 */
	public  List<CarScrapOrderAutopartsBO> queryListByOrderId(String orderid)throws Exception{
		List<CarScrapOrderAutopartsBO>  carScrapOrderAutopartsList = carScrapOrderAutopartsMapper.queryListByOrderId(orderid);
		if(carScrapOrderAutopartsList!=null&& carScrapOrderAutopartsList.size()>0){
			for(CarScrapOrderAutopartsBO bo : carScrapOrderAutopartsList){
				
				 fillPrictureToOrder(bo);
				
//				List<CarScrapOrderAttachmentBO> attachmentList = carScrapOrderAttachmentService.getArrachmentByOrderByid(bo.getId());
//				
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
//							
//						 }
//					}
//					
//				}
				
			}
		}
		
		return carScrapOrderAutopartsList;
		
	}
	
	
	
	private void fillPrictureToOrder(CarScrapOrderAutopartsBO bo){
		
		
		//查询配件入库附件
        List<OrderAttachmentBO> attachmentBo1 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.PARTS_PICTURE,CommonSystemParamter.ORDER_OLDPARTS_TYPE);
		
		bo.setAutoPartsPictures(attachmentBo1);
		
		//查询配件接收附件
		List<OrderAttachmentBO> attachmentBo2 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.PARTS_PICTURE_RECEIVE,CommonSystemParamter.ORDER_OLDPARTS_TYPE);
		
		bo.setAutoPartsReceivePictures(attachmentBo2);
		
		//查询配件入库附件
        List<OrderAttachmentBO> attachmentBo3 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.PARTS_PICTURE_WAREHIUSING,CommonSystemParamter.ORDER_OLDPARTS_TYPE);
		
		bo.setAutoPartsWarehousingPictures(attachmentBo3);
		
		
		//查询配件视频附件
		 List<OrderAttachmentBO> attachmentBo4 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.PARTS_VIDEO,CommonSystemParamter.ORDER_OLDPARTS_TYPE);
	
		 bo.setAutoPartsVideo(attachmentBo4);
		 
		 List<OrderAttachmentBO> attachmentBo5 = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.PARTS_SCARP_RECEIVE,CommonSystemParamter.ORDER_OLDPARTS_TYPE);
			
		 bo.setAutoPartsScrapPictures(attachmentBo5);
		 
	}
	      
	
	
	
//	private void fillPrictureToOrder(CarScrapOrderAutopartsBO bo,String attachmentType,List<String> pictures){
//		//配件照片
//		if(StringUtils.equals(attachmentType, CommonSystemParamter.PARTS_PICTURE)){
//			
//			bo.setAutoPartsPictures(pictures);
//		//配件接收照片
//		}else if(StringUtils.equals(attachmentType, CommonSystemParamter.PARTS_PICTURE_RECEIVE)){
//			
//			//查询配件接收附件
//			List<OrderAttachmentBO> attachmentBo = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.PARTS_PICTURE_RECEIVE);
//			
//			bo.setAutoPartsReceivePictures(attachmentBo);
//			//配件入库照片
//		}else if(StringUtils.equals(attachmentType, CommonSystemParamter.PARTS_PICTURE_WAREHIUSING)){
//			List<OrderAttachmentBO> attachmentBo = carScrapOrderAttachmentService.getArrachmentByOrderIdAndAttachmentType(bo.getId(),CommonSystemParamter.PARTS_PICTURE_WAREHIUSING);
//			
//			bo.setAutoPartsWarehousingPictures(attachmentBo);
//		}
//		
//		
//		
//	}
	
	
	/**
	 * 查询分页的配件业务对象
	 */
	public PageInfo<CarScrapOrderPageBO> queryBOPageListByWhere(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception{
		
		if(StringUtils.isNotBlank(paramter.getAraesids())){
			if(StringUtils.indexOf(paramter.getAraesids(), ",")>0){
				String[] arrayAraes = StringUtils.split(paramter.getAraesids(), ",");
				paramter.setAraesidList(Arrays.asList(arrayAraes));
			}else{
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
		List<CarScrapOrderPageBO> pageList = carScrapOrderAutopartsMapper.queryBOPageList(paramter);
		return new PageInfo<CarScrapOrderPageBO>(pageList);
		
	}
	
	/**
	 * 获取待分拣或者待出库的配件
	 */
	public PageInfo<CarScrapOrderPageBO> getSortingParts(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception{
		PageHelper.startPage(page, rows);
		List<CarScrapOrderPageBO> pageList = carScrapOrderAutopartsMapper.getSortingParts(paramter);
		return new PageInfo<CarScrapOrderPageBO>(pageList);
		
		
	
		
		
		
	}
	
	
	public PageInfo<CarScrapOrderPageBO> queryHistoryBOPageList(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception{
		PageHelper.startPage(page, rows);
		List<CarScrapOrderPageBO> pageList = carScrapOrderAutopartsMapper.queryHistoryBOPageList(paramter);
		
		
		return new PageInfo<CarScrapOrderPageBO>(pageList);
		
	}
	
	
	/**
	 * 
	 * orderStatus  3：配件接收 4：配件无法接收 5：配件入库 6:配件出库 7：配件残值发放 8：配件结束 9：配件异常
	 * 配件审核
	 */
	@Override
	public Integer saveOrderAutopartsAuditingRecord(String id, Integer orderStatus,
			String remark,String operator,CarScrapOrderAutoparts parts) throws Exception {
		//根据id获取配件持久化数据
		CarScrapOrderAutoparts pojo = queryById(id);
		
		if(pojo!=null){
			if(pojo.getOrderAutopartsStatus()==CommonSystemParamter.PARTS_END_STATUS||pojo.getOrderAutopartsStatus()==CommonSystemParamter.PARTS_ERROR_STATUS
					||pojo.getOrderAutopartsStatus()==CommonSystemParamter.PARTS_NO_RECEIVE_STATUS){
				return 1;
			}
			
			
			CheckUtil.check(orderStatus>=pojo.getOrderAutopartsStatus(), "param.is.null");
			if(parts!=null){
	   			 BeanUtils.copyProperties(parts, pojo);
	   		 }
			pojo.setOperator(operator);
			
			pojo.setOrderAutopartsStatus(orderStatus);
			//更新配件数据
			super.update(pojo);
			
			Integer orderStauts = getOrderStatusByCalculationPartsStatus(id,pojo.getOrderId(),orderStatus);
		
			//更新订单状态,和订单审核历史记录
			if(orderStauts!=null){
				CarScrapOrder record = carScrapOrderService.queryById(pojo.getOrderId());
				CheckUtil.notNull(record, "param.is.null");
				
				if(orderStauts==CommonSystemParamter.PARTS_SETTLEMENT_STATUS){
					//结算操作多次
					record.setId(pojo.getOrderId());
					record.setOperator(operator);
					record.setOrderStatus(CommonSystemParamter.ORDER_SETTLEMENT_STATUS);
					carScrapOrderService.updateSelective(record);
					carScrapOrderService.saveOrderAuditingRecord(record.getId(), CommonSystemParamter.ORDER_SETTLEMENT_STATUS, null, operator, record);
				}else{
					
					if(orderStauts>record.getOrderStatus()){
						record.setId(pojo.getOrderId());
						record.setOperator(operator);
						record.setOrderStatus(orderStatus);
						carScrapOrderService.updateSelective(record);
						carScrapOrderService.saveOrderAuditingRecord(record.getId(),orderStauts, null, operator, record);
					}
					
				}
				
				
			}
				//新增审核历史记录
				CarScrapOrderAudit auditData = new CarScrapOrderAudit();
				auditData.setOrderId(id);
				auditData.setStauts(orderStatus);
				auditData.setRemark(remark);
				auditData.setBusinessType(CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS);
				auditData.setCreater(operator);
				auditData.setAuditor(operator);
				auditData.setAuditTime(new Date());
				carScrapOrderAuditService.save(auditData);
				
		
			
		
			return 1;
		}
		
		
		
		return 0;
	}
	
	
	private Integer getOrderStatusByCalculationPartsStatus(String partsId,String orderId,Integer operationOrderStatus) throws Exception{
		
		if(CommonSystemParamter.PARTS_RECEIVE_STATUS == operationOrderStatus){
			//配件接收操作
			   //判断其他配件是否有派单状态
			   int jiedancount =getcoutByStauts(CommonSystemParamter.PARTS_RECEIPT_STATUS,orderId,partsId);
			   if(jiedancount==0){
				   return CommonSystemParamter.ORDER_RECEIVE_STATUS;
			   }
			
			
		}else if(CommonSystemParamter.PARTS_NO_RECEIVE_STATUS == operationOrderStatus){
			//配件无法接收
			   //判断其他配件是否有派单状态
			   int jiedancount =getcoutByStauts(CommonSystemParamter.PARTS_RECEIPT_STATUS,orderId,partsId);
			   if(jiedancount==0){
				   //判断其他订单是否全是是无法接单或异常
				   boolean isAllError = judgeIsAllErrorOtherParsByOrderId(orderId,partsId);
				   if(isAllError){
					   //旧件订单更新为异常状态
					   return CommonSystemParamter.PARTS_NO_RECEIVE_STATUS;
				   }else{
					   //
					  return getMinStautsByOtherParts(orderId,partsId,CommonSystemParamter.PARTS_NO_RECEIVE_STATUS);
					   
				   }
				   
			   }
			
		}else if(CommonSystemParamter.PARTS_STORAGE_STATUS == operationOrderStatus){
			//配件入库
			return getMinStautsByOtherParts(orderId,partsId,CommonSystemParamter.PARTS_STORAGE_STATUS);
		}else if(CommonSystemParamter.PARTS_OUT_STORAGE_STATUS == operationOrderStatus){
			//配件出库
			return getMinStautsByOtherParts(orderId,partsId,CommonSystemParamter.PARTS_OUT_STORAGE_STATUS);
		}else if(CommonSystemParamter.PARTS_SETTLEMENT_STATUS == operationOrderStatus){
			//配件结算
			return getMinStautsByOtherParts(orderId,partsId,CommonSystemParamter.PARTS_SETTLEMENT_STATUS);
		}else if(CommonSystemParamter.PARTS_END_STATUS == operationOrderStatus){
			//配件结束
			return getMinStautsByOtherParts(orderId,partsId,CommonSystemParamter.PARTS_END_STATUS);
			
		}
		return null;
		
		
		
	}
	
	private boolean judgeIsAllErrorOtherParsByOrderId(String orderId,String noEquitId) throws Exception{
		boolean flag = true;
		Example example = new Example(CarScrapOrderAutoparts.class);
		Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", orderId);
		criteria.andNotEqualTo("id", noEquitId);
		
		List<CarScrapOrderAutoparts> partsList = super.queryListByExample(example);
		
		for(CarScrapOrderAutoparts parts:partsList){
			if(parts.getOrderAutopartsStatus()!=null){
				if(parts.getOrderAutopartsStatus()!=CommonSystemParamter.PARTS_NO_RECEIVE_STATUS&&parts.getOrderAutopartsStatus()!=CommonSystemParamter.PARTS_ERROR_STATUS){
					return false;
				}
			}
			
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	private Integer getMinStautsByOtherParts(String orderId,String noEquitId,Integer currentOperationStauts) throws Exception{
		
		List<Object> excludeStatus = new ArrayList();
		excludeStatus.add(CommonSystemParamter.PARTS_NO_RECEIVE_STATUS);
		excludeStatus.add(CommonSystemParamter.PARTS_ERROR_STATUS);
		Example example = new Example(CarScrapOrderAutoparts.class);
		Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId", orderId);
		criteria.andNotEqualTo("id", noEquitId);
		criteria.andNotIn("orderAutopartsStatus", excludeStatus);
		List<CarScrapOrderAutoparts> partsList = super.queryListByExample(example);
		
		if(partsList!=null){
			for(CarScrapOrderAutoparts parts:partsList){
				if(parts.getOrderAutopartsStatus()!=null){
					if(parts.getOrderAutopartsStatus()<currentOperationStauts){
						currentOperationStauts =parts.getOrderAutopartsStatus();
					}
				}
			}
			
		}
		
		
		return currentOperationStauts;
		
	}
	
	
	
	
	public int getcoutByStauts(Integer stauts,String orderId,String noEquitId)throws Exception{
		
		CheckUtil.notNull(stauts, "param is null");
		Example example = new Example(CarScrapOrderAutoparts.class);
		Criteria criteria = example.createCriteria();
		        criteria.andEqualTo("orderId", orderId);
				criteria.andNotEqualTo("id", noEquitId);
				criteria.andEqualTo("orderAutopartsStatus", stauts);
		return super.selectCountByExample(example);
		
		
		
	}
	
	
	public Integer  saveAutoparts(CarScrapOrderAutopartsVO  carScrapOrderAutopartsVO)throws Exception{
		
		CheckUtil.notNull(carScrapOrderAutopartsVO, "param.is.null");
		
		
		if(carScrapOrderAutopartsVO.getId()==null){
			String id = UUIDUtil.getUUID();
			//获取上传的图片信息
			List<CarScrapOrderPictureVO> pictures = carScrapOrderAutopartsVO.getPictures();
			if(pictures!=null&& pictures.size()>0){
				for(CarScrapOrderPictureVO picture:pictures){
					if(StringUtils.equals(picture.getPritureCategory(), "1")){
						if(StringUtils.isNotBlank(picture.getAttachmentId())){
					    		 CarScrapOrderAttachment attachment = new CarScrapOrderAttachment();
					    		 attachment.setAttachmentId(Integer.parseInt(picture.getAttachmentId()));
					    		 attachment.setOrderId(id);
					    		 attachment.setOrderType(CommonSystemParamter.ORDER_OLDPARTS_TYPE);
					    		 attachment.setAttachmentType(picture.getPritureCategory());
					    		 attachment.setCarPictureType(picture.getPritureType());
					    		 carScrapOrderAttachmentService.insert(attachment);
						} 
						
					}
					
				}
			}
			CarScrapOrderAutoparts record = new CarScrapOrderAutoparts();
			BeanUtils.copyProperties(carScrapOrderAutopartsVO, record);
			record.setOrderAutopartsStatus(CommonSystemParamter.PARTS_CREATE_STATUS);
			record.setId(id);
			
			//保存历史记录
			CarScrapOrderAudit auditData = new CarScrapOrderAudit();
			auditData.setOrderId(id);
			auditData.setStauts(CommonSystemParamter.PARTS_CREATE_STATUS);
			auditData.setAuditor(carScrapOrderAutopartsVO.getCreater());
			auditData.setAuditTime(new Date());
			auditData.setRemark("下单");
			auditData.setBusinessType(CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS);
			auditData.setCreater(record.getCreater());
			carScrapOrderAuditService.save(auditData);
			
			
			//String picurl = this.GenerateQRcode(record.getId());
			
		   //	record.setQrPic(picurl);
			
			//保存配件信息
			return super.save(record);
		}
		
		
		return 0;
		
		
		
	}
	
	private String getUrl(String relativePath){
		 String picUrl = StringUtils.replace(
	                StringUtils.substringAfter(relativePath, REPOSITORY_PATH), "\\", "/");
		 
		 
		 picUrl =  PICURL+picUrl;
		 return picUrl;
	}
	
	
	private  String getFilePath(String sourceFileName) {
        String baseFolder = REPOSITORY_PATH+ File.separator + "images";
        Date nowDate = new Date();
        String fileFolder = baseFolder + File.separator + new DateTime(nowDate).toString("yyyy")
                + File.separator + new DateTime(nowDate).toString("MM") + File.separator
                + new DateTime(nowDate).toString("dd");
        File file = new File(fileFolder);
        if (!file.isDirectory()) {
            // 如果目录不存在，则创建目录
            file.mkdirs();
        }
        // 生成新的文件名
        String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS")
                + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
        
        return fileFolder + File.separator + fileName;
    }
	
	
	public Integer queryPendingOrder(String agentUserid,Integer partsStauts,List<String> areasids,Boolean isSorting)throws Exception{
		
		
		return  carScrapOrderAutopartsMapper.queryPendingOrder(agentUserid,partsStauts,areasids,isSorting);
	}
	
	private  String GenerateQRcode(String partsid) throws Exception{
		String storagePath = getFilePath(partsid+".png");
		
		//生成配件的二维码图片
		QRCodeService.generateQRCode(partsid,200,200,"png",storagePath);
		String picurl = getUrl(storagePath);
		
		return picurl;
	}
	
	
	public String createQRcode(String partsid)throws Exception{
		if(StringUtils.isNoneBlank(partsid)){
			return this.GenerateQRcode(partsid);
		}
		return partsid;
		
	}
	
	public Boolean saveSortingParts(String id,Integer sortingStatus, String operator)throws Exception{
		//修改配件信息
		CarScrapOrderAutoparts parts = this.queryById(id);
		if(parts!=null){
			CheckUtil.check(parts.getOrderAutopartsStatus()==CommonSystemParamter.PARTS_STORAGE_STATUS,"param is null");
			parts.setOperator(operator);
			parts.setSortingState(sortingStatus);
			this.update(parts);
			
			//新增审核记录
			CarScrapOrderAudit auditData = new CarScrapOrderAudit();
			auditData.setOrderId(id);
			auditData.setStauts(parts.getSortingState());
			auditData.setAuditor(parts.getOperator());
			auditData.setAuditTime(new Date());
			auditData.setRemark("配件分拣");
			auditData.setBusinessType(CommonSystemParamter.BUSINESS_TYPE_AUTOPARTS);
			auditData.setCreater(parts.getOperator());
			carScrapOrderAuditService.save(auditData);
			return true;
			
			
		}
		
		
		return false;
		
	}


	@Override
	public OrderAttachmentBO importFile(MultipartFile file,String id) throws Exception {
		OrderAttachmentBO bo = new OrderAttachmentBO();
	      
		CarScrapOrderAutoparts parts = this.queryById(id);
		OSSClient  oSSClient = null;
		try{
			if(parts!=null){
				//上传视频的原始名称
				String originalName = file.getOriginalFilename();
				//截取视频的后缀
				
				String fileName = new DateTime(new Date()).toString("yyyyMMddhhmmssSSSS")
		                + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(originalName, ".");
				
				  oSSClient = new OSSClient(ENDPOINT,ACCESSKEYID,ACCESSKEYSECRET);
				
				oSSClient.putObject(BUCKETNAME, fileName, file.getInputStream());
				
				oSSClient.shutdown();
				
				String accessPath = getOSSUrl(fileName);
				
				TbAttachment record = new TbAttachment();
				record.setIsvalid(true);
				record.setOriginalName(originalName);
				record.setStoragePath(accessPath);
				record.setOssKey(fileName);
				record = tbAttachmentService.saveReturnPersistentObject(record);
				
				CarScrapOrderAttachment carScrapOrderAttachment = new CarScrapOrderAttachment();
				carScrapOrderAttachment.setAttachmentId(record.getId());
				carScrapOrderAttachment.setAttachmentType("10");
				carScrapOrderAttachment.setCarPictureType(null);
				carScrapOrderAttachment.setIsvalid(true);
				carScrapOrderAttachment.setOrderId(id);
				carScrapOrderAttachment.setOrderType(CommonSystemParamter.ORDER_OLDPARTS_TYPE);
				carScrapOrderAttachmentService.insert(carScrapOrderAttachment);
				bo.setId(carScrapOrderAttachment.getId());
				bo.setUrl(accessPath);
				return bo;
				
			}else{
				throw new CheckException("请求参数错误");
			}
		}finally {
			  if(oSSClient!=null){
				  oSSClient.shutdown();
			  }
	            
	       
		  }
		
		
		
	}
	
	
	
	
//	public Boolean importFile2(MultipartFile file,String id) throws Exception {
//	      
//      CarScrapOrderAutoparts parts = this.queryById(id);
//		
//		if(parts!=null){
//			//上传视频的原始名称
//			String originalName = file.getOriginalFilename();
//			//截取视频的后缀
//			
//			String fileName = new DateTime(new Date()).toString("yyyyMMddhhmmssSSSS")
//	                + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(originalName, ".");
//			
//			OSSClient  ossClient = new OSSClient(ENDPOINT,ACCESSKEYID,ACCESSKEYSECRET);
//			
//			
//			/* 步骤1：初始化一个分片上传事件。
//			*/
//			InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(BUCKETNAME, fileName);
//			InitiateMultipartUploadResult result = ossClient.initiateMultipartUpload(request);
//			// 返回uploadId，它是分片上传事件的唯一标识，您可以根据这个ID来发起相关的操作，如取消分片上传、查询分片上传等。
//			String uploadId = result.getUploadId();
//			
//			
//			/* 步骤2：上传分片。
//			*/
//			// partETags是PartETag的集合。PartETag由分片的ETag和分片号组成。
//			List<PartETag> partETags =  new ArrayList<PartETag>();
//			// 计算文件有多少个分片。
//			final long partSize = 1 * 1024 * 1024L;   // 1MB
//			long fileLength = file.getSize();
//			int partCount = (int) (fileLength / partSize);
//			if (fileLength % partSize != 0) {
//			    partCount++;
//			 }
//			// 遍历分片上传。
//			for (int i = 0; i < partCount; i++) {
//			    long startPos = i * partSize;
//			    long curPartSize = (i + 1 == partCount) ? (fileLength - startPos) : partSize;
//			    InputStream instream = file.getInputStream();
//			    // 跳过已经上传的分片。
//			    instream.skip(startPos);
//			    UploadPartRequest uploadPartRequest = new UploadPartRequest();
//			    uploadPartRequest.setBucketName(BUCKETNAME);
//			    uploadPartRequest.setKey(fileName);
//			    uploadPartRequest.setUploadId(uploadId);
//			    uploadPartRequest.setInputStream(instream);
//			    // 设置分片大小。除了最后一个分片没有大小限制，其他的分片最小为100KB。
//			    uploadPartRequest.setPartSize(curPartSize);
//			    // 设置分片号。每一个上传的分片都有一个分片号，取值范围是1~10000，如果超出这个范围，OSS将返回InvalidArgument的错误码。
//			    uploadPartRequest.setPartNumber( i + 1);
//				// 每个分片不需要按顺序上传，甚至可以在不同客户端上传，OSS会按照分片号排序组成完整的文件。
//			    UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
//				// 每次上传分片之后，OSS的返回结果会包含一个PartETag。PartETag将被保存到partETags中。
//			    partETags.add(uploadPartResult.getPartETag());
//			}
//			
//			/* 步骤3：完成分片上传。
//			*/
//			// 排序。partETags必须按分片号升序排列。
//			Collections.sort(partETags, new Comparator<PartETag>() {
//			    public int compare(PartETag p1, PartETag p2) {
//			        return p1.getPartNumber() - p2.getPartNumber();
//			    }
//			});
//			// 在执行该操作时，需要提供所有有效的partETags。OSS收到提交的partETags后，会逐一验证每个分片的有效性。当所有的数据分片验证通过后，OSS将把这些分片组合成一个完整的文件。
//			CompleteMultipartUploadRequest completeMultipartUploadRequest =
//			        new CompleteMultipartUploadRequest(BUCKETNAME, fileName, uploadId, partETags);
//			ossClient.completeMultipartUpload(completeMultipartUploadRequest);
//			
//			
//			ossClient.shutdown();
//			
//			String accessPath = getOSSUrl(fileName);
//			
//			TbAttachment record = new TbAttachment();
//			record.setIsvalid(true);
//			record.setOriginalName(originalName);
//			record.setStoragePath(accessPath);
//			record = tbAttachmentService.saveReturnPersistentObject(record);
//			
//			CarScrapOrderAttachment carScrapOrderAttachment = new CarScrapOrderAttachment();
//			carScrapOrderAttachment.setAttachmentId(record.getId());
//			carScrapOrderAttachment.setAttachmentType("10");
//			carScrapOrderAttachment.setCarPictureType(null);
//			carScrapOrderAttachment.setIsvalid(true);
//			carScrapOrderAttachment.setOrderId(id);
//			carScrapOrderAttachment.setOrderType(CommonSystemParamter.ORDER_OLDPARTS_TYPE);
//			return 1==carScrapOrderAttachmentService.insert(carScrapOrderAttachment);
//			
//		}
//		
//		return false;
//	}
	
	
	/**
	 * 获得url链接
	 * 
	 * @param key
	 * @return
	 */
	private  String getOSSUrl(String key) {
		 OSSClient ossClient = null;
		try{
			 // 设置URL过期时间为10年 3600l* 1000*24*365*10
		    Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24
		            * 365 * 10);
		    // 生成URL
		    // 初始化OSSClient
		     ossClient = new OSSClient(ENDPOINT,ACCESSKEYID,ACCESSKEYSECRET);
		    java.net.URL url = ossClient.generatePresignedUrl(BUCKETNAME, key, expiration);
		    if (url != null) {
		        return url.toString();
			}
		  }finally {
			  if(ossClient!=null){
				  ossClient.shutdown();
			  }
	            
	       
		  }
	
	   
	    return null;

	}

	
	
	public Integer selectCount(CarScrapOrderKeywordVO paramter)throws Exception {
		
		return carScrapOrderAutopartsMapper.selectPartCount(paramter);
	}
	
	public boolean removeFile(Integer attachmentId, String operator)throws Exception {
		//根据id获取订单附件数据
		OSSClient  ossClient = null;
		try{
			CarScrapOrderAttachmentExample example  = new CarScrapOrderAttachmentExample();
			com.car.app.carscraporder.pojo.CarScrapOrderAttachmentExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(attachmentId);
			criteria.andAttachmentTypeEqualTo("10");
			List<CarScrapOrderAttachment> carScrapOrderAttachments =  carScrapOrderAttachmentService.selectByExample(example);
			if(carScrapOrderAttachments!=null&&carScrapOrderAttachments.size()>0){
				CarScrapOrderAttachment carScrapOrderAttachment = carScrapOrderAttachments.get(0);
				carScrapOrderAttachment.setIsvalid(false);
				carScrapOrderAttachmentService.updateByPrimaryKey(carScrapOrderAttachment);
				TbAttachment record  = tbAttachmentService.queryById(carScrapOrderAttachment.getAttachmentId());
				
				if(record!=null){
					record.setIsvalid(false);
					record.setOperator(operator);
					tbAttachmentService.update(record);
					
					 String ossKey = record.getOssKey();
					 ossClient = new OSSClient(ENDPOINT,ACCESSKEYID,ACCESSKEYSECRET);
					 ossClient.deleteObject(BUCKETNAME, ossKey);
					 
					 return true;
				}
				
				
			}
		}finally {
			  if(ossClient!=null){
				  ossClient.shutdown();
			  }
	            
	       
		  }
		
		
		
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
