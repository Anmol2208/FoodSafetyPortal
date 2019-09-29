import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		final String driver = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String username = "SYSTEM";
		final String password = "jkl";
        Class.forName(driver);
        Connection conn = null;
        conn = DriverManager.getConnection(url, username, password);          // it will match with the above and establish the connection.
        if(conn != null)
        	System.out.println("Connection established successfully.!!");     // the database is connected successfully
        else
        	System.out.println("There was a problem while connecting to the database.!!");   //error connecting database
        conn.close();
	}

}
