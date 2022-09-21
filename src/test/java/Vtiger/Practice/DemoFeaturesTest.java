package Vtiger.Practice;

//import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoFeaturesTest {
	
	@Test (invocationCount=2, priority=-1)
	public void DemoTest1()
	{
		System.out.println("Demo Test-1");
		//Assert.fail();
	}
	
	@Test (enabled=false)
	public void DemoTest2()
	{
		System.out.println("Demo Test-2");
	}

	@Test 
	public void CreateTest()
	{
		System.out.println("Creation happens first");
		//Assert.fail();
	}
	
	@Test  (dependsOnMethods="CreateTest")
	public void ModifyTest()
	{
		System.out.println("Modification happens after creation");
	}
}
