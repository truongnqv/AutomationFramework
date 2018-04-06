package com.joblogic.gui.deskoffice.pageobject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import com.joblogic.gui.deskoffice.business.PlannerPage
import com.joblogic.gui.deskoffice.common.CustomKeywords
import com.joblogic.gui.deskoffice.pageobject.common.NavMenu
import com.joblogic.log.Logger
import com.joblogic.log.Screenshot

class Planner {
	static WebDriver driver
	static final Logger = new Logger()
	
	@FindBy(xpath ="//*[@id='JobTypeId_listbox']/li")
	private static WebElement lnk_SchedulerContent
	
	@FindBy(xpath ="//*[@id='JobTypeId_listbox']/li")
	private static List<WebElement> cbb_JobTypes
	
	@FindBy(name ="JobTypeId_input")
	static WebElement txt_JobType

	static PlannerPage setJobType(String jobType) throws Exception
	{
		
		try{
			NavMenu.init(driver)
					.clickOnMenu("Planner")
			lnk_SchedulerContent.click()
			CustomKeywords.setTextCustomField(driver, txt_JobType, jobType)
		}
		catch(Exception ex)
		{
			Screenshot.init(driver).captureScreenShot()
			Logger.error ex
		}
		finally{
			return PlannerPage.INSTANCE
		}
	}
}
