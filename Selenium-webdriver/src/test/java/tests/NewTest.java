package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
  @Test
  public void launchBrowserTest() {
	  driver.findElement(By.id("lst-ib")).sendKeys("Github");
	  new Actions(driver).sendKeys(Keys.ENTER).build().perform();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Software\\Selenium\\geckodriver.exe");
      driver = new FirefoxDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("https://www.google.com");
  }

  @AfterTest
  public void afterTest() throws Exception {
	  System.out.println("The title of the webpage is:- "+driver.getTitle());
	  Thread.sleep(1000);
	  driver.quit();
  }

}
