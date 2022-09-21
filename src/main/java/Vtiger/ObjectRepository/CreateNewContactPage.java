package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
//Declaration
	@FindBy (name="lastname")
	private WebElement LastnameEdt;
	
	@FindBy (name="leadsource")
	private WebElement LeadsourceDropDown;
	
// Identifying the image above leadsource (+)
	@FindBy(xpath="//img[@title='Select']")
	private WebElement OrganizationImg;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement SearchnowBtn; 
	
	@FindBy(xpath="//a[@class='listFormHeaderLinks']")
	private WebElement onameselect;
	
	@FindBy(xpath="//a[text()='+ORGNAME+']")
	private WebElement Orgnameselect;
	
	@FindBy(xpath="//input[@name='account_name']")
	private WebElement orgn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

// Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Utilization
	public WebElement getLastnameEdt() {
		return LastnameEdt;
	}

	public WebElement getOrgn() {
		return orgn;
	}
	public WebElement getLeadsourceDropDown() {
		return LeadsourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchnowBtn() {
		return SearchnowBtn;
	}
	
	public WebElement getOnameselect() {
		return onameselect;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public WebElement getOrgnameselect() {
		return Orgnameselect;
	}
	public void setOrgnameselect(WebElement orgnameselect) {
		Orgnameselect = orgnameselect;
	}

	
	public void setOnameselect(WebElement onameselect) {
		this.onameselect = onameselect;
	}
	public void setSaveBtn(WebElement saveBtn) {
		SaveBtn = saveBtn;
	}

// business libs
	
	public WebElement lastname()
	{
		return LastnameEdt;
	}
	
	public void CreateNewCOntact(String lastname)
	{
		LastnameEdt.sendKeys(lastname);
		SaveBtn.click();
	}
		
	public void CreateNewContact(String lastname, String leadsource)
	{
		LastnameEdt.sendKeys(lastname);
		handleDropDown(leadsource,LeadsourceDropDown);
		SaveBtn.click();
		}
	public void CreateNewContact(String lastname, String orgname, WebDriver driver)
	{
		LastnameEdt.sendKeys(lastname);
		OrganizationImg.click();

		//switch window from  parent to child
		
		switchToWindow(driver, "=Accounts&");
		SearchEdt.sendKeys(orgname);
		SearchnowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();

//switch window from child to parent		
		switchToWindow(driver, "=Contacts&");
		SaveBtn.click();
	}

}

