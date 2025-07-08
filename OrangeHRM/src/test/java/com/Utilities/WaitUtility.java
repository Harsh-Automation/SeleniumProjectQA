package com.Utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.BaseClass;

public class WaitUtility extends BaseClass {

	public static WebDriverWait wait;
	static Logger log = LogManager.getLogger(Utilities.class);

	public static void waitForElementToBeClickable(By locator) {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantUtility.waitTimeForElement));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			log.error("Exception occured while waiting for the element : " + e.getMessage());
		}
	}

	public static void waitForVisibilityOfElementLocated(By locator) {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantUtility.waitTimeForElement));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception e) {
			log.error("Exception occured while waiting for the element : " + e.getMessage());
		}
	}

	public static void waitForElementVisiblity(WebElement locator) {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantUtility.waitTimeForElement));
			wait.until(ExpectedConditions.visibilityOf(locator));

		} catch (Exception e) {
			log.error("Exception occured while waiting for the element : " + e.getMessage());
		}
	}

}
