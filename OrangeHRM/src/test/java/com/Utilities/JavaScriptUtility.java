package com.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.BaseClass.BaseClass;

public class JavaScriptUtility extends BaseClass {

	static JavascriptExecutor js;
	static Logger log = LogManager.getLogger(JavaScriptUtility.class);

	public static void scrollToBottom() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			log.info("Scrolled till the bottom of the page.");

			ReportManager.getTest().info("Scrolled till the bottom of the page.");
		} catch (Exception e) {
			log.error("Failed to scroll till to bottom: " + e.getMessage());

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

	public static void clearInputField(WebElement elementLocator) {

		try {

			js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].value='';arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
					elementLocator);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void highlightElement(WebElement element) {
		try {

			String originalStyle = element.getDomAttribute("style");

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='1.7px solid red';", element);
			Thread.sleep(400);

			js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, originalStyle);

		} catch (Exception e) {
			log.error("Error while highlighting element: " + e.getMessage());
			ReportManager.getTest().fail("Error while highlighting element: " + e.getMessage());
		}
	}

//	public static void unHighlightElement(WebElement element) {
//		try {
//
//			js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].style.border='1.5px solid white;", element);
//
//		} catch (Exception e) {
//			log.error("Error while highlighting element: " + e.getMessage());
//			ReportManager.getTest().fail("Error while highlighting element: " + e.getMessage());
//		}
//	}

}
