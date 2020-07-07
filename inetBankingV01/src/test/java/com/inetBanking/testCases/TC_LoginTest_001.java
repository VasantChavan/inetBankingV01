package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest(){
		
		LoginPage login = new LoginPage(driver);	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//login.setUserName(readConfig.getUserName());
		
		login.setUserName(user);
		logger.info("Enetr user name");
		//login.setPassword(readConfig.getUserPass());
		
		login.setPassword(pass);
		
		logger.info("Enetr password name");
		login.clickOnLoginBtn();
		
		logger.info("click on login button");
		
		String title= driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Guru99 Bank Manager HomePage")){
				Assert.assertTrue(true);
				logger.info("Login successfully...");
		}
		else{
			
			captureScreen(driver,"loginTests");
			Assert.assertTrue(false);
			logger.info("Login failed...");
		}
	}
	
	
}
