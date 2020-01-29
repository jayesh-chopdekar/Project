package com.app.pojos;

import java.util.Date;

public class VicAdd 
{
	private Integer vId;
	private String name;
	private int age;
	private double height;
	private String city;
	private String country;
	private String state;
	private String bgrp;
	private Gender gender;
	private String phno;
	private Date dob,missingDate;
	private Photo photoId;
	private byte[] img;
	private String cmpNo;
	public VicAdd() 
	{}
	
	public Photo getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Photo photoId) {
		this.photoId = photoId;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBgrp() {
		return bgrp;
	}
	public void setBgrp(String bgrp) {
		this.bgrp = bgrp;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getMissingDate() {
		return missingDate;
	}
	public void setMissingDate(Date missingDate) {
		this.missingDate = missingDate;
	}
	public String getCmpNo() {
		return cmpNo;
	}
	public void setCmpNo(String cmpNo) {
		this.cmpNo = cmpNo;
	}
	
}
