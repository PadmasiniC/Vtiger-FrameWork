package Vtiger.Practice;

import java.io.IOException;

import Vtiger.GenericUtility.ExcelFileUtility;
import Vtiger.GenericUtility.JavaUtility;
import Vtiger.GenericUtility.ProertyFileUtility;

public class GenericUtilityPractice {
	public static void main(String[] args) throws IOException
	{
		
		JavaUtility jLib=new JavaUtility();
		int random = jLib.getRandomNumber();
		System.out.println(random);
		
		String date=jLib.getSystemDate();
		System.out.println(date);
		
		String d=jLib.getSystemDateInFormat();
		System.out.println(d);
		
		ProertyFileUtility pLib=new ProertyFileUtility();
		String browser=pLib.readDatafromPFile("browser");
		System.out.println(browser);
		
		ExcelFileUtility aLib=new ExcelFileUtility();
		String orgname=aLib.readDataFromExcel("Organization",4,2);
		System.out.println(orgname);
		
		aLib.WriteDataIntoExcel("Organization",4,5,"Padmasini.C.Iyer");
		System.out.println("Data written into the excelsheet");
	}
}
