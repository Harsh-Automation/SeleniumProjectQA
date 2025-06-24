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

	public void dashboardIsDisplayed() {
		Utilities.waitForElement(driver.findElement(dashboard_graph));
		log.info("Dashboard graph is displayed.");

	}

}
