package com.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Utilities.ReportManager;
import com.Utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	String browser = "chrome";

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeMethod
	public void setup() {
		try {

			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--force-device-scale-factor=1.25");

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(co);
			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions eo = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(eo);
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

			driver.get(url);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@AfterMethod

	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser is closed");
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
