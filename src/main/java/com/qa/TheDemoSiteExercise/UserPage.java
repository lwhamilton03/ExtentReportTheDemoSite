package com.qa.TheDemoSiteExercise; 

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.*; 

public class UserPage {
			
		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
		private WebElement username; 
		
		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
		private WebElement password; 
		
		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
		private WebElement sub; 
		
		public void createUser(String user, String pass)
		{
			username.sendKeys(user);
			password.sendKeys(pass);
			sub.submit();
		}
		

		
		@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")
		private WebElement userCheck; 
		
		public boolean checkUser()
		{
			boolean check = false; 
			
			// String Manipulation - in order to ensure that they contain the exact, as inserting 'Hoo' would work
			 if(userCheck.getText().contains("Henrie") && userCheck.getText().contains("Hoover"))
					 {
				 		check = true; 
					 }
			 
			 return check; 
		}
		
	}


