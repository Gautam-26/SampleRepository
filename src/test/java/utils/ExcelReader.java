package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	String path = "D:\\5. Workspace\\1. Selenium Workspace\\SampleProject\\src\\test\\resources\\testData\\Book1.xlsx";
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	
	public static void main(String[] args)
	{
		ExcelReader ob = new ExcelReader();
		ob.readData();
	}


	public void readData()
	{
		try 
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");

			int rows = sheet.getLastRowNum();
			XSSFRow row ;

			for(int i =0 ; i <= sheet.getLastRowNum(); i++)
			{
				row =sheet.getRow(i);

				for(int j = 0; j < row.getLastCellNum(); j++ ) 
				{

					XSSFCell cell = row.getCell(j);

					 switch(cell.getCellType())
					 {
					 case STRING:
						 System.out.println(row.getCell(j).getStringCellValue());
						 break;
					 case NUMERIC:
						 System.out.println(row.getCell(j).getNumericCellValue());
						 break;
						 
					 }

				}
			}
		} 
		catch (FileNotFoundException e) 
		{

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
