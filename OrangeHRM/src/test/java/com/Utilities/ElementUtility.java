package com.Utilities;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ElementUtility extends BaseClass {

	static Logger log = LogManager.getLogger(ElementUtility.class);

	public static void clickOnElement(By locator, String elementName) {

		try {

			WaitUtility.waitForElementVisiblity(driver.findElement(locator));

			WaitUtility.waitForElementToBeClickable(locator);

			JavaScriptUtility.highlightElement(driver.findElement(locator));

			driver.findElement(locator).click();

			log.info("Click action Successful on : " + elementName);
			ReportManager.getTest().pass("Click action Successful on : " + elementName,
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(elementName)).build());

		} catch (Exception e) {
			log.warn("Exception occured while click action on : " + elementName + " " + e.getMessage());
			ReportManager.getTest()
					.warning("Exception occured while click action on : " + elementName + " " + e.getMessage());

			try {

				driver.findElement(locator).click();

				log.info("Retry click action Successful on : " + elementName);
				ReportManager.getTest().pass("Retry click action Successful on : " + elementName,
						MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(elementName)).build());

			} catch (Exception e2) {
				log.warn("Exception occured while retrying click action on : " + elementName + " " + e2.getMessage());
				ReportManager.getTest().warning(
						"Exception occured while retrying click action on : " + elementName + " " + e2.getMessage());

			}

		}

	}

	public static void clickOnDynamicElement(By locator, String elementName) {

		try {

			WaitUtility.waitForElementVisiblity(driver.findElement(locator));

			WaitUtility.waitForElementToBeClickable(locator);

			JavaScriptUtility.highlightElement(driver.findElement(locator));

			driver.findElement(locator).click();

			log.info("Click action Successful on : " + elementName);
			ReportManager.getTest().pass("Click action Successful on : " + elementName,
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(elementName)).build());

		} catch (Exception e) {
			log.warn("Exception occured while click action on : " + elementName + " " + e.getMessage());
			ReportManager.getTest()
					.warning("Exception occured while click action on : " + elementName + " " + e.getMessage());

			try {

				driver.findElement(locator).click();

				log.info("Retry click action Successful on : " + elementName);
				ReportManager.getTest().pass("Retry click action Successful on : " + elementName,
						MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(elementName)).build());

			} catch (Exception e2) {
				log.warn("Exception occured while retrying click action on : " + elementName + " " + e2.getMessage());
				ReportManager.getTest().warning(
						"Exception occured while retrying click action on : " + elementName + " " + e2.getMessage());

			}

		}

	}

	public static void inputIntoField(By locator, String elementName, String inputText) {

		try {
			WaitUtility.waitForVisibilityOfElementLocated(locator);
			JavaScriptUtility.highlightElement(driver.findElement(locator));

			driver.findElement(locator).sendKeys(inputText);

			log.info("Input action Successful on : " + elementName);
			ReportManager.getTest().pass("Input action Successful on : " + elementName,
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(elementName)).build());
		} catch (Exception e) {
			log.info("Exception occured while input action on : " + elementName + " " + e.getMessage());

			ReportManager.getTest()
					.fail("Exception occured while input action on : " + elementName + " " + e.getMessage());

		}

	}

	public static String getTextFromElement(By locator) {

		String elementText = null;

		try {
			WaitUtility.waitForVisibilityOfElementLocated(locator);
			JavaScriptUtility.highlightElement(driver.findElement(locator));

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
			WaitUtility.waitForElementVisiblity(driver.findElement(locator));
			JavaScriptUtility.highlightElement(driver.findElement(locator));

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
			WaitUtility.waitForElementVisiblity(driver.findElement(locator));
			JavaScriptUtility.highlightElement(driver.findElement(locator));

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
			WaitUtility.waitForElementVisiblity(driver.findElement(locator));
			JavaScriptUtility.highlightElement(driver.findElement(locator));

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
			WaitUtility.waitForElementVisiblity(driver.findElement(locator));
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
							JavaScriptUtility.highlightElement(optionList.get(i));
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
							JavaScriptUtility.highlightElement(optionList.get(i));

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
					ReportManager.getTest().fail(elementName + " not present in the option list");

				}
			}
		} catch (Exception e) {

			log.error("Exception while selecting option from dropdown: " + e.getMessage());
			ReportManager.getTest().fail("Exception while selecting option from dropdown: " + e.getMessage());

		}
	}

	public static void customFutureDatePicker(By dropdownLocator, By dateLocator, By monthLocator, By yearLocator,
			By nextmonthYear, String date, String month, String year) {

		WaitUtility.waitForElementToBeClickable(dropdownLocator);
		driver.findElement(dropdownLocator).click();
		try {

			String currentMonth = driver.findElement(monthLocator).getText();
			String currentYear = driver.findElement(yearLocator).getText();

			while (!(currentMonth.equalsIgnoreCase(month) && currentYear.equalsIgnoreCase(year))) {
				try {
					WaitUtility.waitForElementVisiblity(driver.findElement(nextmonthYear));
					JavaScriptUtility.highlightElement(driver.findElement(nextmonthYear));

					driver.findElement(nextmonthYear).click();
					currentMonth = driver.findElement(monthLocator).getText();
					currentYear = driver.findElement(yearLocator).getText();

				} catch (Exception e) {

					log.warn("Exception occured while selecting month and year " + e.getMessage());
					ReportManager.getTest()
							.warning("Exception occured while selecting month and year " + e.getMessage());

					WaitUtility.waitForElementVisiblity(driver.findElement(nextmonthYear));
					JavaScriptUtility.highlightElement(driver.findElement(nextmonthYear));

					driver.findElement(nextmonthYear).click();
					currentMonth = driver.findElement(monthLocator).getText();
					currentYear = driver.findElement(yearLocator).getText();

				}
			}

			log.info("Expected Month and Year matched " + month + " " + year);
			ReportManager.getTest().pass("Expected Month and Year matched " + month + " " + year);

			List<WebElement> dateList = driver.findElements(dateLocator);
			boolean selectedDate = false;

			for (int i = 0; i < dateList.size(); i++) {

				String currentDate = dateList.get(i).getText().trim();

				if (currentDate.equalsIgnoreCase(date)) {
					try {

						JavaScriptUtility.highlightElement(dateList.get(i));

						dateList.get(i).click();
						log.info(currentDate + " : date is selected");
						ReportManager.getTest().pass(currentDate + " : date is selected");
						selectedDate = true;
						break;
					} catch (Exception e) {
						log.warn("Exception occured while selecting date : " + currentDate + " " + e.getMessage());

						ReportManager.getTest().warning(
								"Exception occured while selecting date : " + currentDate + " " + e.getMessage());
						JavaScriptUtility.highlightElement(dateList.get(i));

						driver.findElements(dateLocator).get(i).click();
						log.info(currentDate + " : date is selected after retry");
						ReportManager.getTest().pass(currentDate + " : date is selected after retry");
						selectedDate = true;
						break;
					}

				}

			}
			if (!selectedDate) {
				log.info(date + " not present in the option list");
				ReportManager.getTest().fail(date + " not present in the option list");
			}

		} catch (Exception e) {

			log.error("Exception while selecting date from datepicker: " + e.getMessage());
			ReportManager.getTest().fail("Exception while selecting date from datepicker: " + e.getMessage());
		}

	}

}
