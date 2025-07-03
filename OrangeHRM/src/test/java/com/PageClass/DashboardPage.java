package com.PageClass;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utilities.ElementUtility;

public class DashboardPage {

	WebDriver driver;

	Logger log = LogManager.getLogger(this.getClass());

	By label_dashboard = By.className("oxd-topbar-header-title");
	By logo_OHRM = By.cssSelector("[alt='client brand banner']");
	By profile_icon_section = By.className("oxd-userdropdown-tab");

	By main_menu_item_list = By.xpath("//*[@class='oxd-sidepanel-body']/ul/li/a/span");

	By dropdown_profile_section = By.cssSelector("[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	By dropdown_options_profile_section = By.xpath("//ul[@class='oxd-dropdown-menu']/li");

	By btn_logout = By.linkText("Logout");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		log.info(this.getClass().getSimpleName() + " object initialized.");
	}

	public String verifyDashboardHeaderLabel()

	{
		return ElementUtility.getTextFromElement(label_dashboard);
	}

	public boolean verifyOHRMLogiIsDisplayed()

	{
		return ElementUtility.elementIsDisplayed(logo_OHRM, "OrangeHRM Logo");

	}

	public boolean verifyProfileSectionIsDisplayed()

	{
		return ElementUtility.elementIsDisplayed(profile_icon_section, "Profile icon section");

	}

	public List<WebElement> verifyMainMenuItems() {

		List<WebElement> itemlist = driver.findElements(main_menu_item_list);
		log.info("Main menu items count: " + itemlist.size());

		return itemlist;
	}

	public void clickOnProfileIconDD() {
		ElementUtility.clickOnElement(profile_icon_section, "Profile Icon");
	}

	public List<WebElement> verifyProfileSectionItems() {

		List<WebElement> items = driver.findElements(dropdown_options_profile_section);
		log.info("Profile dropdown items count: " + items.size());
		return items;
	}

	public void cLickOnLogoutBtn() {

		ElementUtility.clickOnElement(btn_logout, "Logout Button");

	}

}
