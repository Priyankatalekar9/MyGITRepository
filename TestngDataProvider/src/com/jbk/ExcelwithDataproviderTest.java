package com.jbk;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class ExcelwithDataproviderTest {

	public static WebDriver driver;

	@BeforeSuite
	public void SetUp_Browser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("file:///F:/Selenium%20Software/Offline%20Website/Offline%20Website/index.html");
		System.out.println(111);

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		System.out.println();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();

	}

	@Test(dataProvider = "loginTestCaseDp")
	public void loginpage(String expMenuName) {
		WebElement menu1 = driver.findElement(By.xpath("//*[@class=\"sidebar-menu\"]//following-sibling::li[1]"));
		System.out.println(111);
		List<WebElement> list = menu1.findElements(By.tagName("li"));

		System.out.println(222);
		for (WebElement we : list) {
			System.out.println(333);
			// int actSize=list.size();
			System.out.println(we.getText());
			System.out.println(444);
			Assert.assertEquals(we.getText(), expMenuName);
			System.out.println(555);
		}
	}

	@DataProvider
	public Object[][] loginTestCaseDp() throws Exception {
		return Excelreader.getDP("Book2.xls", "Sheet1");
	}

}
