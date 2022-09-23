package Vtiger.OrganizationTests;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Vtiger.GenericUtility.BaseClass;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.ObjectRepository.CreateNewOrgPage;
import Vtiger.ObjectRepository.HomePage;

import Vtiger.ObjectRepository.OrganizationInfoVerifyPage;
import Vtiger.ObjectRepository.OrganizationModulePage;

public class BCOrgPomTest extends BaseClass  {
	@Test (groups="SmokeSuite")
	
	public void Orgpom()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		OrganizationModulePage omp=new OrganizationModulePage(driver);
		omp.clickOncreateOrflookupImg();
		
		CreateNewOrgPage cnp=new CreateNewOrgPage(driver);
		cnp.CreateOrgName("IBM"+jUtil.getRandomNumber());
		
		OrganizationInfoVerifyPage oivp=new OrganizationInfoVerifyPage(driver);
		oivp.OrganizationHeader();
		System.out.println("Org- created");
		}
}
	
	