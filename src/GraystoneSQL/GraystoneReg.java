package GraystoneSQL;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class GraystoneReg extends DBFilePath {

	public void insert() {
		//the fields to hold the temp values for db registration
		String id = null;
		String roomNum = null;
		String fname = null;
		String lname = null;
		String address = null;
		String city = null;
		String zipcode = null;
		String phone = null;
		String ssn = null;
	
	
		Scanner inString = new Scanner(System.in);
		System.out.println("enter resident id: ");
		id = inString.nextLine();
		System.out.println("enter resident Room num: ");
		roomNum = inString.nextLine();
		System.out.println("enter resident First Name: ");
		fname = inString.nextLine();
		System.out.println("enter resident Last Name: ");
		lname = inString.nextLine();
		System.out.println("enter resident address: ");
		address = inString.nextLine();
		System.out.println("enter resident city: ");
		city = inString.nextLine();
		System.out.println("enter resident zipcode: ");
		zipcode = inString.nextLine();
		System.out.println("enter resident phone #: ");
		phone = inString.nextLine();
		System.out.println("enter resident ssn: ");
		ssn = inString.nextLine();
		
		File file = getFile();
		
		//the db connection 
		Connection c = null;
		Statement stmt = null;
		
		//the block of code that registers people in the db
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+ file);
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO RESIDENT (ID,ROOMNUM,FNAME,LNAME,ADDRESS,CITY,ZIPCODE,PHONE,SSN) "
					+ "VALUES (" + id + "," + roomNum + ",'" + fname + "','" + lname + "','" + address + "','"
					+ city + "','" + zipcode + "','" + phone + "','" + ssn + "');";
			stmt.executeUpdate(sql);


			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
}
