package eCommerceLive;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;

public class TestCase6 {
	  private WebDriver driver;
	  private String baseUrl;
	  public String EmailAddress= "mohan123@tpg.com.au";       
	  public String Password = "dfdfdfdfdf";  
	  
	  
	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://live.guru99.com/";
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testTestCase5() throws Exception {
		
		// 1. Go to http://live.guru99.com
	    driver.get(baseUrl); 
	    
	    // 2. Click on my account link
	    driver.findElement(By.linkText("MY ACCOUNT")).click();
	    Thread.sleep(2000);
	    
	    // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    // 3a. and fill pervious credential username and password
	    Thread.sleep(3000);
	    driver.findElement(By.name("login[username]")).clear();
	    driver.findElement(By.name("login[username]")).sendKeys(EmailAddress);
	    Thread.sleep(3000);
	    driver.findElement(By.name("login[password]")).clear();
	    driver.findElement(By.name("login[password]")).sendKeys(Password);
	    Thread.sleep(3000);
	    // 3b. Click Login Button
	    
	    driver.findElement(By.xpath("//button[@title='Login']")).click();
	  }
	  
	  
	  //@AfterTest
	  
//	     // Close Browser
//		public void tearDown() throws Exception {
//			Thread.sleep(1000);
//			driver.quit();
//}
}
	  
	  