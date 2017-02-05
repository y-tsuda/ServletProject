package model;

public class Login {
	private String id;
	private String password;

	public Login(String userId, String password) {
		this.id = userId;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

}
