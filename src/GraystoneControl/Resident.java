package GraystoneControl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Resident {

		private final SimpleStringProperty residentID;
		private final SimpleStringProperty roomNumber;
		private final SimpleStringProperty firstName;
		private final SimpleStringProperty lastName;
		private final SimpleStringProperty Address;
		private final SimpleStringProperty City;
		private final SimpleStringProperty zipcode;
		private final SimpleStringProperty phoneNumber;
		private final SimpleStringProperty SSN;
		
		
		

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
			this.residentID.set(resID);
		}
		
		public StringProperty resIdProperty() {
			return residentID;
		}

		public String getRoomNum() {
			return roomNumber.get();
		}

		public void setRoomNum(String roomNum) {
			this.roomNumber.set(roomNum);
		}
		
		public StringProperty roomNumProperty() {
			return roomNumber;
		}
		
		public String getFirstName() {
			return firstName.get();
		}

		public void setFirstName(String fName) {
			this.firstName.set(fName);
		}
		
		public StringProperty fNameProperty() {
			return firstName;
		}

		public String getLastName() {
			return lastName.get();
		}

		public void setLastName(String lName) {
			this.lastName.set(lName);
		}
		
		public StringProperty lNameProperty() {
			return lastName;
		}

		public String getAddress() {
			return Address.get();
		}

		public void setAddress(String address) {
			this.Address.set(address);
		}
		
		public StringProperty addressProperty() {
			return Address;
		}
		
		public String getCity() {
			return City.get();
		}

		public void setCity(String city) {
			this.City.set(city);
		}
		
		public StringProperty cityProperty() {
			return City;
		}
		
		public String getZip() {
			return zipcode.get();
		}

		public void setZip(String zip) {
			this.zipcode.set(zip);
		}
		
		public StringProperty zipProperty() {
			return zipcode;
		}

		public String getPhoneNumber() {
			return phoneNumber.get();
		}

		public void setPhoneNumber(String num) {
			this.phoneNumber.set(num);
		}
		
		public StringProperty numProperty() {
			return phoneNumber;
		}

		public String getSSN() {
			return SSN.get();
		}

		public void setSSN(String ssn) {
			this.SSN.set(ssn);
		}
		
		public StringProperty ssnProperty() {
			return SSN;
		}

	}