package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	private Actions act ;
	
	 @FindBy(xpath = "(//span[text()='All'])[2]")
	 private WebElement all ; 
	 @FindBy(xpath = "(//a[text()='Best Sellers'])[2]")
	 private WebElement bestSeller ; 
	 @FindBy(xpath = "//div[@class='nav-sprite hmenu-close-icon']")
	 private WebElement closeAll ;
	
	 @FindBy(xpath = "//a[contains(@data-csa-c-content-id,'nav_cs_fashion')]")
	 private WebElement fashion ; 
	 
	 @FindBy(xpath = "//span[text()='Account & Lists']")
	 private WebElement accountList ; 
	 
	 @FindBy(xpath = "(//span[text()='Sign in'])[1]")
		private WebElement signUp;
	 
	 @FindBy(xpath = "//span[text()='Sign Out']")
	 private WebElement signout ;
	 @FindBy(xpath = "//a[text()='Gift Ideas	']")
	 private WebElement giftideas ;
	 @FindBy(xpath = "//a[text()='Sports, Fitness & Outdoors']")
	 private WebElement sport ;
	 

	 public HomePage(WebDriver driver){
			this.driver = driver;
		 PageFactory.initElements(driver, this);
		 act = new Actions(driver);
		}
	 
	 public void clickOnAll() {
		 all.click();
	 }
	 public void getBestSeller() {
		 String title = bestSeller.getText();
		 System.out.println(title);
	 }
	 public void clickOnClose() {
		 closeAll.click();
	 }
	 public void clickOnfasshion() {
		 fashion.click();
	 }
	 public void clickOnGiftIdeas() {
		 giftideas.click();
	 }
	 
	 public void moveToAccountList() throws InterruptedException {
		act.moveToElement(accountList).perform();
		Thread.sleep(1000);
	 }
	 public void clickOnSignUp() {
		 
			act.moveToElement(signUp).click().build().perform();
		}
	 public void clickOnSignOut() throws InterruptedException {
		 act.moveToElement(accountList);
		 Thread.sleep(2000);
		 act.moveToElement(signout).click().build().perform();
	 }
	 public void clickOnSportTab() {
		 sport.click();
	 }
	
}
