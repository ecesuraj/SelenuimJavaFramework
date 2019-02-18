package Bookwoo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practices {

	public WebDriver driver;
	
	@BeforeMethod
	public void Lunchbrowser() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://test.bookwow.in/");
		}
	
	@Test(priority=0)
	public void Case1() {
	/*CASE- 1. Both User name and Password are entered correctly. 
	Check whether Email field exists or not */
	    try
	        {
	    	driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a[1]")).click();
	         Thread.sleep(5000);
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
	WebElement signout = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]"));
      Thread.sleep(6000);  
	System.out.println("--------Sign out button exists  ---------\n-----------------------");
	signout.click();
	System.out.println("----------Sign out was successful -------");
        }
    catch(Throwable e)
        {
	System.out.println("Sign out button not found: "+e.getMessage());
        }
  
	}
	@Test(priority=1)
	public void Case2() {
	// CASE- 2. Both Email and Password Fields are blank.
    try
        {
	WebElement button = driver.findElement(By.id("signIn"));
button.click();			        
WebElement GmailText = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a[1]"));
String text = GmailText.getText();
if(text.equals("Primary"))
{
   System.out.println("----------Sucessful Login -------");
}
else
{
	System.out.println("----------Login Failure ----------");
		}
		
}
catch(Throwable e)
{
		System.out.println("Error! Email and Password fields are blank. \n----------------------- ");
System.out.println("Element not found: "+e.getMessage() + "\n-----------------------");
  }
	}
	
	@Test(priority=2)
	public void Case3() {
	
	// CASE- 3. Email field is filled and Password field is blank
	try
	{		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a[1]")).click();
        Thread.sleep(5000);
			WebElement email = driver.findElement(By.id("loginform-username"));
	email.sendKeys("9515321546	");
	WebElement pass = driver.findElement(By.id("loginform-password"));
	WebElement button = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a[1]"));
	//WebElement button = driver.findElement(By.id("signIn"));
	button.click();
    
	WebElement GmailText = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[2]/div/input"));
	String text = GmailText.getText();
	if(text.equals("Primary"))
	{
	System.out.println("----------Sucessful Login -------\n-----------------------");
	}
	else
	{
	System.out.println("----------Login Failure ----------\n-----------------------");
			}
			
	
	 }
	catch(Throwable e)
	 {
			System.out.println("Error! Password field is blank. \n-----------------------");
	System.out.println("Element not found: "+e.getMessage() + "\n-----------------------");
	 }	

	driver.findElement(By.id("loginform-username")).clear();			// Clearing the Email field

	}
	@Test(priority=3)
	public void Case4() {
	// CASE- Email is wrong and Password is wrong	
	 try 
	 {
     driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a[1]")).click();
	 Thread.sleep(5000);
	WebElement email = driver.findElement(By.id("loginform-username"));
	email.sendKeys("9515321544");
	WebElement password = driver.findElement(By.id("loginform-password"));
	password.sendKeys("123455");
	WebElement button = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[4]/button"));
	button.click();
	//System.out.println("Login Failure");
    WebElement Login = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[4]/button/"));
	if(Login != null) 
    {
 	System.out.println("Sucessful Login \n -----------------");
	} 
   else 
   {
   System.out.println("Login Failure");			}
	  } 
	 catch(Throwable e) 
	 {
		  
		  System.out.println("Error! Incorrect Email and password. \n-----------------------");
	  System.out.println("Element not found: "+e.getMessage() + "\n-----------------------");
	  }
	 
	  driver.findElement(By.id("loginform-username")).clear();			// Clearing the Email field
	  driver.findElement(By.id("loginform-password")).clear();			// Clearing the Password field
	  
	} 
	
	//CASE- 7. Email is correct and Password is wrong 	
	@Test(priority=4)
	public void Case5() {
	 try
	 {
		 driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a[1]")).click();
		 Thread.sleep(5000);
		WebElement email = driver.findElement(By.id("loginform-username"));
		email.sendKeys("9515321546");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("123455");
		WebElement button = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[4]/button"));
		button.click();
		 WebElement LoginText = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[4]/button"));
	 String text = LoginText.getText();
	 if(text.equals("Hi Suraj"))
	 {
	 System.out.println("----------Sucessful Login -------");
	 } 
	 else
	 {
	 System.out.println("----------Login Failure ----------");
				}
	  }
	 catch(Throwable e)
	 {
		   System.out.println("Error! Incorrect Password. \n-----------------------");			  
	   System.out.println("Element not found: "+e.getMessage() + "\n-----------------------");
	  }

	  driver.findElement(By.id("loginform-username")).clear();			// Clearing the Email field
	  driver.findElement(By.id("loginform-password")).clear();			// Clearing the Password field
}
	//CASE- 7. Email is wrong and Password is correct	
		@Test(priority=5)
		public void Case6() {
		 try
		 {
			 driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[2]/div[1]/ul/li[1]/a[1]")).click();
			 Thread.sleep(5000);
			WebElement email = driver.findElement(By.id("loginform-username"));
			email.sendKeys("9515321545");
			WebElement password = driver.findElement(By.id("loginform-password"));
			password.sendKeys("123456");
			WebElement button = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[4]/button"));
			button.click();
			 WebElement LoginText = driver.findElement(By.xpath("html/body/div[1]/form/div/div/div/div/div[4]/button"));
		 String text = LoginText.getText();
		 if(text.equals("Hi Suraj"))
		 {
		 System.out.println("----------Sucessful Login -------");
		 } 
		 else
		 {
		 System.out.println("----------Login Failure ----------");
					}
		  }
		 catch(Throwable e)
		 {
			   System.out.println("Error! Incorrect Email. \n-----------------------");			  
		   System.out.println("Element not found: "+e.getMessage() + "\n-----------------------");
		  }

		  driver.findElement(By.id("loginform-username")).clear();			// Clearing the Email field
		  driver.findElement(By.id("loginform-password")).clear();			// Clearing the Password field
	}
@AfterMethod
public void CloseBrowser() { 
driver.close();
driver.quit();		
}

}





