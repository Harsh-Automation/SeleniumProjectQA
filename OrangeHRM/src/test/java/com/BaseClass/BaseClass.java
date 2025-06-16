package com.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	String browser = "chrome";

	@BeforeClass
	public void setup() {
		try {

			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions co = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(co);
			} else if (browser.equalsIgnoreCase("edge")) {
				EdgeOptions eo = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(eo);
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@AfterClass

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
