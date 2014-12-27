package by.bsuir.kyrsProjekt.server;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class otriad { private static java.sql.Connection con;
	private static ArrayList<String> listArrayOtriad;
	
public static ArrayList<String> otriadGet(String thisID) throws Exception {
      JDBC.JDBCconnect();
      ResultSet rs = null;      
      int thisIDLAST=klass.klassGetId(thisID);
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery("SELECT name_otriad FROM otriad WHERE id_last = '"+ thisIDLAST+"'ORDER BY id_otriad ");     
        listArrayOtriad = new ArrayList<String>();
        while (rs.next()) {
        	{
        		listArrayOtriad.add(rs.getString(1));
        		System.out.println(rs.getString(1));
        	}
        }
        stmt.close();
        rs.close();
        con.close();
		return listArrayOtriad;
		
	}



public static void otriadSet(String thisklass, String temp) throws Exception {
	  JDBC.JDBCconnect();     
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
      PreparedStatement s = null;
      s = con.prepareStatement("INSERT INTO otriad (id_last,name_otriad,id_next)  VALUES (?,?,?)");
      s.setInt(1, klass.klassGetId(thisklass));
      s.setString(2, temp);
    s.setInt(3,otriadGetNextId());
    s.execute();
      s.close();
      con.close();

}



public static int otriadGetNextId() throws Exception {
      JDBC.JDBCconnect();
      ResultSet rs = null;   
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery("SELECT id_next FROM otriad ORDER BY id_otriad");
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

public static void otriadDelete(String delOtriad) throws Exception {
	 JDBC.JDBCconnect();    
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
      PreparedStatement stmt = null;
      stmt = con.prepareStatement(
            "DELETE FROM otriad WHERE name_otriad=?");
    stmt.setString(1, delOtriad);
    stmt.execute();
    stmt.close();
        con.close();
}


public static int otriadGetId(String thisotriad) throws Exception {
    JDBC.JDBCconnect();
    ResultSet rs = null;   
    String url = "jdbc:mysql://localhost:3306/klassifikation";
    con = DriverManager.getConnection(url, "root", "1");
     Statement stmt = null;
     stmt = (Statement) con.createStatement();
     rs = stmt.executeQuery("SELECT id_otriad FROM otriad WHERE name_otriad='"+ thisotriad+"'");
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