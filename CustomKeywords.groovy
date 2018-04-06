package com.joblogic.gui.deskoffice.common

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class CustomKeywords {
	
	 static setAttributeJS (WebDriver driver, WebElement element, String attribute, String attrbuteValue){
		 JavascriptExecutor js = (JavascriptExecutor) driver
		 js.executeScript("return arguments[0].setAttribute(arguments[1], arguments[2]);",element, attribute, attrbuteValue)
		 js.executeScript("return document.readyState").equals("complete")
		 
	 }
	 
	 static setTextCustomField (WebDriver driver, WebElement element, String text) {
		 WaitHelper.waitForElementVisible(driver, element, 30).sendKeys(text)
		 element.sendKeys(Keys.TAB)
	 }
}
