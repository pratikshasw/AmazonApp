package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClasses.Fashion;
import pomClasses.HomePage;

public class VerifyHomePage {
	private WebDriver driver;
	private HomePage homePage;
	private Fashion fashion;
	int testID;

	
	@BeforeClass
	public void launchTheBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pratiksha\\Desktop\\VELOCITY\\Selenium_software\\chromedriver.exe");
         driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void openTheAppl() {
		driver.navigate().to("https://www.amazon.in/");
	}
	@Test
	public void verifyAllOption() throws InterruptedException {
		testID = 201;
		homePage = new HomePage(driver);
		homePage.clickOnAll();
		Thread.sleep(1000);
		homePage.getBestSeller();
		homePage.clickOnClose();
		driver.navigate().refresh();
		
	}
	
	@Test
	public void verifyFashion() {
		testID = 202;
		fashion = new Fashion(driver);
		homePage.clickOnfasshion();
		fashion.getText();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.navigate().back();
	}
	
	
	
	@AfterClass
	public void closeThebrowser() {
		driver.close();
	}
}
