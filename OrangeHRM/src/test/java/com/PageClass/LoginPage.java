package com.PageClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.Utilities;

public class LoginPage {

	Logger log = LogManager.getLogger(this.getClass());

	WebDriver driver;

	By lbl_login = By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title");
	By ip_field_username = By.cssSelector("input[placeholder='Username']");
	By ip_field_password = By.cssSelector("input[placeholder='Password']");

	By btn_login = By.cssSelector("button[type='submit']");

	By link_forget_fwd = By.cssSelector(".oxd-text.oxd-text--p.orangehrm-login-forgot-header");

	By dashboard_graph = By.xpath("//div[@class='emp-distrib-chart']/div/canvas");

	By login_alert_Message = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");

	By username_error_message = By.xpath("//input[@placeholder='Username']/../../span");
	By password_error_message = By.xpath("//input[@placeholder='Password']/../../span");

	By forgot_Password_Title = By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-forgot-password-title");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		log.info(this.getClass().getSimpleName() + " object initialized.");

	}

	public boolean lblLoginIsDisplayed() {
		log.info("Login label displayed: ");

		return driver.findElement(lbl_login).isDisplayed();
	}

	public void enter_username_password(String username, String password) {
		log.info("Entering username." + username);
		driver.findElement(ip_field_username).sendKeys(username);

		log.info("Entering password.");
		driver.findElement(ip_field_password).sendKeys(password);

		log.info("Entered credentials for user: " + username);
	}

	public void click_on_login() {
		log.info("Clicking on login button.");

		driver.findElement(btn_login).click();
	}

	public boolean forgetPwdLinkIsDisplayed() {
		log.info("Forgot Password link displayed: ");

		return driver.findElement(link_forget_fwd).isDisplayed();
	}

	public void clickOnForgetPWDLink() {

		log.info("Clicking on Forget Password Link.");

		driver.findElement(link_forget_fwd).click();
	}

	public String getForgetPasswordTitle() {
		log.info("Verifying Forget Password Header Title.");

		Utilities.waitForElement(driver.findElement(forgot_Password_Title));
		return driver.findElement(forgot_Password_Title).getText();
	}

	public void dashboardIsDisplayed() {
		Utilities.waitForElement(driver.findElement(dashboard_graph));
		log.info("Dashboard graph is displayed.");

	}

	public String verifyLoginAlertMessage() {
		Utilities.waitForElement(driver.findElement(login_alert_Message));

		String alertMessage = driver.findElement(login_alert_Message).getText();

		log.info("Verifying login alert message :" + alertMessage);

		return alertMessage;

	}

	public String getUsernameErrorMessage() {

		log.info("Verifying username error message");

		return driver.findElement(username_error_message).getText();
	}

	public String getPasswordErrorMessage() {

		log.info("Verifying password alert message ");

		return driver.findElement(password_error_message).getText();
	}

}
