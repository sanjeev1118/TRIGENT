package com.dell.framework.core.webelement;

import org.openqa.selenium.WebElement;

import com.dell.framework.core.Utility.Driver;
import com.dell.framework.core.webDriver.FindBy;

public class SeWebElement 
{
	public void setValue(String txtValue, String locatorType, String locatoterValue)
	{
		try
		{
			WebElement w1 = Driver.driver.findElement(FindBy.locator(locatorType, locatoterValue));
			w1.sendKeys(txtValue);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	
	public void click(String locatorType, String locatoterValue)
	{
		try
		{
			WebElement w1 = Driver.driver.findElement(FindBy.locator(locatorType, locatoterValue));
			w1.click();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	
	public String getText(String locatorType, String locatoterValue)
	{
		String text = null;
		try
		{
			WebElement w1 = Driver.driver.findElement(FindBy.locator(locatorType, locatoterValue));
			text = w1.getText();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		return text;
	}
	
	
}
