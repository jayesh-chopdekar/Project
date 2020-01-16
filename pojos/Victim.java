package com.app.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "victim")
public class Victim 
{
	private Integer vId,age;
	private String name,bgrp,cmpNo;
	private Gender gender;
	private Double height;
	private Status status;
	private Date dob;
	private Date missingDate;
	private Address vAddId;
	private Photo photoId;
	
	public Victim()
	{
		System.out.println("inside victim parameterless ctor");
	}

	public Victim(Integer age, String name, String bgrp, String cmpNo, Double height, Date dob, Date missingDate) {
		System.out.println("inside victim parameterized ctor");
		this.age = age;
		this.name = name;
		this.bgrp = bgrp;
		this.cmpNo = cmpNo;
		this.height = height;
		this.dob = dob;
		this.missingDate = missingDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBgrp() {
		return bgrp;
	}

	public void setBgrp(String bgrp) {
		this.bgrp = bgrp;
	}

	public String getCmpNo() {
		return cmpNo;
	}

	public void setCmpNo(String cmpNo) {
		this.cmpNo = cmpNo;
	}
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Temporal(TemporalType.DATE)
	public Date getMissingDate() {
		return missingDate;
	}

	public void setMissingDate(Date missingDate) {
		this.missingDate = missingDate;
	}
	@OneToOne(mappedBy = "vId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Address getVAddId() {
		return vAddId;
	}

	public void setVAddId(Address addId) {
		this.vAddId = addId;
	}
	@OneToOne(mappedBy = "vId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Photo getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Photo photoId) {
		this.photoId = photoId;
	}
	
}
