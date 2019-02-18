package MyPackages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollByPage {
	public WebDriver driver;
	
@BeforeMethod
public void LaunchBrowser() {
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.fingoshop.com/");
}


@Test
public void Bypage() throws InterruptedException {
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//     js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
    for(int sl=0;;sl++)
     {
         if(sl>=60)
           {
            break;
       }
	
          js.executeScript("window.scrollBy(0,500)","");
          Thread.sleep(1000);
            
      }
    Thread.sleep(5000);
   for(int s=0;;s++)
  {
       if(s>=60)
        {
            break;
       }
       js.executeScript("window.scrollBy(500,0)","");
      Thread.sleep(1000);
      }

//  @AfterMethod
//  public void CloseBrowser() {
//  driver.close();
//  driver.quit();		
// }

}
}

