package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "police")
public class Police
{
	private Integer deptId;
	private String deptName;
	@JsonIgnore
	private Address pAddId;
	@JsonIgnore
	private User uId;
	
	//constructors
	public Police() 
	{
		System.out.println("inside parameterless police ctor");
	}

	public Police(String deptName) 
	{
		System.out.println("inside parameterized police ctor");
		this.deptName = deptName;
	}
	
	//getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@OneToOne(mappedBy = "pId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Address getpAddId() {
		return pAddId;
	}

	public void setpAddId(Address pAddId) {
		this.pAddId = pAddId;
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
		this.pAddId=a;
		a.setpId(this);
	}
	public void remAddress(Address a)
	{
		this.pAddId=null;
		a.setpId(null);
	}
}
