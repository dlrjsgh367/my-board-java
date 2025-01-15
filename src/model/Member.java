package model;

public class Member {
	
	private int id;
	private String name;
	private String sex;
	private int age;
	private String job;
	private String hobby;
	private String createdAt;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getSex() {return sex;}
	public void setSex(String sex) {this.sex = sex;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getJob() {return job;}
	public void setJob(String job) {this.job = job;}
	public String getHobby() {return hobby;}
	public void setHobby(String hobby) {this.hobby = hobby;}
	public String getCreatedAt() {return createdAt;}
	public void setCreatedAt(String createdAt) {this.createdAt = createdAt;}
}