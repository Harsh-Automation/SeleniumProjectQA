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

	public WebDriver driver;
	String browser = "chrome";

	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeClass
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

	@AfterClass

	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser is closed");
		}
	}
}
