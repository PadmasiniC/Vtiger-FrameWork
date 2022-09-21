package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// e2e Scenario - Create Contact with Organization
public class ContactPage {

	//Declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement CreateContactlookupImg;
		
	//Initialization	
		
		public ContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
//Utilization

		public WebElement getCreateContactlookupImg() {
			return CreateContactlookupImg;
		}
		
//Business Library
		public void ClickOnCreateContactImg()
		{
			CreateContactlookupImg.click();
		}
	}

