import java.sql.*;
import java.util.*;

public class Delete {
	public static void main(String[] args) {
		Connection conn = null;
		try{
			   final String driver = "oracle.jdbc.driver.OracleDriver";
			   Class.forName(driver);
		       String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		       conn = DriverManager.getConnection(mysqlUrl, "THE_FLASH", "hellooracle");
			   Statement smt=conn.createStatement();
			   //query to update records from table REGISTRATION
			   //delete from REGISTRATION where U_ID = 102
			   Scanner in = new Scanner(System.in);
			   System.out.println("Write the delete statement you wish to execute");
			   //delete from REGISTRATION where U_ID = 102
			   String str=in.nextLine();
			   smt.executeUpdate(str);
               System.out.println("Record Deleted as per request");
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

