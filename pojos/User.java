package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User 
{
	private Integer id;
	private String name,email,password;
	private UserRole role;
	private Photo dp;
	private Verification ver;
	@JsonIgnore
	private Address addId;
	@JsonIgnore
	private Police pId;
	@JsonIgnore
	private Ngo nId;
	@JsonIgnore
	private List<Message> msg;
	
	
	//constructors
	public User() 
	{
		System.out.println("in parameterless users ctor");
	}

	public User( String name, String email, String password, UserRole role,Verification ver) 
	{
		System.out.println("in parameterized users ctor");
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.ver=ver;
	}

	//getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name = "name",length = 30)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "email",unique = true)
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
	@Enumerated(EnumType.STRING)
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	public Verification getVer() {
		return ver;
	}

	public void setVer(Verification ver) {
		this.ver = ver;
	}

	
	 @OneToOne(mappedBy = "uId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		public Address getAddId() {
			return addId;
		}

		public void setAddId(Address addId) {
			this.addId = addId;
		}
	

	@OneToOne(mappedBy = "uId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Photo getDp() {
		return dp;
	}

	public void setDp(Photo dp) {
		this.dp = dp;
	}
		
	@OneToOne(mappedBy = "uId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Police getpId() {
		return pId;
	}

	public void setpId(Police pId) {
		this.pId = pId;
	}

	@OneToOne(mappedBy = "uId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Ngo getnId() {
		return nId;
	}

	public void setnId(Ngo nId) {
		this.nId = nId;
	}

	@OneToMany(mappedBy = "uId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public List<Message> getMsg() {
		return msg;
	}

	public void setMsg(List<Message> msg) {
		this.msg = msg;
	}

	

	//convenience methods
	public void addPhoto(Photo p)
	{
		this.dp=p;
		p.setuId(this);
	}
	public void remPhoto(Photo p)
	{
		this.dp=null;
		p.setuId(null);
	}
	
	public void addMsg(Message m)
	{
		msg.add(m);
		m.setuId(this);
	}
	public void addPolice(Police p)
	{
		this.pId=p;
		p.setuId(this);
	}
	public void remPolice(Police p)
	{
		this.pId=null;
		p.setuId(null);
	}
	public void addNgo(Ngo n)
	{
		this.nId=n;
		n.setuId(this);
	}
	public void remNgo(Ngo n)
	{
		this.nId=null;
		n.setuId(null);
	}
	 public void addAddress(Address a)
	 { this.addId=a; a.setuId(this); } 
	 
	 public void remAddress(Address a)
	 { this.addId=null; a.setuId(null); }
	
}
