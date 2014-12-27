package by.bsuir.kyrsProjekt.server;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class organizm {
	private static java.sql.Connection con;
	
public static String organizmGet(String temp) throws Exception {
      JDBC.JDBCconnect();
      ResultSet rs = null;      
      String url = "jdbc:mysql://localhost:3306/klassifikation";
      con = DriverManager.getConnection(url, "root", "1");
        Statement stmt = null;
        stmt = (Statement) con.createStatement();
        int thisIDLAST=vid.vidGetId(temp);
        rs = stmt.executeQuery("SELECT organizm FROM organizm WHERE id_last = '"+ thisIDLAST +"'");     
       String organizm= new String();
        while (rs.next()) {
        	{
        		organizm=rs.getString(1);
        		System.out.println(rs.getString(1));
        	}
        }
        stmt.close();
        rs.close();
        con.close();
		return organizm;
		
	}

public static void organizmSet(String thisvid, String temp) throws Exception {
	  JDBC.JDBCconnect();     
    String url = "jdbc:mysql://localhost:3306/klassifikation";
    con = DriverManager.getConnection(url, "root", "1");
    PreparedStatement s = null;
    s = con.prepareStatement("DELETE FROM organizm WHERE id_last=?");
    s.setInt(1, vid.vidGetId(thisvid));
  s.execute();
    s = con.prepareStatement("INSERT INTO organizm VALUES (?,?)");
    s.setInt(1, vid.vidGetId(thisvid));
    s.setString(2, temp);
  s.execute();
    s.close();
    con.close();

}

}
