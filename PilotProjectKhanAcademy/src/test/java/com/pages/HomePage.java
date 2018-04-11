package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver){
	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//finding all elements on the page
	@FindBy(xpath="//span[@data-test-id='header-profile-button']/span[contains(@class,nicknameDisplay)]")
	WebElement profileName;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logOut;
	
	
	@FindBy(xpath="//div[contains(text(),'Edit') and contains(@class,'inner')]")
	WebElement editProfile;
	
	
	

	public void samplePreferences(){
		this.driver.findElement(By.xpath("//label[contains(text(),'Graduate studies')]")).click();
		this.driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
		this.driver.switchTo().activeElement();
		this.driver.findElement(By.xpath("//label[contains(text(),'Chemistry')]")).click();
		this.driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
	}
	
	public void sampleEditProfilePreferences(){
		this. driver.findElement(By.xpath("//label[contains(text(),'Biology')]")).click();
		this.driver.findElement(By.xpath("//label[contains(text(),'Multivariable calculus')]")).click();
		this.driver.findElement(By.xpath("//label[contains(text(),'Algebra basics')]")).click();
		this.driver.findElement(By.xpath("//label[contains(text(),'Linear algebra')]")).click();
	    this.driver.findElement(By.xpath("//div[contains(text(),'Back')]")).click();
	    this.driver.findElement(By.xpath("//label[contains(text(),'Adult learner')]")).click();
		this.driver.findElement(By.xpath("//*[contains(@class,'topLeftCorner')]/*[contains(@data-test-id,'close-modal-btn')]")).click();
	}
	
	public void logOut(){
		profileName.click();
		logOut.click();
	}
	
}
