package com.cjc.webapp.mercury.pages; //16.02.2023

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.cjc.webapp.mercury.Utility.MercuryCommonUtility;

public class MercuryFlightBooking extends MercuryCommonUtility{

	static Logger log = Logger.getLogger(MercuryFlightBooking.class.getName());

	@FindBy(css = "body > div:nth-child(5) > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > a")
	WebElement flightHyperlink;

	@FindBy(css = "[value='roundtrip']")
	WebElement tripType;

	@FindBy(css = "[name='passCount']")
	WebElement passCounttype;

	@FindBy(css = "[name='fromPort']")
	WebElement fromPortType;

	@FindBy(css = "[name='fromMonth']")
	WebElement fromMonthType;

	@FindBy(css = "[name='fromDay']")
	WebElement fromDayType;

	@FindBy(css = "[name='toPort']")
	WebElement toPortType;

	@FindBy(css = "[name='toMonth']")
	WebElement toMonthType;

	@FindBy(css = "[name='toDay']")
	WebElement toDateType;

	@FindBy(css = "[value='Business']")
	WebElement serviceClsBusnss;

	@FindBy(css = "[name='airline']")
	WebElement airlinePrefer;

	@FindBy(css = "[name='findFlights']")
	WebElement flightsFind;

	@FindBy(css = "body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > a > img")
	WebElement backToHome;

	public MercuryFlightBooking(WebDriver driver) {
		this.driver = driver;
	}

	public void flightBoookingMercury() throws InterruptedException {
		Thread.sleep(500);
		flightHyperlink.click();
		Thread.sleep(500);
		tripType.click();
		Thread.sleep(500);
		Select select = new Select(passCounttype);
		select.selectByIndex(1);
		Thread.sleep(500);
		Select select1 = new Select(fromPortType);
		select1.selectByIndex(1);
		Thread.sleep(500);
		Select select2 = new Select(fromMonthType);
		select2.selectByIndex(1);
		Thread.sleep(500);
		Select select3 = new Select(fromDayType);
		select3.selectByIndex(1);
		Thread.sleep(500);
		Select select4 = new Select(toPortType);
		select4.selectByIndex(1);
		Thread.sleep(500);
		Select select5 = new Select(toMonthType);
		select5.selectByIndex(1);
		Thread.sleep(500);
		Select select6 = new Select(toDateType);
		select6.selectByIndex(1);
		Thread.sleep(500);
		serviceClsBusnss.click();
		Thread.sleep(500);
		Select select7 = new Select(airlinePrefer);
		select7.selectByIndex(1);
		Thread.sleep(500);
		flightsFind.click();
		Thread.sleep(1000);
		backToHome.click();
//		Thread.sleep(1500);
//		driver.navigate().to("https://demo.guru99.com/test/newtours/register.php");
	}

}
