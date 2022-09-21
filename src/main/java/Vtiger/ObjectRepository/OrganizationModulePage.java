package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationModulePage {
	
	//Rule -1 - Create a Java class page wise 
	/* this class is the object repository for Organization Module page of Vtiger
	 * @author Padmasini.C
	 */
		
	//Rule -2 Identify the web elements in the Organization page using @findby
	//Step-1 - DECLARATION

	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationlookupImg;
	
//INTILAIZATION
	public OrganizationModulePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

		
// UTILAIZATION
	
	public WebElement getCreateOrganizationlookupImg() {
		return CreateOrganizationlookupImg;
	}
	
//business logic lib
	/* this will click on the org lookup icon on org page
	 * 
	 */
	
	public void clickOncreateOrflookupImg()
	{
		CreateOrganizationlookupImg.click();
	}
	
	
}
