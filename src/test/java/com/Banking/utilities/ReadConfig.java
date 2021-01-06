package com.Banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	//Constructor
	public ReadConfig() {
		
		try {
			File src = new File ("./Configuration/config.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Methode erstellen um config.properties zu lesen
	
	public String getApplicationURL() 
	
	{
		String url=pro.getProperty("baseURL");
		return url;
	}

	public  String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}

	public  String getpassword() {
		String password= pro.getProperty("password");
		return password;
	}
	
	public  String getchrompath() 
	{
		String chrompath= pro.getProperty("chrompath");
		return chrompath;
	}

	
	public  String getiepath()
	{
		String iepath= pro.getProperty("iepath");
		return iepath;
	}

	public  String getfirefoxpath()
	{
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	
	
}
