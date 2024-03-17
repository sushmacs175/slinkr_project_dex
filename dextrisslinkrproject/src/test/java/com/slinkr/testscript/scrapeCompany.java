package com.slinkr.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;

import com.slinkr.genericutility.BaseClass;
import com.slinkr.genericutility.FileUtility;
import com.slinkr.pom.CompanyPage;

@Listeners(com.slinkr.genericutility.ListenerImplementationSlinkr.class)
public class scrapeCompany extends BaseClass{
	
	@Test(groups="regression")
	public void OneEndToEndSlinkrCompany() throws IOException, SQLException
	{
		CompanyPage company=new CompanyPage(driver);
		company.getCoampanyLink().click();
		
		FileUtility fis=new FileUtility();
		String url = fis.getExceldata("company", 0, 0);
		company.getCompanyUrl().sendKeys(url);
		
		company.getCSearchButton().submit();
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/slinkrdb","root","root");
		Statement stmt=con.createStatement();
		String s="select comp_name from linkapp_companydata1 where comp_name='Accetion'";
		ResultSet rs=stmt.executeQuery(s); 
		while(rs.next())
		{
			
			String cn=rs.getString("comp_name");
			Reporter.log("comp_name is :" +cn);
		}
		
		String companytabText=company.getTableCompanyDetails().getText();
		
		System.out.println(companytabText);
		
		Reporter.log(companytabText);
		
		String dbMessage=company.getCompanyDbMessage().getText();
		Reporter.log(dbMessage);
	}
}	

