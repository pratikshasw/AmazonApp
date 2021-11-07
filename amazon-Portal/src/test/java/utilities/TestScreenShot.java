package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TestScreenShot{
	public static void takesScreenshot(WebDriver driver,int testID) throws IOException, InterruptedException{
	
	Date currentdate = new Date();
	String filename = currentdate.toString().replace(" ", "-").replace(":", "-");
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest = new File("test-output\\testScreenshot\\Test_"+"testID"+filename+".png");
	FileHandler.copy(source, dest);
	Thread.sleep(3000);
	}
}
