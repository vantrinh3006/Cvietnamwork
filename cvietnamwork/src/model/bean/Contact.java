package model.bean;

public class Contact {
	private int id;
	private String fullname;
	private  String email;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Contact(int id, String fullname, String email, String message) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.message = message;
	}
	
	
	
}
