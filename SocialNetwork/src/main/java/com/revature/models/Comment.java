package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.models.Post;
import com.revature.models.Users;

@Component("comments")//generic stereotype for any spring managed component
@Scope("prototype")
@Entity
@Table(name = "COMMENTS")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CommentSequence")
    @SequenceGenerator(name="CommentSequence", sequenceName="COMMENT_SEQ", allocationSize=1)
	@Column(name="COMMENT_ID")
	private int CommentId;
	
	@Column(name="COMMENT")
	private String Comment;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="POST_ID")
	private Post post;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private Users user;

	public Comment() {
		super();
	}

	public Comment(int CommentId, String Comment) {
		super();
		this.CommentId = CommentId;
		this.Comment = Comment;
	}

	public int getCommentId() {
		return CommentId;
	}

	public void setCommentId(int CommentId) {
		this.CommentId = CommentId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String Comment) {
		this.Comment = Comment;
	}

	@Override
	public String toString() {
		return "Comment [CommentId=" + CommentId + ", Comment=" + Comment + "]";
	}

}
