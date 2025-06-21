package com.TestClass;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClass;
import com.PageClass.LoginPage;
import com.Utilities.Utilities;

public class LoginTest extends BaseClass {

	LoginPage lp;

	@Test
	public void loginTest() throws InterruptedException {

		SoftAssert sa = new SoftAssert();
		try {
			
			System.out.println("****** On Login Page ******");
			lp = new LoginPage(driver);
			sa.assertTrue(lp.lblLoginIsDisplayed());
			lp.enter_username_password("Admin", "admin123");

			sa.assertTrue(lp.forgetPwdLinkIsDisplayed());
			Utilities.takeScreenshot("LoginPage");
			Thread.sleep(1000);
			lp.click_on_login();

			lp.dashboardIsDisplayed();
			System.out.println("****** On Dashboard Page ******");
			Utilities.takeScreenshot("Dashboard");

			sa.assertAll();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
