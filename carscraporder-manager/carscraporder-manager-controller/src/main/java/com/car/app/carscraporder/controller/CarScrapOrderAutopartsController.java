package com.car.app.carscraporder.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsBO;
import com.car.app.carscraporder.bo.CarScrapOrderAutopartsDetailBO;
import com.car.app.carscraporder.bo.CarScrapOrderPageBO;
import com.car.app.carscraporder.bo.OrderAttachmentBO;
import com.car.app.carscraporder.bo.UserBO;
import com.car.app.carscraporder.exception.UnloginException;
import com.car.app.carscraporder.http.DataConverter;
import com.car.app.carscraporder.pojo.CarScrapOrderAutoparts;
import com.car.app.carscraporder.pojo.User;
import com.car.app.carscraporder.service.CarScrapOrderAutopartsService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.util.UserUtil;
import com.car.app.carscraporder.vo.CarScrapOrderAutoPartsSetAmountVO;
import com.car.app.carscraporder.vo.CarScrapOrderAutopartsVO;
import com.car.app.carscraporder.vo.CarScrapOrderKeywordVO;
import com.car.app.carscraporder.vo.PartsSetAmountVO;
import com.car.app.common.bean.PageResult;
import com.car.app.common.bean.ResultBean;
import com.car.app.common.exception.DataException;
import com.car.app.common.exception.FileTooLargeException;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/autoparts")
@Api(value = "AUTOPARTS-API",tags={"配件操作接口"})
public class CarScrapOrderAutopartsController {
	
	@Autowired
	private CarScrapOrderAutopartsService carScrapOrderAutopartsService;
	
	/**
	 * 配件分页列表
	 * @param page
	 * @param rows
	 * @param paramter
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "获取配件分页列表",notes = "获取配件分页列表")
	public ResultBean<PageResult<CarScrapOrderPageBO>> getUserList(
			@ApiParam(name = "page", value = "分页参数页码",required = true)
			@RequestParam(value="page",required = true,defaultValue="1")Integer page,
			@ApiParam(name = "rows", value = "分页参数每页数据条数",required = true)
			@RequestParam(value="rows",required = true,defaultValue="10")Integer rows,
			CarScrapOrderKeywordVO paramter) throws Exception{
		      UserBO user = UserUtil.getUser();
		      if(user==null){
	               throw new UnloginException();
                }  
		      
		       if(!user.getIsAllDataPermisssion()) paramter.setAraesids(user.getAreasids());
		      
			    PageResult<CarScrapOrderPageBO> pageResult  = new PageResult<CarScrapOrderPageBO>();
			    PageInfo<CarScrapOrderPageBO> pageInfo =  carScrapOrderAutopartsService.queryBOPageListByWhere(page, rows, paramter);
			    pageResult.setRows(pageInfo.getList());
			    pageResult.setTotal(pageInfo.getTotal());
		     return new ResultBean<PageResult<CarScrapOrderPageBO>>(pageResult);
		
		
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
	 * 根据配件id获取配件详情（包含订单信息）
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
	public ResultBean<Integer> updateOrder(@PathVariable("id")String id,@Validated CarScrapOrderAutopartsVO carScrapOrderVo,BindingResult bindingResult
			,HttpServletRequest request) throws Exception{
		
		CarScrapOrderAutoparts carScrapOrderAutoparts = carScrapOrderAutopartsService.queryById(id);
		if(carScrapOrderAutoparts!=null){
			 carScrapOrderAutoparts = DataConverter.copyRequestParamToCarScrapOrderAutopartsdel(carScrapOrderAutoparts,request);
			 //判断是否生成二维码
			 if(StringUtils.isBlank(carScrapOrderAutoparts.getQrPic())){
				 String picurl = carScrapOrderAutopartsService.createQRcode(carScrapOrderAutoparts.getId());
					
				 carScrapOrderAutoparts.setQrPic(picurl);
			 }
			 
	    	 return new ResultBean<Integer>(carScrapOrderAutopartsService.update(carScrapOrderAutoparts));
	  
		}
		return new ResultBean(null);
		
		
		
	}
	
	@RequestMapping(value = "setAmount",method = RequestMethod.PUT)
	@ResponseBody
	public ResultBean<Boolean> setAmount(@RequestBody CarScrapOrderAutoPartsSetAmountVO carScrapOrderVo) throws Exception{
		UserBO user = UserUtil.getUser();
	      if(user==null){
             throw new UnloginException();
          }  
		
		
		for(PartsSetAmountVO parts:carScrapOrderVo.getParts()){
			
			CarScrapOrderAutoparts carScrapOrderAutoparts = new CarScrapOrderAutoparts();
			BeanUtils.copyProperties(parts, carScrapOrderAutoparts);
			carScrapOrderAutoparts.setOperator(user.getId());
			carScrapOrderAutopartsService.updateSelective(carScrapOrderAutoparts);
		}
		
		
		return new ResultBean<Boolean>(true);
		
		
		
	}
	
	/**
	 * 根据配件id删除配件
	 * @param id
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Integer> deleteAutoParts(@PathVariable("id")String id) throws Exception{
		
		CarScrapOrderAutoparts carScrapOrderAutoparts = carScrapOrderAutopartsService.queryById(id);
		
		User u = UserUtil.getUser();
		carScrapOrderAutoparts.setOperator(u.getId());
		carScrapOrderAutoparts.setIsValid(false);
		
		
		
		return new ResultBean<Integer>(carScrapOrderAutopartsService.update(carScrapOrderAutoparts));
		
	}
	
	/**
	 * 根据订单id获取配件列表
	 * @param id
	 * @param u
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="listbyorderid",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<CarScrapOrderAutopartsBO>> queryAutoPartsByOrderId(@RequestParam(required=true,value="orderid")String orderId) throws Exception{
		
		
		return new ResultBean<List<CarScrapOrderAutopartsBO>>(carScrapOrderAutopartsService.queryListByOrderId(orderId));
		
	}
	
	
	
	
	/**
	 * 配件订单审核
	 * @param id
	 * @param orderStatus
	 * @param remark
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/audit/{id}",method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "配件审核",notes = "配件审核")
	public ResultBean<Boolean> saveOrderAuditingRecord(@PathVariable("id")String id,
			@RequestParam(required = true)Integer auditorderStatus,
			@RequestParam(value="auditRemark")String auditRemark,CarScrapOrderAutopartsVO vo,HttpServletRequest request) throws Exception{
		User user = UserUtil.getUser();
	     if(user == null){
	    	 throw new DataException("未登录系统");
	     }  
	     
	     CarScrapOrderAutoparts parts = carScrapOrderAutopartsService.queryById(id);
	     if(parts!=null){
	    	 parts = DataConverter.copyRequestParamToCarScrapOrderAutopartsdel(parts,request);
	    	 int result = carScrapOrderAutopartsService.saveOrderAutopartsAuditingRecord(id,auditorderStatus,auditRemark,user.getId(),parts);
	    	 return new ResultBean<Boolean>(result==1);
	     }
	     
	     return new ResultBean(true);
	     
		
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "新增配件",notes = "新增配件")
	public ResultBean<Boolean> saveOrderPartsRecord(CarScrapOrderAutopartsVO vo) throws Exception{
		User user = UserUtil.getUser();
	     if(user == null){
	    	 throw new DataException("未登录系统");
	     }  
	     
	     int result = carScrapOrderAutopartsService.saveAutoparts(vo);
	     
	     return new ResultBean<Boolean>(result==1);
	     
		
		
	}
	
	
	@RequestMapping(value="/importFile",method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "上传视频",notes = "上传视频")
	public ResultBean<OrderAttachmentBO> importFile(@RequestParam(value="file",required = true) MultipartFile file, 
			@RequestParam(required = true)String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
		if(file.getSize()==0){
			throw new DataException("附件不能为空");
		}
		
		if(file.getSize()>20971520){
			throw new FileTooLargeException("上传附件过大");
		}
		
		if(file!=null){
			return new ResultBean<OrderAttachmentBO>(carScrapOrderAutopartsService.importFile(file,id));
		}
		
	
		
		return new ResultBean(null);
	     
		
		
	}
	
	@RequestMapping(value="/removeFile",method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "上传视频",notes = "上传视频")
	public ResultBean<Boolean> removeFile(@RequestParam(required = true,value="attachmentId")Integer attachmentId,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		User user = UserUtil.getUser();
	     if(user == null){
	    	 throw new DataException("未登录系统");
	     }  
	     
	     return new ResultBean<Boolean>(carScrapOrderAutopartsService.removeFile(attachmentId, user.getId()));
	
		
	
	     
		
		
	}
	
	

}
