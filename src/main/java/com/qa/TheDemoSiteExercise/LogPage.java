package com.qa.TheDemoSiteExercise;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogPage {

		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
		private WebElement log; 

		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
		private WebElement password; 
		
		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
		private WebElement testLog;
		
		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
		private WebElement status; 
		 
		public void checkLog() 
		{
			log.sendKeys("Henrie");
			password.sendKeys("Hoover");
			testLog.submit();
		}
		
		public WebElement getStatus() {
			return status;
		}

		public void setStatus(WebElement status) {
			this.status = status;
		}
		
	}
	
	

