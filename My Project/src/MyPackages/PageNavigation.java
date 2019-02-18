package MyPackages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Utility;

public class PageNavigation {

	public WebDriver driver;
	
	
	@BeforeMethod
	public void Lunchbrowser() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.fingoshop.com/");
		}
	
	
//	@Test
//	public void PageNavg() throws Exception {
//		try {
//		driver.findElement(By.linkText("Women")).click();
//	    driver.findElement(By.xpath("//div[2]/div/div/div/div/div[1]/div/div/ul/li[1]/ul/li/div/div/div[1]/a[1]")).click();
//	    WebElement myDynamicElement = (new WebDriverWait(driver, 10))
//             .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/div/div/div/div[1]/div/div/ul/li[1]/ul/li/div/div/div[1]/a[1]")));
//            getResults(driver);
//            Thread.sleep(1000);
//	    List<WebElement> links=driver.findElements(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div[1]/div/div[3]/div[3]/div/div[1]/div[2]/ol/li/a"));
//		System.out.println("numberpages : " +links.size() );
//	    for(int i=0;i<links.size();i++){
//	    Thread.sleep(5000);	
//        driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div[1]/div/div[3]/div[3]/div/div[1]/div[2]/ol/li[6]/a")).click();
//        Thread.sleep(1000);
//        getResults(driver);
//	    }
//     } catch (Exception e) {
//      System.err.println("Error caught - " + e);
//     }
//   }
//	
//  public static void getResults(WebDriver driver) {
//     List<WebElement> findElements = null;
//     findElements = driver.findElements(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div[1]/div/div[3]/div[3]/div/div[1]/div[2]/ol/li[6]/a"));
//
//       for (WebElement webElement : findElements) {
//    	   System.out.println(webElement.getAttribute("href"));
//       }
//    }
// }
// 
       
	@Test
   public void PageNavg() throws Exception {
	try{
	driver.findElement(By.linkText("Women")).click();
	driver.findElement(By.xpath("//div[2]/div/div/div/div/div[1]/div/div/ul/li[1]/ul/li/div/div/div[1]/a[1]")).click();
	 WebElement myDynamicElement = (new WebDriverWait(driver, 10))
             .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/div/div/div/div[1]/div/div/ul/li[1]/ul/li/div/div/div[1]/a[1]")));
             getResults(driver);
             Thread.sleep(1000);

             for (int i = 0; i <= 1000; i++) {
                 driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div[1]/div/div[3]/div[3]/div/div[1]/div[2]/ol/li[6]/a")).click();
                 Thread.sleep(1000);
                 getResults(driver);
             }
         } catch (Exception e) {
             System.err.println("Error caught - " + e);
         }

     }

     public static void getResults(WebDriver driver) {
         List<WebElement> findElements = null;
         findElements = driver.findElements(By.xpath("html/body/div[1]/div/div[4]/div/div[2]/div/div[1]/div/div[3]/div[3]/div/div[1]/div[2]/ol/li[6]/a"));

         for (WebElement webElement : findElements) {
             System.out.println(webElement.getAttribute("href"));
         }
     }

}
	
	

