package com.joblogic.gui.deskoffice.pageobject.quotes

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import com.joblogic.gui.deskoffice.business.quotes.LogQuotePage
import com.joblogic.gui.deskoffice.common.CustomKeywords
import com.joblogic.gui.deskoffice.pageobject.common.NavMenu
import com.joblogic.log.Logger
import com.joblogic.log.Screenshot

class LogQuote {
	static WebDriver driver
	static final Logger = new Logger()
	
	@FindBy(xpath ="//*[@id='JobTypeId_listbox']/li")
	private static List<WebElement> cbb_JobTypes
	
	@FindBy(name ="JobTypeId_input")
	static WebElement txt_JobType

	static LogQuotePage setJobType(String jobType) throws Exception
	{
		
		try{
			NavMenu.init(driver)
					.clickOnSubMenu("Quotes", "Log Quote")
			CustomKeywords.setTextCustomField(driver, txt_JobType, jobType)
		}
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			Logger.error ex
		}
		finally{
			return LogQuotePage.INSTANCE
		}
	}
}
