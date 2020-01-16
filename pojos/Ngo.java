package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ngo")
public class Ngo 
{
	private Integer nId;
	private String name;
	private Address nAddId;
	
	public Ngo() 
	{
		System.out.println("inside parameterless ngo ctor");
	}

	public Ngo(String name)
	{
		System.out.println("inside parameterized ngo ctor");
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@OneToOne(mappedBy = "nId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Address getnAddId() {
		return nAddId;
	}

	public void setnAddId(Address nAddId) {
		this.nAddId = nAddId;
	}
	
}
