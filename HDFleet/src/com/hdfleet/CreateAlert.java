package com.hdfleet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import util_lib.Constants;

public class CreateAlert {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Automating HDFleet application");
		System.setProperty("webdriver.gecko.driver", "D:/Software/Selenium/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Launch URL
		driver.get(Constants.url);
		
		//Login to application
		driver.findElement(By.id("email")).sendKeys(Constants.un);
		driver.findElement(By.id("inputPassword3")).sendKeys(Constants.pw);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//Click on Vehicle Status
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Vehicle Status')]")).click();
		driver.findElement(By.xpath("//div[@id='slmenu']/img")).click();
		//Select customers
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click;", driver.findElement(By.xpath("//a[contains(text(),'TWG Supply')]")));
		//driver.findElement(By.xpath("//a[contains(text(),'TWG Supply')]")).click();
		
		//Close session
		driver.close();
	}

}
