package eCommerceLive;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase3 {

	WebDriver driver;
	String baseUrl;
	WebElement e;

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://live.guru99.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testTestCase3() throws Exception {

		// 1. Go to http://live.guru99.com
		driver.get(baseUrl); 

		// 2. Click on Mobile menu
		driver.findElement(By.linkText("MOBILE")).click();

		// 3. Click on ADD TO CART Button
		driver.findElement(By.xpath("//ul[@class='products-grid products-grid--max-4-col first last odd']//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")).click();

		// 4. Change 'QTY' Value to 1000 and click 'UPDATE' Button
		driver.findElement(By.xpath("//td[@class='product-cart-actions']//a[@title='Edit item parameters'][contains(text(),'Edit')]")).click();
		WebElement e=driver.findElement(By.xpath("//input[@id='qty']"));
		e.click();
		Thread.sleep(5000);
		e.clear();
		e.sendKeys("1000");
		Thread.sleep(3000);
		WebElement c=driver.findElement(By.xpath("//span[contains(text(),'Update Cart')]"));
		c.click();

		// 5. Verify the error message

		// 6. Then click on 'EMPTY CARD' Link
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).click();

		// 7. Verify card is empty


	}


	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}



