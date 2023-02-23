import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
	String sqlURL  = "jdbc:mysql://sc1.swu.ac.kr:13306/yebbnrjs_ts";
    String user = "yebbnrjs";
    String password = "yebbnrjs90";
    static Connection conn = null;
   
 public ConnectDB(){
     try {
      System.out.println("try : get connection");
      Class.forName("org.mariadb.jdbc.Driver");
         conn = DriverManager.getConnection(sqlURL, user, password);
         System.out.println("success !");
     } catch (SQLException e) {} catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 public static Connection getConnection(){
  return conn;
 }
} 