package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDatafromPropertyFile {
	public static void main(String[] args) throws IOException {
		
// step 1 - load the file location into file inputStream
	
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\CommonData.Properties");

//step-2 - create object of properties
		Properties pObj = new Properties();
		
// step-3 - Load the data into property file
		pObj.load(fis);
	
// step 4- Use the key & read the value 
		String BROWSER =pObj.getProperty("browser");
		System.out.println(BROWSER);

		String URL= pObj.getProperty("url");
		System.out.println(URL);
	}
}
