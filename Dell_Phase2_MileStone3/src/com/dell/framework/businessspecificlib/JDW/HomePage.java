package com.dell.framework.businessspecificlib.JDW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dell.ObjectSpecific.JDW.HomePageObj;
import com.dell.framework.core.Utility.Driver;

public class HomePage 
{
	public void searchProduct(String productName)
	{
		WebElement w1 = Driver.driver.findElement(By.xpath(HomePageObj.searchTxtBox));
		w1.sendKeys(productName);
		
		WebElement W2 = Driver.driver.findElement(By.id(HomePageObj.searchButton));
		
		W2.click();
	}
}
