package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule -1 - Create a Java class page wise 
/* this class is the object repository for login page of Vtiger
 * @author Padmasini.C
 */
public class LoginPage {
	
//Rule -2 Identify the web elements in the login page using @findby
//Step-1 - DECLARATION
	
	@FindBy (name="user_name")
private WebElement UserNameEdt;
	
	@FindBy (name="user_password")
	private WebElement PasswordEdt;
	
	@FindBy (id="submitButton")
	private WebElement SubmitBtn;
	
// Step -2 INTIALIZATION
	// Initializing the elements with a constructor
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
// Step-3 - UTILIZATION - Encapsulation
	
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

//Business Library
/* This Generic Lib method will login to the application
* @ para username, password
*/
	public void LoginToApp(String username, String password)
	{
		UserNameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}
}