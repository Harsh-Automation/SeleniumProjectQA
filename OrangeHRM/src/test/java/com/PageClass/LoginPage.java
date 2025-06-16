package com.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	
	By ip_field_username = By.cssSelector("input[placeholder='Username']");
	By ip_field_password = By.cssSelector("input[placeholder='Password']");

	By btn_login = By.cssSelector("button[type='submit']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void enter_username_password(String username, String password)
	{
		driver.findElement(ip_field_username).sendKeys(username);
		
		driver.findElement(ip_field_password).sendKeys(password);
		
	}
	
	
	public void click_on_login()
	{
		driver.findElement(btn_login).click();
	}
	
}
