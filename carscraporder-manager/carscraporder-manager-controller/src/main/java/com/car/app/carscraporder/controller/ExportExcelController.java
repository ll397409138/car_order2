package com.car.app.carscraporder.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.car.app.carscraporder.pojo.CarAssessment;
import com.car.app.carscraporder.service.CarAssessmentService;

@Controller
@RequestMapping("/exportExcel")
@Api(value = "exportExcel-API",tags={"Excel导出"} )
public class ExportExcelController {
	
	@Autowired
	private CarAssessmentService carAssessmentService;
	
	
	 /**
     * 导出excel
     * @param out 输出到哪里
     * @param students 学生信息
     * @param title excel中内容标题
     * @param headers 学生信息表中的头标签
	 * @throws Exception 
     */
	

	@RequestMapping(value="exportData",method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "导出车辆估值数据",notes = "导出车辆估值数据")
    public void exportExcel( HttpServletRequest request,HttpServletResponse response) throws Exception{
		ServletOutputStream out=response.getOutputStream();
	     String fileName=new String(("UserInfo "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(),"UTF-8");
		
		 
		 // 设置相应头信息，以附件形式下载并且指定文件名
	     
	        
	        response.setHeader("Content-disposition", "attachment;filename=Car_Assessment.xls");  
	        
		  String[] titles = { "关键字1", "关键字2", "关键字3","出厂日期","排量","变速箱","燃油","区域","价格" }; 
		
		  try{
	             // 第一步，创建一个workbook，对应一个Excel文件
	             HSSFWorkbook workbook = new HSSFWorkbook();
	             // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
	             HSSFSheet hssfSheet = workbook.createSheet("sheet1");
	             // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	             HSSFRow hssfRow = hssfSheet.createRow(0);
	             // 第四步，创建单元格，并设置值表头 设置表头居中
	             HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
	             //居中样式
	             hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	 
	             HSSFCell hssfCell = null;
	             for (int i = 0; i < titles.length; i++) {
	                 hssfCell = hssfRow.createCell(i);//列索引从0开始
	                 hssfCell.setCellValue(titles[i]);//列名1
	                 hssfCell.setCellStyle(hssfCellStyle);//列居中显示                
	             }
	             
	             // 第五步，写入实体数据 
	             List<CarAssessment> carAssessments = carAssessmentService.queryAll();     
	 
	             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	             if(carAssessments != null && !carAssessments.isEmpty()){
	                 for (int i = 0; i < carAssessments.size(); i++) {
	                     hssfRow = hssfSheet.createRow(i+1);                
	                     CarAssessment carAssessment = carAssessments.get(i);
	                     
	                     // 第六步，创建单元格，并设置值
	                    
	                     String keyWord1 = "";
	                     if(carAssessment.getKeyword1() != null){
	                    	 keyWord1 = carAssessment.getKeyword1();
	                     }
	                     hssfRow.createCell(0).setCellValue(keyWord1);
	                     
	                     String keyWord2 = "";
	                     if(carAssessment.getKeyword2() != null){
	                    	 keyWord2 = carAssessment.getKeyword2();
	                     }
	                     hssfRow.createCell(1).setCellValue(keyWord2);
	                     
	                     String keyWord3 = "";
	                     if(carAssessment.getKeyword3 () != null){
	                    	 keyWord3 = carAssessment.getKeyword3();
	                     }
	                     hssfRow.createCell(2).setCellValue(keyWord3);
	                     
	                     
	                     String datesofproduction = "";
	                     if(carAssessment.getDatesofproduction () != null){
	                    	 datesofproduction = carAssessment.getDatesofproduction();
	                     }
	                     hssfRow.createCell(3).setCellValue(datesofproduction);
	                     
	                     String displacement = "";
	                     if(carAssessment.getDisplacement () != null){
	                    	 displacement = carAssessment.getDisplacement();
	                     }
	                     hssfRow.createCell(4).setCellValue(displacement);
	                     
	                     String gearbox = "";
	                     if(carAssessment.getGearbox () != null){
	                    	 gearbox = carAssessment.getGearbox();
	                     }
	                     hssfRow.createCell(5).setCellValue(gearbox);
	                     
	                     String fueltype = "";
	                     if(carAssessment.getFueltype () != null){
	                    	 fueltype = carAssessment.getFueltype();
	                     }
	                     hssfRow.createCell(6).setCellValue(fueltype);
	                     
	                     String region = "";
	                     if(carAssessment.getRegion () != null){
	                    	 region = carAssessment.getRegion();
	                     }
	                     hssfRow.createCell(7).setCellValue(region);
	                     
	                     String price = "";
	                     if(carAssessment.getPrice () != null){
	                    	 price = carAssessment.getPrice();
	                     }
	                     hssfRow.createCell(8).setCellValue(price);
	                 }
	             }
	             
	             
	            
	             // 第七步，将文件输出到客户端浏览器
	             try {
	                 workbook.write(out);
	                 out.flush();
	                 out.close();
	 
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }catch(Exception e){
	             e.printStackTrace();
	             throw new Exception("导出信息失败！");
	         } 
			
			     
		
    }
	
	
	

}
