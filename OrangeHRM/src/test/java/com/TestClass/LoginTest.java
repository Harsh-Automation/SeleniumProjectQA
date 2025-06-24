package com.TestClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClass;
import com.PageClass.LoginPage;
import com.Utilities.Utilities;

public class LoginTest extends BaseClass {

	LoginPage lp;

	@Test
	public void loginTest() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		sa.assertTrue(lp.lblLoginIsDisplayed());

		lp.enter_username_password("Admin", "admin123");

		sa.assertTrue(lp.forgetPwdLinkIsDisplayed());
		Utilities.takeScreenshot("LoginPage");
		Thread.sleep(1000);
		lp.click_on_login();

		lp.dashboardIsDisplayed();
		Utilities.takeScreenshot("Dashboard");

		sa.assertAll();

	}

}
