package Repositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myRepo {
	WebDriver driver;
	
	public myRepo(WebDriver driver){
		this.driver=driver;
	}
	public WebElement loginLink()
	{
		WebElement loginLink = driver.findElement(By.xpath("//a[@href=\"https://www.drishtiias.com/login\"]"));
		return loginLink;
	}
	
	public WebElement username()
	{
		WebElement username =driver.findElement(By.xpath("(//input[@class=\"_aa4b _add6 _ac4d _ap35\"])[1]"));
		return username;
	}
	
	public WebElement password()
	{
		WebElement password = driver.findElement(By.xpath("//input[@fdprocessedid=\"8xj7q\"]"));
		return password;
		
	}
	
	public WebElement checkBox()
	{
		WebElement checkbox = driver.findElement(By.xpath("(//span[@role=\"checkbox\"])[1]/div"));
		return checkbox;
	}
	
	public WebElement submitButton()
	{
		WebElement submitButton = driver.findElement(By.xpath("//button[@fdprocessedid=\"qq14ic\"]"));
		return submitButton;
	}
	
	public WebElement homePage()
	{
		WebElement homepage =  driver.findElement(By.xpath("//a[@href=\"https://www.drishtiias.com/eng\"]"));
		return homepage;
	}
	 
	
	
	public WebElement syllabus()
	{
		WebElement syl =  driver.findElement(By.xpath("(//a[text()=\"Syllabus & Strategy\"])[1]"));
		return syl;
	}
	public WebElement target()
	{
		WebElement tar = driver.findElement(By.xpath("//a[@href=\"https://www.drishtiias.com/upsc-syllabus#prelims-syllabus\"]"));
		return tar;
	}
	public WebElement prelims() {
		WebElement prelims = driver.findElement(By.xpath("//span[text()=\"Prelims\"]"));
		return prelims;
		
	}
	

}
