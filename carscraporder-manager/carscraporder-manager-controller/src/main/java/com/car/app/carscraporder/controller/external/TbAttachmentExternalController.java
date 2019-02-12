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
import com.car.app.carscraporder.pojo.TbAttachment;
import com.car.app.carscraporder.service.TbAttachmentService;
import com.car.app.carscraporder.vo.AttachmentVO;
import com.car.app.common.bean.ResultBean;

@Controller
@RequestMapping(value="/external/attachment")
@Api(value = "TB-ATTACHMENT-API",tags={"附件上传"})
public class TbAttachmentExternalController {
	
	@Autowired
	private TbAttachmentService tbAttachmentService;
	
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResultBean<AttachmentBO> saveAttachmentBuniessData(@RequestBody AttachmentVO vo)throws Exception{
		AttachmentBO bo = new AttachmentBO();
		TbAttachment record = new TbAttachment();
		record.setOriginalName(vo.getOriginalName());
		record.setStoragePath(vo.getStoragePath());
		TbAttachment result = tbAttachmentService.saveReturnPersistentObject(record);
		bo.setId(result.getId());
		return new ResultBean<AttachmentBO>(bo);
		
		
		
		
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> saveAttachmentBuniessData(@PathVariable("id")Integer id)throws Exception{
		TbAttachment tbAttachment = tbAttachmentService.queryById(id);
		if(tbAttachment!=null){
			tbAttachment.setIsvalid(false);
			tbAttachmentService.update(tbAttachment);
		}
		
		return new ResultBean<Boolean>(true);
		
		
		
	}

}
