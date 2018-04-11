package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountSignUp {
 WebDriver driver;
 
 public AccountSignUp(WebDriver driver){
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 //******************identifying all elements
 @FindBy(xpath="//a[text()='Sign up']")
 WebElement signUpHome;
 
 //learner related elements
 @FindBy(xpath="//*[contains(text(),'Learner')]")
 WebElement learnerButton;
 
 @FindBy(xpath="//select[@name='birth[month]']")
 WebElement monthDropDown;
 
 @FindBy(xpath="//select[@name='birth[day]']")
 WebElement dayDropDown;
 
 @FindBy(xpath="//select[@name='birth[year]']")
 WebElement yearDropDown;
 
 
 //teacher related elements
 @FindBy(xpath="//*[contains(text(),'Teacher')]")
 WebElement teacherButton;
 
 
 
 
 //common elements for leaner, teacher and parent
 @FindBy(xpath="//*[contains(text(),'Sign up with Email')]")
 WebElement signUpwithMail;
 
 @FindBy(xpath="//*[text()='Continue with Facebook']")
 WebElement continueWithfaceBook;
 
@FindBy(xpath="//*[text()='Continue with Google']")
WebElement continueWithGoogle;
 
 

//signup with mail elements
@FindBy(xpath="//input[@type='email']")
WebElement mailTextBox;
@FindBy(xpath="//label[starts-with(@class,'label_') and contains( text(),'First name')] /form[starts-with(@class,'input_')]/input[@type='text']")
WebElement firstNameTextBox;
@FindBy(xpath="//label[starts-with(@class,'label_') and contains( text(),'Last name')] /form[starts-with(@class,'input_')]/input[@type='text']")
WebElement lastNameTextBox;
@FindBy(xpath="//input[@type='password']")
WebElement passwordTextBox;
@FindBy(xpath="//div[text()='Sign up']")
WebElement signUpButton;


 
 public void signUpHome(){
	 signUpHome.click();
 } 
 
 
 //a learner specific method
 public void signUpLearner(int month, int day, int year){
	 learnerButton.click();
	 new Select(monthDropDown).selectByValue(String.valueOf(month));
	 new Select(dayDropDown).selectByValue(String.valueOf(day));
	 new Select(yearDropDown).selectByValue(String.valueOf(year));
	 signUpwithMail.click();	
 }
 
 public void signUpTeacher(){
	 teacherButton.click();
 }
 
 
 //same for learner, parent and teacher
 public void signUpWithMailUserDetails(String mailId,String first, String last, String pass){
	 mailTextBox.sendKeys(mailId);
	 firstNameTextBox.sendKeys(first);
	 lastNameTextBox.sendKeys(last);
	 passwordTextBox.sendKeys(pass);
	 signUpButton.click();
 }
 
}
