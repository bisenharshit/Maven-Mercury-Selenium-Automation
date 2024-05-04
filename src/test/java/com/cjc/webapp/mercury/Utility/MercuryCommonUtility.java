package com.cjc.webapp.mercury.Utility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class MercuryCommonUtility {

	public WebDriver driver;
	static Logger log = Logger.getLogger(MercuryCommonUtility.class.getName());

	@BeforeSuite
	public void browserOpen() {
		log.debug("This is the Data Driven Framework Performed On The Mercury");
		System.setProperty("webdriver.chrome.driver", "src//test//resources//Browser Exe//chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Open The Browser Successfully");
	}

	@BeforeTest
	//@Parameters({ "url" })String urlPassing
	public void sendingUrl() {
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		log.info("Sending The URL Successfully");
	}

	@BeforeClass
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		log.info("Maximize and Putting Wait Successfully");
	}

	@BeforeMethod
	public void addingCookies() {
		Set<org.openqa.selenium.Cookie> cook = driver.manage().getCookies();
		int cookSize = cook.size();
		log.info("Adding The Cookies Successfully = " + cookSize);
	}

	@AfterMethod
	public void screenShots() throws IOException, InterruptedException {
		Thread.sleep(2000);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("src//test//resources//Screenshots"));
		log.info("Screen Shot Taken Successfully");
	}

	@AfterClass
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
		log.info("Delete All The Cookies Successfully");
	}

	@AfterTest
	public void dataBaseConnection() {
		log.info("Data Base Connection Close Successfully");
	}

	@AfterSuite
	public void browserClosing() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		log.info("Browser Close Successfully");
	}

}
