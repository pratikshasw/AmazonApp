package testClasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import basePackage.BaseClass;
import pomClasses.HomePage;
import pomClasses.LoginPass;
import pomClasses.SignUpPage;
import utilities.TestScreenShot;

public class CrossBrowserTesting extends BaseClass {
	
	private WebDriver driver;
	private HomePage homePage;
	private SignUpPage signUpPage;
	private LoginPass loginPass;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter ;
  
  @BeforeTest
  @Parameters("browser")
  public void launchBrowser(String browser) {
	  reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
	  
	  if(browser.equalsIgnoreCase("Chrome"))
	  {
		  driver = openChromeBrowser();
	  }
	  else
	  {
		  driver = openFireFoxBrowser();
	  }
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.navigate().to("https://www.amazon.in/");
    } 
  
  @BeforeClass
  public void createPOM() {
	  
	    homePage = new HomePage(driver);
		signUpPage =new SignUpPage(driver);
		loginPass = new LoginPass(driver);
   }
  @BeforeMethod
  public void loginToApp() throws InterruptedException {
	  homePage = new HomePage(driver);
	   signUpPage = new SignUpPage(driver);
	   loginPass = new LoginPass(driver);
		homePage.moveToAccountList();
		homePage.clickOnSignUp();
		signUpPage.sendEmailOrMobileNo();
		signUpPage.clickOnsignUpcont();
		loginPass.sendloginPass();
		loginPass.clickOnlogincont() ;
  }
  @Test
  public void toVerifySportTab() {
	  testID = 101;
	  homePage.clickOnSportTab();
	  String url = driver.getCurrentUrl();
	  System.out.println(url);
  }
  @AfterMethod
  public void logout(ITestResult result) throws InterruptedException, IOException {
	  if(ITestResult.FAILURE == result.getStatus())
	  {
		  TestScreenShot.takesScreenshot(driver,testID);
	  }
	  homePage.clickOnSignOut();
  }
  @AfterClass
  public void clearPomObject() {
	  homePage = null;
		signUpPage = null;
		loginPass = null;
  }
  @AfterTest
  public void closeBrowser() {
	  driver.close();
	  driver = null;
	  System.gc();
  }
}
