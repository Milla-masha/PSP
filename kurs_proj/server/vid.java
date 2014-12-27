package by.bsuir.kyrsProjekt.server;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class vid {
	private static java.sql.Connection con;
	private static ArrayList<String> listArrayVid;
	
public static ArrayList<String> vidGet(String temp) throws Exception {
      JDBC.JDBCconnect();
      ResultSet rs = null;      
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
        stmt = (Statement) con.createStatement();
        int thisIDLAST=rod.rodGetId(temp);
        rs = stmt.executeQuery("SELECT name_vid FROM vid WHERE id_last = '"+ thisIDLAST+"'ORDER BY id_vid ");     
        listArrayVid = new ArrayList<String>();
        while (rs.next()) {
        	{
        		listArrayVid.add(rs.getString(1));
        		System.out.println(rs.getString(1));
        	}
        }
        stmt.close();
        rs.close();
        con.close();
		return listArrayVid;
		
	}

public static ArrayList<String> vidGetVibor(String temp) throws Exception {
    JDBC.JDBCconnect();
    ResultSet rs = null;      
    String url = "jdbc:mysql://localhost:3306/klassifikation";
    con = DriverManager.getConnection(url, "root", "1");
      Statement stmt = null;
      stmt = (Statement) con.createStatement();
      listArrayVid = new ArrayList<String>();  
      
      int[] thisID=status.statusGetIdVidor(temp);
      int i=0,ID;
for(i=0;i<100;i++){
	ID=thisID[i];
      rs = stmt.executeQuery("SELECT name_vid FROM vid WHERE id_vid = '"+ ID+"'ORDER BY id_vid ");     

      while (rs.next()) {
      	
      		listArrayVid.add(rs.getString(1));
      	
      }
}
      stmt.close();
      rs.close();
      con.close();
		return listArrayVid;
		
	}


public static ArrayList<String> vidGetAll() throws Exception {
    JDBC.JDBCconnect();
    ResultSet rs = null;      
    String url = "jdbc:mysql://localhost:3306/klassifikation";
    con = DriverManager.getConnection(url, "root", "1");
      Statement stmt = null;
      stmt = (Statement) con.createStatement();
      rs = stmt.executeQuery("SELECT name_vid FROM vid ORDER BY id_vid ");     
      listArrayVid = new ArrayList<String>();
      while (rs.next()) {
      	{
      		listArrayVid.add(rs.getString(1));
      		System.out.println(rs.getString(1));
      	}
      }
      stmt.close();
      rs.close();
      con.close();
		return listArrayVid;
		
	}

public static void vidSet(String thisrod, String temp) throws Exception {
	  JDBC.JDBCconnect();     
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
      PreparedStatement s = null;
      s = con.prepareStatement("INSERT INTO vid (id_last,name_vid,id_next)  VALUES (?,?,?)");
      s.setInt(1, rod.rodGetId(thisrod));
      s.setString(2, temp);
    s.setInt(3,vidGetNextId());
    s.execute();
      s.close();
      con.close();

}



public static int vidGetNextId() throws Exception {
      JDBC.JDBCconnect();
      ResultSet rs = null;   
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery("SELECT id_next FROM vid ORDER BY id_vid");
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

public static void vidDelete(String delvid) throws Exception {
	 JDBC.JDBCconnect();    
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
      PreparedStatement stmt = null;
      stmt = con.prepareStatement("DELETE FROM vid WHERE name_vid=?");
    stmt.setString(1, delvid);
    stmt.execute();
    stmt.close();
        con.close();
}


public static int vidGetId(String thisvid) throws Exception {
    JDBC.JDBCconnect();
    ResultSet rs = null;   
    String url = "jdbc:mysql://localhost:3306/klassifikation";
    con = DriverManager.getConnection(url, "root", "1");
     Statement stmt = null;
     stmt = (Statement) con.createStatement();
     rs = stmt.executeQuery("SELECT id_vid FROM vid WHERE name_vid='"+ thisvid+"'");
      int ID=0;   
      while (rs.next()) {
      	ID=rs.getInt(1);
      }
		stmt.close();
      rs.close();
      con.close();
return ID;
}	

public static void vidUp (String numbvid, String newvid) throws Exception {
    JDBC.JDBCconnect(); 
    String url = "jdbc:mysql://localhost:3306/klassifikation";
    con = DriverManager.getConnection(url, "root", "1");
    PreparedStatement s = null;
    System.out.println(numbvid);
    System.out.println(newvid);
    System.out.println("kjtfk");
    s = con.prepareStatement("UPDATE vid SET name_vid='"+newvid+" WHERE id_vid="+vidGetId(numbvid)+"");
		s.close();
        con.close();
}	

}
