package com.hdfc.common;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelManager {

	public void readExcel(String sheetName) throws InvalidFormatException, IOException{

		//Open the File
		File fis = new File("C:/Test Leaf/HdfcBankAcount/src/test/resources/InputExcel.xlsx");
		
		//Open the WorkBook
		XSSFWorkbook wBook = new XSSFWorkbook(fis);

		//Go to the Sheet
		XSSFSheet  sheet = wBook.getSheet(sheetName);
		
		//Get number of Rows
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		
		//Get number of Column
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		
		for (int i = 1; i <=rowCount; i++) {
			// Go to the row
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j < columnCount; j++) {
				// Go to the Cell
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}
		}
	}

}
