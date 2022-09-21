package Vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/*
 * This class contains all the generic methods related to java
 * This method will generate a ramdom no after every execution
 * @ author -Padmasini.C
 * return ran
 */

public class JavaUtility {

	public int getRandomNumber()
	{
		Random r=new Random();
		int ran=r.nextInt(1000);
		return ran;
	}
	
/* This method will return the current system date
 * @ return
  * 
 */
	public String getSystemDate()
	{
		Date d=new Date();
		String Date=d.toString(); //converting the date into string format and storing it
		return Date;
	}
	
	/* This method will provide the date and time in a specific format
	 * @return
	 */
	 public String getSystemDateInFormat()
	 {
		 Date d=new Date();
		 String[] dArr=d.toString().split(" ");
		 String date=dArr[2];
		 String month=dArr[1];
		 String year=dArr[5];
		 String time=dArr[3].replace(":","-");
		 String CurrentDate=date+" "+month+" "+year+" "+time;
		 return CurrentDate;
	 }
}
