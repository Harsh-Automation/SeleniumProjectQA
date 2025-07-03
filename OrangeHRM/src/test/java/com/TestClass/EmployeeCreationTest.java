package com.TestClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClass;
import com.PageClass.DashboardPage;
import com.PageClass.EmployeeCreationPage;
import com.PageClass.LoginPage;
import com.Utilities.DataUtil;
import com.Utilities.JavaScriptUtility;
import com.Utilities.Utilities;

public class EmployeeCreationTest extends BaseClass {

	LoginPage lp;
	EmployeeCreationPage ec;
	DashboardPage dp;

	@Test(priority = 1)
	public void employeeCreation() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);

		lp.enter_username_password("Admin", "admin123");
		Thread.sleep(1000);

		lp.click_on_login();

		ec = new EmployeeCreationPage(driver);
		ec.cLickOnPIMOption();

		Utilities.takeScreenshot("PIM_Page");

		sa.assertEquals(ec.verifyPIMHeader(), "PIM");

		sa.assertEquals(ec.addBtnIsDisplayed(), true);

		ec.clickOnAddBtn();

		sa.assertEquals(ec.verifyAddEmployeeHeader(), "Add Employee");

		sa.assertEquals(ec.footerIsDisplayed(), true);

		Utilities.takeScreenshot("Employee_creation_page");
		ec.setFirstName(DataUtil.firstName);
		ec.setMiddleName(DataUtil.middleName);
		ec.setLastName(DataUtil.randomLastName());
		ec.setEmployeeId(DataUtil.randomNumber());

		Utilities.takeScreenshot("Filled_Employee_data");

		sa.assertTrue(ec.saveBtnIsEnabled());

		ec.clickOnSaveBtn();

		String successMsg = ec.verifySuccessMsg();
		sa.assertEquals(successMsg, "Successfully Saved");

		Utilities.takeScreenshot("Success_Toaster_message");
		dp = new DashboardPage(driver);
		dp.clickOnProfileIconDD();
		dp.cLickOnLogoutBtn();

		sa.assertAll();
	}

	@Test(priority = 2)

	public void employeeSearch() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		lp.enter_username_password("Admin", "admin123");

		lp.click_on_login();

		ec = new EmployeeCreationPage(driver);
		ec.cLickOnPIMOption();

		ec.searchEmployeeName(DataUtil.firstName);

		Utilities.takeScreenshot("Search_result_lookup");

		sa.assertTrue(ec.submitBtnIsEnabled(),"Submit button is not Enabled");

		ec.clickOnSubmitBtn();
		JavaScriptUtility.scrollToBottom();

		String actualName = ec.verifyEmployeeNameFromTable();
		String expectedName = DataUtil.firstName + " " + DataUtil.middleName;
		sa.assertEquals(actualName, expectedName);

		Utilities.takeScreenshot("Search_result");

		dp = new DashboardPage(driver);
		dp.clickOnProfileIconDD();
		dp.cLickOnLogoutBtn();

		sa.assertAll();
	}

}
