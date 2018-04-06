package com.joblogic.gui.deskoffice.business.jobs

import org.junit.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import com.joblogic.gui.deskoffice.pageobject.Jobs.LogJob

class LogJobPage extends LogJob{
	
	static final INSTANCE = new LogJobPage()

	static LogJobPage init(WebDriver driver)
	{
		PageFactory.initElements(driver, this)
		this.driver = driver
		return INSTANCE
	}
	
	static verifyJobType(String expectedJobType) throws Exception{
		Assert.isEquals(expectedJobType, txt_JobType.getAttribute("value"))
	}

}
