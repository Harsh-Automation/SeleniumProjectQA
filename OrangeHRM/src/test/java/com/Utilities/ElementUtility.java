package com.Utilities;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.BaseClass.BaseClass;

public class ElementUtility extends BaseClass {

	static Logger log = LogManager.getLogger(ElementUtility.class);

	public static void clickOnElement(By locator, String elementName) {

		try {

			Utilities.waitForElement(driver.findElement(locator));
			driver.findElement(locator).click();
			log.info("Click action Successful on : " + elementName);
			ReportManager.getTest().pass("Click action Successful on : " + elementName);
		} catch (Exception e) {
			log.warn("Exception occured while click action on : " + elementName + " " + e.getMessage());

			ReportManager.getTest()
					.warning("Exception occured while click action on : " + elementName + " " + e.getMessage());

			try {
				driver.findElement(locator).click();
				log.info("Retry click action Successful on : " + elementName);
				ReportManager.getTest().pass("Retry click action Successful on : " + elementName);

			} catch (Exception e2) {
				log.warn("Exception occured while retrying click action on : " + elementName + " " + e2.getMessage());

				ReportManager.getTest().warning(
						"Exception occured while retrying click action on : " + elementName + " " + e2.getMessage());

			}

		}

	}

	public static void inputIntoField(By locator, String elementName, String inputText) {

		try {
			Utilities.waitForElement(driver.findElement(locator));
			driver.findElement(locator).sendKeys(inputText);
			log.info("Input action Successful on : " + elementName);
			ReportManager.getTest().pass("Input action Successful on : " + elementName);
		} catch (Exception e) {
			log.info("Exception occured while input action on : " + elementName + " " + e.getMessage());

			ReportManager.getTest()
					.fail("Exception occured while input action on : " + elementName + " " + e.getMessage());

		}

	}

	public static String getTextFromElement(By locator) {

		String elementText = null;

		try {
			Utilities.waitForElement(driver.findElement(locator));
			elementText = driver.findElement(locator).getText();
			log.info("Text fetched successfully : " + elementText);
			ReportManager.getTest().pass("Text fetched successfully : " + elementText);

		} catch (Exception e) {
			log.info("Exception occured while fetching text : " + elementText + " " + e.getMessage());

			ReportManager.getTest()
					.fail("Exception occured while fetching text : " + elementText + " " + e.getMessage());

		}
		return elementText;

	}

	public static boolean elementIsDisplayed(By locator, String elementName) {

		boolean elementDisplayed = false;

		try {
			Utilities.waitForElement(driver.findElement(locator));
			elementDisplayed = driver.findElement(locator).isDisplayed();
			log.info(elementName + " displayed successful");
			ReportManager.getTest().pass(elementName + " displayed successful");
		} catch (Exception e) {
			log.info("Exception occured while displaying element : " + elementName + " " + e.getMessage());

			ReportManager.getTest()
					.fail("Exception occured while displaying element : " + elementName + " " + e.getMessage());

		}

		return elementDisplayed;

	}

	public static boolean elementIsEnabled(By locator, String elementName) {

		boolean elementEnabled = false;

		try {
			Utilities.waitForElement(driver.findElement(locator));
			elementEnabled = driver.findElement(locator).isEnabled();
			log.info(elementName + " is enabled");
			ReportManager.getTest().pass(elementName + " is enabled");
		} catch (Exception e) {
			log.info("Exception occured while element to be enabled : " + elementName + " " + e.getMessage());

			ReportManager.getTest()
					.fail("Exception occured while element to be enabled : " + elementName + " " + e.getMessage());

		}

		return elementEnabled;

	}

	public static boolean elementIsSelected(By locator, String elementName) {

		boolean elementSelected = false;

		try {
			Utilities.waitForElement(driver.findElement(locator));
			elementSelected = driver.findElement(locator).isSelected();
			log.info(elementName + " is in selected state");
			ReportManager.getTest().pass(elementName + " is in selected state");
		} catch (Exception e) {
			log.info("Exception occured while element to be in selected state : " + elementName + " " + e.getMessage());

			ReportManager.getTest().fail(
					"Exception occured while element to be in selected state : " + elementName + " " + e.getMessage());

		}

		return elementSelected;

	}

	public static void selectByName(By locator, String name) {

		try {
			Utilities.waitForElement(driver.findElement(locator));
			Select select = new Select(driver.findElement(locator));

			select.selectByVisibleText(name);
			log.info(name + " selected successfully from dropdown");
			ReportManager.getTest().pass(name + " selected successfully from dropdown");

		} catch (Exception e) {
			log.error("Exception occured while element an element : " + name + " " + e.getMessage());
			ReportManager.getTest().fail("Exception occured while element an element : " + name + " " + e.getMessage());

		}

	}

	public static void selectCustomDropdownValue(By dropdownLocator, By optionsLocator, String valueName,
			String elementName) {
		try {
			ElementUtility.clickOnElement(dropdownLocator, elementName);

			List<WebElement> optionList = driver.findElements(optionsLocator);

			if (optionList != null && !optionList.isEmpty()) {

				log.info("Options are present in the option list");
				ReportManager.getTest().pass("Options are present in the option list");

				boolean found = false;

				for (int i = 0; i < optionList.size(); i++) {

					String item = optionList.get(i).getText().trim();

					if (item.equalsIgnoreCase(valueName)) {
						try {
							optionList.get(i).click();
							log.info(item + " : option is selected");
							ReportManager.getTest().pass(item + " : option is selected");
							found = true;
							break;

						}

						catch (Exception e) {

							log.warn("Exception occured while selecting : " + item + " " + e.getMessage());

							ReportManager.getTest()
									.warning("Exception occured while selecting : " + item + " " + e.getMessage());

							driver.findElements(optionsLocator).get(i).click();
							log.info(item + " : option is selected after retry");
							ReportManager.getTest().pass(item + " : option is selected after retry");
							found = true;
							break;
						}

					}
				}
				if (!found) {
					log.info(elementName + " not present in the option list");
					ReportManager.getTest().pass(elementName + " not present in the option list");

				}
			}
		} catch (Exception e) {

			log.error("Exception while selecting option from dropdown: " + e.getMessage());
			ReportManager.getTest().fail("Exception while selecting option from dropdown: " + e.getMessage());

		}
	}

}
