package com.joblogic.gui.deskoffice.common;

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.joblogic.log.Logger

public class WaitHelper {
	static final Logger = new Logger()
	static WebElement waitForElementVisible(WebDriver driver, WebElement element, long timeOutInSecond) throws Exception
	{
		try{
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSecond)
			driverWait.until(ExpectedConditions.visibilityOf(element))
		}
		catch(Exception ex)
		{
			Logger.error ex
		}
		finally{
			return element
		}
	}
	
	static waitForElementsVisible(WebDriver driver, List<WebElement> webElements, long timeOutInSecond) throws Exception
	{
		try{
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSecond)
			driverWait.until(ExpectedConditions.visibilityOfAllElements(webElements))
		}
		catch(Exception ex)
		{
			Logger.error ex
		}
	}
	
	static waitForElementsNotVisible(WebDriver driver, List<WebElement> webElements, long timeOutInSecond) throws Exception
	{
		try{
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSecond)
			driverWait.until(ExpectedConditions.invisibilityOfAllElements(webElements))
		}
		catch(Exception ex)
		{
			Logger.error ex
		}
	}
	
	static waitForElementNotVisible(WebDriver driver, WebElement element, long timeOutInSecond) throws Exception
	{
		try{
			List<WebElement> webElements = new ArrayList<WebElement>()
			webElements.add(element)
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSecond)
			driverWait.until(ExpectedConditions.invisibilityOfAllElements(webElements))
		}
		catch(Exception ex)
		{
			Logger.error ex
		}
	}
	
	static WebElement waitForElementClickable(WebDriver driver, WebElement element, long timeOutInSecond) throws Exception
	{
		try{
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSecond)
			driverWait.until(ExpectedConditions.elementToBeClickable(element))
		}
		catch(Exception ex)
		{
			Logger.error ex
		}
		finally{
			return element
		}
		
	}
	
	static void waitForWindowsVisible(WebDriver driver, int noOfWindows, long timeOutInSecond) throws Exception
	{
		try{
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSecond)
			driverWait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows))
		}
		catch(Exception ex)
		{
			Logger.error ex
		}
	}
}
