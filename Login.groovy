package com.joblogic.gui.deskoffice.pageobject.common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import com.joblogic.gui.deskoffice.business.common.LoginPage
import com.joblogic.gui.deskoffice.common.WaitHelper
import com.joblogic.log.Logger
import com.joblogic.log.Screenshot

public class Login {
	static WebDriver driver
	static final Logger = new Logger()
	
	@FindBy(id ="UserName")
	private static WebElement txt_username
	
	@FindBy(id ="Password")
	private static WebElement txt_password

	@FindBy(id ="loginButton")
	private static WebElement btn_login
	
	@FindBy(id = "accountMenu")
	static WebElement lbl_AccountMenu
	

	static LoginPage login(String username, String password) 
	{
		
		try{
			WaitHelper.waitForElementVisible(driver, txt_username, 30).sendKeys(username)
			txt_password.sendKeys(password)
			btn_login.click()
		}
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			Logger.error ex
		}
		finally{
			return LoginPage.INSTANCE
		}
	}
}
