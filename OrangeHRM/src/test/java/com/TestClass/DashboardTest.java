package com.TestClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClass;
import com.PageClass.DashboardPage;
import com.PageClass.LoginPage;
import com.Utilities.Utilities;

public class DashboardTest extends BaseClass {

	LoginPage lp;
	DashboardPage dp;

	SoftAssert sa = new SoftAssert();

	@Test
	public void dashboardPageTest() throws InterruptedException, IOException
	{
		lp= new LoginPage(driver);
		lp.enter_username_password("Admin", "admin123");
		Thread.sleep(1000);
		lp.click_on_login();
		Utilities.takeScreenshot("Dashboard_Page");
		lp.dashboardIsDisplayed();
		
		dp = new DashboardPage(driver);
		
		sa.assertEquals(dp.verifyDashboardHeaderLabel(),"Dashboard");
		dp.verifyOHRMLogiIsDisplayed();
		dp.verifyProfileSectionIsDisplayed();
		
		List<String> itemList = new ArrayList<String>(Arrays.asList("Admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard","Directory","Maintenance","Claim","Buzz"));
		Utilities.assertMainMenuOptions(dp.verifyMainMenuItems(), itemList);
		
		sa.assertAll();
		Thread.sleep(1000);
				
		
	}
	
}
