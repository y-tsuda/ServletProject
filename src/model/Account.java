package model;

public class Account {
	private String id;
	private String password;
	private String mail;
	private String name;
	
	public Account(String id, String password, String mail, String name){
		this.id = id;
		this.password = password;
		this.mail = mail;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}	
}
