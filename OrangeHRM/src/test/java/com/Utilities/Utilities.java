package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.BaseClass.BaseClass;

public class Utilities extends BaseClass {


	public static JavascriptExecutor js;
	static Logger log = LogManager.getLogger(Utilities.class);

	public static String takeScreenshot(String scrName) throws IOException {
		File dir = new File(System.getProperty("user.dir")+"/Screenshots");
		String dest = null;

		try {
			if (!dir.exists()) {
				dir.mkdir();
				log.info("New Directory created" + dir);
			}

			TakesScreenshot js = (TakesScreenshot) driver;
			File src = js.getScreenshotAs(OutputType.FILE);
			dest = dir + "/" + scrName + "_" + DataUtil.timestamp() + ".png";
			FileUtils.copyFile(src, new File(dest));

			log.info("Screenshot capture with filename " + scrName + ".png");

		} catch (Exception e) {
			log.error("Exception occured while capturing screenshot : " + e.getMessage());
			ReportManager.getTest().fail("Exception occured while capturing screenshot : " + e.getMessage());
		}
		return dest;

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

	

	public static void assertMainMenuOptions(List<WebElement> actualItems, List<String> expectedItems) {
		try {

			if (actualItems.size() == expectedItems.size()) {

				boolean allmatched = true;
				for (WebElement actualElement : actualItems) {

					String item = actualElement.getText().trim();
					if (!expectedItems.contains(item)) {
						allmatched = false;
						log.error(item + " not present in the assertion list");
						ReportManager.getTest().fail(item + " not present in the assertion list");
					} else {

						log.info("Matched: " + item);
						ReportManager.getTest().pass(item + " present in the assertion list");

					}

				}
				if (!allmatched) {
					log.error("One or more menu items did not match expected list.");
					ReportManager.getTest().fail("One or more menu items did not match expected list.");

				} else {
					log.info("All Main Menu items matched with the expected list.");
					ReportManager.getTest().fail("All Main Menu items matched with the expected list.");

				}
			}

			else {

				log.error("List size mismatch: expected " + expectedItems.size() + ", but found " + actualItems.size());
				ReportManager.getTest().fail(
						"List size mismatch: expected " + expectedItems.size() + ", but found " + actualItems.size());

			}

		} catch (Exception e) {
			log.error("Assertion Error : " + e.getMessage());
			ReportManager.getTest().fail("Assertion Error : " + e.getMessage());
		}
	}

}
