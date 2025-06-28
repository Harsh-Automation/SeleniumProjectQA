package com.TestClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClass;
import com.PageClass.LoginPage;
import com.Utilities.ReportManager;
import com.Utilities.Utilities;
import com.aventstack.extentreports.ExtentTest;

public class LoginTest extends BaseClass {

	LoginPage lp;

	public ExtentTest test;

	@Test(priority = 1)
	public void loginTest() throws Exception {

		test = ReportManager.report.createTest("Login test for Valid credntials");

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		test.info("LoginPage object created");

		sa.assertTrue(lp.lblLoginIsDisplayed());
		test.pass("Login label is displayed");

		lp.enter_username_password("Admin", "admin123");
		test.info("Entered username and password");

		sa.assertTrue(lp.forgetPwdLinkIsDisplayed());
		test.pass("Forgot password link is visible");

		Utilities.takeScreenshot("LoginPage");
		Thread.sleep(1000);

		lp.click_on_login();
		test.info("Clicked on Login button");

		lp.dashboardIsDisplayed();
		test.pass("Dashboard is displayed");

		Utilities.takeScreenshot("Dashboard");

		sa.assertAll();

	}

	@Test(priority = 2)
	public void invalidLoginTest() throws Exception {

		test = ReportManager.report.createTest("Invalid Login Test", "Login with incorrect credentials");

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		test.info("LoginPage object initialized.");

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label not displayed");
		test.pass("Login label is displayed");

		lp.enter_username_password("admin", "invalid@111");
		test.info("Entered invalid username and password.");

		lp.click_on_login();
		test.info("Clicked on Login button.");
		Thread.sleep(1000);

		String actualAlert = lp.verifyLoginAlertMessage();
		sa.assertEquals(actualAlert, "Invalid credentials", "Login alert message mismatched");
		test.pass("Alert message verified: " + actualAlert);

		Utilities.takeScreenshot("InvalidLogin");
		test.addScreenCaptureFromPath("./Screenshots/InvalidLogin.png", "Invalid Login Screenshot");

		sa.assertAll();
	}

	@Test(priority = 3)
	public void emptyUsernamePasswordTest() throws Exception {

		test = ReportManager.report.createTest("Empty Credentials Login Test",
				"Login attempt with empty username and password");

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		test.info("LoginPage object initialized.");

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label not displayed");
		test.pass("Login label is displayed.");

		lp.enter_username_password("", "");
		test.info("Empty username and password entered.");

		lp.click_on_login();
		test.info("Clicked on Login button.");
		Thread.sleep(1000);

		String usernameError = lp.getUsernameErrorMessage();
		String passwordError = lp.getPasswordErrorMessage();

		sa.assertEquals(usernameError, "Required", "Mismatch in username error message validation.");
		test.pass("Username error message validated: " + usernameError);

		sa.assertEquals(passwordError, "Required", "Mismatch in password error message validation.");
		test.pass("Password error message validated: " + passwordError);

		Utilities.takeScreenshot("EmptyCredentials");
		test.addScreenCaptureFromPath("./Screenshots/EmptyCredentials.png", "Empty Credentials Screenshot");

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label should remain visible on empty credentials.");
		test.pass("Login label is still visible after validation.");

		sa.assertAll();
	}

	@Test(priority = 4)
	public void caseSensitivityTest() throws Exception {

		test = ReportManager.report.createTest("Case Sensitivity Test",
				"Attempt login with incorrect case in credentials");

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		test.info("LoginPage object initialized.");

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login label not displayed.");
		test.pass("Login label is visible.");

		lp.enter_username_password("admin", "ADMIN123"); // Incorrect case
		test.info("Entered username 'admin' and password 'ADMIN123' (wrong case).");

		lp.click_on_login();
		test.info("Clicked on Login button.");
		Thread.sleep(1000);

		String alertMessage = lp.verifyLoginAlertMessage();
		sa.assertEquals(alertMessage, "Invalid credentials", "Login alert message mismatched.");
		test.pass("Alert message verified: " + alertMessage);

		Utilities.takeScreenshot("CaseSensitiveLogin");
		test.addScreenCaptureFromPath("./Screenshots/CaseSensitiveLogin.png", "Case-Sensitive Login Screenshot");

		sa.assertTrue(lp.lblLoginIsDisplayed(), "Login should fail on incorrect case.");
		test.pass("Login label remains visible after failed attempt.");

		sa.assertAll();
	}

	@Test(priority = 5)
	public void verifyForgotPasswordLinkVisible() throws Exception {

		test = ReportManager.report.createTest("Forgot Password Link Test",
				"Verify visibility and navigation of 'Forgot your password?' link");

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		test.info("LoginPage object initialized.");

		sa.assertTrue(lp.forgetPwdLinkIsDisplayed(), "Forgot password link not visible.");
		test.pass("'Forgot your password?' link is visible on the login page.");

		Utilities.takeScreenshot("ForgotPwdVisible");
		test.addScreenCaptureFromPath("./Screenshots/ForgotPwdVisible.png", "Forgot Password Link Visible Screenshot");

		lp.clickOnForgetPWDLink();
		test.info("Clicked on 'Forgot your password?' link.");

		String title = lp.getForgetPasswordTitle();
		sa.assertEquals(title, "Reset Password", "Forget Password title mismatch.");
		test.pass("Navigated to Forgot Password page. Title verified: " + title);

		Utilities.takeScreenshot("ForgetPWDPage");
		test.addScreenCaptureFromPath("./Screenshots/ForgetPWDPage.png", "Forgot Password Page Screenshot");

		sa.assertAll();
	}
}
