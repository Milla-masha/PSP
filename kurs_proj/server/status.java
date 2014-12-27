package by.bsuir.kyrsProjekt.server;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class status {
	private static java.sql.Connection con;
	
	public static String statusGet(String temp) throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;      
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	        Statement stmt = null;
	        stmt = (Statement) con.createStatement();
	        int thisIDLAST=vid.vidGetId(temp);
	        rs = stmt.executeQuery("SELECT name_status FROM status WHERE id_last = '"+ thisIDLAST +"'");     
	       String status= new String();
	        while (rs.next()) {
	        	{
	        		status=rs.getString(1);
	        		System.out.println(rs.getString(1));
	        	}
	        }
	        stmt.close();
	        rs.close();
	        con.close();
			return status;
			
		}

	public static void statusSet(String thisvid, String temp) throws Exception {
		  JDBC.JDBCconnect();     
	    String url = "jdbc:mysql://localhost:3306/klassifikation";
	    con = DriverManager.getConnection(url, "root", "1");
	    PreparedStatement s = null;
	    s = con.prepareStatement("DELETE FROM status WHERE id_last=?");
	    s.setInt(1, vid.vidGetId(thisvid));
	  s.execute();
	    s = con.prepareStatement("INSERT INTO status VALUES (?,?)");
	    s.setInt(1, vid.vidGetId(thisvid));
	    s.setString(2, temp);
	  s.execute();
	    s.close();
	    con.close();

	}
	
	public static int[] statusGetIdVidor(String temp) throws Exception {
		 JDBC.JDBCconnect();
		    ResultSet rs = null;      
		    String url = "jdbc:mysql://localhost:3306/klassifikation";
		    con = DriverManager.getConnection(url, "root", "1");
		      Statement stmt = null;
		      stmt = (Statement) con.createStatement();
			    int[] arrayID= new int[150];
		        int i=0;
	    rs = stmt.executeQuery("SELECT id_last FROM status WHERE name_status = '"+ temp +"'");  
        while (rs.next()) {
        	arrayID[i]=rs.getInt(1);
        	i++;
        }
        stmt.close();
        rs.close();
        con.close();
  		return arrayID;
  		
  	}

}
	

