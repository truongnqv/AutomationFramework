package com.joblogic.gui.deskoffice.pageobject.customers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import com.joblogic.gui.deskoffice.business.customers.AddCustomerPage
import com.joblogic.gui.deskoffice.common.WaitHelper
import com.joblogic.gui.deskoffice.pageobject.common.NavMenu
import com.joblogic.log.Logger
import com.joblogic.log.Screenshot

class AddCustomer {
	static WebDriver driver
	static final Logger = new Logger()
	
	@FindBy(id ="CustomerName")
	private static WebElement txt_CustomerName
	
	@FindBy(xpath="//button[contains(@class,'SubmitButton')]")
	private static WebElement btn_Save
	
	static AddCustomerPage saveCustomer(String customerName, String password) throws Exception
	{
		
		try{
			NavMenu.init(driver)
					.clickOnSubMenu("Customers", "Add Customer")
			WaitHelper.waitForElementVisible(driver, txt_CustomerName, 30).sendKeys(customerName)
			btn_Save.click()
		}
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			Logger.error ex
		}
		finally{
			return AddCustomerPage.INSTANCE
		}
	}
}
