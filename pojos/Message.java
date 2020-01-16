package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message 
{
	private Integer mId;
	private String msg;
	private User uId;
	public Message() 
	{
		System.out.println("inside message parameterless ctor");
	}
	public Message(String msg) 
	{
		System.out.println("inside message parameterized ctor");
		this.msg = msg;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "m_id")
	public Integer getmId() {
		return mId;
	}
	public void setmId(Integer mId) {
		this.mId = mId;
	}
	@Lob
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getuId() {
		return uId;
	}
	public void setuId(User uId) {
		this.uId = uId;
	}
	
}
