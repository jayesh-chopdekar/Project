package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address 
{
	private Integer addId;
	private String city;
	private String state;
	private String country;
	private String phoneno;
	private User uId;
	private Victim vId;
	private Ngo ngoId;
	private Police pId;
	
	public Address() 
	{
		System.out.println("inside Address parameterless ctor");
	}

	public Address(String city, String state, String country, String phoneno) 
	{
		System.out.println("inside Address parameterized ctor");
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneno = phoneno;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "add_id")
	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
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

	
	 @OneToOne
	 @JoinColumn(name = "user_id") 
	 public User getuId() { return uId; }
	 
	 public void setuId(User uId) { this.uId = uId; }
	
	@OneToOne
	@JoinColumn(name = "victim_id")
	public Victim getvId() {
		return vId;
	}

	public void setvId(Victim vId) {
		this.vId = vId;
	}
	@OneToOne
	@JoinColumn(name = "ngo_id")
	public Ngo getNgoId() {
		return ngoId;
	}

	public void setNgoId(Ngo ngoId) {
		this.ngoId = ngoId;
	}

	@OneToOne
	@JoinColumn(name = "police_id")
	public Police getpId() {
		return pId;
	}

	public void setpId(Police pId) {
		this.pId = pId;
	}
	
}
