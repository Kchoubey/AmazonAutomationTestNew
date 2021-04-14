package com.amazon.qa.util;


//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
////import java.io.File;
////import java.io.FileInputStream;
////import java.io.FileNotFoundException;
////import java.io.IOException;
////
////import org.apache.commons.io.FileUtils;
////import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
////import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
////import org.openqa.selenium.OutputType;
////import org.openqa.selenium.TakesScreenshot;
////import org.openqa.selenium.WebDriver;
////import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
////import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
//
//
//public class TestUtil {
//	public static long PAGE_LOAD_TIMEOUT = 20;
//	public static long IMPLICIT_WAIT = 10;
//	//public static WebDriver driver;
//	
//	   
//	public static String TESTDATA_SHEET_PATH = "D:\\Java Workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\testdata\\Amazon_TestData.xlsx";
//	Workbook book;
//    Sheet sheet;
//	
//	public static Object[][] getTestData(String sheetName){
//	FileInputStream file = null;
//		try {
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//		}catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			book =  XSSFWorkbookFactory.create(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		sheet = book.getSheet(sheetName);
//		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		for (int i=0;i< sheet.getLastRowNum();i++) {
//			for(int k =0;k < sheet.getRow(0).getLastCellNum(); k++) {
//				data[i][k] = sheet.getRow(i +1).getCell(k).toString();
//				
//		}
//		}
//		return data;
//	}
//	
//		public static void takeScreenshotAtEndofTest() throws IOException
//		{
//			//TakesScreenshot driver;
//			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			String currentDir = System.getProperty("user.dir");
//			//if (osName.startswith("Mac")) {
//			FileUtils.copyFile(scrFile, new File(currentDir  + System.currentTimeMillis() + ".png"));
//			
//			
//}
////////			else
////////			{
////////				FileUtils.copyFile(scrFile, new File(currentDir +"\\screenshot\\" + System.currentTimeMillis() + ".png"))
////////			}
//		}
//
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazon.qa.base.TestBase;

//import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	//public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "D:\\Java Workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\testdata\\Amazon_TestData.xlsx";

	static Workbook book;
	static Sheet sheet;


//	public void switchToFrame(){
//		driver.switchTo().frame("mainpanel");
//	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("C:\\Users\\Karis\\Desktop\\Docs\\SeleniumScreeshots");

		FileUtils.copyFile(scrFile, new File("C:\\Users\\Karis\\Desktop\\Docs\\SeleniumScreeshots" + "/screenshots/" + System.currentTimeMillis() + ".png"));

		}
}
