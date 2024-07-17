package com.OHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader
{
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	
	public static XSSFSheet excelConnection(String sheetName)
	{
		try
		{
			FileInputStream efis=new FileInputStream(new File("src\\test\\java\\com\\OHRM\\TestData\\inputData.xlsx"));
			book=new XSSFWorkbook(efis);
			sheet=book.getSheet(sheetName);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return sheet;
	}
	public static String excelData(String sheetName, int row, int cell)
	{
		return excelConnection(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
}
