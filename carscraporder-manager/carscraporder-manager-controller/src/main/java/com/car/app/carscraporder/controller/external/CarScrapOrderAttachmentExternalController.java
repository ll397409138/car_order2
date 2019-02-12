package com.car.app.carscraporder.controller.external;

import io.swagger.annotations.Api;













import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.app.carscraporder.bo.AttachmentBO;
import com.car.app.carscraporder.pojo.CarScrapOrderAttachment;
import com.car.app.carscraporder.pojo.TbAttachment;
import com.car.app.carscraporder.service.CarScrapOrderAttachmentService;
import com.car.app.carscraporder.service.TbAttachmentService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.carscraporder.vo.AttachmentVO;
import com.car.app.common.bean.ResultBean;




@Controller
@RequestMapping(value="/external/carattachment")
@Api(value = "External-ATTACHMENT-API",tags={"汽车相关附件"})
public class CarScrapOrderAttachmentExternalController {
	
	@Autowired
	private TbAttachmentService tbAttachmentService;
	
	
	@Autowired
	private CarScrapOrderAttachmentService carScrapOrderAttachmentService;

	
	@RequestMapping(value="{buniessid}",method = RequestMethod.PUT)
	@ResponseBody
	public ResultBean<AttachmentBO> saveAttachmentBuniessData(@RequestBody AttachmentVO vo)throws Exception{
		AttachmentBO bo = new AttachmentBO();
		if(vo!=null){
			
				
				TbAttachment record = new TbAttachment();
				record.setOriginalName(vo.getOriginalName());
				record.setStoragePath(vo.getStoragePath());
				TbAttachment prsistentPojo = tbAttachmentService.saveReturnPersistentObject(record);
				bo.setId(prsistentPojo.getId());
				
				CarScrapOrderAttachment orderAttachment = new 	CarScrapOrderAttachment();
				orderAttachment.setAttachmentId(prsistentPojo.getId());
				orderAttachment.setOrderType(vo.getBusinessType());
				orderAttachment.setAttachmentType(vo.getPictureType());
				orderAttachment.setCarPictureType(vo.getPicturePecialType());
				orderAttachment.setOrderId(vo.getBuniessid());
				int result = carScrapOrderAttachmentService.insert(orderAttachment);
				bo.setBusinessId(orderAttachment.getId());
				return new ResultBean<AttachmentBO>(bo);
					
				
			
		}
		return new ResultBean(null);
		
		
	}
	
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> deleteByCarScrapAttachmentid(@PathVariable("id")Integer id)throws Exception{
		//根据id查询carscraporderattachment
		CarScrapOrderAttachment carScrapOrderAttachment = carScrapOrderAttachmentService.selectByPrimaryKey(id);
		if(carScrapOrderAttachment!=null){
			//删除carScrapOrderAttachment
			carScrapOrderAttachment.setIsvalid(false);
			carScrapOrderAttachmentService.updateByPrimaryKey(carScrapOrderAttachment);
			TbAttachment attachement = tbAttachmentService.queryById(carScrapOrderAttachment.getAttachmentId());
			if(attachement!=null){
				attachement.setIsvalid(false);
				
				return new ResultBean<Boolean>(tbAttachmentService.update(attachement)==1);
			}
			
		}
		
		
		
		
		return new ResultBean<Boolean>(false);
		
		
		
	}
}
