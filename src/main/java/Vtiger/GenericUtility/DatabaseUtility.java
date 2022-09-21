package Vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all the Generic methods related to Database
 * @author Padmasini
 *
 */
public class DatabaseUtility {
	
	Driver driverRef;
	Connection con = null;
	
	/**
	 * This method will establish the connection with My Database
	 * @throws SQLException
	 */
	public void connectDB() throws SQLException
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IconstantsUtility.DBUrl,IconstantsUtility.DBUsername,IconstantsUtility.DBPassword);
	}
	
	/**
	 * This method will helps to close the Database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method will execute the query and verify the expected data in database and return 
	 * the data only if expdata and actual data are matching , else it will return empty string
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryVerifyDataAndReturn(String query , int columnIndex , String expData) throws SQLException
	{
		// Execute the Query
		@SuppressWarnings("unused")
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(columnIndex);
			
		    // Verify the expected data with actual data from the database
			if(actData.equals(expData))
			{
				flag = true;    // flag rising
				break;
			}
			
		}	
		// Return if Exp data and Act data is matching
		if(flag = true)
		{
			System.out.println("Data Verified");
			return expData;
		}
		else
		{
			System.out.println("Data not Verified");
			return "";
		}
		
   }
}