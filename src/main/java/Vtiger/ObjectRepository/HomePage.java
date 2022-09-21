package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

//Rule -1 - Create a Java class page wise 
/* this class is the object repository for login page of Vtiger
* @author Padmasini.C
*/
public class HomePage extends WebDriverUtility {
//Rule -2 Identify the web elements in the login page using @findby
//Step-1 - DECLARATION
	
		
	@FindBy(linkText ="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpputunitiesLink;
	
	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")
	private WebElement AdministratorLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignoutLink;
	
// INTIALIZATION
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// UTILAIZATION

	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getOpputunitiesLink() {
		return OpputunitiesLink;
	}

	public WebElement getAdministratorLink() {
		return AdministratorLink;
	}

	public WebElement getSignoutLink() {
		return SignoutLink;
	}
	
// BUSINESS LOGIC LIBRARY
	/* This will click on organization link
	 * 
	 */
	public void clickOnOrganizationLink()
	{
		OrganizationLink.click();
	}
	
// this will click on Contacts link
	public void clickOnContactsLink()
	{
		ContactLink.click();
	}
// this will click on opportunities link
	
	public void clickOnOppurtunitiesLink()
	{
		OpputunitiesLink.click();
	}
	
// this will click on product link
	
	public void clickOnProductsLink()
	{
		ProductLink.click();
	}
/* This is to signout from the app
 * @param driver
 */
public void SignoutApp(WebDriver driver)
{
	mouseHover(driver,AdministratorLink);
	SignoutLink.click();
}

}
