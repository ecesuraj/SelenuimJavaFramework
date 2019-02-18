package Bookwoo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookwowLoginPage {
public WebDriver driver;
	
	@BeforeMethod
	public void Lunchbrowser() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.bookwow.in/");
		}
	
	@Test(priority=0)
	public void Case1() {
		/*CASE- 1. Both User name and Password are entered correctly. 
		Check whether Email field exists or not */

		try
        {
          driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/a[1]")).click();
			WebElement a1 = driver.findElement(By.xpath("//*[@id='loginform-username']"));
          System.out.println("---------Email field exists --------------\n-----------------------");
          a1.sendKeys("9515321546");
         }
    catch(Throwable e)
         {
         System.out.println("Email field not found: " + e.getMessage());
         }

    //Check whether Password field exists or not
     try
        {
    	 Thread.sleep(5000);
	 WebElement password = driver.findElement(By.xpath("//*[@id='loginform-password']"));
         System.out.println("----------Password field exits ------------\n-----------------------");
         password.sendKeys("123456");
        }
    catch(Throwable e)
        {
	 System.out.println("Password field not found: " + e.getMessage());
        }

//Asserting the Sign In button exists or not and clicking it
try
{
 	WebElement button = driver.findElement(By.name("login-button"));
         System.out.println("-------Sign In button exists----------\n-----------------------");
        //To uncheck the "Check sign in" checkbox
        WebElement check_stay_sign_in = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[4]/button"));
         check_stay_sign_in.click();   
 	button.click();
 	System.out.println("----------Sucessful Login -------");
         }
     catch(Throwable e)
         {
 	System.out.println("Sign In button not found: "+ e.getMessage());
         }
//Asserting and clicking on the Signout button.
try
   {
	Thread.sleep(5000);
//WebElement signout=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/ul/li[3]"));
WebElement signout=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]")); 
System.out.println("--------Sign out button exists  ---------\n-----------------------");
signout.click();
Thread.sleep(5000);
driver.findElement(By.xpath("//div[1]/div/div[2]/div[1]/ul/li[1]/ul/li[3]/form/button")).click();
System.out.println("----------Sign out was successful -------");
    }
catch(Throwable e)
    {
System.out.println("Sign out button not found: "+e.getMessage());
    }


}

}

