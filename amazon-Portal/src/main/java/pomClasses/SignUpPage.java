package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	private WebDriver driver;
	
	 @FindBy(xpath = "//input[@id='ap_email']")
	private WebElement emailOrMobileNo ; 

	 @FindBy(xpath = "//span[@id='continue']")
	private WebElement signUpcontiButton ; 
	
	 
	 public SignUpPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 public void sendEmailOrMobileNo() {
		 emailOrMobileNo.sendKeys("9766373413");
	 }
	 
	 public void clickOnsignUpcont() {
		 signUpcontiButton.click();
	 }
	

}
