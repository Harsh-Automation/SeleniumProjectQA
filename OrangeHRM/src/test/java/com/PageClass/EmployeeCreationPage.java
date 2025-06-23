package com.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utilities.Utilities;

public class EmployeeCreationPage {

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

	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void cLickOnPIMOption() {
		driver.findElement(main_menu_option_PIM).click();
	}

	public String verifyPIMHeader() {
		return driver.findElement(header_title).getText();
	}

	public boolean addBtnIsDisplayed() {
		return driver.findElement(btn_add).isDisplayed();
	}

	public String verifyAddEmployeeHeader() {
		return driver.findElement(lbl_addEmployee).getText();
	}

	public void clickOnAddBtn() {
		driver.findElement(btn_add).click();
	}

	public boolean footerIsDisplayed() {
		Utilities.waitForElement(driver.findElement(footer_addEmployee));
		return driver.findElement(footer_addEmployee).isDisplayed();
	}

	public void setFirstName(String firstName) {
		driver.findElement(txt_firstName).clear();

		driver.findElement(txt_firstName).sendKeys(firstName);
	}

	public void setMiddleName(String middleName) {
		driver.findElement(txt_middleName).clear();

		driver.findElement(txt_middleName).sendKeys(middleName);
	}

	public void setLastName(String lastName) {
		driver.findElement(txt_lastName).clear();

		driver.findElement(txt_lastName).sendKeys(lastName);
	}

	public void setEmployeeId(int empId) {
		Utilities.clearInputField(driver.findElement(txt_empId));

		driver.findElement(txt_empId).sendKeys(String.valueOf(empId));
	}

	public boolean saveBtnIsEnabled() {
		return driver.findElement(btn_save).isEnabled();
	}

	public void clickOnSaveBtn() {
		driver.findElement(btn_save).click();
	}

	public String verifySuccessMsg() {

		Utilities.waitForElement(driver.findElement(msg_success));

		return driver.findElement(msg_success).getText();
	}

	public void searchEmployeeName(String empName) {

		driver.findElement(search_field_employeename).sendKeys(empName);

		Utilities.waitForElement(driver.findElement(select_first_search_result));
		driver.findElement(select_first_search_result).click();
	}

	public boolean submitBtnIsEnabled() {
		return driver.findElement(btn_submit).isEnabled();
	}

	public void clickOnSubmitBtn() {
		driver.findElement(btn_submit).click();
	}
}
