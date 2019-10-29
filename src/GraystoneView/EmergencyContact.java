package GraystoneView;
/*
 * Emergency Contact information
 * 
 */
public class EmergencyContact {

	private String fName;
	private String lName;
	private String address;
	private String cellNumber;
	private String workNumber;
	private String exention;
	
	public EmergencyContact(String fName, String lName, String address, String cellNumber, String workNumber,
			String exention) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.cellNumber = cellNumber;
		this.workNumber = workNumber;
		this.exention = exention;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getAddress() {
		return address;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public String getExention() {
		return exention;
	}
	
	
	
	
}
