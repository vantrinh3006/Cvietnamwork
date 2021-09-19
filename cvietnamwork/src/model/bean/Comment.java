package model.bean;

public class Comment {
	private int id;
	private String message;
	private int news_id;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment(int id, String message, int news_id, User user) {
		super();
		this.id = id;
		this.message = message;
		this.news_id = news_id;
		this.user = user;
	}
	
	
	
	
}