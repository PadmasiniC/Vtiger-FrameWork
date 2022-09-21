package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

//Rule -1 - Create a Java class page wise 
	/* this class is the object repository for Organization Information Verification page of Vtiger
	 * (after saving org- u get this info on top)
	 * @author Padmasini.C
	 */
public class OrganizationInfoVerifyPage extends WebDriverUtility {

//Declaration
	@FindBy(xpath = "//span[@id=\"dtlview_Organization Name\"]")
	private WebElement OrganizationName;
  
 @FindBy(xpath="//input[@class='crmbutton small edit']")
 private WebElement EditBtn;
 
 @FindBy(xpath="//input[@class='crmbutton small delete']")
 private WebElement DeleteBtn;
 
 @FindBy(xpath="//span[@class='dvHeaderText']")
 private WebElement Titleinfo;
 //Initialization
 
	public OrganizationInfoVerifyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getEditBtn() {
		return EditBtn;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(WebElement organizationName) {
		OrganizationName = organizationName;
	}

	public WebElement getTitleinfo() {
		return Titleinfo;
	}

	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	public WebElement getTilteinfo() {
		return Titleinfo;
	}

	// Business Logic
	
		/**
		 * This Method is used to click on the Edit Button
		 */
	public void ClickOnEditBtn()
		{
			EditBtn.click();
		}
	    
		/**
		 * This Method is used to Click on the Delete Button
		 */
		public void ClickOnDeleteBtn()
		{
			DeleteBtn.click();
		}
		
		/**
		 * This Method is used to Read the Organization Header
		 * @return 
		 * 
		 */
		public String OrganizationHeader()
		{
			String OrgHeader = Titleinfo.getText();
			System.out.println(OrgHeader);
			return OrgHeader;
		}
		
		/**
		 * This Method is used to Fetch the Text of Organization Field
		 * @return 
		 */
		public String OrganizationNameField()
		{
			 String OrgName = OrganizationName.getText();
			 System.out.println(OrgName);
			 return OrgName;
		}
	}


