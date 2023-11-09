package com.TechAssessment02;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	String url = "https://demowebshop.tricentis.com/";
	LoginPage page;
	@Test(dataProvider = "loginData")
	  public void loginTest(String email, String password) {
		page = new LoginPage(driver);		  
		  page.login(email,password);		
	  }
@DataProvider(name = "loginData")
public Object[][] dataDelivery() {
	  String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\login (3).xlsx";
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
 
@BeforeMethod
public void launch() {
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demowebshop.tricentis.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  driver.findElement(By.xpath("//a[text()='Register']")).click();
	  driver.findElement(By.xpath("//a[text()='Log in']")).click();
}
@Test(dataProvider = "loginData")
public void testLogin(String email, String password, boolean expectedResult) {
    LoginPage loginPage = new LoginPage(driver);  
    loginPage.enterEmailId(email);
    loginPage.enterLoginPassword(password);    
    loginPage.clickButton();  
    AssertJUnit.assertEquals(driver.getTitle().contains("Demo Web Shop"), expectedResult);
}
@AfterMethod
public void dropup() {
}
}