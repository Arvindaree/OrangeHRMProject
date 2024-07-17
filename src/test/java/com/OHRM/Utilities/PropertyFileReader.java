package com.OHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader
{
	Properties pro;
	public PropertyFileReader()
	{
		try 
		{
			FileInputStream fis=new FileInputStream(new File("Configuration//config.properties"));
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getBaseUrl()
	{
		return pro.getProperty("baseUrl");
	}
	public String getScreenPath()
	{
		return pro.getProperty("screenPath");
	}
	public String getDriverPath()
	{
		return pro.getProperty("driverPath");
	}
	public String getLoginUID()
	{
		return pro.getProperty("loginUsername");
	}
	public String getLoginPwd()
	{
		return pro.getProperty("loginPassword");
	}
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
}
