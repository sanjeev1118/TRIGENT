package com.dell.Testscenario.JDW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dell.ObjectSpecific.JDW.HomePageObj;
import com.dell.ObjectSpecific.JDW.Login;
import com.dell.ObjectSpecific.JDW.PDPPageObj;
import com.dell.ObjectSpecific.JDW.PLPPageObj;
import com.dell.framework.businessspecificlib.JDW.HomePage;
import com.dell.framework.businessspecificlib.JDW.PLPPage;
import com.dell.framework.core.Utility.Driver;
import com.dell.framework.core.datalayer.Excel;
import com.dell.framework.core.webDriver.FindBy;
import com.dell.framework.core.webDriver.SeWebDriver;
import com.dell.framework.core.webelement.SeWebElement;

public class Test1 
{
	
	
	public WebDriver driver;
	public SeWebDriver sedriver;
	public SeWebElement sw;

	
	@BeforeClass
	public void init()
	{
		sedriver = new SeWebDriver();
		sw = new SeWebElement();
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = Driver.getDriver();
		sedriver.getUrl();
		sedriver.implicitlyWait();
	}
	
	@Test
	public void addProductToBag()
	{
		try
		{
			sw.setValue("Jeans", "xpath", HomePageObj.searchTxtBox);
			sw.click("id", HomePageObj.searchButton);
			sedriver.explicitlyWait("xpath", PLPPageObj.plpProduct);
			sw.click("xpath", PLPPageObj.plpProduct);
			sedriver.explicitlyWait("xpath", PDPPageObj.colorWebElm);
			sw.click("xpath", PDPPageObj.colorWebElm);
			
			sw.click("xpath", PDPPageObj.sizeWebElm);
			
			sedriver.explicitlyWait("xpath", PDPPageObj.sizeWebElm);
			
			Thread.sleep(4000);
			
			String expectedText = "In Stock";
			String actualText = sw.getText("xpath", PDPPageObj.inStockWebElm);
			
			Assert.assertEquals(actualText, expectedText, "Product is not in Stock");
			
			sw.click("id", PDPPageObj.addToBagWebElm);
			
			sedriver.explicitlyWait("xpath", PDPPageObj.addToBagConfirm);
			
			Thread.sleep(4000);
			String expectedAddBagText = "This item has been added to your bag.";
			
			String actualConfirmationMsg = sw.getText("xpath", PDPPageObj.addToBagConfirm);
			
			Assert.assertEquals(actualConfirmationMsg, expectedAddBagText, "Product is not addedto the bag");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult itr)
	{
		boolean b1 = itr.isSuccess();
		if(!b1)
		{
			sedriver.takeScreenShot(itr.getMethod().getMethodName());
		}
	}
	
	
	
	
	
}
