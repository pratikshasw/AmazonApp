package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomClasses.HomePage;
import pomClasses.LoginPass;
import pomClasses.SignUpPage;

public class GiftIdeasVerification extends BaseClass {
	
	private WebDriver driver;
	private HomePage homePage;
	private SignUpPage signUpPage;
	private LoginPass loginPass;
	int testID;
	
   @BeforeClass
   public void launchTheBrowser() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pratiksha\\Desktop\\VELOCITY\\Selenium_software\\chromedriver.exe");
       driver = new ChromeDriver();
      driver.navigate().to("https://www.amazon.in/");
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
   }
   @BeforeMethod
   public void loginToAppl() throws InterruptedException {
	   
	   homePage = new HomePage(driver);
	   signUpPage = new SignUpPage(driver);
	   loginPass = new LoginPass(driver);
		homePage.moveToAccountList();
		homePage.clickOnSignUp();
		signUpPage.sendEmailOrMobileNo();
		signUpPage.clickOnsignUpcont();
		loginPass.sendloginPass();
		loginPass.clickOnlogincont();
	   
   }
   @Test
   public void verfyGiftIdeas() {
	   testID=301;
	   homePage = new HomePage(driver); 
	   homePage.clickOnGiftIdeas();
	   String url = driver.getCurrentUrl();
	   System.out.println(url);
   }
   
   @AfterMethod
   public void signout() throws InterruptedException {
	   homePage = new HomePage(driver); 
	   homePage.clickOnSignOut();
   }
   @AfterClass
   public void closeBrowser() {
	   driver.close();
   }
	
}
