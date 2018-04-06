package com.joblogic.gui.deskoffice.common

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

import com.joblogic.gui.deskoffice.pageobject.Login

class JSKeywords {
	
	 static setAttribute (WebDriver driver, WebElement element, String attribute, String attrbuteValue){
		 JavascriptExecutor js = (JavascriptExecutor) driver
		 js.executeScript("return arguments[0].setAttribute(arguments[1], arguments[2]);",element, attribute, attrbuteValue)
		 js.executeScript("return document.readyState").equals("complete")
		 
	 }
}
