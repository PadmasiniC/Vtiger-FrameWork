package Vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeSuite 
	public void bsConfig()
	{
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("BEfore class");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("After class");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("After Method");
	}
	@Test
	public void baseTest()
	{
		System.out.println("Test-1 sequence of execution of @Annotation- base class");
	}

}
