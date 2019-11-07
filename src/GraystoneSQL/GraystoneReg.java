package GraystoneSQL;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * GraystoneReg holds the methods for registering residents into to db
 * 
 * 
 * @author 17col
 *
 */
public class GraystoneReg extends DBFilePath {

	// the fields to hold the temp values for db registration
	String id = null;
	String roomNum = null;
	String fname = null;
	String lname = null;
	String address = null;
	String city = null;
	String zipcode = null;
	String phone = null;
	String ssn = null;

	public GraystoneReg(String id, String roomNum, String fname, String lname, String address, String city,
			String zipcode, String phone, String ssn) {
		super();
		this.id = id;
		this.roomNum = roomNum;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.ssn = ssn;
	}

	public GraystoneReg() {
		super();
	}

	public void insert() {

		// Temporary method of reading in a new resident
		// eventually will add the javafx view and get input from the user there
		System.out.println("VALUES ('" + id + "','" + roomNum + "','" + fname + "','" + lname + "','" + address + "','"
				+ city + "','" + zipcode + "','" + phone + "','" + ssn + "');");
		File file = getDBFile();

		// the db connection
		Connection c = null;
		// statement obj that reads in the sql code and executes it
		Statement stmt = null;

		// the block of code that registers people in the db
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + file);
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			// writing the sql code to a string for the statement to run
			String sql = "INSERT INTO RESIDENT (ID,ROOMNUM,FNAME,LNAME,ADDRESS,CITY,ZIPCODE,PHONE,SSN) " + "VALUES ('"
					+ id + "','" + roomNum + "','" + fname + "','" + lname + "','" + address + "','" + city + "','"
					+ zipcode + "','" + phone + "','" + ssn + "');";

			// running the sql code
			stmt.executeUpdate(sql);

			// releasing the used resources of the statement
			stmt.close();

			// saving the changes to db
			c.commit();

			// closing the connection to the db
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
}
