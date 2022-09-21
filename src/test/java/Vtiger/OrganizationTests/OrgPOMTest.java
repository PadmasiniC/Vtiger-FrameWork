package Vtiger.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.ProertyFileUtility;
import Vtiger.GenericUtility.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrgPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoVerifyPage;
import Vtiger.ObjectRepository.OrganizationModulePage;

public class OrgPOMTest  {
	
public static void main(String[] args) throws IOException {
	
JavaUtility jUtil=new JavaUtility();
ProertyFileUtility pUtil=new ProertyFileUtility();
WebDriverUtility wUtil=new WebDriverUtility();
ExcelFileUtility eUtil=new ExcelFileUtility();

WebDriver driver=new ChromeDriver();
wUtil.maximizeWindow(driver);
wUtil.waitForDOMLoad(driver);

String URL=pUtil.readDatafromPFile("url");
driver.get(URL);

// read from excel
String ed=eUtil.readDataFromExcel("Organization", 4, 2);
System.out.println(ed);

//login to app
LoginPage lp=new LoginPage(driver);
lp.LoginToApp("admin","admin");

//homepage
HomePage hp=new HomePage(driver);
hp.clickOnOrganizationLink();

// click on orgimage
OrganizationModulePage omP=new OrganizationModulePage(driver);
omP.clickOncreateOrflookupImg();

// create org with fields

CreateNewOrgPage cnp=new CreateNewOrgPage(driver);
cnp.CreateOrgName(ed+jUtil.getRandomNumber());

// Verification
OrganizationInfoVerifyPage oIp=new OrganizationInfoVerifyPage(driver);
String head=oIp.OrganizationHeader();
System.out.println(head);

String hdo=oIp.OrganizationNameField();
System.out.println(hdo);

if(oIp.OrganizationHeader().contains(oIp.OrganizationNameField()))
{
	System.out.println("pass");
}
else
{
	System.out.println("fail");
}
//logout
hp.SignoutApp(driver);
}
}
