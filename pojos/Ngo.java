package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ngo")
public class Ngo 
{
	private Integer nId;
	private String ngoName;
	@JsonIgnore
	private Address nAddId;
	@JsonIgnore
	private User uId;
	
	//constructors
	public Ngo() 
	{
		System.out.println("inside parameterless ngo ctor");
	}

	public Ngo(String ngoName)
	{
		System.out.println("inside parameterized ngo ctor");
		this.ngoName = ngoName;
	}
	
	//getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getnId() {
		return nId;
	}

	public void setnId(Integer nId) {
		this.nId = nId;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}
	@OneToOne(mappedBy = "ngoId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Address getnAddId() {
		return nAddId;
	}

	public void setnAddId(Address nAddId) {
		this.nAddId = nAddId;
	}
	
	@OneToOne
	@JoinColumn(name = "user_id")
	public User getuId() {
		return uId;
	}

	public void setuId(User uId) {
		this.uId = uId;
	}

	//convenience methods
	public void addAddress(Address a)
	{
		this.nAddId=a;
		a.setNgoId(this);
	}
	public void remAddress(Address a)
	{
		this.nAddId=null;
		a.setNgoId(null);
	}
}
