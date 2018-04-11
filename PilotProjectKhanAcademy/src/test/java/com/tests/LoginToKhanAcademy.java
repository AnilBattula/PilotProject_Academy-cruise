package com.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pages.AccountLogIn;
import com.pages.FaceBookLogin;


 
public class LoginToKhanAcademy {
	WebDriver driver;
	AccountLogIn objLogin;
	FaceBookLogin objFBLogin;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void ExtentReports3(){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Anilkumar");
		
		htmlReporter.config().setDocumentTitle("My Automation Run");
		htmlReporter.config().setReportName("LogintoKhanAcademy");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	
	@BeforeMethod
	public void setUp(){	
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		 driver.get("https://www.khanacademy.org/");	 
	}
	
  @AfterMethod
	public void closureActivities(){
		driver.close();	

	}
 @AfterMethod
 public void getResult(ITestResult result){
	 if(result.getStatus()==ITestResult.FAILURE)
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"- test case is faile", ExtentColor.RED));
		else if(result.getStatus()==ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		} 
	 }
 
 
	
	@Test(priority=0,description="Login to the application with Account credentials")
	public void loginWithAcademyCredentials(){
		logger=extent.createTest("loginWithAcademyCredentials");
		objLogin= new AccountLogIn(driver);
		objLogin.loginWithCredentials("b12test@gmail.com", "Test@12345");	
		String actValue =objLogin.getUserProfileName();
		String expValue="Name";
		Assert.assertTrue(actValue.contains(expValue));
		//logging out
		String msg=objLogin.logOut();
		Assert.assertTrue(msg.contains("Khan"), "Logged Out Successfully");
		logger.log(Status.PASS, MarkupHelper.createLabel("Positive test case is passed", ExtentColor.GREEN));
		extent.flush();
	}
	 
	
	@Test(priority=1,description="Login to the application with facebook credentials")
	public void loginWithFBCredentials(){
		logger=extent.createTest("loginWithFBCredentials");
		objFBLogin = new FaceBookLogin(driver);
		objFBLogin.clickLoginPage();
		objFBLogin.clickContinuewithFB();
		String s=objFBLogin.FBUserLogin("leela.krishna101@gmail.com", "anil123");
		System.out.println(s);
		Assert.assertTrue(!(s.contains("null")), "Logged in Successfully");
		logger.log(Status.PASS, MarkupHelper.createLabel("Positive test case is passed", ExtentColor.GREEN));
		extent.flush();
	}
	
	@Test(priority=2,description ="A simple negative Scenario with blank login")
	public void blankLogin(){
		logger=extent.createTest("blankLogin");
		//objLogin.loginBlank();
		 driver.get("https://www.khanacademy.org/");	
		 driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		 driver.findElement(By.xpath("//input[contains(@class,'input') and @type='text']")).sendKeys(Keys.TAB);
		 String error=driver.findElement(By.xpath("//*[contains(@class,'fieldRequirement') and contains(text(),'An email or username')]")).
		 getText();
		 System.out.println("Error: "+error);
		Assert.assertTrue(error.contains("required"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Negative test case is passed", ExtentColor.GREEN));
		extent.flush();
	}



}
