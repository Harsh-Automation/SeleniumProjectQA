package com.TestClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClass;
import com.PageClass.LoginPage;
import com.Utilities.Utilities;

public class LoginTest extends BaseClass {

	LoginPage lp;

	@Test(priority = 1)
	public void loginTest() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login Label not displayed on the Login Page");

		lp.enter_username_password("Admin", "admin123");

		sa.assertTrue(lp.forgetPwdLinkIsDisplayed());

		Utilities.takeScreenshot("LoginPage");
		Thread.sleep(1000);

		lp.click_on_login();

		lp.dashboardIsDisplayed();

		Utilities.takeScreenshot("Dashboard");

		sa.assertAll();

	}

	@Test(priority = 2)
	public void invalidLoginTest() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label not displayed");

		lp.enter_username_password("admin", "invalid@111");

		lp.click_on_login();
		Thread.sleep(1000);

		String actualAlert = lp.verifyLoginAlertMessage();
		sa.assertEquals(actualAlert, "Invalid credentials", "Login alert message mismatched");

		Utilities.takeScreenshot("InvalidLogin");

		sa.assertAll();
	}

	@Test(priority = 3)
	public void emptyUsernamePasswordTest() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label not displayed");

		lp.enter_username_password("", "");

		lp.click_on_login();
		Thread.sleep(1000);

		String usernameError = lp.getUsernameErrorMessage();
		String passwordError = lp.getPasswordErrorMessage();

		sa.assertEquals(usernameError, "Required", "Mismatch in username error message validation.");

		sa.assertEquals(passwordError, "Required", "Mismatch in password error message validation.");

		Utilities.takeScreenshot("EmptyCredentials");

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label should remain visible on empty credentials.");

		sa.assertAll();
	}

	@Test(priority = 4)
	public void caseSensitivityTest() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label not displayed.");

		lp.enter_username_password("admin", "ADMIN123"); // Incorrect case

		lp.click_on_login();
		Thread.sleep(1000);

		String alertMessage = lp.verifyLoginAlertMessage();
		sa.assertEquals(alertMessage, "Invalid credentials");

		Utilities.takeScreenshot("CaseSensitiveLogin");

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login should fail on incorrect case.");

		sa.assertAll();

	}

	@Test(priority = 5)
	public void verifyForgotPasswordLinkVisible() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);

		sa.assertTrue(lp.forgetPwdLinkIsDisplayed(), "Forgot password link not visible.");

		Utilities.takeScreenshot("ForgotPwdVisible");
		lp.clickOnForgetPWDLink();

		String title = lp.getForgetPasswordTitle();
		sa.assertEquals(title, "Reset Password", "Forget Password title mismatch.");

		Utilities.takeScreenshot("ForgetPWDPage");

		sa.assertAll();
	}
}
