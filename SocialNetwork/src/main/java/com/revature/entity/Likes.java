package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIKES")
public class Likes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LIKE_ID")
	private long likeId;
	
	@Column(name="POST_ID")
	private long  postId;
	
	@Column(name="USER_ID")
	private long  userId;
	
	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Likes(long postId, long userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", postId=" + postId + ", userId=" + userId + "]";
	}
	
	
	
}
