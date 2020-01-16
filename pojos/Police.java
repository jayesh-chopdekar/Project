package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "police")
public class Police
{
	private Integer deptId;
	private String name;
	private Address pAddId;
	
	public Police() 
	{
		System.out.println("inside parameterless police ctor");
	}

	public Police(String name) 
	{
		System.out.println("inside parameterized police ctor");
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
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
	@OneToOne(mappedBy = "pId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Address getpAddId() {
		return pAddId;
	}

	public void setpAddId(Address pAddId) {
		this.pAddId = pAddId;
	}
	
}
