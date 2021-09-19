package model.bean;

public class News {
	private int id;
	private String title;
	private String date;
	private String corporatename;
	private String adress;
	private String jobrequest;
	private String jd;
	private int salary;
	private String email;
	private Category category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCorporatename() {
		return corporatename;
	}
	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getJobrequest() {
		return jobrequest;
	}
	public void setRequest(String jobrequest) {
		this.jobrequest = jobrequest;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public News(int id, String title, String date, String corporatename, String adress, String jobrequest, String jd,
			int salary, String email, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.corporatename = corporatename;
		this.adress = adress;
		this.jobrequest = jobrequest;
		this.jd = jd;
		this.salary = salary;
		this.email = email;
		this.category = category;
	}
	
	
}
