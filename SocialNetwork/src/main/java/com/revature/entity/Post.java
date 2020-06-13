package com.revature.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "POSTS")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="POST_ID")
	private long postId;
	
	@Column(name="MESSAGE")
	private String message;
	
	@Column(name="NUM_OF_LIKES")
	private int numOfLikes;
	
	@Column(name="DATE_SUBMITTED", columnDefinition="TimeStamp")
	private Date date;
	
	@Column(name="POST_IMAGE", nullable = true, columnDefinition="BLOB")
	private byte[] postImage;

	@Column(name="USER_ID")
	private long userId;

	public Post() {
		super();
	}
	
	public Post(String message, byte[] postImages, int numOfLikes) {
		super();
		this.message = message;
		this.postImage = postImages;
		this.numOfLikes = numOfLikes;
	}

	
	public Post(String message, byte[] postImage, long userId) {
		super();
		this.message = message;
		this.postImage = postImage;
		this.userId = userId;
	}

	public Post(long postId, String message, int numOfLikes, Date date, byte[] postImages, long userId) {
		super();
		this.postId = postId;
		this.message = message;
		this.numOfLikes = numOfLikes;
		this.date = date;
		this.postImage = postImages;
		this.userId = userId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date localDate) {
		this.date = localDate;
	}

	public byte[] getPostImages() {
		return postImage;
	}

	public void setPostImages(byte[] postImages) {
		this.postImage = postImages;
	}

	public int getNumOfLikes() {
		return numOfLikes;
	}

	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", message=" + message + ", image=" + postImage + ", numOfLikes=" + numOfLikes
				+ ", user=" + userId + "]";
	}
}
