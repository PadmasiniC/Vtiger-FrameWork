package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement ContactHeaderTxt;
		
		@FindBy (name="lastname")
		private WebElement Lastnamebtn;
	//Initialization 
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

	//Utilization
		public WebElement getContactHeaderTxt() {
			return ContactHeaderTxt;
		}
		public WebElement getLastnamebtn() {
			return Lastnamebtn;
		}
		
	//Business Library
	
		public String contactheader()
		{
			String head= ContactHeaderTxt.getText();
			return head;
			
		}
		
		public String lastname()
		{
			String ln=  Lastnamebtn.getText();
			return ln;
		}
		
	}
