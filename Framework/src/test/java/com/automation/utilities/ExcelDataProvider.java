package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	 XSSFSheet sheet;
	public ExcelDataProvider() {
		
		File src= new File("C:\\Users\\SwamyKalaveni\\OneDrive - SoftClouds LLC\\Desktop\\MACU\\Framework\\TestData\\Data.xlsx");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			
			 wb=new XSSFWorkbook(fis);
			 
			
			 
		}catch (Exception e) {
			
			System.out.println("Unable to read Excel File"+e.getMessage());
			
		}
		
	}
	public String getStringDate(int sheetIndex,int row,int column) {
		   
		   sheet=wb.getSheetAt(sheetIndex);
		   return sheet.getRow(row).getCell(column).getStringCellValue();
		    
	   }
	
   public String getStringData(String sheetName,int row,int column) {
	   sheet=wb.getSheet(sheetName);
	   return sheet.getRow(row).getCell(column).getStringCellValue();
   }
   public double getNUmaricData(String sheetName,int row,int column) {
	   return wb.getSheet("sheetName").getRow(row).getCell(column).getNumericCellValue();
	   
   }
}
