package com.Banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//1.create the driver object
	WebDriver ldriver;
	
	//2.Constructor
	 public LoginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	
	}
	//3.PageElemente finden
	@FindBy (name="uid")
	@CacheLookup
	WebElement txtUserName;
	@FindBy (name ="password")
	WebElement txtpassword;
	@FindBy (name = "btnLogin")
	WebElement btnLogin;
	
	
	//4 Actions-Methodes
	public void SetUserName(String uname) {
		txtUserName.sendKeys(uname);
			
	}
	
	public void SetPassword(String password) {
		
		txtpassword.sendKeys(password);
	}

	public void ClickSubmit() {
		btnLogin.click();
	}
	
}
