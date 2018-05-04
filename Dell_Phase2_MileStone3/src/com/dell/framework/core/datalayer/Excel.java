package com.dell.framework.core.datalayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dell.framework.core.Utility.UtilConstant;

public class Excel 
{
	
	public static String readData(String sheetName, int rownNum, int colNum)
	{
		String data = null;
		try
		{
			FileInputStream fis = new FileInputStream(UtilConstant.testData);
		
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rownNum);
			
			XSSFCell cell = row.getCell(colNum);
			
			data = cell.getStringCellValue();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return data;
	}
	
	public static void writeDataToExcel(String sheetName, int rowNo, int ColNum, String staus)
	{
		try
		{
			FileInputStream fis = new FileInputStream(UtilConstant.testData);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rowNo);
			
			row.createCell(ColNum).setCellValue(staus);
			
			FileOutputStream fos = new FileOutputStream(UtilConstant.testData);
			
			workbook.write(fos);
			
			fos.close();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public static String[] getAllRowData(String sheetName, int rownNum)
	{
		String[] s1 = null;
		try
		{
			FileInputStream fis = new FileInputStream(UtilConstant.testData);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rownNum);
			
			int collNum = row.getLastCellNum();
			
			s1 = new String[collNum];
			
			for(int i=0; i<=collNum; i++)
			{
				s1[i] = row.getCell(i).getStringCellValue();
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return s1;
		
	}
	
	public static String[] getAllColumnData(String sheetName, int colNum)
	{
		String[] s1 = null;
		try
		{
			FileInputStream fis = new FileInputStream(UtilConstant.testData);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int rowLen = sheet.getLastRowNum();
			
			s1 = new String[rowLen];
			

			for(int i=0; i<rowLen;i++)
			{
				XSSFRow row = sheet.getRow(i);
				s1[i] = row.getCell(4).getStringCellValue();
			}
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return s1;
		
	}
}
