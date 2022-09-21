package Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPrividerPractice
{
	@Test(dataProvider="phoneData")  //read the data of dataprovider from test script
	
		public void addPhonesToCartTest(String name, int price)
		{
			System.out.println(name+"-->"+price);
		}
@DataProvider (name="phoneData")
public Object[][] getData()
{
Object[][] data=new Object[3][2];

data[0][0]="Samsung C7Pro";
data[0][1]=15000;

data[1][0]="Iphone-11";
data[1][1]=50000;

data[2][0]="Vivo-v25";
data[2][1]=10000;
return data;
	}
}


