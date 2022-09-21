package Vtiger.ContactsTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.BaseClass;
import Vtiger.ObjectRepository.ContactInfoPage;
import Vtiger.ObjectRepository.ContactPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrgPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoVerifyPage;
import Vtiger.ObjectRepository.OrganizationModulePage;

public class CreatecnwithOrgTest extends BaseClass {
	
	
	@Test
	public void createcontactwithorg() throws InterruptedException
	{
//Navigate to Organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
//click on create organization look up image
		OrganizationModulePage omp=new OrganizationModulePage(driver);
		omp.clickOncreateOrflookupImg();
		
	//Create organization with mandatory fields and save
		CreateNewOrgPage cop=new CreateNewOrgPage(driver);
		cop.CreateOrgName("HPE"+jUtil.getRandomNumber());
		
	//Validate for Organization
		OrganizationInfoVerifyPage ovp=new OrganizationInfoVerifyPage(driver);
	/*	if (ovp.OrganizationHeader().contains(ovp.OrganizationNameField()))
		{
			Reporter.log("Org-created - pass", true);
		}
		else
		{
			Reporter.log("Org-not created - fail", true);
		} */
		String orgheader=ovp.OrganizationHeader();
		System.out.println(orgheader);  //true
		String orgname=ovp.OrganizationNameField();
		Assert.assertEquals(orgheader.contains(orgname), true); 
		Reporter.log("Org-created - test pass", true);
	
	//Navigate to contacts link
		hp.clickOnContactsLink();
		
	//Click on create contact look up image
		ContactPage cp=new ContactPage(driver);
		cp.ClickOnCreateContactImg();		
		
	//Create contact with Organization and save
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		//cnc.CreateNewContact("Chandru1", "Employee");
		cnc.CreateNewContact("Harshu"+jUtil.getRandomNumber(), orgname, driver);
			
	// Validating contact
		ContactInfoPage cip=new ContactInfoPage(driver);
		String head=cip.contactheader();
		System.out.println(head);
		String ln=cip.lastname();
		System.out.println(ln);
		Assert.assertEquals(head.contains(ln), true);
		Reporter.log("Contact created-pass", true);
	
}
}
