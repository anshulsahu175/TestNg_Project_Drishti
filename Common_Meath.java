package Common_Methods;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Meath {
	
	WebDriver driver;
	
	//Browser launch
	public WebDriver launchChrome() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\OneDrive\\Documents\\Onedrive Data\\Desktop\\Automation\\SeleniumAutomation\\lib\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;}
	
	//Application Launch
	public void launchApplication(WebDriver driver) throws Exception
	{
		driver.get("https://www.drishtiias.com/");
		Thread.sleep(2000);
	}
	
	//Taking Screenshot
	public void takingScreenshot(WebDriver driver) throws Exception
	{
		TakesScreenshot scrshot = (TakesScreenshot) driver;
        File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
        String  timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_mm_yyyy_ss"));
        Path destPath = Paths.get("screenshotpro", "File"+timestamp + ".png");
        Files.createDirectories(destPath.getParent());
        Files.copy(srcFile.toPath(), destPath);
	}
	
	
}
	
	
	


