package by.bsuir.kyrsProjekt.server;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class tip {
	 private static java.sql.Connection con;
    	private static ArrayList<String> listArrayTip;
		
	public static ArrayList<String> tipGet(int thisIDLAST) throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;      
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	        Statement stmt = null;
	  
	        stmt = (Statement) con.createStatement();
	        rs = stmt.executeQuery("SELECT name_tip FROM tip");
	       thisIDLAST=Carstvo.CarstvoGetId(thisIDLAST);
	        listArrayTip = new ArrayList<String>();
	        int[] arrayID= new int[150];
	        arrayID=TipGetIdList();
	        int i=0;
	        while (rs.next()) {
	        	if(arrayID[i]==thisIDLAST)
	        	{listArrayTip.add(rs.getString(1));
	        	System.out.println(rs.getString(1));}
	        	i++;
	        }
	        stmt.close();
	        rs.close();
	        con.close();
			return listArrayTip;
			
		}
	
	public static int[]  TipGetIdList() throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;   
	     // System.out.println(thisID);
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	        Statement stmt = null;
	  
	        stmt = (Statement) con.createStatement();
	       rs = stmt.executeQuery("SELECT id_last FROM tip ORDER BY id_tip");
	        int[] arrayIDlast= new int[150];
	        int i=0;
	        while (rs.next()) {
	      	        	arrayIDlast[i]=rs.getInt(1);
	        	i++;
	        }
	      
			stmt.close();
	        rs.close();
	        con.close();
		
	return arrayIDlast;
	}	
	
	public static void tipSet(int thisID, String temp) throws Exception {//норм или не норм?
		  JDBC.JDBCconnect();     
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	      PreparedStatement s = null;
	      s = con.prepareStatement("INSERT INTO tip (id_last,name_tip,id_next)  VALUES (?,?,?)");
	      s.setInt(1, Carstvo.CarstvoGetId(thisID));
        s.setString(2, temp);
        s.setInt(3,TipGetNextIdList(Carstvo.CarstvoGetId(thisID) ));
        s.execute();
	      s.close();
	      con.close();
	}
	
	
	public static int TipGetNextId() throws Exception {
	int ID=0;
	 int[] arrayID= new int[150];
int stop=0;
    	while (stop==0) {
    		for(int i=0;i<149||stop==0;i++)
     	if(arrayID[i]!=ID)
     	     stop++;
     	ID++;
     }
		return ID;
	}
	
	
	public static int TipGetNextIdList(int idlast) throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;   
	     // System.out.println(thisID);
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	        Statement stmt = null;
	       
	        stmt = (Statement) con.createStatement();//WHERE id_last = '"+ idlast+"' 
	        rs = stmt.executeQuery("SELECT id_next FROM tip ORDER BY id_tip");
	        int[] arrayID= new int[150];
	        int i=0;
	        int ID=0;
	        while (rs.next()) {
	        	arrayID[i]=rs.getInt(1);
	        	ID=rs.getInt(1);
	        	 System.out.println(rs.getInt(1));
	        	i++;
	        }

			stmt.close();
	        rs.close();
	        con.close();

	        return ID+1;
	}	
	
	public static void tipDelete(String delTip) throws Exception {
		 JDBC.JDBCconnect();    
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	      PreparedStatement stmt = null;
	      stmt = con.prepareStatement(
                 "DELETE FROM tip WHERE name_tip=?");
         stmt.setString(1, delTip);
         stmt.execute();
         stmt.close();
	        con.close();
}
	
	public static int tipGetId(String thisTip) throws Exception {
	      JDBC.JDBCconnect();
	      ResultSet rs = null;   
	      String url = "jdbc:mysql://localhost:3306/klassifikation";
	      con = DriverManager.getConnection(url, "root", "1");
	       Statement stmt = null;
	       stmt = (Statement) con.createStatement();
	       rs = stmt.executeQuery("SELECT id_tip FROM tip WHERE name_tip='"+ thisTip+"'");
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
