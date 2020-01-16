package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "photo")
public class Photo 
{
	private Integer photoId;
	private Byte[] img;
	private User uId;
	private Victim vId;
	
	public Photo() 
	{
		System.out.println("inside photo parameterless ctor");
	}

	public Photo(Byte[] img) 
	{
		System.out.println("inside photo parameterized ctor");
		this.img = img;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_id")
	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	@Lob
	public Byte[] getImg() {
		return img;
	}

	public void setImg(Byte[] img) {
		this.img = img;
	}
	@OneToOne
	@JoinColumn(name = "user_id")
	public User getuId() {
		return uId;
	}
	
	public void setuId(User uId) {
		this.uId = uId;
	}
	@OneToOne
	@JoinColumn(name = "victim_id")
	public Victim getvId() {
		return vId;
	}

	public void setvId(Victim vId) {
		this.vId = vId;
	}
	
}
