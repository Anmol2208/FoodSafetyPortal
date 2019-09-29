import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Login {
	public static void main(String[] args) {
		Connection conn = null;
		try{
			final String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
		    String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		    conn = DriverManager.getConnection(mysqlUrl, "THE_FLASH", "hellooracle");
			Statement smt=conn.createStatement();
			
			//query to display all records from table REGISTRATION
			Scanner in= new Scanner(System.in);
			System.out.println("Enter Username");//User input of username
			String userName=in.nextLine();
			System.out.println("Enter Password");//User input of password
			String pswd=in.nextLine();
		
			String str = "select * from registration where user_name = '"+userName+"' and password = '"+pswd+"'";
			ResultSet rs=smt.executeQuery(str);
			
			//to print the ResultSet on console
			if(rs.next()){ 
				{
				     System.out.println("Welcome, you are logged in now.!");
				}
			             }
			else
				{
					System.out.println("Username or Password is incorrect.!!!");
				}
		
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

