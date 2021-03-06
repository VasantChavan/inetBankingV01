package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	WebElement logoutBtn;
	
	
	public void setUserName(String userName){		
		txtUserName.sendKeys(userName);
		
	}
	public void setPassword(String userPassword){
		txtPassword.sendKeys(userPassword);
	}
	public void clickOnLoginBtn(){		
		loginBtn.click();
	}
	
	public void clickOnLogOutBtn(){		
		logoutBtn.click();
	}
		
}
