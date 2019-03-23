package CucumberFramework1.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Login {
	WebDriver driver;
	
	@Before
	public void setUp() {
//      System.setProperty("wedriver.chrome.driver","C:\\Users\\CreoTech\\Desktop\\Cucumber Framework1\\CucumberFramework1\\src\\test\\java\\CucumberFramework1\\resources" );
//	  this.driver=new ChromeDriver();
	  this.driver=new FirefoxDriver();	
	  this.driver.manage().window().maximize();
	  this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  this.driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
	  
	}
	
	@After
	public void tearDown() {
	this.driver.manage().deleteAllCookies();
	this.driver.quit();
	this.driver=null;
	
		
	}
	@Given("^: User naviagte to home page$")
	public void user_naviagte_to_home_page() throws Throwable {
	  driver.get("http://test.bookwow.in/");  
	}

	@And("^: Check whether Email field exists or not$")
	public void check_whether_Email_field_exists_or_not() throws Throwable {
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
	}

	@And("^: Check whether Password field exists or not$")
	public void check_whether_Password_field_exists_or_not() throws Throwable {
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
	}

	@When("^: Asserting the Sign In button exists or not and clicking it$")
	public void asserting_the_Sign_In_button_exists_or_not_and_clicking_it() throws Throwable {
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
	}

	@When("^: Asserting and clicking on the Signout button$")
	public void asserting_and_clicking_on_the_Signout_button() throws Throwable {
		try {
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
