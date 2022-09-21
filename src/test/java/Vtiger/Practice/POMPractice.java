package Vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Vtiger.GenericUtility.WebDriverUtility;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationModulePage;

public class POMPractice extends WebDriverUtility {
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		WebDriverUtility w=new WebDriverUtility();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);		
		driver.get("http:/localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp("admin","admin");
		
		HomePage hp=new HomePage(driver);
		hp.getProductLink().click();
		hp.clickOnContactsLink();
		hp.clickOnOppurtunitiesLink();
		w.mouseHover(driver, hp.getAdministratorLink());
		hp.getSignoutLink().click();
		
		OrganizationModulePage oMp=new OrganizationModulePage(driver);
		
	}
}
