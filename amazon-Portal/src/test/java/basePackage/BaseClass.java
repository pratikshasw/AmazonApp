package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pratiksha\\Desktop\\VELOCITY\\Selenium_software\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();
	       return driver;
	}
	
	public static WebDriver openFireFoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pratiksha\\Desktop\\VELOCITY\\Selenium_software\\geckodriver.exe");
	       WebDriver driver = new FirefoxDriver();
	       return driver;
	}
}
