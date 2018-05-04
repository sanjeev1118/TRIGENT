package com.dell.framework.core.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver1 
{
	public static WebDriver driver = null;
	public static WebDriver getDriver()
	{
		try
		{
			switch(UtilConstant.browserName.toLowerCase())
			{
				case "chrome":
					System.setProperty("webdriver.chrome.driver", UtilConstant.chromeServer);
					driver = new ChromeDriver();
					break;
					
				case "ie":
					System.setProperty("webdriver.ie.driver", UtilConstant.ieServer);
					driver = new InternetExplorerDriver();
					break;
					
				case "firefox":
					System.setProperty("webdriver.gecko.driver", UtilConstant.ffServer);
					driver = new FirefoxDriver();
					break;
					
				default:
					throw new Exception("Invalid Browser"+UtilConstant.browserName);
				
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return driver;
	}
}
