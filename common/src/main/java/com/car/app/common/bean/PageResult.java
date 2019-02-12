package com.car.app.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
/**
 * 分页查询结果
 * 类名称：PageResult   
 * 类描述：   
 * 创建人：刘子亮
 * 创建时间：2018年4月16日 上午10:04:01      
 * @version  V1.0
 *
 */
@ApiModel(value = "分页结果")
public class PageResult<T>  {
	
	 @ApiModelProperty(value = "数据总结果数")
	  private Long total;
	 @ApiModelProperty(value = "当前请求每页显示数据条数")
	  private List<?> rows;
	  
	  public PageResult() {

	    }

	 public PageResult(Long total, List<?> rows) {
	        this.total = total;
	        this.rows = rows;
	    }

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	 
	 
	 

}
