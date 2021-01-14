package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	static String projectPath = System.getProperty("user.dir"); //Fetching the Project Path
	static String excelPath = projectPath+"/excel/data.xlsx";
	static String sheetName = "Sheet1";
	
	@Test(dataProvider = "TestOneData")
	public void test1(String Username, String Password) {
		System.out.println(Username+"|"+Password );
	}
	
	@DataProvider(name = "TestOneData")
	public static Object[][] getData() {
		Object data[][] = testData(excelPath, sheetName);
		return data;
	}

	public static Object[][] testData(String strexcelPath, String strsheetName) {
		
		ExcelUtils excel = new ExcelUtils(strexcelPath, strsheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellDataValue =  excel.getStringCellDataValue(i, j);
				data[i-1][j] = cellDataValue;
			}
		}
		return data;
	}
	
}
