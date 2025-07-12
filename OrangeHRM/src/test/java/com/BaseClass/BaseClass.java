package com.BaseClass;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Utilities.BufferLogManager;
import com.Utilities.ConstantUtility;
import com.Utilities.ReportManager;
import com.Utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	String browser = "chrome";

	static Logger log = LogManager.getLogger(BaseClass.class);

	@BeforeMethod
	public void setup() {
		try {

			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions co = new ChromeOptions();
//				co.addArguments("--headless");
//				co.addArguments("--disable-gpu");
//				co.addArguments("--window-size=1920,1080");
//				co.addArguments("--start-maximized");

				co.addArguments("--force-device-scale-factor=1.25");

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(co);
				log.info("Chrome browser launched.");

			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions eo = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(eo);
				log.info("Chrome browser launched.");

			}
//			driver.manage().window().setSize(new Dimension(1920, 1080));

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			 BufferLogManager.bufferInfo("Browser launched successfully");

			driver.get(ConstantUtility.appUrl);
			log.info("Navigated to: " + ConstantUtility.appUrl);
			BufferLogManager.bufferInfo("Navigated to: " + ConstantUtility.appUrl);

		} catch (Exception e) {
			log.error("Exception during browser setup: " + e.getMessage());
			ReportManager.getTest().fail("Exception during browser setup: " + e.getMessage());
		}

	}

	@AfterMethod

	public void tearDown() {
		if (driver != null) {
			driver.quit();
			log.info("Browser Closed Successfully");
			ReportManager.getTest().pass("Browser Closed Successfully");

		}
	}

	@BeforeSuite
	public void deleteDirectory() {
		Utilities.delete_directory();
	}

	@BeforeSuite
	public void setupReport() {
		ReportManager.setupExtendReport();

	}

	@AfterSuite
	public void flushReport() {

		ReportManager.flushReport();
	}

}
