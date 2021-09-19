package model.bean;

public class Vote {
	private int id;
	private int user_id;
	private int news_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public Vote(int id, int user_id, int news_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.news_id = news_id;
	}
	
	
}
