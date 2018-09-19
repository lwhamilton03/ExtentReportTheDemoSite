package com.qa.TheDemoSiteExercise;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.PageFactory;

	import com.relevantcodes.extentreports.ExtentTest;
	import com.qa.TheDemoSiteExercise.LogPage;
	import com.qa.TheDemoSiteExercise.UserPage;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.LogStatus;
	
public class UserPageTesting {
	
		WebDriver driver = null; 
		Constants constant = new Constants(); 
		public static ExtentReports report; 
		public ExtentTest test;
		
		@BeforeClass
		public static void initial()
		{
			//setting up a report (file name, replace existing)
			report = new ExtentReports("C:\\Users\\Admin\\Desktop\\ExtentReport\\DemoSite.html", false); 
		}
		
		@Before
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Documents/Selenium/chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
		}
		
		@Test 
		public void inputUser() throws IOException
		{
			test = report.startTest("Inputting a User Test");
			driver.get(Constants.userPage);
			UserPage page = PageFactory.initElements(driver, UserPage.class);
			
			test.log(LogStatus.INFO, "Start Creating User");
			
			//Get The Data from the file (DDT)
			FileInputStream file = null;
			file = new FileInputStream(Constants.path_TestData + Constants.file_TestData );
				
			XSSFWorkbook workbook = null; 
			workbook = new XSSFWorkbook(file); 
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//for loop for each bit of the cell 
			for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)
			{
				test.log(LogStatus.INFO, "Get: New User, New Password");
				Cell username = sheet.getRow(i).getCell(0); 
				Cell password = sheet.getRow(i).getCell(1); 
				
				String user = username.getStringCellValue();
				String pass = password.getStringCellValue(); 
				
				page.createUser(user, pass);
				
				if(page.checkUser())
				{		
					test.log(LogStatus.PASS, "User Has Been Created");
				}
				else
				{
					test.log(LogStatus.FAIL, "User Has Not Been Created");
				}
				
			}
			
			
			//System.out.println(cell.getStringCellValue());
			
			
			//page.createUser("Henrie", "Hoover");
//			if(page.checkUser())
//			{		
//				test.log(LogStatus.PASS, "User Has Been Created");
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, "User Has Not Been Created");
//			}	
			//assertTrue("User Has Not Been Created", page.checkUser()); 
			workbook.close();
		}
		
		
		@After
		public void tearDown()
		{
			driver.quit(); 
			report.endTest(test); 
		}
		
		@AfterClass
		public static void end()
		{
			report.flush();
		}
}

