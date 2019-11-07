package GraystoneSQL;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * This class creates the Graystone database
 * 
 * 
 */
public class GraystoneCreate extends DBFilePath {
	
	 public void create() {
		 
		 //The path to Graystone DB file
		 File file = getDBFile();
			
	      Connection c = null;
	      Statement stmt = null;
	      
	      //creating the db File with the correct parameters
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:"+ file);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE RESIDENT " +
	                        "("
	                        + "ID            STIRNG PRIMARY KEY  NOT NULL," +
	                        " ROOMNUM        STRING              NOT NULL," +
	                        " FNAME          STRING              NOT NULL, " + 
	                        " LNAME          STRING              NOT NULL, " + 
	                        " ADDRESS        STRING              NOT NULL, " + 
	                        " CITY           STRING              NOT NULL," +
	                        " ZIPCODE		 STRING	             NOT NULL," +
	                        " PHONE          STRING              NOT NULL," +
	                        " SSN            STRING              NOT NULL)"; 
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		//error handling
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
}

