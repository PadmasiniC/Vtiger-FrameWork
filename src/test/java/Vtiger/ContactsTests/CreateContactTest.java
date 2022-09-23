package Vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.ProertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		
//step-1 Create objects of all the utilities
		JavaUtility jUtil=new JavaUtility();
		ProertyFileUtility pUtil=new ProertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
// step-2 Read all the necessary data
	// from prop file
		String BROWSER=pUtil.readDatafromPFile("browser");
		String URL=pUtil.readDatafromPFile("url");
		String USERNAME=pUtil.readDatafromPFile("username");
		String PASSWORD=pUtil.readDatafromPFile("password");
		
	// from excel sheet	

		String LASTNAME=eUtil.readDataFromExcel("Contacts",1, 2)+jUtil.getRandomNumber();
		String LEADSOURCE=eUtil.readDataFromExcel("Contacts",1,3);
		System.out.println(LASTNAME);
		System.out.println(LEADSOURCE);
		
// STEP-3 - LAUNCH THE BROWSER - runtime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser Name");
		}
		
//now to maximize, wait&get url-use the utility methods
		wUtil.maximizeWindow(driver);
		wUtil.waitForDOMLoad(driver);
		driver.get(URL);
		
//step-4 login to app
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	   	driver.findElement(By.id("submitButton")).click();

// step-5 navigate to create contacts
		driver.findElement(By.linkText("Contacts")).click();
		
//step-6 click on create contacts
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
//step-7- create contacts with mandi.fields
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		WebElement ele=driver.findElement(By.name("leadsource"));
		wUtil.handleDropDown(LEADSOURCE, ele);
		 driver.findElement(By.name("button")).click();
		 
//step- 8 - logout
		 WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wUtil.waitForElementTOBeVisible(driver, element);
		 wUtil.mouseHover(driver, element);
		 driver.findElement(By.linkText("Sign Out")).click();
		 System.out.println("Saved the Contact and Logged out successfully");
		 driver.close();
	}
}
