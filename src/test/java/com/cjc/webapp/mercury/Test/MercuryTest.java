package com.cjc.webapp.mercury.Test; //14.02.2023

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cjc.webapp.mercury.Utility.MercuryCommonUtility;
import com.cjc.webapp.mercury.pages.MercuryFlightBooking;
import com.cjc.webapp.mercury.pages.MercuryLoginPage;
import com.cjc.webapp.mercury.pages.MercuryRegisterPage;

public class MercuryTest extends MercuryCommonUtility {

	static Logger log = Logger.getLogger(MercuryTest.class.getName());

	@Test(priority = 2, dataProvider = "getdataEagerLoading")
	public void mercuryLogin(String uname, String pass) throws InterruptedException {
		MercuryLoginPage ml = PageFactory.initElements(driver, MercuryLoginPage.class);
		ml.login(uname, pass);
		log.info("Mercury Login Page Successfully");
	}

	@Test(priority = 1, dataProvider = "getDataLazyLoading")
	public void mercuryRegister(String fname, String lname, String phone, String em, String addr, String cityN,
			String stateN, String pcode, String uname, String pass, String cpass) throws InterruptedException {
		MercuryRegisterPage mr = PageFactory.initElements(driver, MercuryRegisterPage.class);
		mr.mercuryRegister(fname, lname, phone, em, addr, cityN, stateN, pcode, uname, pass, cpass);
		log.info("Mercury Register Successfully");
	}

	@Test(priority = 3)
	public void filghtbooking() throws InterruptedException {
		MercuryFlightBooking mf = PageFactory.initElements(driver, MercuryFlightBooking.class);
		mf.flightBoookingMercury();
		log.info("Successfully Booking The Flight On Mercury");
	}


	@DataProvider
	public Object[][] getdataEagerLoading() {
		Object ob[][] = new Object[1][2];
		ob[0][0] = "harshitbisen123";
		ob[0][1] = "Harshit@123";
//		ob[1][0] = "jacksparrow123";
//		ob[1][1] = "Jack@123";
		return ob;
	}

	@DataProvider
	public Object[][] getDataLazyLoading() {
		return new Object[][] { 
			new Object[] { "Harshit", "Bisen", "9981206487", "harshitbisen564@gmail.com",
				"Karvenagar", "Pune", "Maharstra", "123456", "harshitbisen123", "Harshit@123", "Harshit@123" }
//			new Object[] { "Jack", "Sparrow", "4581206487", "jacksaprrow123@gmail.com",
//					"Flamming Street", "Dalas", "Newyork", "0163456", "jacksparrow123", "Jack@123", "Jack@123" }
			};

	}

}
