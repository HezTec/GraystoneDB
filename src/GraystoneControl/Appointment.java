package GraystoneControl;
/*
 * Appointment Scheduler
 * 
 */
public class Appointment {

	private String appTime;
	private String dateCreated;
	private String phoneNumber;
	private String fName;
	private String lName;
	
	public Appointment(String appTime, String dateCreated, String phoneNumber, String fName, String lName) {
		super();
		this.appTime = appTime;
		this.dateCreated = dateCreated;
		this.phoneNumber = phoneNumber;
		this.fName = fName;
		this.lName = lName;
	}

	public String getAppTime() {
		return appTime;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}
	
	
}
