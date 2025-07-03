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
	SoftAssert sa;

	@Test
	public void dashboardPageTest() throws InterruptedException, IOException {

		sa = new SoftAssert();

		lp = new LoginPage(driver);
		lp.enter_username_password("Admin", "admin123");

		lp.click_on_login();

		Utilities.takeScreenshot("Dashboard_Page");
		lp.dashboardIsDisplayed();

		dp = new DashboardPage(driver);

		String dbHeaderLabel = dp.verifyDashboardHeaderLabel();
		sa.assertEquals(dbHeaderLabel, "Dashboard");

		boolean oHRMLogo = dp.verifyOHRMLogiIsDisplayed();
		sa.assertTrue(oHRMLogo, "OHRM Logo is not displayed");

		boolean profileSection = dp.verifyProfileSectionIsDisplayed();
		sa.assertTrue(profileSection, "Profile section is not displayed");

		List<String> itemList = new ArrayList<>(Arrays.asList("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info",
				"Performance", "Dashboard", "Directory", "Maintenance", "Claim", "Buzz"));

		Utilities.assertMainMenuOptions(dp.verifyMainMenuItems(), itemList);

		dp.clickOnProfileIconDD();

		List<String> dropdownitemList = new ArrayList<>(Arrays.asList("About", "Support", "Change Password", "Logout"));

		Utilities.assertMainMenuOptions(dp.verifyProfileSectionItems(), dropdownitemList);
		Utilities.takeScreenshot("Profile_section_items");

		dp.cLickOnLogoutBtn();

		sa.assertTrue(lp.lblLoginIsDisplayed());
		Utilities.takeScreenshot("Loginpage_after_Logout");
		sa.assertAll();

	}

}
