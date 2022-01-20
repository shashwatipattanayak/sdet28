package com.crm.comcast.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * Utility for database
 * @author Shashwati Pattanayak
 *
 */
public class DatabaseUtility {
	Connection connection = null;
	/**
	 * This method will do the connection to the database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(IPathConstants.DATABASE_URL, IPathConstants.DATABASE_ID, IPathConstants.DATABASE_PASSWORD);
	}
	/**
	 * This method will close the database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		connection.close();
	}
	/**
	 * This method will fetch the data from the database
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet getAllData(String query) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(query);
		return result;
	}
	/**
	 * This method will update the data in the database and it will verify
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public boolean updateData(String query) throws Throwable {
		boolean flag = false;
		int result = connection.createStatement().executeUpdate(query);
		if(result == 1) {
			System.out.println("Data is updated in database");
			flag = true;
		}else {
			System.out.println("Data is not updated in database");
		}
		return flag;
	}
	/**
	 * This method will verify the given data is present in the database or not
	 * @param query
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String getTheData(String query, int columnNumber, String expectedData) throws Throwable {
		boolean flag = false;
		String actualData = null;
		ResultSet result = connection.createStatement().executeQuery(query);
		while(result.next()) {
			String data = result.getString(columnNumber);
			if(data.equals(expectedData)) {
				actualData = data;
				flag = true;
				break;
			}
		}
		if(flag == true) {
			System.out.println("Data is present in the database");
			return actualData;
		}else {
			System.out.println("Data is not present in the database");
			return actualData;
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
