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
}
