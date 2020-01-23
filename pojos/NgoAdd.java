package com.app.pojos;

public class NgoAdd 
{
	private Integer nId;
	private String name;
	private String email,password;
	private String ngoName;
	private String city;
	private String state;
	private String country;
	private String phoneno;
	private String ngoCity;
	private String ngoState;
	private String ngoCountry;
	private String ngoPhoneno;
	public NgoAdd() {
		super();
	}
	public NgoAdd(Integer nId, String name, String email, String password, String ngoName, String city, String state,
			String country, String phoneno, String ngoCity, String ngoState, String ngoCountry, String ngoPhoneno) {
		super();
		this.nId = nId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.ngoName = ngoName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneno = phoneno;
		this.ngoCity = ngoCity;
		this.ngoState = ngoState;
		this.ngoCountry = ngoCountry;
		this.ngoPhoneno = ngoPhoneno;
	}
	public Integer getnId() {
		return nId;
	}
	public void setnId(Integer nId) {
		this.nId = nId;
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
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
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
	public String getNgoCity() {
		return ngoCity;
	}
	public void setNgoCity(String ngoCity) {
		this.ngoCity = ngoCity;
	}
	public String getNgoState() {
		return ngoState;
	}
	public void setNgoState(String ngoState) {
		this.ngoState = ngoState;
	}
	public String getNgoCountry() {
		return ngoCountry;
	}
	public void setNgoCountry(String ngoCountry) {
		this.ngoCountry = ngoCountry;
	}
	public String getNgoPhoneno() {
		return ngoPhoneno;
	}
	public void setNgoPhoneno(String ngoPhoneno) {
		this.ngoPhoneno = ngoPhoneno;
	}

	
}
