package com.joblogic.gui.deskoffice.business.common

import org.junit.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import com.joblogic.gui.deskoffice.pageobject.common.Login
import com.joblogic.gui.deskoffice.common.WaitHelper
import com.joblogic.log.Screenshot

class LoginPage extends Login{
	
	static final INSTANCE = new LoginPage()

	static LoginPage init(WebDriver driver) 
	{
		PageFactory.initElements(driver, this)
		this.driver = driver
		return INSTANCE
	}

	static verifyAccountPresent() throws Exception
	{
		try{
			WaitHelper.waitForElementVisible(driver, lbl_AccountMenu, 30)
			Assert.assertEquals(lbl_AccountMenu.displayed, true)
		}
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			
		}
		
	}
}
