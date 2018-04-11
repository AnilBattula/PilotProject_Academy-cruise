package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogIn {

	WebDriver driver;
	AccountLogIn(){
		}
	public AccountLogIn(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//****************Identifying all web elements
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement logInPage;
	
	@FindBy(xpath="//input[contains(@class,'input') and @type='text']")
	WebElement userName;
	
	@FindBy(xpath="//input[contains(@type,'password')]")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Log in']")
	WebElement Login;
	
	@FindBy(xpath="//span[@data-test-id='header-profile-button']/span[contains(@class,nicknameDisplay)]")
	WebElement userProfile;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOut;
	
	@FindBy(xpath="//*[contains(text(),'Continue with Facebook')]")
	WebElement continueWithFB;
	
	//error message elements
	@FindBy(xpath="//*[contains(@class,'fieldRequirement') and contains(text(),'An email or username')]")
	WebElement userNameErrorMessage;
	
	
	//******************simple methods for each user action
	//continue with face book
	public void clickContinuewithFB(){
		continueWithFB.click();
	}
	
	//navigating to Login Page
	public void clickLoginPage(){
		logInPage.click();
	}
	
	//clicking on Login
	public void login(){
		Login.click();
	}
	
	//getting profile name
	public String getUserProfileName(){
		return userProfile.getText();
	}
	
	//logingout
	public String logOut(){
		userProfile.click();
		logOut.click();
		return this.driver.getTitle();
	}
	
	
	
	
	//******************************methods for each work flow
	public void loginWithCredentials(String userName, String password){
		this.clickLoginPage();
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.Login.click();	
	}
	
	
	public void loginBlank(){
		this.logInPage.click();
		this.userName.sendKeys(Keys.TAB);
		 String error=this.userNameErrorMessage.getText();
		 System.out.println("Error: "+error);
	}
	
	
	
	
	
}
