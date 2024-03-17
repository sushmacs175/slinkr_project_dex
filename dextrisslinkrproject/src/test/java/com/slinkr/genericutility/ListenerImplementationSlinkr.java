package com.slinkr.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImplementationSlinkr extends BaseClass  implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorImages/"+name+".png");
		try {
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) {
		}
	}
}
