
package bank.management.system;
import java.sql.*;

 public class conn{
     
      Connection c;
      Statement s;
     public conn(){
         try{
           //  Class.forName(com.mysql.jdbc.Driver); //classpath alredy have path of driver so no need to register driver
             c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagementsystem","root","root");
             s = c.createStatement();
         } catch (Exception e){
             System.out.println(e);
         }
     }
 }

//"jdbc:mysql://localhost:3307/emp","root","root"