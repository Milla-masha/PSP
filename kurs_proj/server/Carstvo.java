package by.bsuir.kyrsProjekt.server;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class Carstvo {
	 private static java.sql.Connection con;
	private static ArrayList<String> listArrayCarstvo;
	
	public static ArrayList<String> CarstvoGet() throws Exception {

      JDBC.JDBCconnect();
      ResultSet rs = null;      
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
  
        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery("SELECT name_carstvo FROM carstvo");

        listArrayCarstvo = new ArrayList<String>();
        
        while (rs.next()) {
        	listArrayCarstvo.add(rs.getString(1));
        }
        stmt.close();
        rs.close();
        con.close();
		return listArrayCarstvo;
		
	}
	
	public static void CarstvoSet(String temp) throws Exception {
		  JDBC.JDBCconnect();     
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	      PreparedStatement s = null;
	      s = con.prepareStatement("INSERT INTO carstvo (name_carstvo)  VALUES (?)");
          s.setString(1, temp);
          s.execute();
	      s.close();
	      con.close();

	}
	
	public static int CarstvoGetId(int thisID) throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;   
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	        Statement stmt = null;
	  
	        stmt = (Statement) con.createStatement();
	        rs = stmt.executeQuery("SELECT id_carstvo FROM carstvo");
	        int[] arrayID= new int[150];
	        int i=0;
	        while (rs.next()) {
	        	arrayID[i]=rs.getInt(1);
	        	i++;
	        }
	        
			int ID=arrayID[thisID];	
			stmt.close();
	        rs.close();
	        con.close();
	return ID;
	}	
	
	public static void CarstvoDelete(int numb) throws Exception {
		 JDBC.JDBCconnect();    
		 numb=CarstvoGetId(numb);
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	      PreparedStatement stmt = null;
	      stmt = con.prepareStatement(
                  "DELETE FROM carstvo WHERE id_carstvo=?");
          stmt.setInt(1, numb);
          stmt.execute();
          stmt.close();
	        con.close();
}
}
