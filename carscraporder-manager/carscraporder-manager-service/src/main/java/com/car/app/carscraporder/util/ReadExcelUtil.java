package com.car.app.carscraporder.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.car.app.carscraporder.pojo.CarAssessment;

public class ReadExcelUtil {
	
	// 总行数
    private int totalRows = 0;
    // 总条数
    private int totalCells = 0;
    // 错误信息接收器
    private String errorMsg;

    // 构造方法
    public ReadExcelUtil() {
    }

    // 获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    // 获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    // 获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * 读EXCEL文件，获取信息集合
     * 
     * @param fielName
     * @return
     */
    public List<String> importData(MultipartFile mFile) {
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
        }
        return null;
    }

    /**
     * 根据excel里面的内容读取客户信息
     * 
     * @param is      输入流
     * @param isExcel2003   excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<String> createExcel(InputStream is, boolean isExcel2003) {
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
        }
        return null;
    }

    /**
     * 读取Excel里面客户的信息
     * 
     * @param wb
     * @return
     */
    private List<String> readExcelValue(Workbook wb) {
    	 List<String>  importMessage = new ArrayList<String>();
    	
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            // 循环Excel的列
         
            for (int c = 0; c < this.totalCells; c++) {
            	
                Cell cell = row.getCell(c);
                if (null != cell) {
                	CarAssessment data = new CarAssessment();
                    if (c == 0) {
                    	data.setKeyword1(cell.getStringCellValue());
                    } else if (c == 1) {
                    	data.setKeyword2(cell.getStringCellValue());
                    } else if (c == 2) {
                    	data.setKeyword3(cell.getStringCellValue());
                    }else if (c == 3) {
                    	data.setKeyword1(cell.getStringCellValue());
                    }else if (c == 4) {
                    	data.setDatesofproduction(cell.getStringCellValue());
                    }else if (c == 5) {
                    	data.setDisplacement(cell.getStringCellValue());
                    }else if (c == 6) {
                    	data.setGearbox(cell.getStringCellValue());
                    }else if (c == 7) {
                    	data.setFueltype(cell.getStringCellValue());
                    }else if (c == 8) {
                    	data.setRegion(cell.getStringCellValue());
                    }else if (c == 9) {
                    	data.setPrice(cell.getStringCellValue());
                    }
                    
                }
            }
           
        }
        return importMessage;
    }

    /**
     * 验证EXCEL文件
     * 
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
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
