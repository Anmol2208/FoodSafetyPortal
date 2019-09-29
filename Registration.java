import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Registration {
   public static void main(String args[])throws Exception {
   PasswordValid checkpassword = new PasswordValid();
   Connection conn = null;
   try {
	  final String driver = "oracle.jdbc.driver.OracleDriver";
	  Class.forName(driver); //Loading the oracle driver
      String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:xe";
      conn = DriverManager.getConnection(mysqlUrl, "THE_FLASH", "hellooracle");
      //Making the connection
      System.out.println("Connection established.!");
      //Inserting values to a table
      Scanner in = new Scanner(System.in);
      System.out.println("Enter Full Name: ");
      String FullName = in.nextLine();
      System.out.println("Enter a unique username: ");
      String User_Name = in.nextLine();
      System.out.println("Enter Mobile: ");
      String mobile = in.nextLine();
      System.out.println("Enter Email: ");
      String email = in.nextLine();
      System.out.println("Enter Password: ");
      String password = in.nextLine();
      Boolean check = checkpassword.validate(password);  //it will check with the PasswordValid.java
      System.out.println("Enter DOB: ");
      String DOB = in.nextLine();
      System.out.println("Enter Gender: ");
      String gender = in.nextLine();
      System.out.println("Enter City: ");
      String city = in.nextLine();
      
     

      String query = "INSERT INTO REGISTRATION(FullName, User_Name, mobile, email, password, DOB, gender, city, date_time)VALUES (?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP)";
      //Query to insert into the table
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, FullName);
      ps.setString(2, User_Name);
      ps.setString(3, mobile);
      ps.setString(4, email);
      ps.setString(5, password);
      ps.setString(6, DOB);
      ps.setString(7, gender);
      ps.setString(8, city);
      
      ps.execute();//Executing the statement
      System.out.println();
      System.out.println("Registration done successfully.!");
      in.close();
   }
   catch(ClassNotFoundException e){
	    System.out.println("Driver class not found!! Exception Occured");
  }
  catch(SQLException sqle){
	    System.out.println();
	    System.out.println("This username is not unique, Please enter a unique username!!");
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