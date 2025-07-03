package com.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

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
			log.info("Exception occured while click action on : " + elementName + " " + e.getMessage());

			ReportManager.getTest()
					.fail("Exception occured while click action on : " + elementName + " " + e.getMessage());

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
			log.info(elementName + " selected successful");
			ReportManager.getTest().pass(elementName + " selected successful");
		} catch (Exception e) {
			log.info("Exception occured while element to be selected : " + elementName + " " + e.getMessage());

			ReportManager.getTest()
					.fail("Exception occured while element to be selected : " + elementName + " " + e.getMessage());

		}

		return elementSelected;

	}

}
