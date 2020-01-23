package com.app.pojos;

public class UserAdd 
{
	private Integer id;
	private String name,email,password;
	private UserRole role;
	private Photo dp;
	private Verification ver;
	private String city;
	private String state;
	private String country;
	private String phoneno;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public Photo getDp() {
		return dp;
	}
	public void setDp(Photo dp) {
		this.dp = dp;
	}
	public Verification getVer() {
		return ver;
	}
	public void setVer(Verification ver) {
		this.ver = ver;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}
