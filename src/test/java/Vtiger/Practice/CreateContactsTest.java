package Vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactsTest {
	public static void main(String[] args) throws Exception {
//step 1 launch the browser		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		Thread.sleep(3000);
//step 2- login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);	
//step 3 navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
//step 4 - click on contact to create contact
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//step 5 - create contact with madi.fields
		driver.findElement(By.name("lastname")).sendKeys("Iyer");
		
		driver.findElement(By.id("department")).sendKeys("Operations");
		
		//to select the industry...		
	//	driver.findElement(By.xpath("//img[@alt='Select']")).click();
		//driver.navigate().to("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
	//	driver.findElement(By.id("search_txt")).sendKeys("HPE");
	//	driver.findElement(By.name("search_text")).click();
	//	driver.findElement(By.id("1")).click();
		//driver.navigate().to("http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
	 	//use Switchto ??
		
// step 6 - save the contact
		driver.findElement(By.name("button")).click();
		
//step 7 - logout from the app.
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Saved Contact and Logged out successfully");
		Thread.sleep(3000);
		driver.close();
	 }
}
