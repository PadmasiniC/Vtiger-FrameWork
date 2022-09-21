package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

//Rule -1 - Create a Java class page wise 
	/* this class is the object repository for Organization Module page of Vtiger
	 * @author Padmasini.C
	 */
public class CreateNewOrgPage extends WebDriverUtility {
	
	
			
	//Rule -2 Identify the web elements in the Organization page using @findby
// DECLARATION

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrgNameEdt;
	
	@FindBy (name="industry")
	private WebElement IndustryLinkDd;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")    
	private WebElement SaveBtn;

//initialization
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
// Utilization
	public String CreateNewOrg(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		return OrgName;
		
	}
	
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryLinkDd() {
		return IndustryLinkDd;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	

//	public void ClickonDropDown(WebDriver driver)
	//{
		//handleDropDown(driver,IndustryLinkDd);
	//}
/* this method is used to enter the orgname
 * @para, Orgname	
 */


	/* this method will click on the industry dropdown
	 * 
	 */
	public void CreateOrgName(String ON)
	{
		OrgNameEdt.sendKeys(ON);
		SaveBtn.click();
	}
	
		
}
