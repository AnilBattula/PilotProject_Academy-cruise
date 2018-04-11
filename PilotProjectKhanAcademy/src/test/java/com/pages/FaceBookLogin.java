package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLogin extends AccountLogIn{

	WebDriver driver;
	
public FaceBookLogin(WebDriver driver){
	this.driver=driver;	
	PageFactory.initElements(driver, this);
}
	
//****************Identifying all web elements	
	@FindBy(xpath="//*[@id='email']")
	WebElement fbUserName;

	@FindBy(xpath="//*[@id='pass']")
	WebElement fbPassword;

	@FindBy(xpath="//*[@id='loginbutton']")
	WebElement fbLoginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign up for Facebook')]")
	WebElement fbSignUp;
	
	
	
	public void setUserName(String name){
		fbUserName.sendKeys(name);
	}
	
	public void setPassword(String name){
		fbPassword.sendKeys(name);
	}
	
	public String fblogin(){
		fbLoginButton.click();
		return this.driver.getTitle();
	}
	
	
	public String FBUserLogin(String user, String pswrd){
		this.setUserName(user);
		this.setPassword(pswrd);
		return this.fblogin();
	   }
	
}
