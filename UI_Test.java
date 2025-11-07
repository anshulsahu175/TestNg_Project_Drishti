package MyJourney;
import org.testng.annotations.Test;

import Common_Assertions.Assertions;
import Common_Methods.Common_Meath;
import Repositry.myRepo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class UI_Test {
	WebDriver driver;
	Common_Meath cm;
	myRepo mr;
	Assertions ar;
 
  @Test
  public void uiTest() throws Exception {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		Long height = (Long) js.executeScript("return document.body.scrollHeight;");
		System.out.println("Total page height: " + height + " pixels");
		  
		//HomePage Open
		  mr.homePage().click();
		//prelims Option
		 mr.prelims().click();
		 mr.syllabus().click();
		 mr.target().click();
		  
		int scrollValue = 0;
		for (int i = 1; i <= height/414; i++) {
			    js.executeScript("window.scrollBy(0," + scrollValue + ")");
			    Thread.sleep(3000);
			    
			    //Taking ScreenShot
			    cm.takingScreenshot(driver);
			    
			    //End Condition
	            WebElement end= driver.findElement(By.xpath("//a[@href=\"https://www.drishtiias.com/drishti-policies/cancellation-refund-policy\"]"));
	            Boolean isInView = (Boolean) js.executeScript(
	            	    "var elem = arguments[0];" +
	            	    "var rect = elem.getBoundingClientRect();" +
	            	    "return (rect.top >= 0 && rect.bottom <= window.innerHeight);", 
	            	    end);
                  if (isInView) { break;}
	            	Thread.sleep(2000);
			    scrollValue += 414; 
			    driver.navigate().refresh();
				Thread.sleep(2000);
			}
	  
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	 cm.launchApplication(driver); }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("UI TEST Completed");
  }

  @BeforeClass
  public void beforeClass() {
	  cm = new Common_Meath();
	  driver=cm.launchChrome();
	  mr=new myRepo(driver);
	  
	  ar=new Assertions(driver);
	  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
}
