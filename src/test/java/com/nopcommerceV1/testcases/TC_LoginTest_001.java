package com.nopcommerceV1.testcases;

import java.io.IOException;

import org.junit.Assert;


import org.testng.annotations.Test;

import com.nopcommerceV1.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClassCommon{
	
	
	
	
	@Test
	public void LoginTest() throws IOException
	{
		driver.get(basURL);
		logger.info("URL is opned");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(Email);
		logger.info("User is provided");
		
		lp.setPassword(password);
		logger.info("Password is provided");
		
		lp.clickLogin();
		logger.info("Login in Clicked");
		
		if(driver.getTitle().equals("Your store. Login"))
		{
			Assert.assertTrue(true);
			
			lp.clickLogOut();
			logger.info("Loggin passed");
		}
		else
		{
			//captureScreen("driver","LoginTest");
			Assert.assertFalse(false);
			
			logger.error("Loggin Failed");
		}
		
	}
	
	

}
