package com.revature.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_SUBMITTED")
	private Date date;
	
	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Image> images;

	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
//	@JsonIgnore
	private List<Comment> comments;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private Users user;

	@OneToMany(mappedBy="likedPosts", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
//	@JsonIgnore
	private List<Users> likers;
	
	public Post() {}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post(int postId, String message, List<Image> images, int numOfLikes, Users user) {
		super();
		this.postId = postId;
		this.message = message;
		this.images = images;
		this.numOfLikes = numOfLikes;
		this.user = user;
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public int getNumOfLikes() {
		return numOfLikes;
	}

	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", message=" + message + ", images=" + images + ", numOfLikes=" + numOfLikes
				+ ", user=" + user + "]";
	}
	

}
