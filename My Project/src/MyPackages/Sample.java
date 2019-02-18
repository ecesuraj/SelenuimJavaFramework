package MyPackages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample {
	 public WebDriver driver;
	 
	 @BeforeMethod
	 public void Lunchbrowser() {
	 	driver=new FirefoxDriver();
	 	driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	driver.get("https://www.fingoshop.com/");
	 	}
@Test
public void Urlcapture() {
	//driver.findElement(By.xpath("//div[2]/div/div/div/div/div[1]/div/div/ul/li[1]/a"));
    driver.findElement(By.linkText("Women")).click();
	//List<WebElement> links=driver.findElements(By.xpath("//div[2]/div/div/div/div/div[1]/div/div/ul/li[1]/ul/li/div/div/div[1]/div[1]/ul/li/a"));
    List<WebElement> links=driver.findElements(By.xpath("//*[@class='item level1 text-content']/div/div/div/div"));
    int Totalcount=links.size();	
	System.out.println(Totalcount);
	for (int i = 0; i < Totalcount; i++) {
		System.out.println(links.get(i).getAttribute("href"));
		
	}
}

@AfterMethod
public void CloseBrowser() {
	driver.close();
	driver.quit();
}

}