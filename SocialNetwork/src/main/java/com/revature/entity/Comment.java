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
	
	@Column(name="COMMENT")
	private String comment;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="POST_ID")
	private Post post;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private Users user;

	public Comment() {
		super();
	}

	public Comment(long commentId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String Comment) {
		this.comment = Comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", post=" + post + ", user=" + user + "]";
	}



	
}
