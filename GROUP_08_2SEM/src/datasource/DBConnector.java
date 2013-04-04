package datasource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jannik
 */
public class DBConnector {
     private static String id = "CLDATB12E8";
 private static String pw = "CLDATB12E8";

 public Connection getConnection() {
  Connection con = null;
  try {
   Class.forName("oracle.jdbc.driver.OracleDriver");
   con = DriverManager.getConnection(
     "jdbc:oracle:thin:@delfi.lyngbyes.dk:1521:KNORD", id, pw);
  } catch (Exception e) {
   System.out
     .println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
   System.out.println("eror in DBConnector.getConnection()");
   System.out.println(e);
  }

  return con;
 }

 public void releaseConnection(Connection con) {
  try {
   con.close();
  } catch (Exception e) {
   System.err.println(e);
  }
 }
}
