package com.car.app.carscraporder.controller.external;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsDetailBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.http.DataConverter;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.systemparameter.CommonSystemParamter;
import com.car.app.carscraporder.util.CheckUtil;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsVO;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/external/autoparts")
@Api(value = "External-AUTOPARTS-API",tags={"配件操作接口"})
public class CarScrapOrderAutopartsExternalController {
	
	@Autowired
	private CarScrapOrderAutopartsService carScrapOrderAutopartsService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件分页列表",notes = "获取用户分页列表")
	public ResultBean<PageResult<CarScrapOrderPageBO>> getCarScrapOrderAutopartsList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		    
			    PageResult pageResult  = new PageResult();
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderAutopartsService.queryBOPageListByWhere(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	
	
	/**
	 * 获取待分拣和待入库数据
	 * @param page
	 * @param rows
	 * @param paramter
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getSortingParts",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件分页列表",notes = "获取用户分页列表")
	public ResultBean<PageResult<CarScrapOrderPageBO>> getSortingParts(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		    
			    PageResult pageResult  = new PageResult();
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderAutopartsService.getSortingParts(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean(pageResult);
		
		
	}
	
	
	@RequestMapping(value="/history",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件分页列表",notes = "获取用户分页列表")
	public ResultBean<PageResult<CarScrapOrderPageBO>> getHistoryList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		    
		 PageResult pageResult  = new PageResult();
	     PageInfo<CarScrapOrderPageBO> pageInfo =   carScrapOrderAutopartsService.queryHistoryBOPageList(page, rows, paramter);
	     pageResult.setRows(pageInfo.getList());
	     pageResult.setTotal(pageInfo.getTotal()); 
		     return new ResultBean(pageResult);
		
		
	}
	
	
	
	/**
	 * 根据订单id查询配件列表
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="?orderid={orderId}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据订单id获取配件详情",notes = "根据订单id获取配件详情")
	public ResultBean<List<CarScrapOrderAutopartsBO>> queryListByOrderId(@PathVariable("orderId")String orderId) throws Exception{
		List<CarScrapOrderAutopartsBO> data = carScrapOrderAutopartsService.queryListByOrderId(orderId);
		return  new ResultBean<List<CarScrapOrderAutopartsBO>>(data);
		
	}
	
	
	/**
	 * 根据配件id获取配件简单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据配件id获取配件详情",notes = "根据配件id获取配件详情")
	public ResultBean<CarScrapOrderAutopartsBO> getOrderAutopartsBOById(@PathVariable("id")String id) throws Exception{
		
		return  new ResultBean<CarScrapOrderAutopartsBO>(carScrapOrderAutopartsService.queryBOById(id));
		
	}
	
	/**
	 * 根据订单id获取配件详情
	 * @param id
	 * @param carScrapOrderVo
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}/detail",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<CarScrapOrderAutopartsDetailBO> getOrderAutopartsDetailById(@PathVariable("id")String id) throws Exception{
		
		return  new ResultBean<CarScrapOrderAutopartsDetailBO>(carScrapOrderAutopartsService.getOrderAutopartsDetailById(id));
		
	}
	
	
	/**
	 * 根据id更新配件信息
	 * @param id
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseBody
	public ResultBean<Boolean> updateAutoParts(@PathVariable("id")String id,@Validated CarScrapOrderAutopartsVO carScrapOrderVo,BindingResult bindingResult,
			HttpServletRequest request) throws Exception{
		CarScrapOrderAutoparts carScrapOrderAutoparts = carScrapOrderAutopartsService.queryById(id);
//		CarScrapOrderAutoparts pojo = new CarScrapOrderAutoparts();
//		BeanUtils.copyProperties(carScrapOrderVo, pojo);
//		pojo.setCreater(carScrapOrderAutoparts.getCreater());
//		pojo.setCreatetime(carScrapOrderAutoparts.getCreatetime());
		
		
		if(carScrapOrderAutoparts!=null){
			 carScrapOrderAutoparts = DataConverter.copyRequestParamToCarScrapOrderAutopartsdel(carScrapOrderAutoparts,request);
			 //判断是否生成二维码
			 if(StringUtils.isBlank(carScrapOrderAutoparts.getQrPic())){
				 String picurl = carScrapOrderAutopartsService.createQRcode(carScrapOrderAutoparts.getId());
					
				 carScrapOrderAutoparts.setQrPic(picurl);
			 }
		}
		
		
		return new ResultBean<Boolean>(carScrapOrderAutopartsService.update(carScrapOrderAutoparts)==1);
		
	}
	
	
	/**
	 * 根据ID删除配件
	 * @param id
	 * @param operator
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> deleteAutoPartsById(@PathVariable("id")String id,@RequestParam(value="operator",required = true)String operator) throws Exception{
	    CarScrapOrderAutoparts carScrapOrderAutoparts = carScrapOrderAutopartsService.queryById(id);
	    carScrapOrderAutoparts.setOperator(operator);
	    carScrapOrderAutoparts.setIsValid(false);
		return new ResultBean<Boolean>(carScrapOrderAutopartsService.update(carScrapOrderAutoparts)==1);
		
	}
	
	
	/**
	 * 订单审核
	 * @param id  配件id
	 * @param orderStatus 审核状态
	 * @param remark  审核备注
	 * @param operator 数据操作人
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/audit/{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "配件审核",notes = "配件审核")
	public ResultBean<Boolean> saveOrderAuditingRecord(@PathVariable("id")String id,
			@RequestParam(required = true)Integer auditorderStatus,
			@RequestParam(value="auditRemark",required = false)String auditRemark,@RequestParam(value="auditer")String auditer,CarScrapOrderAutopartsVO vo,HttpServletRequest request) throws Exception{
		
	     
	     CarScrapOrderAutoparts parts = carScrapOrderAutopartsService.queryById(id);
	     if(parts!=null){
	    	 if(auditorderStatus!= CommonSystemParamter.PARTS_NO_RECEIVE_STATUS){
	    		 vo.setUnableReceiveReason(null);
	    	 }else{
	    		 CheckUtil.notNull(vo.getUnableReceiveReason(), "param.is.null");
	    	 }
	    	 
	    	 
	    	 parts = DataConverter.copyRequestParamToCarScrapOrderAutopartsdel(parts,request);
	    	 parts.setOperator(auditer);
	    	 int result = carScrapOrderAutopartsService.saveOrderAutopartsAuditingRecord(id,auditorderStatus,auditRemark,auditer,parts);
	    	 return new ResultBean<Boolean>(result==1);
	     }
	     
	     return new ResultBean(false);
	     
		
		
	}
	
	@RequestMapping(value = "/queryToDoHndleParts",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询待处理的订单数",notes = "审核订单")
	public ResultBean<Integer> queryPendingOrder(String agentUserid,Integer partsStauts,String areas,Boolean isSorting)throws Exception{
		
		List<String> areasArray = new ArrayList<String>();
		if(StringUtils.isNotBlank(areas)){
			String[] areasids = StringUtils.split(areas, ",");
			areasArray = Arrays.asList(areasids);
		}
		if(CommonSystemParamter.PARTS_RECEIPT_STATUS==partsStauts){
			//待接收
			Integer count = carScrapOrderAutopartsService.queryPendingOrder(agentUserid, partsStauts, areasArray,null);
			return new ResultBean<Integer>(count);
		}else if (CommonSystemParamter.PARTS_RECEIVE_STATUS==partsStauts){
			//待入库
			Integer count = carScrapOrderAutopartsService.queryPendingOrder(null, partsStauts, areasArray,null);
			return new ResultBean<Integer>(count);
		}else if (6==partsStauts){
			//待分拣
			Integer count = carScrapOrderAutopartsService.queryPendingOrder(null, 5, areasArray,false);
			return new ResultBean<Integer>(count);
		}else if (CommonSystemParamter.PARTS_STORAGE_STATUS==partsStauts){
			//待出库
			Integer count = carScrapOrderAutopartsService.queryPendingOrder(null, partsStauts, areasArray,true);
			return new ResultBean<Integer>(count);
		}
		
		
		
		
		
		
		 return new ResultBean<Integer>(0);
		
	}
	
	@RequestMapping(value = "/sorting/{id}",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "配件分拣",notes = "配件分拣")
	public ResultBean<Boolean> sortingParts(@PathVariable("id")String id,
			@RequestParam(required = true)Integer sortingStatus,@RequestParam(required = true)String operator,
			HttpServletRequest request) throws Exception{
		
		CarScrapOrderAutoparts parts = carScrapOrderAutopartsService.queryById(id);
		 if(parts!=null){
			 
		  return new ResultBean(carScrapOrderAutopartsService.saveSortingParts(id, sortingStatus, operator));
			
		}
		
		  return new ResultBean(false);
		
	}
	
	

}
