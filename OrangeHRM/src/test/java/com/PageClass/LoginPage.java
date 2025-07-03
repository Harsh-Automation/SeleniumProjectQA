package com.PageClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.ElementUtility;

public class LoginPage {

	Logger log = LogManager.getLogger(this.getClass());

	WebDriver driver;

	By lbl_login = By.cssSelector("[class='oxd-text oxd-text--h5 orangehrm-login-title']");
	By ip_field_username = By.cssSelector("input[placeholder='Username']");
	By ip_field_password = By.cssSelector("input[placeholder='Password']");

	By btn_login = By.cssSelector("button[type='submit']");

	By link_forget_fwd = By.cssSelector("[class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
	

	By dashboard_graph = By.xpath("//div[@class='emp-distrib-chart']/div/canvas");

	By login_alert_Message = By.cssSelector("[class='oxd-text oxd-text--p oxd-alert-content-text']");

	By username_error_message = By.xpath("//input[@placeholder='Username']/../../span");
	By password_error_message = By.xpath("//input[@placeholder='Password']/../../span");

	By forgot_Password_Title = By.cssSelector("[class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		log.info(this.getClass().getSimpleName() + " object initialized.");

	}

	public boolean lblLoginIsDisplayed() {

		return ElementUtility.elementIsDisplayed(lbl_login, "Login Label");
	}

	public void enter_username_password(String username, String password) {

		ElementUtility.inputIntoField(ip_field_username, "Username field", username);
		ElementUtility.inputIntoField(ip_field_password, "Password field", password);

	}

	public void click_on_login() {
		ElementUtility.clickOnElement(btn_login, "login Button");

	}

	public boolean forgetPwdLinkIsDisplayed() {
		return ElementUtility.elementIsDisplayed(link_forget_fwd, "Forget Password Link");

	}

	public void clickOnForgetPWDLink() {

		ElementUtility.clickOnElement(link_forget_fwd, "Forget Password Link");

	}

	public String getForgetPasswordTitle() {

		return ElementUtility.getTextFromElement(forgot_Password_Title);

	}

	public void dashboardIsDisplayed() {
		ElementUtility.elementIsDisplayed(dashboard_graph, "Dashboard graph");

	}

	public String verifyLoginAlertMessage() {
		return ElementUtility.getTextFromElement(login_alert_Message);

	}

	public String getUsernameErrorMessage() {

		return ElementUtility.getTextFromElement(username_error_message);
	}

	public String getPasswordErrorMessage() {

		return ElementUtility.getTextFromElement(password_error_message);

	}

}
