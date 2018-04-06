package com.joblogic.log

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver

public class Screenshot {
	static WebDriver driver
	
	static final INSTANCE = new Screenshot()
	
	static Screenshot init(WebDriver driver )
	{
		this.driver = driver
		return INSTANCE
	}
	
	static captureScreenShot(){
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)
		FileUtils.copyFile(screenshotFile,new File(getTimeStampValue()))
	}
	
	static String getTimeStampValue(){
		String datetime = new Date().format("yyyyMMdd'T'HHmmss", TimeZone.getTimeZone('UTC'))
		return "c:\\Screenshots\\${datetime}.png"
	}
}
