package com.OHRM.TestCases;

import java.io.File;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.OHRM.Utilities.PropertyFileReader;

public class BaseClass 
{
	public static WebDriver driver;
	public static Logger logger;
	PropertyFileReader pfr=new PropertyFileReader();
	public String driverPath=pfr.getDriverPath();
	public String baseUrl=pfr.getBaseUrl();
	public String screenPath=pfr.getScreenPath();
	public String loginUid=pfr.getLoginUID();
	public String loginPwd=pfr.getLoginPwd();
	//public String browser=pfr.getBrowser();

	@Parameters("brow")
	@BeforeClass
	public void setup(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", driverPath);
			driver=new FirefoxDriver();
		}
		else
			System.out.println("browser is mismatched");
		
		driver.manage().window().maximize();
		logger= Logger.getLogger("OHRM");
		PropertyConfigurator.configure("log4j.properties");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Application Opened");
	}
	//@AfterSuite
	public void teardown()
	{
		logger.info("Application Closed");
		driver.quit();
	}
	
	public void captureScreen(String fileName)
	{
		try 
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(screenPath+fileName+".png"));
			logger.info(fileName+" :Image Captured");
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String randomString(int n)
	{
		return RandomStringUtils.randomAlphabetic(n);
	}
}
