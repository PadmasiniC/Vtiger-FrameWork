package Vtiger.OrganizationTests;

//Scenario-3

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationTests {
	public static void main(String[] args) throws IOException {
		WebDriver Driver;

// Step 1- Read all the necessary data
		
// Read from the properties file -> common data
	
	FileInputStream fisp=new FileInputStream(".\\src\\main\\resources\\CommonData.Properties");
	Properties pObj=new Properties();
	pObj.load(fisp);
	String BROWSER= pObj.getProperty("browser");
	String URL= pObj.getProperty("url");
	String USERNAME= pObj.getProperty("username");
	String PSWD= pObj.getProperty("password");

// Read the Data from the Excel Sheet  -> TestData

	FileInputStream fise=new FileInputStream(".\\src\\main\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fise);
    Sheet sh=wb.getSheet("Organization");
    Row rw =sh.getRow(1);
    Cell cel=rw.getCell(2);
    String ON =cel.getStringCellValue();
	
// Step 2 Launch the browser
     Driver=new ChromeDriver();
   	
	if (BROWSER.equalsIgnoreCase("chrome"))
	{
		Driver = new ChromeDriver();
		System.out.println("Chrome Browser is Launched");	
	}
	else if (BROWSER.equalsIgnoreCase("firefox"))
	{
		Driver = new FirefoxDriver();
		System.out.println("Firefox Browser is Launched");	
	}
	else {
		System.out.println("Invalid Browser name, Default Browser is launched");
		Driver=new ChromeDriver();
	}
	Driver.manage().window().maximize();
    Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Driver.get(URL);
    
//step-3 - Login to app
	Driver.findElement(By.name("user_name")).sendKeys(USERNAME);
   	Driver.findElement(By.name("user_password")).sendKeys(PSWD);
   	Driver.findElement(By.id("submitButton")).click();
   	
// step-4 Navigate to Organization Module
	Driver.findElement(By.linkText("Organizations")).click();
	
//step5- click on create organization

		Driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
//step-6-create orgaization with mand. fields
		
		Driver.findElement(By.name("accountname")).sendKeys("Capgemini35");
		// select electronics from industry dropdown // use select class to select from dropdown

		 WebElement dropdown=Driver.findElement(By.name("industry"));
			Select s=new Select(dropdown);
		
			s.selectByValue("Technology");
					
			List<WebElement> alloptions=s.getOptions();
			System.out.println(alloptions.size());
			for(WebElement b:alloptions)
			{
				System.out.println(b.getText());
			}
// step 7- save it
		Driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
//step-8 - logout from the app
		Driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Saved Contact and Logged out successfully");
		
	}

}
