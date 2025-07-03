package com.PageClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.ElementUtility;
import com.Utilities.Utilities;

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
		Utilities.clearInputField(driver.findElement(txt_firstName));

		ElementUtility.inputIntoField(txt_firstName, "Employee first name input field", firstName);
	}

	public void setMiddleName(String middleName) {
		Utilities.clearInputField(driver.findElement(txt_middleName));

		ElementUtility.inputIntoField(txt_middleName, "Employee middle name input field", middleName);
	}

	public void setLastName(String lastName) {
		Utilities.clearInputField(driver.findElement(txt_lastName));

		ElementUtility.inputIntoField(txt_lastName, "Employee last name input field", lastName);
	}

	public void setEmployeeId(int empId) {

		log.info("Setting employee ID: " + empId);

		Utilities.clearInputField(driver.findElement(txt_empId));

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
		ElementUtility.clickOnElement(select_first_search_result, "First Employee name");

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
}
