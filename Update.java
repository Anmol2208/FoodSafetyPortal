import java.sql.*;
import java.util.*;

public class Update {
	public static void main(String[] args) {
		Connection conn = null;
		try{
			   final String driver = "oracle.jdbc.driver.OracleDriver";
			   Class.forName(driver);
		       String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		       conn = DriverManager.getConnection(mysqlUrl, "THE_FLASH", "hellooracle");
			   Statement smt=conn.createStatement();
			   Scanner in = new Scanner(System.in);
			   System.out.println("Write the update statement you wish to execute");
			   //update REGISTRATION set U_Name = 'Sunil' where U_ID = 102
			   String q=in.nextLine();
               smt.executeUpdate(q);
               System.out.println("Table Updated as per request");
		       in.close();
		   }
		catch(ClassNotFoundException e){
			   System.out.println("Driver class not found!! Exception Occured");
		}
		catch(SQLException sqle){
			   sqle.printStackTrace();
		}
		
		finally {
			    try{
				        conn.close();
			        }
			    catch(SQLException sqle){
				        System.out.println("Exception occured while closing the connection");
			}
			}
   }
}

