package MyPackages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Myclass {
 public WebDriver driver;
 
@BeforeMethod
public void Lunchbrowser() {
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.fingoshop.com/");
	}


@Test(priority=0)
public void verfiypageTitleTest() {
	String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Best Online Shopping Site in India – fingoshop.com");
}
@Test(priority=1)
public void verifyFingologo() {
	boolean flag=driver.findElement(By.xpath("//div[2]/div/div[1]/div/div/div[1]/h1/a/img")).isDisplayed();
	Assert.assertTrue(flag);
	
}

@Test(priority=2)
public void Signin() {
	driver.findElement(By.linkText("Sign In")).click();
	driver.findElement(By.id("mini-login")).sendKeys("suraj@ctouchproducts.com");
	driver.findElement(By.id("mini-password")).sendKeys("luckyali");
	driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[1]/div[1]/div/div/div[2]/ul/li[7]/div/div/form/div/div[2]/button")).click();
	System.out.println("signinlogin successfully");
	driver.findElement(By.xpath("//div[1]/div/div/div[2]/ul[2]/li[7]")).click();
	System.out.println("signinlogout successfully");
	
	
	
}

@Test(priority=3)
public void SignUp(){
    driver.findElement(By.linkText("Sign Up")).click();
    driver.findElement(By.id("firstname")).sendKeys("suraj");
    driver.findElement(By.id("lastname")).sendKeys("mahato");
    driver.findElement(By.id("email_address")).sendKeys("suraj.ctouchproducts@gmail.com");
    driver.findElement(By.id("password")).sendKeys("luckyali");
    driver.findElement(By.id("confirmation")).sendKeys("luckyali");
    driver.findElement(By.xpath("//div[2]/form/div[5]/button")).click();
    System.out.println("signup login successfully");
      
}

@AfterMethod
public void CloseBrowser() {
	driver.close();
	driver.quit();
}

}
