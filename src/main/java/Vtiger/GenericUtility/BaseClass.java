package Vtiger.GenericUtility;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//public DatabaseUtility  dbUtil = new DatabaseUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public ProertyFileUtility pUtil = new ProertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;

	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		//dbUtil.connectDB();
		Reporter.log(" ---- DB Connection Successfull ---- ",true);
	}
	
	@BeforeClass
	public void bcConfig() throws Throwable
	{
		String BROWSER = pUtil.readDatafromPFile("browser");
	    String URL = pUtil.readDatafromPFile("url");
	    
	    if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log(BROWSER + "--- Browser Launched ---- ");
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log(BROWSER + "--- Browser Launched ---- ");
		}
		else
		{
			System.out.println("--- Invalid Browser Name --- ");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForDOMLoad(driver);
		driver.get(URL);
	    }
		
		@BeforeMethod
		public void bmConfig() throws Throwable
		{
		
			String USERNAME = pUtil.readDatafromPFile("username");
			String PASSWORD = pUtil.readDatafromPFile("password");
			
			LoginPage lp = new LoginPage(driver);
			lp.LoginToApp(USERNAME, PASSWORD);
			Reporter.log(" --- Logged In Sucessfully --- ",true);
		
		}
		
		@AfterMethod
		public void amConfig()
		{
			HomePage hp = new HomePage(driver);
			hp.SignoutApp(driver);
			Reporter.log(" --- Logged Out Succesfully --- ",true);
		}
		
		@AfterClass
		public void acConfig()
		{
			driver.close();
			Reporter.log(" --- Browser closed Sucessfully --- ",true);
		}
		
		@AfterSuite
		public void asConfig() throws SQLException
		{
		//	dbUtil.closeDB();
			Reporter.log(" --- Database Connection Closed Succesfully",true);
		}
}
