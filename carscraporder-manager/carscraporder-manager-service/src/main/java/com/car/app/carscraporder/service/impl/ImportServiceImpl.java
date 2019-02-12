package com.car.app.carscraporder.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.car.app.carscraporder.pojo.CarAssessment;
import com.car.app.carscraporder.service.CarAssessmentService;
import com.car.app.carscraporder.service.ImportService;
import com.car.app.carscraporder.util.StringUtils;
import com.car.app.common.exception.ExcelException;

@Service
public class ImportServiceImpl implements ImportService {
	
	@Autowired
	private CarAssessmentService carAssessmentService;
	
	public String ImportDataByExcel(MultipartFile file) throws Exception{
		
		return importData(file);
		
		
	}
	
	
	  /**
     * 读EXCEL文件，获取信息集合
     * 
     * @param fielName
     * @return
     */
    private  String importData(MultipartFile mFile) {
        String fileName = mFile.getOriginalFilename();// 获取文件名

        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            return createExcel(mFile.getInputStream(), isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcelException("导入excel错误");
        }
      
    }
    
    
    /**
     * 根据excel里面的内容读取客户信息
     * 
     * @param is      输入流
     * @param isExcel2003   excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    private String createExcel(InputStream is, boolean isExcel2003) {
        try {
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }
            return readExcelValue(wb);// 读取Excel里面客户的信息
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExcelException("导入excel错误");
        }
      
    }
    
    
    /**
     * 读取Excel里面客户的信息
     * 
     * @param wb
     * @return
     */
    private String readExcelValue(Workbook wb) {
    	StringBuffer sbffer = new StringBuffer();
    	
    	int totalRows = 0;
    	int totalCells = 0;
    	int importSuccess=0;
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        totalRows = sheet.getPhysicalNumberOfRows();
        sbffer.append("总共："+(totalRows-1)+"条数据.");
        // 得到Excel的列数(前提是有行数)
        if (sheet.getPhysicalNumberOfRows() > 1 && sheet.getRow(0) != null) {
        	totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
        	try{
	            Row row = sheet.getRow(r);
	            if (row == null) {
	                continue;
	            }
	            CarAssessment data = new CarAssessment("无限","无限","无限","无限","无限");
	            
	            
	            
              // 循环Excel的列
	            for (int c = 0; c <=totalCells; c++) {
	            	
	                Cell cell = row.getCell(c);
	                if (null != cell) {
	                	
	                    if (c == 0) {
	                    	  if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setKeyword1(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  data.setKeyword1(cell.getStringCellValue()); 
	                    	  }
	                    	
	                    } else if (c == 1) {
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setKeyword2(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  data.setKeyword2(cell.getStringCellValue()); 
	                    	  }
	                    	
	                    } else if (c == 2) {
	                    	
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setKeyword3(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  data.setKeyword3(cell.getStringCellValue()); 
	                    	  }
	                    	
	                    }else if (c == 3) {
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		   String name = String.valueOf(cell.getNumericCellValue());
	                    		   data.setDatesofproduction(name.substring(0, name.length() - 2 > 0 ? name.length() - 2 : 1)); 
	                    	  }else{
	                    		  data.setDatesofproduction(cell.getStringCellValue()==null?"不限":cell.getStringCellValue()); 
	                    	  }
	                    	
	                    	
	                    }else if (c == 4) {
	                    	
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setDisplacement(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  data.setDisplacement(cell.getStringCellValue()==null?"不限":cell.getStringCellValue()); 
	                    	  }
	                    }else if (c == 5) {
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setGearbox(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  if(StringUtils.isBlank(cell.getStringCellValue())){
	                    			  data.setGearbox("不限");
	                    		  }else{
	                    			  if(StringUtils.indexOf(cell.getStringCellValue(), "手动")>0){
	                    				  data.setGearbox("手动");
	                    			  }else{
	                    				  data.setGearbox("自动");
	                    			  }
	                    		  }
	                    		  
	                    		 
	                    	  }
	                    	
	                    }else if (c == 6) {
	                    	
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setFueltype(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  data.setFueltype(cell.getStringCellValue()==null?"不限":cell.getStringCellValue()); 
	                    	  }
	                    	
	                    }else if (c == 7) {
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setRegion(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  data.setRegion(cell.getStringCellValue()==null?"不限":cell.getStringCellValue()); 
	                    	  }
	                    }else if (c == 8) {
	                    	
	                    	if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	                    		  data.setPrice(String.valueOf(cell.getNumericCellValue())); 
	                    	  }else{
	                    		  data.setPrice(cell.getStringCellValue()); 
	                    	  }
	                    }
	                    
	                }
	            }
	            
	            if(StringUtils.isBlank(data.getKeyword1())&&StringUtils.isBlank(data.getKeyword2())&&StringUtils.isBlank(data.getKeyword3())){
	            	sbffer.append("第"+r+"条数据导入失败.因为是空字符.");
	            }else{
	            	carAssessmentService.save(data);	
	            	importSuccess++;
	            }
	            
        	}catch(Exception e){
        		 sbffer.append("第"+r+"条数据导入失败.");
        		 
        	}
           
        }
        sbffer.append("成功导入"+importSuccess+"条数据.");
        
        return sbffer.toString();
    }

    
    
    /**
     * 验证EXCEL文件
     * 
     * @param filePath
     * @return
     */
    private boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
          
            return false;
        }
        return true;
    }

    
    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    // @描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
