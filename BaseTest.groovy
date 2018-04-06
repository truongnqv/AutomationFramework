package com.joblogic.test.gui.officedesk.common;

import org.junit.AfterClass
import org.junit.BeforeClass
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

public class BaseTest {
	static WebDriver driver

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", Variables.driverExecution)
		driver = new ChromeDriver();
		driver.manage().window().maximize()
		driver.get(Variables.deskUrl)
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close()
	}

}
