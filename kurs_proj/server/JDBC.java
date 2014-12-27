package by.bsuir.kyrsProjekt.server;

import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
	 private static java.sql.Connection con;


		public static void JDBCconnect() throws Exception {
		 
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/klassifikation";
	             con = DriverManager.getConnection(url, "root", "1");
	        } catch (ClassNotFoundException e) {
	            throw new Exception(e);
	        } catch (SQLException e) {
	            throw new Exception(e);
	        }
	        con.close();

        	    }

}
