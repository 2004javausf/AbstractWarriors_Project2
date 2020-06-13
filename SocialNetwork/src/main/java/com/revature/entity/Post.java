package com.revature.entity;

import java.time.LocalDate;
import java.util.Date;
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
	
	@Column(name="DATE_SUBMITTED", columnDefinition="TimeStamp")
	private Date date;
	
	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Image> images;

//	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
//	@Fetch(value = FetchMode.SUBSELECT)
//	@JsonIgnore
//	private List<Comment> comments;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
//	@JoinColumn(name="USERNAME", nullable = false)
//	private Users user;
	
	@Column(name="USER_ID")
	private long userId;

	@OneToMany(mappedBy="likedPosts", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
//	@JsonIgnore
	private List<Users> likers;

	public Date getDate() {
		return date;
	}

	public void setDate(Date localDate) {
		this.date = localDate;
	}
	
	public Post() {
		super();
	}
	
	public Post(String message, List<Image> images, int numOfLikes) {
		super();
		this.message = message;
		this.images = images;
		this.numOfLikes = numOfLikes;
	}

	public Post(long postId, String message, int numOfLikes, Date date, List<Image> images, long userId) {
		super();
		this.postId = postId;
		this.message = message;
		this.numOfLikes = numOfLikes;
		this.date = date;
		this.images = images;
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

//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", message=" + message + ", images=" + images + ", numOfLikes=" + numOfLikes
				+ ", user=" + userId + "]";
	}
}
