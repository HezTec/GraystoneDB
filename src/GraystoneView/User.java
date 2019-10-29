package GraystoneView;
/*
 * Employee Connection to Database
 * 
 */
public class User {

	private String userId;
	private String password;
	
	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
