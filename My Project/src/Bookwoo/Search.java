package Bookwoo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search {
	public WebDriver driver;
	@BeforeMethod
	public void Launchbrowser() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://test.bookwow.in/");
	}
	@Test
	public void Search1() {
		Actions act=new Actions(driver);
		Action sendesc=act.sendKeys(Keys.ESCAPE).build();
		sendesc.perform();
		driver.findElement(By.xpath("html/body/div[2]/div/a")).click();
		Action sendpagedown=act.sendKeys(Keys.PAGE_DOWN).build();
		sendpagedown.perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpathRow="//*[@class='row hostel-details']/div/div";
		List<WebElement> listTotal=driver.findElements(By.xpath(xpathRow));
		System.out.println("Total number of rows"+listTotal.size());
		for (int i = 0; i < listTotal.size(); i++) {
		String xpathcols="//*[@class='col-lg-6 col-md-6 col-sm-6 col-xs-12 first-sec']/div";
		List<WebElement> listcols=driver.findElements(By.xpath(xpathcols));
		System.out.println("Total number of cols"+listcols.size());	
		for (int j = 0; j <listcols.size(); j++) {
			String xapthHostelname="html/body/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/h4";
			List<WebElement>contentel=driver.findElements(By.xpath("xapthHostelname"));	
			System.out.println(contentel.get(j).getText());
		}
		System.out.println("==============================");
		}
	}
}

