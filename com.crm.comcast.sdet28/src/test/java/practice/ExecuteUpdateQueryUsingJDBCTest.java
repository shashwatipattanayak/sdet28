package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateQueryUsingJDBCTest {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		try {
			Driver driver = new Driver();
			DriverManager.deregisterDriver(driver);
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
			
			Statement statement = connection.createStatement();
			
			String query = "insert into student values(107, 'Tom', 'VB');";
			
			 int result = statement.executeUpdate(query);
			 if (result == 1) {
				 System.out.println("Database has been updated");
			 }
			 else
			 {
				 System.out.println("Database has not been updated");
			 }
			
		} catch (Exception e) {
		}
		
		finally {
			connection.close();
			
		}
		
	}
	

}
