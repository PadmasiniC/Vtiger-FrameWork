package Vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Vtiger.GenericUtility.JavaUtility;

public class CreateOrganizationTest {
	@Test
	public void CreateOrgTest() throws Exception {
		
		
		JavaUtility jUtil=new JavaUtility();
		
	//step 1 launch the browser
		
	WebDriver driver1= new ChromeDriver();
	driver1.manage().window().maximize();
	driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver1.get("http://localhost:8888");
	Thread.sleep(3000);
	
//step 2- login to app
	driver1.findElement(By.name("user_name")).sendKeys("admin");
	driver1.findElement(By.name("user_password")).sendKeys("admin");
	driver1.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	
//step3 - navigate to organization link
	driver1.findElement(By.linkText("Organizations")).click();
	
// step4- click on create organization

	driver1.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
//step5-create orgaization with mand. fields
	
	driver1.findElement(By.name("accountname")).sendKeys("Accenture"+jUtil.getRandomNumber());
	
// step 6 save it
	driver1.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			
	}
}


