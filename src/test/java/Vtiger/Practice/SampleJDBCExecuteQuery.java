package Vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	public static void main(String[] args) throws SQLException {
		Driver driveref =new Driver();
		
// step -1 - Register the driver/database
		DriverManager.registerDriver(driveref);
		
// step -2 - Get the connection with database - provide database name
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3305/clientdb", "root", "root");
		
// step-3 issue the create statement
		
		Statement state=con.createStatement();
		
// step-4 -execute a query - provide table name
		ResultSet result =state.executeQuery(" Select * from clientinfo;");
		
		while (result.next())
{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
}
// step 5 - close the database
		con.close();
	}

}
