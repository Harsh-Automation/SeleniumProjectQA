package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.BaseClass;

public class Utilities extends BaseClass {

	public static WebDriverWait wait;

	public static JavascriptExecutor js;


	public static void takeScreenshot(String scrName) throws IOException {
		File dir = new File("Screenshots");

		try {
			if (!dir.exists()) {
				dir.mkdir();
			}

			TakesScreenshot js = (TakesScreenshot) driver;
			File src = js.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(dir + "/" + scrName + "_" + DataUtil.timestamp() + ".png"));

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void delete_directory() {

		File dir = new File("Screenshots");

		try {
			if (dir.exists()) {
				FileUtils.deleteDirectory(dir);
				System.out.println("Directory Deleted from path " + dir.getAbsolutePath());
			} else {

				System.out.println("Directory not exists");

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void waitForElement(WebElement locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(locator));
	}

	public static void assertMainMenuOptions(List<WebElement> actualItems, List<String> expectedItems) {
		try {

			if (actualItems.size() == expectedItems.size()) {

				boolean allmatched = true;
				for (WebElement actualElement : actualItems) {

					String item = actualElement.getText().trim();
					if (!expectedItems.contains(item)) {
						allmatched = false;
						throw new AssertionError(item + " not present in the assertion list");
					} else {

						System.out.println("Matched: " + item);

					}

				}
				if (!allmatched) {
					throw new AssertionError("One or more menu items did not match expected list.");

				} else {
					System.out.println("All Main Menu items matched with the expected list.");
				}
			}

			else {

				throw new AssertionError(
						"List size mismatch: expected " + expectedItems.size() + ", but found " + actualItems.size());
			}

		} catch (Exception e) {
			System.out.println("Assertion Error : " + e.getMessage());
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

}
