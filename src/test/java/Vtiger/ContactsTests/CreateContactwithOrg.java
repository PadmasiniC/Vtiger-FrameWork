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

/* This program scenario - Create Contact with Organization
 * Automating the precondition too
 * Precondition- Before creating contact, 1st create organization and validate both.
 * @ author - Padmasini.C - 
 * There shouldn't be dependency btwn test cases
 */

public class CreateContactwithOrg {
	public static void main(String[] args) throws IOException
	{
		WebDriver driver=null;
//Step-1 - create object of all utilities
		JavaUtility jUtil= new JavaUtility();
		ProertyFileUtility pUtil=new ProertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
// step-2 Read all the necessary data
	// from prop file
		String BROWSER=pUtil.readDatafromPFile("browser");
		String URL=pUtil.readDatafromPFile("url");
		String USERNAME=pUtil.readDatafromPFile("username");
		String PASSWORD=pUtil.readDatafromPFile("password");
		
	// from excel sheet	- CONTACT SHEET-ROW-5

		String ORGNAME=eUtil.readDataFromExcel("Contacts",4, 3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcel("Contacts",4,2);
		System.out.println(ORGNAME);
		System.out.println(LASTNAME);

// step-3 - Launch the browser-	example of runtime polymorphism
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

// step-5 navigate to create organization link
		driver.findElement(By.linkText("Organizations")).click();
		
//step-6 click on create organization - lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
//step-7- create organization with mandi.fields & save it
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.name("button")).click();
		
//step-8- Validate for Organization
	// WILL RECEIVE A MESG ON THE TOP OF THE SCRN - INFORMATION- INSPECT THE 1st word of  THE LINK.
		String orgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if (orgHeader.contains(ORGNAME))
				{
			System.out.println("Organization Created");
				}
		else {
			System.out.println("Organization not created");
		}
		
//	step 9- Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		
//step-10 click on create contacts lookup page
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

//step-11 - create contacts with mand.fields and save it
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	// right click on the + symbol and inspect it.
		// we should not use index no- there using following-sibling
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		
	// Switch control from parent to child window(org lookup window)
		wUtil.switchToWindow(driver,"Accounts"); // this account is a partial test form the window link
		
		 // search box
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME); 
		// search now icon
		driver.findElement(By.name("search")).click();   
		driver.findElement(By.linkText(ORGNAME)).click();
	
		// Switch control back from  child to parent window(create contact window)	
		wUtil.switchToWindow(driver,"Contacts"); 
		// this contact is a partial test form the window link
	// to save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//step- 12 - validate for contacts

	    String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
	    //Inspect on the link which is printed on the top	
	    System.out.println(contactHeader);
			if(contactHeader.contains(LASTNAME))
			{
				System.out.println("Contact Created -- PASS");
			}
			else
			{
				System.out.println("Contact not created --- FAIL");
			}
			
//step-13 -Logout
			
			WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 wUtil.waitForElementTOBeVisible(driver, element);
			 wUtil.mouseHover(driver, element);
			 driver.findElement(By.linkText("Sign Out")).click();
			 System.out.println("Saved the Contact and Logged out successfully");
			 driver.close();
			
		}
	}
