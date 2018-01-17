package com.dell.framework.core.webDriver;

import org.openqa.selenium.By;

public class FindBy
{
	public static By locator(String locatorName, String locatorValue)
	{
		By by=null;
		try 
		{
			switch (locatorName.toLowerCase())
			{
				case "id":
					by = By.id(locatorValue);
					break;
					
				case "name":
					by = By.name(locatorValue);
					break;
					
				case "classname":
					by = By.className(locatorValue);
					break;
					
				case "xpath":
					by = By.xpath(locatorValue);
					break;
					
				case "css":
					by = By.cssSelector(locatorValue);
					break;
					
				case "linktext":
					by = By.linkText(locatorValue);
					break;
					
				case "partiallinktext":
					by = By.partialLinkText(locatorValue);
					break;

				case "tagname":
					by = By.tagName(locatorValue);
					break;
					
				default:
					System.out.println("Unable to identify thelocator");
					throw new Exception("Unable to identify thelocator");
					
					
			}
		}
		catch 
		(Exception e)
		{		
			e.getMessage();
		}
		
		return by;
	}
}
