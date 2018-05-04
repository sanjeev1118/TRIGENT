package com.dell.framework.businessspecificlib.JDW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dell.ObjectSpecific.JDW.HomePageObj;
import com.dell.ObjectSpecific.JDW.PLPPageObj;
import com.dell.framework.core.Utility.Driver;

public class PLPPage 
{
	public void selectProductFromPLP()
	{
		WebElement w1 = Driver.driver.findElement(By.xpath(PLPPageObj.plpProduct));
		w1.click();
	}
}
