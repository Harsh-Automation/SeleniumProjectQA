package com.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.Utilities;

public class LoginPage {

	WebDriver driver;

	By lbl_login = By.cssSelector(".oxd-text.oxd-text--h5.orangehrm-login-title");
	By ip_field_username = By.cssSelector("input[placeholder='Username']");
	By ip_field_password = By.cssSelector("input[placeholder='Password']");

	By btn_login = By.cssSelector("button[type='submit']");

	By link_forget_fwd = By.cssSelector(".oxd-text.oxd-text--p.orangehrm-login-forgot-header");

	By dashboard_graph = By.xpath("//div[@class='emp-distrib-chart']/div/canvas");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean lblLoginIsDisplayed() {
		return driver.findElement(lbl_login).isDisplayed();
	}

	public void enter_username_password(String username, String password) {
		driver.findElement(ip_field_username).sendKeys(username);

		driver.findElement(ip_field_password).sendKeys(password);

	}

	public void click_on_login() {
		driver.findElement(btn_login).click();
	}

	public boolean forgetPwdLinkIsDisplayed() {

		return driver.findElement(link_forget_fwd).isDisplayed();
	}

	public void dashboardIsDisplayed() {
		Utilities.waitForElement(driver.findElement(dashboard_graph));
	}

}
