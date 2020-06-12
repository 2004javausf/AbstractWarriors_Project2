package com.revature.entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "IMAGES")
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IMAGE_ID")
	private long imageId;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "picByte", length = 1000, nullable = true, columnDefinition="BLOB")
	private byte[] picByte;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="POST_ID")
	private Post post;

	public Image() {
		super();
	}

	public Image(String image, String type, byte[] picByte, Post post) {
		super();
		this.image = image;
		this.type = type;
		this.picByte = picByte;
		this.post = post;
	}

	public Image(String image, String type, byte[] picByte) {
		super();
		this.image = image;
		this.type = type;
		this.picByte = picByte;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", image=" + image + ", type=" + type + ", picByte="
				+ Arrays.toString(picByte) + ", post=" + post + "]";
	}

	
	
}
