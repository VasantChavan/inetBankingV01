package com.inetBanking.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="getData")
	public void loginDDT(String user, String pass){
		
		LoginPage loginPage=new LoginPage(driver);		
		
		loginPage.setUserName(user);
		 
		logger.info("username is provided");
		loginPage.setPassword(pass);
		logger.info("password is provided");
		loginPage.clickOnLoginBtn();
		logger.info("clicked on login button");
		
		if(isAlertPresent()==true){
			driver.switchTo().alert().accept();//close login alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else{
			Assert.assertTrue(true);
			loginPage.clickOnLogOutBtn();			
			driver.switchTo().alert().accept();// close logout alert			
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent(){
		
		try{
			 driver.switchTo().alert();
			 return true;
		}
		catch(NoAlertPresentException e){			
			return false;
		}
	}
	
	@DataProvider
	public Object [][] getData() throws Exception{
				
		String excelPath="C:\\Users\\vasant\\git\\inetBankingV01\\inetBankingV01\\TestData\\inetBankingTestData.xlsx";
	
		Object[][] loginData = XLUtils.getCellData(excelPath, "Sheet1");
		
		return loginData;
	}
}
