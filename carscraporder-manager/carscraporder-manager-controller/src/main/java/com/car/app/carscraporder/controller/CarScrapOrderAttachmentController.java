package com.car.app.carscraporder.controller;

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
import com.car.app.carscraporder.vo.AttachmentVO;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/carattachment")
@Api(value = "TB-ATTACHMENT-API",tags={"附件删除"})
public class CarScrapOrderAttachmentController {
	
	@Autowired
	private CarScrapOrderAttachmentService carScrapOrderAttachmentService;
	
	@Autowired
	private TbAttachmentService tbAttachmentService;
	
	
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
