package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPass {
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement loginpassword;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement logincont;
	
	public LoginPass(WebDriver driver){
		 PageFactory.initElements(driver, this);
		}
		
		public void sendloginPass() {
			loginpassword.sendKeys("Gauri@321");
		}
		
		public void clickOnlogincont() {
			logincont.click();
		}

}
