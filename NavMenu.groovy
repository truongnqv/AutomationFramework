package com.joblogic.gui.deskoffice.pageobject.common

import groovy.util.ObservableList.ElementAddedEvent

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

import com.joblogic.gui.deskoffice.common.WaitHelper
import com.joblogic.log.Logger
import com.joblogic.log.Screenshot

class NavMenu {
	static WebDriver driver
	static final Logger = new Logger()
	
	@FindBy(xpath ="//*[@class='jl-sidebar-nav']//li")
	private static List<WebElement> lnk_MenuItems
	
	
	static final INSTANCE = new NavMenu()

	static NavMenu init(WebDriver driver)
	{
		PageFactory.initElements(driver, this)
		this.driver = driver
		return INSTANCE
	}
	
	static clickOnMenu(String menuItemName) throws Exception
	{
		try{
			WaitHelper.waitForElementVisible(driver, lnk_MenuItems[0], 30)
			lnk_MenuItems.find{it.text == menuItemName}.click()
		}	
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			Logger.error ex
		}
		
	}
	
	static clickOnSubMenu(String menuItemName, String subMenuItemName) throws Exception
	{
		try{
			clickOnMenu(menuItemName)
			clickOnMenu(subMenuItemName)
		}
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			Logger.error ex.toString()
		}
	}
}
