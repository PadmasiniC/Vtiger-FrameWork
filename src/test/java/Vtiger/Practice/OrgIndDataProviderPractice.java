package Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrgIndDataProviderPractice {
	
	@Test(dataProvider="Organizations") // read the data of data provider form test script thru name
	public void addIndustryToOrgTest(String orgname, String industry)
	{
		System.out.println(orgname+"-->"+industry);
	}
	
	@DataProvider (name="Organizations")  // create data provider and load the values
	public Object[][] getData()  // method to get the data
	{
	Object[][] data=new Object[5][2];
		
		data[0][0]="HPE";
		data[0][1]="Service";
		
		data[1][0]="Accenture";
		data[1][1]="Development";
		
		data[2][0]="MorganStanley";
		data[2][1]="Banking";
		
		data[3][0]="Qspiders";
		data[3][1]="Training";
		
		data[4][0]="Wipro";
		data[4][1]="Consulting";
		return data;
			}

}
