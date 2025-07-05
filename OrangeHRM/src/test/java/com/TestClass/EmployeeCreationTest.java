package com.TestClass;

import java.io.IOException;

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

		sa.assertTrue(ec.submitBtnIsEnabled(), "Submit button is not Enabled");

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

	@Test(priority = 3)

	public void invalidSearch() throws Exception {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		lp.enter_username_password("Admin", "admin123");

		lp.click_on_login();

		ec = new EmployeeCreationPage(driver);
		ec.cLickOnPIMOption();

		ec.searchEmployeeName("Green");

		Utilities.takeScreenshot("invalid_search_result_lookup");

		ec.clickOnSubmitBtn();
		JavaScriptUtility.scrollToBottom();

		sa.assertTrue(ec.noRecordMsgIsDisplayed(), "No Record Found message is not displayed");

		String recordMessage = ec.verifyNoRecordMessage();
		sa.assertEquals(recordMessage, "Info\n" + "No Records Found");

		Utilities.takeScreenshot("no_record_found_msg");

		dp = new DashboardPage(driver);
		dp.clickOnProfileIconDD();
		dp.cLickOnLogoutBtn();

		sa.assertAll();
	}

	@Test(priority = 4)
	public void editEmployeeDetails() throws IOException {

		SoftAssert sa = new SoftAssert();

		lp = new LoginPage(driver);
		lp.enter_username_password("Admin", "admin123");

		lp.click_on_login();

		ec = new EmployeeCreationPage(driver);
		ec.cLickOnPIMOption();

		ec.searchEmployeeName(DataUtil.firstName);

		ec.clickOnSubmitBtn();
		JavaScriptUtility.scrollToBottom();
		Utilities.takeScreenshot("employee_search_result_for_edit");
		
		sa.assertTrue(ec.editButtonIsEnabled(),"Edit button is not enabled");
		ec.clickOnEditButton();
		
		String perosnalheadertitle = ec.getPersonalDetailsHeaderText();
		sa.assertEquals(perosnalheadertitle, "Personal Details");
		
		ec.nationalitySelection("Indian");
		
		Utilities.takeScreenshot("Nationality_selected");
		
		ec.maritalStatusSelection("Single");
		Utilities.takeScreenshot("Marital_status_selected");

		dp = new DashboardPage(driver);
		dp.clickOnProfileIconDD();
		dp.cLickOnLogoutBtn();
		
		Utilities.takeScreenshot("Logout_out_successful");

		sa.assertAll();

	}
}
