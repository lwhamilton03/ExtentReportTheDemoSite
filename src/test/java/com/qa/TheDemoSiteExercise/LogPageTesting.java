package com.qa.TheDemoSiteExercise;
import static org.junit.Assert.*;

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
	
public class LogPageTesting {

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
		public void checkLog()
		{
			test = report.startTest("Checking A User Log In Test");
			test.log(LogStatus.INFO, "Get up the Log Page");
			driver.get(Constants.logPage);
			LogPage pageL = PageFactory.initElements(driver, LogPage.class);
			
			test.log(LogStatus.INFO, "Start Checking if Log In Successful");
			pageL.checkLog();
			if(pageL.getStatus().getText().equals("**Successful Login**"))
			{
				test.log(LogStatus.PASS, "Login Successful");
			}
			else
			{
				test.log(LogStatus.FAIL, "Failed LogIn");
			}
			assertEquals("**Login Not Successful**", "**Successful Login**", pageL.getStatus().getText());
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


