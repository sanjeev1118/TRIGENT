package com.dell.framework.core.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) 
	{		
		
		WebDriver driver  = Driver1.getDriver();
		driver.get("https://gmail.com");
		System.out.println("Changes are made");
		
	}
	

}
