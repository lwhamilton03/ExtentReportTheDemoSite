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
		public void inputUser()
		{
			test = report.startTest("Inputting a User Test");
			driver.get(Constants.userPage);
			UserPage page = PageFactory.initElements(driver, UserPage.class);
			
			test.log(LogStatus.INFO, "Start Creating User");
			page.createUser("Henrie", "Hoover");
			if(page.checkUser())
			{		
				test.log(LogStatus.PASS, "User Has Been Created");
			}
			else
			{
				test.log(LogStatus.FAIL, "User Has Not Been Created");
			}	
			assertTrue("User Has Not Been Created", page.checkUser()); 
			
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

