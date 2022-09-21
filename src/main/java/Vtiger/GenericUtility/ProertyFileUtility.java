package Vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProertyFileUtility {
	
	/*
	 * this class contains all the generic methods related to property file
	 * @ author Padmasini.C
	  */
	/* 
	 * This method will read the key form the property file and return the value
	 * @ param key
	 * @return value
	 * throws IOException
	 */
	public String readDatafromPFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IconstantsUtility.PropertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
	}

}
