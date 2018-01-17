package com.dell.framework.core.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver 
{
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		String browser = UtilConstant.browserName;
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", UtilConstant.chromeServer);
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", UtilConstant.ieServer);
			driver = new InternetExplorerDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", UtilConstant.ffServer);
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Browser Not Found");
		}
		
		return driver;
	}
}
