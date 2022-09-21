package Vtiger.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrganizationTest2 {
	@Test
	public void CreateOrg2Test() throws Exception {
		
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
	
//step3 - navigate to organization link
	driver.findElement(By.linkText("Organizations")).click();
	
// step4- click on create organization

	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
//step 4 - create organization with mand.field
	
	driver.findElement(By.name("accountname")).sendKeys("IBM");
	
// select electronics from industry dropdown // use select class to select from dropdown

	 WebElement dropdown=driver.findElement(By.name("industry"));
		Select s=new Select(dropdown);
		//s.selectByIndex(8);
	//	Thread.sleep(3000);
		s.selectByValue("Electronics");
				
		List<WebElement> alloptions=s.getOptions();
		System.out.println(alloptions.size());
		for(WebElement b:alloptions)
		{
			System.out.println(b.getText());
		}

// step 6 - save the organization
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
// step 7 - loggout from the app
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Saved Contact and Logged out successfully");
}
}
