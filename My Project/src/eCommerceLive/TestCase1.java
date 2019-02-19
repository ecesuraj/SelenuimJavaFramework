package eCommerceLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	WebDriver driver;
	String baseUrl;
	WebElement clickMobileTab;
	
	@BeforeTest
	public void setUp() {
		
		driver=new FirefoxDriver();
		baseUrl="http://live.guru99.com/index.php/mobile.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testTestCase1() throws Exception {
		
		// 1. Go to http://live.guru99.com
		driver.get(baseUrl);
		
		// 2. Verify title of the page
		
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Mobile");
		
		// 3. Click on Mobile Menu
		
		clickMobileTab= driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		clickMobileTab.click();
		
		// 4. Verify title of the page
		
		String titleofMobile=driver.getTitle();
		System.out.println( titleofMobile);
		Assert.assertEquals(titleofMobile, "Mobile");
		
		//5. In the list of all mobile , select 'SORT BY' Dropdown as name
		
		Select sort=new Select(driver.findElement(By.xpath("//body[contains(@class,'catalog-category-view categorypath-mobile-html category-mobile')]/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")));
		sort.selectByVisibleText("Name");
		Thread.sleep(3000);	
		
	}
	
	@AfterTest
	
	// close browser
	
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
	

}
