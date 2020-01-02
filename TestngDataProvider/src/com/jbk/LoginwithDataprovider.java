package com.jbk;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginwithDataprovider {
	@Test(dataProvider = "loginTestCaseDp")
	public void loginpage(String testDesp, String un, String pwd, String expMEssage, String expMEssage1) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();

		driver.get("file:///F:/Selenium%20Software/Offline%20Website/Offline%20Website/index.html");
		System.out.println(111);

		driver.findElement(By.id("email")).sendKeys(un);
		System.out.println();
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();

		if (!testDesp.equals("valid")) {
			String actErrorMesgemail = driver.findElement(By.xpath(".//*[@id='email_error']")).getText();
			String expErroMsg = expMEssage;
			Assert.assertEquals(actErrorMesgemail, expErroMsg);

			String actErrorMesgpass = driver.findElement(By.xpath(".//*[@id='password_error']")).getText();
			String expErroMsg1 = expMEssage1;
			Assert.assertEquals(actErrorMesgpass, expErroMsg1);

		} else {
			String actTitle = driver.getTitle();
			System.out.println(actTitle);
			Assert.assertEquals(actTitle, expMEssage);

		}
		driver.close();
	}

	@DataProvider
	public Object[][] loginTestCaseDp() {
		return new Object[][] {
				new Object[] { "blank", " ", " ", "Please enter email as kiran@gmail.com",
						"Please enter password 123456" },
				new Object[] { "Inavalid", "asfds", "asdcc", "Please enter email as kiran@gmail.com",
						"Please enter password 123456" },
				new Object[] { "valid", "kiran@gmail.com", "123456", "JavaByKiran | Dashboard",
						"JavaByKiran | Dashboard" } };
	}
}

/*
 * import org.testng.annotations.Test; import org.junit.Assert; import
 * org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.testng.annotations.BeforeSuite; import
 * org.testng.annotations.DataProvider; import org.testng.annotations.Listeners;
 * 
 * 
 * @Listeners(com.testng.dp.shoaib.TrackingUtility.class) public class
 * Data_Provider_Complete { public static WebDriver driver = null;
 * 
 * 
 * @BeforeSuite public void beforeSuite() { driver = new FirefoxDriver();
 * driver.get("file:///D:/JBK%20Offline%20Website/index1.html"); }
 * 
 * @Test(dataProvider = "loginTestcasesData") public void CheckAllCases(String
 * TestCaseId, String testcasedescr, String uname, String pswd, String Expmesg)
 * { System.out.println("now test case running >>" +TestCaseId+"descr>>"
 * +testcasedescr); WebElement
 * username=driver.findElement(By.xpath(".//*[@id='email']")); username.clear();
 * username.sendKeys(uname);
 * 
 * WebElement password= driver.findElement(By.xpath(".//*[@id='password']"));
 * password.clear(); password.sendKeys(pswd);
 * driver.findElement(By.xpath(".//*[@id='form']/div[3]/div/button")).click();
 * 
 * 
 * if(!testcasedescr.equals("valid")){ String
 * actualerrormessage=driver.findElement(By.xpath(".//*[@id='email_error']")).
 * getText(); String expectederrormessage= Expmesg;
 * Assert.assertEquals(actualerrormessage, expectederrormessage); } else{
 * 
 * String actualerrormessage = driver.getTitle();
 * System.out.println("Actual title of the page is" +actualerrormessage); String
 * expectederrormessage = "JavaByKiran | Dashboard";
 * 
 * Assert.assertEquals(actualerrormessage, expectederrormessage);
 * 
 * } }
 * 
 * @DataProvider public Object[][] loginTestcasesData() { return new Object[][]
 * { new Object[] { "TC01","blank","","","balnk user name pswd not allowed" },
 * new Object[] { "TC02", "invalid", "s@yes.com","1234",
 * "invalid uname and pswd not allowed" }, new Object[] { "TC03", "valid",
 * "kiran@gmail.com", "123456", "Dashboard"} }; } }
 */

/*
 * //read the data from excel in data provider public Object[][] logiTestCaseDp{
 * return Excelreader.getdp(); //Object [][]getdp() class create and put the
 * logic of excel sheet }
 */
