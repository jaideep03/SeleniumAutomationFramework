package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		getRowCount();
		getStringCellDataValue(0,0);
		getNumericCellDataValue(1,1);
	}
	
	public static int getRowCount() {
		int rCount=0;
		rCount = sheet.getPhysicalNumberOfRows(); 
		System.out.println("No. of rows: "+rCount);
		return rCount;	
	}
	
	public static int getColCount() {
		int cCount=0;
		cCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No. of cols: "+cCount);
		return cCount;
	}
	
	public static String getStringCellDataValue(int rowNum, int colNum) {
		String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println("String Cell data is: "+cellData);
		return cellData;
	}
	
	public static double getNumericCellDataValue(int rowNum, int colNum) {
		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println("Numeric Cell data is: "+cellData);
		return cellData;
	} 
	
}
