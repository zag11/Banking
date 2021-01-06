package com.Banking.testCases;



/*import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;*/

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Banking.utilities.ReadConfig;


public class BaseClass {
public static WebDriver driver;
public static Logger logger;

	//um die Werte aus der config.properties zu lesen
	// wird hier ein Object erstellt von ReadConfig

	ReadConfig readconfig = new ReadConfig();
				
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getpassword();
	public String chrompath = readconfig.getchrompath();
	public String iepath = readconfig.getiepath();
	public String firefoxpath = readconfig.getfirefoxpath();
	
	

	@Parameters("browser")
	@BeforeClass
	public void Setup(String br){
		
		logger=Logger.getLogger("Banking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrompath"))
		{
			System.setProperty("webdriver.Chrome.driver", readconfig.getchrompath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefoxpath")) {
			
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
		}
		
		else if(br.equals(iepath)) {
			
			System.setProperty("webdriver.ie.driver", readconfig.getiepath());
			driver = new InternetExplorerDriver();
			
		}
		
		driver.get(baseURL);
		
		
	}
	
	  @AfterClass public void tearDown() {
	  
	  driver.quit();
	  
	  }
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return(generatedstring);
		}
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
}
