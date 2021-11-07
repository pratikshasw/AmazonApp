package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fashion {
	
	private WebDriver driver;
	
	 @FindBy(xpath = "//img[@alt='Amazon Fashion']")
	 private WebElement amzonfashion ; 
	 
	 public Fashion(WebDriver driver){
			this.driver = driver;
		 PageFactory.initElements(driver, this);
		// act = new Actions(driver);
		}
	 
	 public void getText() {
		 String text = amzonfashion.getText();
		 System.out.println(text);
	 }

}
