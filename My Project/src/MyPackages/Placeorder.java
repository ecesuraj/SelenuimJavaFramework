package MyPackages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.remote.server.handler.GetElementLocation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Utility;

public class Placeorder {
	
	public WebDriver driver;
	public static String sBookkey="Dummy";
	private static final String sSearchResult="//div[2]/div/div/form/div/div[2]/ul/li";
	private static final String sAddToCart="//*[@id='product-addtocart-button']";
	private static final String viewCheckout="html/body/div[1]/div/div[1]/div[1]/div[2]/div/div[1]/div/div/div[4]";
	private static final String checkoutview="//div[1]/div[2]/div/div[1]/div/div/div[4]/div/a";
	public static String emailxapth="login-email";
	public static String emailusername="suraj@ctouchproducts.com";
	public static String emailpassxapth="login-password";
	public static String emailpass="luckyali";
	public static String login="checkout-login";
	
	@BeforeMethod
	public void Lunchbrowser() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.fingoshop.com/");
		}
	
//	@Test
//	public void Addtocard() throws Exception
//	{
//		driver.findElement(By.id("search")).sendKeys(sBookkey);
//		WebElement SearchBar=driver.findElement(By.xpath(sSearchResult));
//		SearchBar.click();
//		
//		//driver.findElement(By.id("search")).click();
//		//WebElement SearchBar=driver.findElement(By.id("search"));
//		//SearchBar.sendKeys("Dummy");
//		//driver.findElement(By.xpath("//div[2]/div/div/form/div/div[2]/ul/li[2]")).click();
//		
//		WebDriverWait wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sAddToCart))).click();
//		Utility.Addtocard(driver, "dummyimages");
//		driver.findElement(By.xpath(viewCheckout)).click();
//		Utility.Addtocard(driver, "addcardlink");
//		WebElement checkout=driver.findElement(By.id(emailxapth));
//		checkout.sendKeys(emailusername);
//		checkout.sendKeys(Keys.ENTER);
//		WebElement checkouts=driver.findElement(By.id(emailpassxapth));
//		checkouts.sendKeys(emailpass);
//		WebElement emaillogin=driver.findElement(By.id(login));
//		emaillogin.click();
//		WebElement Checkoutlink=driver.findElement(By.xpath("//div/ol/strong/strong/strong/li[1]/div[2]/form/fieldset/div/button"));
//		Checkoutlink.click();
//		Thread.sleep(2000);
//		Utility.Addtocard(driver, "checkoutimages");
//		driver.findElement(By.xpath("//div[1]/div/div/div[2]/ul[2]/li[7]")).click();
//		
//		}
	
	
	
//
//@AfterMethod
// public void CloseBrowser() {
// driver.close();
// driver.quit();		
//}

	
@Test
public void Addtocard2() throws Exception
{
	driver.findElement(By.id("search")).sendKeys(sBookkey);
	WebElement SearchBar=driver.findElement(By.xpath(sSearchResult));
	SearchBar.click();
	Select size=new Select(driver.findElement(By.id("attribute135")));
	size.selectByVisibleText("M");
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sAddToCart))).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath(checkoutview)).click();
	driver.findElement(By.xpath("//div/div[1]/div/div/div[4]/div/div/div[2]/div[2]/button")).click();
	WebElement checkout=driver.findElement(By.id(emailxapth));
	checkout.sendKeys(emailusername);
	checkout.sendKeys(Keys.ENTER);
	WebElement checkouts=driver.findElement(By.id(emailpassxapth));
	checkouts.sendKeys(emailpass);
	WebElement emaillogin=driver.findElement(By.id(login));
	emaillogin.click();
	WebElement Checkoutlink=driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div/div/ol/strong/strong/strong/li[1]/div[2]/form/fieldset/div/button"));
	Checkoutlink.click();
	Thread.sleep(2000);
	Utility.Addtocard2(driver, "checkoutimages");
	Thread.sleep(3000);
	driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div/div/ol/strong/strong/strong/li[3]/div[2]/form/fieldset/dl/div[1]/table/tbody/tr/td[6]")).click();
	Thread.sleep(3000);
	//driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div/div/ol/strong/strong/strong/li[1]/div[2]/form/fieldset/div/button")).click();
	driver.findElement(By.xpath("//div[1]/div/div/div[2]/ul[2]/li[7]")).click();
	
}



@AfterMethod
public void CloseBrowser() {
	driver.close();
	driver.quit();
}

}





