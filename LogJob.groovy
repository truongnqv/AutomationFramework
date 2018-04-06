package com.joblogic.gui.deskoffice.pageobject.Jobs

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import com.joblogic.gui.deskoffice.business.jobs.LogJobPage
import com.joblogic.gui.deskoffice.common.CustomKeywords
import com.joblogic.gui.deskoffice.pageobject.common.NavMenu
import com.joblogic.log.Logger
import com.joblogic.log.Screenshot

class LogJob {
	static WebDriver driver
	static final Logger = new Logger()
	
	@FindBy(xpath ="//*[@id='JobTypeId_listbox']/li")
	private static List<WebElement> cbb_JobTypes
	
	@FindBy(name ="JobTypeId_input")
	static WebElement txt_JobType

	static LogJobPage setJobType(String jobType) throws Exception
	{
		
		try{
			NavMenu.init(driver)
					.clickOnSubMenu("Jobs", "Log Job")
			CustomKeywords.setTextCustomField(driver, txt_JobType, jobType)
		}
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			Logger.error ex
		}
		finally{
			return LogJobPage.INSTANCE
		}
	}
}
