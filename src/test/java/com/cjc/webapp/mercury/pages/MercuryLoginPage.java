package com.cjc.webapp.mercury.pages; //12.02.2023

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cjc.webapp.mercury.Utility.MercuryCommonUtility;

public class MercuryLoginPage extends MercuryCommonUtility{

	static Logger log = Logger.getLogger(MercuryLoginPage.class.getName());
	@FindBy(css = "[name='userName']")
	WebElement usernname;

	@FindBy(css = "[name='password']")
	WebElement password;

	@FindBy(css = "[name='submit']")
	@CacheLookup
	WebElement submit;

	public MercuryLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String uname, String Pass) throws InterruptedException {

		usernname.sendKeys(uname);
		Thread.sleep(500);
		password.sendKeys(Pass);
		Thread.sleep(500);
		submit.click();

	}

}
