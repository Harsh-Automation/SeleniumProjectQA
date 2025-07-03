package com.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.BaseClass.BaseClass;

public class JavaScriptUtility extends BaseClass {

	static JavascriptExecutor js;
	static Logger log = LogManager.getLogger(JavaScriptUtility.class);

	public static void scrollToBottom() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			log.info("Scrolled to the bottom of the page.");

			ReportManager.getTest().info("Scrolled to the bottom of the page.");
		} catch (Exception e) {
			log.error("Failed to scroll to bottom: " + e.getMessage());

			ReportManager.getTest().fail("Failed to scroll till the bottom: " + e.getMessage());
		}
	}

	public static void scrollToElement(By element, String elementName) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			log.info("Scrolled to element: " + elementName);

			ReportManager.getTest().info("Scrolled to element: " + elementName);
		} catch (Exception e) {
			ReportManager.getTest().fail("Failed to scroll to element: " + elementName + " - " + e.getMessage());
		}
	}

}
