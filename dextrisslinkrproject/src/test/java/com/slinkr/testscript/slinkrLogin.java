package com.slinkr.testscript;

import org.testng.annotations.Test;
import com.slinkr.pom.LogoutPage;


import com.slinkr.pom.SlinkrLoginPage;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.slinkr.genericutility.BaseClass;
import com.slinkr.genericutility.FileUtility;

@Listeners(com.slinkr.genericutility.ListenerImplementationSlinkr.class)
public class slinkrLogin extends BaseClass{

	@Parameters("browser")
	@Test(groups="regression")
	public void oneendtoendLoginPage() throws IOException, InterruptedException {
		
		SlinkrLoginPage login=new SlinkrLoginPage(driver);
		login.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
		login.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
		login.getLoginButton().submit();
		LogoutPage logout=new LogoutPage(driver);
		logout.getLogoutButton().click();
	}
	
	@Test(groups="smoke")
	public void loginCosmeticVerification() throws IOException, InterruptedException
	{
		SlinkrLoginPage login=new SlinkrLoginPage(driver);
		String backgroundColor=login.getLoginColorButton().getCssValue("background-color");
		Reporter.log("background color of login button is " +backgroundColor);
		
		String fontFamily=login.getLoginColorButton().getCssValue("font-family");
		Reporter.log("fontfamily is " +fontFamily);
		Thread.sleep(2000);
	}
	
	@Test(enabled=false,groups={"functional","integration"})
	public void enumOperations() throws IOException, InterruptedException
	{
		SlinkrLoginPage login=new SlinkrLoginPage(driver);
		login.getUsernameTextField().sendKeys(fileUtils.getPropertyData("username"));
		login.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
		Thread.sleep(2000);
		login.getUsernameTextField().sendKeys(Keys.CONTROL+"a");
		login.getUsernameTextField().sendKeys(Keys.DELETE);
		login.getUsernameTextField().sendKeys(Keys.chord(fileUtils.getPropertyData("username")));
		login.getPasswordTextField().sendKeys(Keys.CONTROL+"a");
		login.getPasswordTextField().sendKeys(Keys.DELETE);
		login.getPasswordTextField().sendKeys(Keys.chord(fileUtils.getPropertyData("password")));
		
		 WebElement loginColorChange = login.getLoginButton();
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(loginColorChange).build().perform();
		Thread.sleep(2000);	
		login.getLoginButton().submit();
	}
	@Test
	public void unpwdheightandwidth()
	{
		SlinkrLoginPage login=new SlinkrLoginPage(driver);	
		int usernameHeight = login.getUsernameTextField().getRect().getHeight();
		Reporter.log("username Height is "+usernameHeight);
		int usernameWidth = login.getUsernameTextField().getRect().getWidth();
		Reporter.log("username width is "+usernameWidth);
	}
	
	
	@Test
	public void sendinginvalidUn() throws EncryptedDocumentException, IOException
	{
		SlinkrLoginPage un=new SlinkrLoginPage(driver);
		FileUtility fis=new FileUtility();
		String username = fis.getExceldataUserName("usernamestring", 0, 0);
		un.getUsernameTextField().sendKeys(username);
		un.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
		un.getLoginButton().submit();
	}
	
	@Test
	public void sendinginvalidUn1() throws EncryptedDocumentException, IOException
	{
		SlinkrLoginPage un=new SlinkrLoginPage(driver);
		FileUtility fis=new FileUtility();
		String username = fis.getExceldataUserName("usernamestring", 1, 0);
		un.getUsernameTextField().sendKeys(username);
		un.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
		un.getLoginButton().submit();
	}
	
	@Test
	public void loginErrorMsg() throws EncryptedDocumentException, IOException
	{
		SlinkrLoginPage un=new SlinkrLoginPage(driver);
		FileUtility fis=new FileUtility();
		String username = fis.getExceldataUserName("usernamestring", 0, 0);
		un.getUsernameTextField().sendKeys(username);
		un.getPasswordTextField().sendKeys(fileUtils.getPropertyData("password"));
		un.getLoginButton().submit();	
		
		String invalidText = un.getLoginErrorMsg().getText();
		Reporter.log("invalid message : " +invalidText);
		
	}
}
