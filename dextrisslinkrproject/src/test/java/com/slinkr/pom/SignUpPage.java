package com.slinkr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")
	private WebElement usernameTextField;
	public WebElement getUserNameTextField()
	{
		return usernameTextField;
	}
	
	@FindBy(name="firstname")
	private WebElement firstnameTextField;
	public WebElement getfirstnameTextField()
	{
		return firstnameTextField;
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameTextField;
	public WebElement getlastnameTextField()
	{
		return lastnameTextField;
	}
	
	@FindBy(name="email")
	private WebElement emailTextField;
	public WebElement getemailTextField()
	{
		return emailTextField;
	}
	
	@FindBy(name="password1")
	private WebElement password1TextField;
	public WebElement getpassword1TextField()
	{
		return password2TextField;
	}
	
	@FindBy(name="password2")
	private WebElement password2TextField;
	public WebElement getpassword2TextField()
	{
		return password2TextField;
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement signupButton;
	public WebElement getSignUpButton()
	{
		return signupButton;
	}
}
