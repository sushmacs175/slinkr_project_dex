package com.slinkr.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;
import com.slinkr.genericutility.BaseClass;
import com.slinkr.pom.PersonPage;
import com.slinkr.pom.SlinkrLoginPage;

@Listeners(com.slinkr.genericutility.ListenerImplementationSlinkr.class)
public class scrapePerson extends BaseClass{
	@Parameters({"browser"})
	@Test(groups="regression")
	public void OneEndToEndSlinkrPerson() throws IOException
	{
	
	SlinkrLoginPage loginS=new SlinkrLoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	}
	
	@Test
	public void titleVerification() {
	String expectedTitle="Nav Bar";
	String actualTitle=driver.getTitle();
	AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void sendPersonUrl() throws IOException {
	SlinkrLoginPage loginS=new SlinkrLoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	PersonPage person=new PersonPage(driver);	
	person.getUrlLink().sendKeys(fileUtils.getPropertyData("personurl"));
	person.getPLoginButton().submit();
	}
	
	@Test
	public void personTableDetails() throws IOException
	{
	SlinkrLoginPage loginS=new SlinkrLoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	PersonPage person=new PersonPage(driver);	
	person.getUrlLink().sendKeys(fileUtils.getPropertyData("personurl"));
	person.getPLoginButton().submit();
	String persontabText=person.getTablePersonDetails().getText();
	System.out.println(persontabText);
	Reporter.log(persontabText);
	String name=person.getUserLoggedinName().getText();
	Reporter.log("user name is " +name);
	}
	
	@Test
	public void logoutScreenshot() throws IOException
	{
	SlinkrLoginPage loginS=new SlinkrLoginPage(driver);
	loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
	loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
	loginS.getLoginButton().submit();
	PersonPage person=new PersonPage(driver);
	String timeStamp=LocalDateTime.now().toString().replace(':','-');
	File tempFile = person.getLogoutButton().getScreenshotAs(OutputType.FILE);
	File permFile=new File("./errorshots/"+timeStamp+"logout.png");
	FileUtils.copyFile(tempFile, permFile);
	}
	
	@Test
	public void welcomText() throws IOException
	{
		SlinkrLoginPage loginS=new SlinkrLoginPage(driver);
		loginS.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
		loginS.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
		loginS.getLoginButton().submit();
		PersonPage person=new PersonPage(driver);
		String welcomeText=person.getWelcomText().getText();
		Reporter.log(welcomeText);
	}
}
