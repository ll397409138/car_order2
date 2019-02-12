package com.car.app.carscraporder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.carscraporder.mapper.TbAttachmentMapper;
import com.car.app.carscraporder.pojo.TbAttachment;
import com.car.app.carscraporder.service.TbAttachmentService;


@Service
public class TbAttachmentServiceImpl extends BaseServiceImpl<TbAttachment> implements
		TbAttachmentService {

	@Autowired
	private TbAttachmentMapper  tbAttachmentMapper;
	

}
