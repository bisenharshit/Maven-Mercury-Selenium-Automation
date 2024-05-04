package com.cjc.webapp.mercury.pages;  //15.02.2023

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.cjc.webapp.mercury.Utility.MercuryCommonUtility;

public class MercuryRegisterPage extends MercuryCommonUtility {

	static Logger log = Logger.getLogger(MercuryRegisterPage.class.getName());

	@FindBy(css = "[name='firstName']")
	WebElement firstname;
	@FindBy(css = "[name='lastName']")
	WebElement lastname;
	@FindBy(css = "[name='phone']")
	WebElement phonnumber;
	@FindBy(css = "[name='userName']")
	WebElement email;
	@FindBy(css = "[name='address1']")
	WebElement addr1;
	@FindBy(css = "[name='city']")
	WebElement city;
	@FindBy(css = "[name='state']")
	WebElement state;
	@FindBy(css = "[name='postalCode']")
	WebElement postalcode;
	@FindBy(css = "[name='country']")
	WebElement country;
	@FindBy(css = "[name='email']")
	WebElement username;
	@FindBy(css = "[name='password']")
	WebElement password;
	@FindBy(css = "[name='confirmPassword']")
	WebElement cpassword;
	@FindBy(css = "[name='submit']")
	WebElement submit;

	public MercuryRegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void mercuryRegister(String fname,String lname,String phone,String em,
			String addr,String cityN,String stateN,String pcode,String uname,
			String pass, String cpass) throws InterruptedException {

		firstname.sendKeys(fname);
		Thread.sleep(500);
		lastname.sendKeys(lname);
		Thread.sleep(500);
		phonnumber.sendKeys(phone);
		Thread.sleep(500);
		email.sendKeys(em);
		Thread.sleep(500);
		addr1.sendKeys(addr);
		Thread.sleep(500);
		city.sendKeys(cityN);
		Thread.sleep(500);
		state.sendKeys(stateN);
		Thread.sleep(500);
		postalcode.sendKeys(pcode);
		Thread.sleep(500);
		Select select = new Select(country);
		select.selectByIndex(125);
		Thread.sleep(500);
		username.sendKeys(uname);
		Thread.sleep(500);
		password.sendKeys(pass);
		Thread.sleep(500);
		cpassword.sendKeys(cpass);
		Thread.sleep(500);
		submit.click();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.guru99.com/test/newtours/login.php");
	}

}
