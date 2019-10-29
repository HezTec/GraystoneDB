package GraystoneView;
import javafx.beans.property.SimpleStringProperty;

public class Resident {

		public final SimpleStringProperty residentID;
		public final SimpleStringProperty roomNumber;
		public final SimpleStringProperty firstName;
		public final SimpleStringProperty lastName;
		public final SimpleStringProperty Address;
		public final SimpleStringProperty City;
		public final SimpleStringProperty zipcode;
		public final SimpleStringProperty phoneNumber;
		public final SimpleStringProperty SSN;

		public Resident(String resId, String roomNum, String fName, String lName, String address, String city,
				String zip, String num, String ssn) {
			this.residentID = new SimpleStringProperty(resId);
			this.roomNumber = new SimpleStringProperty(roomNum);
			this.firstName = new SimpleStringProperty(fName);
			this.lastName = new SimpleStringProperty(lName);
			this.Address = new SimpleStringProperty(address);
			this.City = new SimpleStringProperty(city);
			this.zipcode = new SimpleStringProperty(zip);
			this.phoneNumber = new SimpleStringProperty(num);
			this.SSN = new SimpleStringProperty(ssn);
		}

		public String getResidentID() {
			return residentID.get();
		}

		public void setResidentID(String resID) {
			residentID.set(resID);
		}

		public String getRoomNum() {
			return roomNumber.get();
		}

		public void setRoomNum(String roomNum) {
			roomNumber.set(roomNum);
		}

		public String getFirstName() {
			return firstName.get();
		}

		public void setFirstName(String fName) {
			firstName.set(fName);
		}

		public String getLastName() {
			return lastName.get();
		}

		public void setLastName(String lName) {
			lastName.set(lName);
		}

		public String getAddress() {
			return Address.get();
		}

		public void setAddress(String address) {
			Address.set(address);
		}

		public String getCity() {
			return City.get();
		}

		public void setCity(String city) {
			City.set(city);
		}

		public String getZip() {
			return zipcode.get();
		}

		public void setZip(String zip) {
			zipcode.set(zip);
		}

		public String getPhoneNumber() {
			return phoneNumber.get();
		}

		public void setPhoneNumber(String num) {
			phoneNumber.set(num);
		}

		public String getSSN() {
			return SSN.get();
		}

		public void setSSN(String ssn) {
			SSN.set(ssn);
		}

	}