package com.TestClass;

import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.PageClass.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage lp;

	@Test
	public void loginTest()
	{
		
		lp = new LoginPage(driver);
		lp.enter_username_password("Admin","admin123");
		lp.click_on_login();
	}

}
