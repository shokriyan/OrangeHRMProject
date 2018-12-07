package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	XSSFWorkbook book;
	XSSFSheet sheet;
	String filePath = ConstanceClass.excelFilePath;
	public void openExcelSheet(String filePath, String sheetName) {
		 
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
			sheet = book.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getRow () {
		return sheet.getLastRowNum();
	}
	
	public int getcol () {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public String getCellValue(int row, int col) {
		String value = sheet.getRow(row).getCell(col).toString();
		return value;
	}

}
