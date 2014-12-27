package by.bsuir.kyrsProjekt.server;


import java.net.*;
import java.util.ArrayList;
import java.io.*;
public class Server {
	
	
	    static ServerSocket ss;
	    static Socket socket;
	    static InetAddress ipAddress;
	    static InputStream sin;
	    static OutputStream sout;
	    static DataInputStream in;
	    static DataOutputStream out;
	private static ArrayList<String> list;
	
	 public static void conect() throws IOException
	   {
		 int port = 6666;
		 ss = new ServerSocket(port); 
         System.out.println("Waiting for a client...");
         socket = ss.accept(); 
         System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
         System.out.println();
         sin = socket.getInputStream();
         sout = socket.getOutputStream();
         in = new DataInputStream(sin);
         out = new DataOutputStream(sout);
	   }
	
	 public static void disconect() throws IOException
	   {

		 socket.close();
         ss.close();
         sin.close();
         sout.close();
         in.close();
         out.close();
	   }
	 
   public static void main(String[] ar)    {
 
       try {
    	   
      	 conect(); 
         String line = null;
    	 int numb;
    	 int[] numblist;
    	 int a=1;
         while(a==1)
         {
        	 System.out.println("1");
             line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
        	 System.out.println("2");
             list=new ArrayList<String>();
        	  
                     if( line.equals("Carstvo.CarstvoGet();"))
           {    	 
                   
        		 list= Carstvo.CarstvoGet();
        		 for(int i=0;i<list.size();i++)
           {
        		  out.writeUTF(list.get(i));
                  System.out.println(list.get(i));
           }
        		 out.writeUTF("by-by Masha");
        		 
        		 out.flush();
           }
        	 
                     
                     else if( line.equals("Carstvo.CarstvoSet();"))
            {
                    	 line = in.readUTF();
                    	 Carstvo.CarstvoSet(line);
                         //out.writeUTF("by-by Masha");
                         out.flush();
            }
                     
                     
                     else if( line.equals("Carstvo.CarstvoGetID();"))
            {
                       	 numb=in.readInt();
                    	 out.writeInt(Carstvo.CarstvoGetId(numb));
                         out.flush();
            }
                     
                     else if( line.equals("Carstvo.CarstvoDelete();"))
            {
                    	 numb=in.readInt();
                    	 Carstvo.CarstvoDelete(numb);
                    	 out.flush();
           
            }
                     
                     else if( line.equals("tip.tipGet();"))
                     {

                    	 numb=in.readInt();
                    	 list=tip.tipGet(numb);
                    	 for(int i=0;i<list.size();i++)
                         {
                    		 System.out.println("1");
                      		  out.writeUTF(list.get(i));
                                System.out.println(list.get(i));
                         }
                      		 out.writeUTF("by-by Masha");
                      		 out.flush();  
                     }
                     
                     else if( line.equals("vid.vidGetAll();"))
                     {

                
                    	 list=vid.vidGetAll();
                    	 for(int i=0;i<list.size();i++)
                         {
                      		  out.writeUTF(list.get(i));
                                System.out.println(list.get(i));
                         }
                      		 out.writeUTF("by-by Masha");
                      		 out.flush();  
                     }
                     
                     
                     else if( line.equals("tip.TipGetIdList();"))
                     {
                    	numblist=tip.TipGetIdList();
                    	for(int i=0;i<numblist.length;i++)
                        {
                     		  out.writeInt(numblist[i]);
                        }
                    	 out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("tip.tipSet();"))
                     {
                    	 numb=in.readInt();
                    	 line=in.readUTF();
                    	 tip.tipSet(numb, line);
                  		 out.flush();
                     }
                     
                     else if( line.equals("tip.TipGetNextIdList();"))
                     {
                    	 numb=in.readInt();
                    	 tip.TipGetNextIdList(numb);
                    	 out.writeInt(numb);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("tip.tipDelete();"))
                     {
                    	 line=in.readUTF();
                    	 tip.tipDelete(line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else  if( line.equals("tip.tipGetId();"))
                     {
                    	 line=in.readUTF();
                    	 numb=tip.tipGetId(line);
                    	 out.writeInt(numb);
                  		 out.flush();
                     }
                     
                     else if( line.equals("klass.klassGet();"))
                     {
                    	 String str=in.readUTF();
                    	 list=klass.klassGet(str);
                    	 for(int i=0;i<list.size();i++)
                         {
                      		  out.writeUTF(list.get(i));
                                System.out.println(list.get(i));
                         }
                      		 out.writeUTF("by-by Masha");
                      		 out.flush();                      		 
                     }
                     
                     
                     else if( line.equals("klass.klassSet();"))
                     {
                    	 String temp;
                    	 temp=in.readUTF();
                    	 line=in.readUTF();
                    	 klass.klassSet(temp, line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else  if( line.equals("klass.klassGetNextId();"))
                     {
                    	 numb=klass.klassGetNextId();
                    	 out.writeInt(numb);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("klass.klassDelete();"))
                     {
                    	 line=in.readUTF();
                    	 klass.klassDelete(line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("klass.klassGetId();"))
                     {
                    	 line=in.readUTF();
                    	 numb=klass.klassGetId(line);
                    	 out.writeInt(numb);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("otriad.otriadGet();"))
                     {
                    	 String str=in.readUTF();
                    	 list=otriad.otriadGet(str);
                    	 for(int i=0;i<list.size();i++)
                         {
                      		  out.writeUTF(list.get(i));
                                System.out.println(list.get(i));
                         }
                      		 out.writeUTF("by-by Masha");
                      		 out.flush();                      		 
                     }
                     
                     
                     else if( line.equals("otriad.otriadSet();"))
                     {
                    	 String temp;
                    	 temp=in.readUTF();
                    	 line=in.readUTF();
                    	 otriad.otriadSet(temp, line);
                    //	 out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("otriad.otriadGetNextId();"))
                     {
                    	 numb=otriad.otriadGetNextId();
                    	 out.writeInt(numb);
                    	// out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("otriad.otriadDelete();"))
                     {
                    	 line=in.readUTF();
                    	 otriad.otriadDelete(line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("otriad.otriadGetId();"))
                     {
                    	 line=in.readUTF();
                    	 numb=otriad.otriadGetId(line);
                    	 out.writeInt(numb);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("rod.rodGet();"))
                     {
                    	 String str=in.readUTF();
                    	 list=rod.rodGet(str);
                    	 for(int i=0;i<list.size();i++)
                         {
                      		  out.writeUTF(list.get(i));
                                System.out.println(list.get(i));
                         }
                      		 out.writeUTF("by-by Masha");
                      		 out.flush();                      		 
                     }
                     
                     else if( line.equals("vid.vidGetVibor();"))
                     {
                    	 String str=in.readUTF();
                    	 list=vid.vidGetVibor(str);
                    	 for(int i=0;i<list.size();i++)
                         {
                      		  out.writeUTF(list.get(i));
                                System.out.println(list.get(i));
                         }
                      		 out.writeUTF("by-by Masha");
                      		 out.flush();                      		 
                     }
                     
                     
                     else if( line.equals("rod.rodSet();"))
                     {
                    	 String temp;
                    	 temp=in.readUTF();
                    	 line=in.readUTF();
                    	 rod.rodSet(temp, line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("rod.rodGetNextId();"))
                     {
                    	 numb=rod.rodGetNextId();
                    	 out.writeInt(numb);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("rod.rodDelete();"))
                     {
                    	 line=in.readUTF();
                    	 klass.klassDelete(line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("rod.rodGetId();"))
                     {
                    	 line=in.readUTF();
                    	 numb=klass.klassGetId(line);
                    	 out.writeInt(numb);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("vid.vidGet();"))
                     {
                    	 line=in.readUTF();
                    	 list=vid.vidGet(line);
                    	 for(int i=0;i<list.size();i++)
                         {
                      		  out.writeUTF(list.get(i));
                                System.out.println(list.get(i));
                         }
                      		 out.writeUTF("by-by Masha");
                      		 out.flush();                      		 
                     }
                     
                     
                     else if( line.equals("vid.vidSet();"))
                     {
                    	 String temp;
                    	 temp=in.readUTF();
                    	 line=in.readUTF();
                    	 vid.vidSet(temp, line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("vid.vidGetNextId();"))
                     {
                    	 numb=vid.vidGetNextId();
                    	 out.writeInt(numb);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else  if( line.equals("vid.vidDelete();"))
                     {
                    	 line=in.readUTF();
                    	 vid.vidDelete(line);
                    	 //out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("vid.vidGetId();"))
                     {
                    	 line=in.readUTF();
                    	 numb=vid.vidGetId(line);
                    	 out.writeInt(numb);
                    	// out.writeUTF("by-by Masha");
                  		 out.flush();
                     }
                     
                     else if( line.equals("organizm.organizmGet();"))
                     {
                    	 line=in.readUTF();
                    	 String temp;
                    	 temp=organizm.organizmGet(line);
                      		 out.writeUTF(temp);
                      		 out.flush();                      		 
                     }
                     
                     else if( line.equals("organizm.organizmSet();"))
                     {
                    	 String temp;
                    	 temp=in.readUTF();
                    	 line=in.readUTF();
                    	 organizm.organizmSet(temp, line);
                     }
                     
                     else if( line.equals("status.statusSet();"))
                     {
                    	 String temp;
                    	 temp=in.readUTF();
                    	 line=in.readUTF();
                    	 status.statusSet(temp, line);
                     }
                     
                     else if( line.equals("vid.vidUp();"))
                     {
                    	 String temp;
                    	 temp=in.readUTF();
                    	 line=in.readUTF();
                    	 vid.vidUp(temp, line);
                     }
                     
                     else if( line.equals("status.statusGet();"))
                     {
                    	 line=in.readUTF();
                    	 String temp;
                    	 temp=status.statusGet(line);
                      		 out.writeUTF(temp);
                      		 out.flush();                      		 
                     }
                     
                     else if( line.equals("close"))
                     {
                    	a=0;
                    	disconect();
                     }
                     
                     else  System.out.println("ЕСИТ");
                     
         }
      } catch(Exception x) { x.printStackTrace(); }
   }
}