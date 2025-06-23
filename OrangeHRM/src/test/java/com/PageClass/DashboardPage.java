package com.PageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	WebDriver driver;

	By label_dashboard = By.className("oxd-topbar-header-title");
	By logo_OHRM = By.cssSelector("[alt='client brand banner']");
	By profile_icon_section = By.className("oxd-userdropdown-tab");

	By main_menu_item_list = By.xpath("//*[@class='oxd-sidepanel-body']/ul/li/a/span");

	By dropdown_profile_section = By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon");
	By dropdown_options_profile_section = By.xpath("//ul[@class='oxd-dropdown-menu']/li");

	By btn_logout = By.linkText("Logout");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyDashboardHeaderLabel()

	{
		return driver.findElement(label_dashboard).getText();

	}

	public boolean verifyOHRMLogiIsDisplayed()

	{
		return driver.findElement(logo_OHRM).isDisplayed();

	}

	public boolean verifyProfileSectionIsDisplayed()

	{
		return driver.findElement(profile_icon_section).isDisplayed();

	}

	public List<WebElement> verifyMainMenuItems() {
		return driver.findElements(main_menu_item_list);
	}

	public void clickOnProfileIconDD() {
		driver.findElement(dropdown_profile_section).click();
	}

	public List<WebElement> verifyProfileSectionItems() {
		return driver.findElements(dropdown_options_profile_section);
	}

	public void cLickOnLogoutBtn() {
		driver.findElement(btn_logout).click();
	}

}
