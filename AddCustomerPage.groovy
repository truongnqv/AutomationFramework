package com.joblogic.gui.deskoffice.business.customers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import com.joblogic.gui.deskoffice.pageobject.customers.AddCustomer

class AddCustomerPage extends AddCustomer{
	
	static final INSTANCE = new AddCustomerPage()

	static AddCustomerPage init(WebDriver driver)
	{
		PageFactory.initElements(driver, this)
		this.driver = driver
		return INSTANCE
	}

}
