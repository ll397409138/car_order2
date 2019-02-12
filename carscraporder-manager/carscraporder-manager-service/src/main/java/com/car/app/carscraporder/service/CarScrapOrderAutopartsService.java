package com.car.app.carscraporder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.car.app.carscraporder.bo.CarScrapOrderAutopartsBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsDetailBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsPageBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.OrderAttachmentBO;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsKeyWordVO;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsVO;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsWhereParamter;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 类名称：CarScrapOrderAutopartsService   
 * 类描述：汽车配件服务类   
 * 创建人：刘子亮
 * 创建时间：2018年10月9日 下午4:22:28      
 * @version  V1.0
 *
 */
public interface CarScrapOrderAutopartsService extends BaseService<CarScrapOrderAutoparts>{
	
	
	
	
	
	public CarScrapOrderAutoparts queryById(String id);
	
	public CarScrapOrderAutopartsBO  queryBOById(String id)throws Exception;
	
	
	public Integer  saveAutoparts(CarScrapOrderAutopartsVO  carScrapOrderAutopartsVO)throws Exception;
	
	public CarScrapOrderAutopartsDetailBO  getOrderAutopartsDetailById(String id)throws Exception;
	
	
	public  List<CarScrapOrderAutopartsBO> queryListByOrderId(String orderid)throws Exception;
	
	
	public PageInfo<CarScrapOrderPageBO> queryBOPageListByWhere(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception;
	
	/**
	 * 获取待分拣和待入库数据
	 * @param page
	 * @param rows
	 * @param paramter
	 * @return
	 * @throws Exception
	 */
	public PageInfo<CarScrapOrderPageBO> getSortingParts(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception;
	
	
	public PageInfo<CarScrapOrderPageBO> queryHistoryBOPageList(Integer page,Integer rows, CarScrapOrderKeywordVO paramter)throws Exception;
	/**
	 * 
	 * @param id  配件主键
	 * @param orderStatus 审核状态
	 * @param remark 审核备注
	 * @param operator 审核人
	 * @return
	 * @throws Exception
	 */
	public Integer saveOrderAutopartsAuditingRecord(String id,Integer orderStatus,String remark,String operator,CarScrapOrderAutoparts parts)throws Exception;
	
	
	
	public Integer queryPendingOrder(String agentUserid,Integer partsStauts,List<String> areasids,Boolean isSorting)throws Exception;
	
	public String createQRcode(String partsid)throws Exception;
	
	public Boolean saveSortingParts(String id,Integer sortingStatus, String operator)throws Exception;
	
	public OrderAttachmentBO importFile(MultipartFile file,String id)throws Exception ;
	
	
	public Integer selectCount(CarScrapOrderKeywordVO paramter)throws Exception ;
	
	
	public boolean removeFile(Integer attachmentId, String operator)throws Exception ;
	

}
