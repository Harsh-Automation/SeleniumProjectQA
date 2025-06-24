package com.TestClass;


import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClass;
import com.PageClass.LoginPage;
import com.Utilities.DataUtil;
import com.Utilities.LoggerUtil;
import com.Utilities.Utilities;
import com.PageClass.EmployeeCreationPage;


public class EmployeeCreationTest extends BaseClass {

	LoginPage lp;
	EmployeeCreationPage ec;

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
		ec.setMiddleName(DataUtil.randomMiddleName());
		ec.setLastName(DataUtil.randomLastName());
		ec.setEmployeeId(DataUtil.randomNumber());

		Utilities.takeScreenshot("Filled_Employee_data");

		sa.assertTrue(ec.saveBtnIsEnabled());
		ec.clickOnSaveBtn();

		sa.assertEquals(ec.verifySuccessMsg(), "Successfully Saved");
		Utilities.takeScreenshot("Success_Toaster_message");

		sa.assertAll();

	}

	@Test(priority = 2)

	public void employeeSearch() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		lp.enter_username_password("Admin", "admin123");
		Thread.sleep(1000);
		lp.click_on_login();

		ec = new EmployeeCreationPage(driver);

		ec.cLickOnPIMOption();

		ec.searchEmployeeName(DataUtil.firstName);

		Thread.sleep(1000);

		Utilities.takeScreenshot("Search_result_lookup");

		sa.assertTrue(ec.submitBtnIsEnabled());
		ec.clickOnSubmitBtn();

		Utilities.takeScreenshot("Search_result");

		Thread.sleep(1000);

		sa.assertAll();

	}

}
