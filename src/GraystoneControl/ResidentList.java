package GraystoneControl;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import GraystoneSQL.DBFilePath;
import GraystoneView.Resident;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ResidentList extends DBFilePath{
	
	private static File file = getFile();
	/*
	 * returns the entire resident list in CSV format
	 */
	public static List getList() {
		
		// the fields that need be entered to create the resident list
		String id = null;
		String roomNum = null;
		String fname = null;
		String lname = null;
		String address = null;
		String city = null;
		String zipcode = null;
		String phone = null;
		String ssn = null;
		
		//The list to be returned with all the residents in it
		ObservableList<Resident> List = FXCollections.observableArrayList();

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + file);
			c.setAutoCommit(false);
			System.out.println("Opened database successfully, resident list");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESIDENT;");
			
			//Reading in the lines and adding them to the list
			while (rs.next()) {

				id = rs.getString("id");
				roomNum = rs.getString("roomnum");
				fname = rs.getString("fname");
				lname = rs.getString("lname");
				address = rs.getString("address");
				city = rs.getString("city");
				zipcode = rs.getString("zipcode");
				phone = rs.getString("phone");
				ssn = rs.getString("ssn");
				List.add(new Resident(id, roomNum, fname, lname, address, city, zipcode, phone, ssn));
			}

			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return List;
	}
}
