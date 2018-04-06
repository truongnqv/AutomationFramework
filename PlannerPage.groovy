package com.joblogic.gui.deskoffice.business

import org.junit.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import com.joblogic.gui.deskoffice.pageobject.Planner

class PlannerPage extends Planner{
	
	static final INSTANCE = new PlannerPage()

	static PlannerPage init(WebDriver driver)
	{
		PageFactory.initElements(driver, this)
		this.driver = driver
		return INSTANCE
	}
	
	static verifyJobType(String expectedJobType) throws Exception{
		Assert.isEquals(expectedJobType, txt_JobType.getAttribute("value"))
	}

}
