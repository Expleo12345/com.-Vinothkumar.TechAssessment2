package com.TechAssessment02;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
public class RegisterTest extends LoginTest{
	WebDriver driver;
	String url = "https://demowebshop.tricentis.com/";
	RegisterPage page2;

	@Test(dataProvider = "RegisterData")
	  public void registerTest(String firstname, String lastname,String email,String password,String confirmPassword) {
		page2 = new RegisterPage(driver);		  
		  page2.register(email,password,email,password,confirmPassword);		
		  System.out.println("Registed successfully");
	  }
	@DataProvider(name = "RegisterData")
	  public Object[][] dataDelivery1() {
		  String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\Book1 (3).xlsx";
		  File excelFile = new File(excelPath);
			FileInputStream fis = null;		
			try {
				fis = new FileInputStream(excelFile);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(fis);
			}catch(IOException e) {
				e.printStackTrace();
			}
			XSSFSheet sheet = workbook.getSheet("Sheet1");	
			int rowsCount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowsCount);
			int columsCount = sheet.getRow(0).getLastCellNum();
			System.out.println(columsCount);
			Object[][] data = new Object[rowsCount-1][columsCount];	
			for(int r=0; r<rowsCount-1; r++) {			
				XSSFRow row = sheet.getRow(r+1);	
				for(int c=0; c<columsCount; c++) {
					XSSFCell cell = row.getCell(c);
					CellType cellType = cell.getCellType();
					switch(cellType) {
					case STRING:
						data[r][c] = cell.getStringCellValue();
						break;
					}				
				}
			}	
			return data;
	  }
	}