package by.bsuir.kyrsProjekt.client;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Client {
	
    static Socket socket;
    static InetAddress ipAddress;
    static InputStream sin;
    static OutputStream sout;
    static DataInputStream in;
    static DataOutputStream out;
    static String line;
	private static ArrayList<String> list;

	   public static void conect() throws IOException
	   {
		    int serverPort = 6666; 
	        String address = "127.0.0.1"; 
		   ipAddress = InetAddress.getByName(address); 
           socket = new Socket(ipAddress, serverPort);
           sin = socket.getInputStream();
           sout = socket.getOutputStream();
           in = new DataInputStream(sin);
           out = new DataOutputStream(sout);
	   }
	
	   public static void disconect() throws IOException
	   {


           socket.close();
           sin.close();
           sout.close();
           in.close();
           out.close();
	   }
	   
	
	  
	   public static ArrayList<String> CarstvoGet() throws IOException
	   {
		  // conect();
		   list = new ArrayList<String>();
		   line="Carstvo.CarstvoGet();";
		   out.writeUTF(line);
		   out.flush();
		   while((line=in.readUTF()) != null)
           { 
            if(line.equals("by-by Masha"))  {break;}
           list.add(line); // ждем пока сервер отошлет строку текста.
         //  System.out.println(line);
           }
		 
		   //in.close();
		   return list;
		   
	   }
	   
	   public static  ArrayList<String> tipGet(int numb) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="tip.tipGet();";
		   out.writeUTF(line);
		   out.writeInt(numb);
		   out.flush();

		   int ifnot=0;
		   while(ifnot != 1)
           {//  System.out.println(line);
			   line=in.readUTF();
          
            if(line.equals("by-by Masha"))  {ifnot=1; break;}
           list.add(line); // ждем пока сервер отошлет строку текста.
       //    System.out.println(line);
           }
		   return list;
		   
	   }
	   
	   public static  ArrayList<String> klassGet(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="klass.klassGet();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();

		   int ifnot=0;
		   while(ifnot != 1)
           {//  System.out.println(line);
			   line=in.readUTF();
          
            if(line.equals("by-by Masha"))  {ifnot=1; break;}
           list.add(line); // ждем пока сервер отошлет строку текста.
          // System.out.println(line);
           }
		   return list;
		   
	   }
	   
	   
	   public static  ArrayList<String> vidGetVibor(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="vid.vidGetVibor();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();

		   int ifnot=0;
		   while(ifnot != 1)
           {
			   line=in.readUTF();
            if(line.equals("by-by Masha"))  {ifnot=1; break;}
           list.add(line); 
           }
		   return list;
		   
	   }
	   
	   
	   public static  ArrayList<String> otriadGet(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="otriad.otriadGet();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();

		   int ifnot=0;
		   while(ifnot != 1)
           {  //System.out.println(line);
			   line=in.readUTF();
          
            if(line.equals("by-by Masha"))  {ifnot=1; break;}
           list.add(line); // ждем пока сервер отошлет строку текста.
           //System.out.println("Этооооооо");
           //System.out.println(list);
           }
		   return list;
		   
	   }
	   
	   
	   public static  ArrayList<String> rodGet(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="rod.rodGet();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();

		   int ifnot=0;
		   while(ifnot != 1)
           { // System.out.println(line);
			   line=in.readUTF();
          
            if(line.equals("by-by Masha"))  {ifnot=1; break;}
           list.add(line); // ждем пока сервер отошлет строку текста.
           //System.out.println(line);
           }
		   return list;
		   
	   }
	   
	   
	   public static  ArrayList<String> vidGet(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="vid.vidGet();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();

		   int ifnot=0;
		   while(ifnot != 1)
           {  //System.out.println(line);
			   line=in.readUTF();
          
            if(line.equals("by-by Masha"))  {ifnot=1; break;}
           list.add(line); // ждем пока сервер отошлет строку текста.
           //System.out.println(line);
           }
		   return list;
		   
	   }
	   
	   
	   
	   public static  ArrayList<String> vidGetAll() throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="vid.vidGetAll();";
		   out.writeUTF(line);
		   out.flush();

		   int ifnot=0;
		   while(ifnot != 1)
           { 
			   line=in.readUTF();
          
            if(line.equals("by-by Masha"))  {ifnot=1; break;}
           list.add(line); // ждем пока сервер отошлет строку текста.
           }
		   return list;
		   
	   }
	   
	   public static  String organizmGet(String temp) throws IOException
	   {
	
		   line="organizm.organizmGet();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();
		   line=in.readUTF();
		   return line;
		   
	   }
	   
	   public static  String statusGet(String temp) throws IOException
	   {
	
		   line="status.statusGet();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();
		   line=in.readUTF();
		   return line;
		   
	   }
	   
	   
	   public static  void tipDelete(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="tip.tipDelete();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   
	   public static  void CarstvoDelete(int temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="Carstvo.CarstvoDelete();";
		   out.writeUTF(line);
		   out.writeInt(temp);
		   out.flush();   
	   }
	   
	   public static  void klassDelete(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="klass.klassDelete();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void otriadDelete(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="otriad.otriadDelete();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void rodDelete(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="rod.rodDelete();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void vidDelete(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="vid.vidDelete();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void CarstvoSet(String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="Carstvo.CarstvoSet();";
		   out.writeUTF(line);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void tipSet(int numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="tip.tipSet();";
		   out.writeUTF(line);
		   out.writeInt(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void klassSet(String numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="klass.klassSet();";
		   out.writeUTF(line);
		   out.writeUTF(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void otriadSet(String numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="otriad.otriadSet();";
		   out.writeUTF(line);
		   out.writeUTF(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void rodSet(String numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="rod.rodSet();";
		   out.writeUTF(line);
		   out.writeUTF(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void vidSet(String numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="vid.vidSet();";
		   out.writeUTF(line);
		   out.writeUTF(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void organizmSet(String numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="organizm.organizmSet();";
		   out.writeUTF(line);
		   out.writeUTF(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   
	   public static  void statusSet(String numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="status.statusSet();";
		   out.writeUTF(line);
		   out.writeUTF(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void vidUp(String numb, String temp) throws IOException
	   {
	
		   list = new ArrayList<String>();
		   line="vid.vidUp();";
		   out.writeUTF(line);
		   out.writeUTF(numb);
		   out.writeUTF(temp);
		   out.flush();   
	   }
	   
	   public static  void closes() throws IOException
	   {
	
		   line="close";
		   out.writeUTF(line);
		   out.flush();   
	   }
	   
 
}