package com.Banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.pageObjects.LoginPage;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_LoginTest_001 extends BaseClass

{
	
	@Test
	
	public void LoginTest() throws IOException {
		
		driver.get(baseURL);
		logger.info("browser");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(username);
		logger.info("username wird gesetzt");
		lp.SetPassword(password);
		logger.info("passwort wird gesetzt");
		lp.ClickSubmit();
		logger.info("submit wird angekelickt");
		
		
		  if(driver.getTitle().equals(" Guru99 Bank"))
		  {
		  
		  Assert.assertTrue(true);
		  }
		  
			/*
			 * else {
			 * 
			 * captureScreen(driver,"loginTest"); Assert.assertTrue(false);
			 * logger.info("Test failed");
			 * 
			 * 
			 * 
			 * }
			 */
		 
		
	
		
	}
	
	
	
	
	
	

}
