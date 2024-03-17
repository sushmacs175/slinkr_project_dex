package com.slinkr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage {
	
	public CompanyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[text()='Company']")
	private WebElement companyLink;
	public WebElement getCoampanyLink()
	{
		return companyLink;
	}
	
	@FindBy(xpath="//input[@placeholder=\"Company Name....\"]")
	private WebElement companyUrl;
	public WebElement getCompanyUrl()
	{
		return companyUrl;
	}
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchCPButton;
	public WebElement getCSearchButton()
	{
		return searchCPButton;
	}
	
	@FindBy(id="tab")
	private WebElement tableCompanyDetails;
	public WebElement getTableCompanyDetails()
	{
		return tableCompanyDetails;
	}
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible fade show' and 'Your message has been successfully fetched from Database     ']")
	private WebElement companyDbMessage;
	public WebElement getCompanyDbMessage()
	{
		return companyDbMessage;
	}
	
}
