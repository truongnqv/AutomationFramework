package com.joblogic.gui.deskoffice.business.quotes

import org.junit.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import com.joblogic.gui.deskoffice.pageobject.quotes.LogQuote

class LogQuotePage extends LogQuote{
	
	static final INSTANCE = new LogQuotePage()

	static LogQuotePage init(WebDriver driver)
	{
		PageFactory.initElements(driver, this)
		this.driver = driver
		return INSTANCE
	}
	
	static verifyJobType(String expectedJobType) throws Exception{
		Assert.isEquals(expectedJobType, txt_JobType.getAttribute("value"))
	}

}
