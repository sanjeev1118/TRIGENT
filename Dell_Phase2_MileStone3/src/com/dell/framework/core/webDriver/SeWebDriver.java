package com.dell.framework.core.webDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dell.framework.core.Utility.Driver;
import com.dell.framework.core.Utility.UtilConstant;

public class SeWebDriver
{
	public void getUrl()
	{
		try
		{
			Driver.driver.get(UtilConstant.appUrl);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public void implicitlyWait()
	{
		try
		{
			Driver.driver.manage().timeouts().implicitlyWait(UtilConstant.syncTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	
	public void explicitlyWait(String locatorName, String locatorValue)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(Driver.driver, UtilConstant.syncTime);

			wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.locator(locatorName, locatorValue)));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		
	}
	
	
	public void waitForPageLoad()
	{
		try
		{
			Driver.driver.manage().timeouts().pageLoadTimeout(UtilConstant.syncTime, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public String getBrowserTitle()
	{
		String title = null;
		
		try
		{

			title = Driver.driver.getTitle();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return title;
	}
	
	public String getPageSource()
	{
		String pageSource = null;
		
		try
		{

			pageSource = Driver.driver.getPageSource();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return pageSource;
	}
	
	public String getWindowId()
	{
		String winId = null;
		try
		{
			winId = Driver.driver.getWindowHandle();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return winId;
	}
	
	public Set<String> getAllWinId()
	{
		Set<String> allWinIds = null;
		try
		{
			allWinIds = Driver.driver.getWindowHandles();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return allWinIds;
	}
	
	
	public void takeScreenShot(String screenshotName)
	{
		
		try
		{
			EventFiringWebDriver e1 = new EventFiringWebDriver(Driver.driver);
			
			File source = e1.getScreenshotAs(OutputType.FILE);
			
			File destination = new File("C:\\Users\\SHALINI KUMARI\\workspace\\Dell_Phase2_MileStone3\\ScreenShot\\"+screenshotName+".png");
			
			FileUtils.copyFile(source, destination);
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	
	
}