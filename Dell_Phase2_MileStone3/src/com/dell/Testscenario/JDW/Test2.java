package com.dell.Testscenario.JDW;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {
	
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		driver.get("jvd");
		
		List<WebElement> rows = driver.findElements(By.xpath("Check box xpath"));
		
		int len = rows.size();
		
		if(len>=1)
		{
			for(int i=0; i<len; i++)
			{
				boolean flag = rows.get(i).isSelected();
				if(!flag)
				{
					driver.findElement(By.xpath("Check box xpath")).click();
				}
			}
			rows.get(2).click();
		}
		
	}

}
