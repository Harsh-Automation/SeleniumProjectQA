package com.PageClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.ElementUtility;
import com.Utilities.JavaScriptUtility;

public class EmployeeCreationPage {

	Logger log = LogManager.getLogger(this.getClass());

	WebDriver driver;

	By main_menu_option_PIM = By.xpath("//span[text()='PIM']");
	By header_title = By.className("oxd-topbar-header-title");

	By btn_add = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

	By lbl_addEmployee = By.xpath("//*[contains(@class, 'oxd-text') and contains(@class, 'orangehrm-main-title')]");

	By footer_addEmployee = By.className("oxd-form-actions");

	By txt_firstName = By.name("firstName");
	By txt_middleName = By.name("middleName");
	By txt_lastName = By.name("lastName");

	By txt_empId = By.xpath("//label[text()='Employee Id']/../../div[2]/input");

	By btn_save = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");

	By msg_success = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");

	By search_field_employeename = By.xpath("//*[text()='Employee Name']/../../div[2]/div/div/input");

	By select_first_search_result = By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div[1]");

	By btn_submit = By
			.cssSelector("[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");

	By tbl_firstname = By
			.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[3]");

	By noRecord_info_msg = By.cssSelector("[class='oxd-toast-content oxd-toast-content--info']");

	By dd_nationality = By.xpath("//label[contains(text(),'Nationality')]/../../div[2]/div");
	By dd_option_list = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div");

	By editButton = By.xpath(
			"//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[9]/div/button[1]");

	By personalDetailsHeader = By.xpath("//div[@class='orangehrm-edit-employee-content']/div[1]/h6");

	By dd_marital_status = By.xpath("//label[contains(text(),'Marital')]/../../div[2]/div");
	By marital_status_list = By.xpath("//label[contains(text(),'Marital')]/../../div[2]/div/div[2]/div");

	By datePicker_date_of_birth = By.xpath("//label[contains(text(),'Date of Birth')]/../../div[2]/div/div");

	By datePicker_next_month_year = By.xpath("//div[@class='oxd-calendar-wrapper']/div[1]/button[2]");
	By datePicker_month = By.xpath("//div[@class='oxd-calendar-wrapper']/div[1]/ul/li[1]/div/p");
	By datePicker_year = By.xpath("//div[@class='oxd-calendar-wrapper']/div[1]/ul/li[2]/div/p");

	By datePicker_date = By.xpath("//div[@class='oxd-calendar-wrapper']/div[3]/div/div");

	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		log.info(this.getClass().getSimpleName() + " object initialized.");

	}

	public void cLickOnPIMOption() {

		ElementUtility.clickOnElement(main_menu_option_PIM, "PIM menu");
	}

	public String verifyPIMHeader() {

		return ElementUtility.getTextFromElement(header_title);

	}

	public boolean addBtnIsDisplayed() {
		return ElementUtility.elementIsDisplayed(btn_add, "Add button");

	}

	public String verifyAddEmployeeHeader() {
		return ElementUtility.getTextFromElement(lbl_addEmployee);
	}

	public void clickOnAddBtn() {
		ElementUtility.clickOnElement(btn_add, "Add button");

	}

	public boolean footerIsDisplayed() {
		return ElementUtility.elementIsDisplayed(footer_addEmployee, "Employee page footer");
	}

	public void setFirstName(String firstName) {
		JavaScriptUtility.clearInputField(driver.findElement(txt_firstName));

		ElementUtility.inputIntoField(txt_firstName, "Employee first name input field", firstName);
	}

	public void setMiddleName(String middleName) {
		JavaScriptUtility.clearInputField(driver.findElement(txt_middleName));

		ElementUtility.inputIntoField(txt_middleName, "Employee middle name input field", middleName);
	}

	public void setLastName(String lastName) {
		JavaScriptUtility.clearInputField(driver.findElement(txt_lastName));

		ElementUtility.inputIntoField(txt_lastName, "Employee last name input field", lastName);
	}

	public void setEmployeeId(int empId) {

		log.info("Setting employee ID: " + empId);

		JavaScriptUtility.clearInputField(driver.findElement(txt_empId));

		ElementUtility.inputIntoField(txt_empId, "Employee ID input field", String.valueOf(empId));
	}

	public boolean saveBtnIsEnabled() {

		return ElementUtility.elementIsEnabled(btn_save, "Save Button");

	}

	public void clickOnSaveBtn() {

		ElementUtility.clickOnElement(btn_save, "Save button");

	}

	public String verifySuccessMsg() {

		return ElementUtility.getTextFromElement(msg_success);
	}

	public void searchEmployeeName(String empName) {

		ElementUtility.inputIntoField(search_field_employeename, "Employee name", empName);

	}

	public By selectDynamicName(String dynamicName) {
		return By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']//span[contains(text(),'"
				+ dynamicName + "')]");

	}

	public void selectDynamicNameFromList(String name) {
		ElementUtility.clickOnElement(selectDynamicName(name), " " + name + " record");
	}

	public boolean submitBtnIsEnabled() {

		return ElementUtility.elementIsEnabled(btn_submit, "Submit Button");
	}

	public void clickOnSubmitBtn() {

		ElementUtility.clickOnElement(btn_submit, "Save button");

	}

	public String verifyEmployeeNameFromTable() {

		return ElementUtility.getTextFromElement(tbl_firstname);
	}

	public boolean noRecordMsgIsDisplayed()

	{
		return ElementUtility.elementIsDisplayed(noRecord_info_msg, "No Record Found message");
	}

	public String verifyNoRecordMessage() {
		return ElementUtility.getTextFromElement(noRecord_info_msg);
	}

	public void nationalitySelection(String nationality) {
		ElementUtility.selectCustomDropdownValue(dd_nationality, dd_option_list, nationality, "Nationality Dropdown");
	}

	public boolean editButtonIsEnabled() {
		return ElementUtility.elementIsEnabled(editButton, "Edit Button");

	}

	public void clickOnEditButton() {
		ElementUtility.clickOnElement(editButton, "Edit button");

	}

	public String getPersonalDetailsHeaderText() {
		return ElementUtility.getTextFromElement(personalDetailsHeader);
	}

	public void maritalStatusSelection(String maritalStatus) {
		ElementUtility.selectCustomDropdownValue(dd_marital_status, marital_status_list, maritalStatus,
				"Marital Status Dropdown");
	}

	public void setDateOfBirthFromDatePicker(String date, String month, String year) {

		ElementUtility.customFutureDatePicker(datePicker_date_of_birth, datePicker_date, datePicker_month,
				datePicker_year, datePicker_next_month_year, date, month, year);
	}
}
