package com.revature.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMMENT_ID")
	private long commentId;
	
	@Column(name="MESSAGE")
	private String message;
	
	@Column(name="POST_ID")
	private long  postId;
	
	@Column(name="USER_ID")
	private long  userId;

//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="POST_ID")
//	private Post post;
//
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="USER_ID")
//	private Users user;

	public Comment() {
		super();
	}

	public Comment(String comment, long postId, long userId) {
		super();
		this.message = comment;
		this.postId = postId;
		this.userId = userId;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		return "Comment [commentId=" + commentId + ", comment=" + message + ", post=" + postId + ", user=" + userId + "]";
	}



	
}
