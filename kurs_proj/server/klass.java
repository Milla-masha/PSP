package by.bsuir.kyrsProjekt.server;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class klass {
	 private static java.sql.Connection con;
 	private static ArrayList<String> listArrayKlass;
		
	public static ArrayList<String> klassGet(String thisID) throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;      
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	        Statement stmt = null;
	  
	        stmt = (Statement) con.createStatement();
	        int thisIDLAST=tip.tipGetId(thisID);
	        rs = stmt.executeQuery("SELECT name_klass FROM klass WHERE id_last = '"+ thisIDLAST+"'ORDER BY id_klass ");     
	        listArrayKlass = new ArrayList<String>();
	        while (rs.next()) {
	        	{
	        		listArrayKlass.add(rs.getString(1));
	        		System.out.println(rs.getString(1));
	        	}
	        }
	        stmt.close();
	        rs.close();
	        con.close();
			return listArrayKlass;
			
		}
	
	

	public static void klassSet(String thistip, String temp) throws Exception {
		  JDBC.JDBCconnect();     
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	      PreparedStatement s = null;
	      s = con.prepareStatement("INSERT INTO klass (id_last,name_klass,id_next)  VALUES (?,?,?)");
	      s.setInt(1, tip.tipGetId(thistip));
          s.setString(2, temp);
        s.setInt(3,klassGetNextId());
        s.execute();
	      s.close();
	      con.close();

	}
	
	
	
	public static int klassGetNextId() throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;   
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	        Statement stmt = null;
	        stmt = (Statement) con.createStatement();
	        rs = stmt.executeQuery("SELECT id_next FROM klass ORDER BY id_klass");
	        int ID=0;
	        while (rs.next()) 
	        {
	        	ID=rs.getInt(1);
	        }
			stmt.close();
	        rs.close();
	        con.close();
	        return ID+1;
	}	
	
	public static void klassDelete(String delKlass) throws Exception {
		 JDBC.JDBCconnect();    
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	      PreparedStatement stmt = null;
	      stmt = con.prepareStatement(
                "DELETE FROM klass WHERE name_klass=?");
        stmt.setString(1, delKlass);
        stmt.execute();
        stmt.close();
	        con.close();
}
	
	public static int klassGetId(String thisklass) throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;   
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	       Statement stmt = null;
	       stmt = (Statement) con.createStatement();
	       rs = stmt.executeQuery("SELECT id_klass FROM klass WHERE name_klass='"+ thisklass+"'");
	        int ID=0;   
	        while (rs.next()) {
	        	ID=rs.getInt(1);
	        }
			stmt.close();
	        rs.close();
	        con.close();
	return ID;
	}	
	
	
	
}
