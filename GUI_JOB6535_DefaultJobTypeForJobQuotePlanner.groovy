package com.joblogic.test.gui.officedesk

import org.junit.Test

import com.joblogic.gui.deskoffice.business.common.LoginPage
import com.joblogic.gui.deskoffice.business.jobs.LogJobPage
import com.joblogic.gui.deskoffice.business.quotes.LogQuotePage
import com.joblogic.test.gui.officedesk.common.BaseTest
import com.joblogic.test.gui.officedesk.common.Variables

public class GUI_JOB6535_DefaultJobTypeForJobQuotePlanner extends BaseTest{

	@Test
	public void LoginOfficeDesk() {
		
		LoginPage.init(driver)
				.login(Variables.deskUsername, Variables.deskPassword)
				.verifyAccountPresent()
				
		LogJobPage.init(driver)
				.setJobType("Maintenance")
				.verifyJobType("Maintenance")
				
		LogQuotePage.init(driver)
				.setJobType("Maintenance")
				.verifyJobType("Maintenance")
	}

}
