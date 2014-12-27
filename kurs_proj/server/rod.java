package by.bsuir.kyrsProjekt.server;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class rod {
	private static java.sql.Connection con;
	private static ArrayList<String> listArrayRod;
	
public static ArrayList<String> rodGet(String thisID) throws Exception {
      JDBC.JDBCconnect();
      ResultSet rs = null;      
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
        int thisIDLAST=otriad.otriadGetId(thisID);
        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery("SELECT name_rod FROM rod WHERE id_last = '"+ thisIDLAST+"'ORDER BY id_rod ");     
        listArrayRod = new ArrayList<String>();
        while (rs.next()) {
        	{
        		listArrayRod.add(rs.getString(1));
        		System.out.println(rs.getString(1));
        	}
        }
        stmt.close();
        rs.close();
        con.close();
		return listArrayRod;
		
	}



public static void rodSet(String thisotriad, String temp) throws Exception {
	  JDBC.JDBCconnect();     
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
      PreparedStatement s = null;
      s = con.prepareStatement("INSERT INTO rod (id_last,name_rod,id_next)  VALUES (?,?,?)");
      s.setInt(1, otriad.otriadGetId(thisotriad));
      s.setString(2, temp);
    s.setInt(3,rodGetNextId());
    s.execute();
      s.close();
      con.close();

}



public static int rodGetNextId() throws Exception {
      JDBC.JDBCconnect();
      ResultSet rs = null;   
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery("SELECT id_next FROM rod ORDER BY id_rod");
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

public static void rodDelete(String delrod) throws Exception {
	 JDBC.JDBCconnect();    
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
      PreparedStatement stmt = null;
      stmt = con.prepareStatement(
            "DELETE FROM rod WHERE name_rod=?");
    stmt.setString(1, delrod);
    stmt.execute();
    stmt.close();
        con.close();
}


public static int rodGetId(String thisrod) throws Exception {
    JDBC.JDBCconnect();
    ResultSet rs = null;   
    String url = "jdbc:mysql://localhost:3306/klassifikation";
    con = DriverManager.getConnection(url, "root", "1");
     Statement stmt = null;
     stmt = (Statement) con.createStatement();
     rs = stmt.executeQuery("SELECT id_rod FROM rod WHERE name_rod='"+ thisrod+"'");
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