package com.app.pojos;

public class PoliceAdd 
{
	private Integer id;
	private Integer deptId;
	private String name;
	private String email,password;
	private byte[] img;
	private String deptName;
	private String city;
	private String state;
	private String country;
	private String phoneno;
	private String deptCity;
	private String deptState;
	private String deptCountry;
	private String deptPhoneno;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer Id) {
		id = Id;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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
	
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	public String getDeptCity() {
		return deptCity;
	}
	public void setDeptCity(String deptCity) {
		this.deptCity = deptCity;
	}
	public String getDeptState() {
		return deptState;
	}
	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}
	public String getDeptCountry() {
		return deptCountry;
	}
	public void setDeptCountry(String deptCountry) {
		this.deptCountry = deptCountry;
	}
	public String getDeptPhoneno() {
		return deptPhoneno;
	}
	public void setDeptPhoneno(String deptPhoneno) {
		this.deptPhoneno = deptPhoneno;
	}

	
}
