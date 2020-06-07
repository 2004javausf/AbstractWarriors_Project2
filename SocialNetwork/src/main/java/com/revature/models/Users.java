package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Component("users")//generic stereotype for any spring managed component
@Scope("prototype")
@Entity
@Table(name="USERS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	@SequenceGenerator(name="userSequence", sequenceName="USER_SEQ", allocationSize=1)
	@Column(name="USER_ID")
	private long userid;
	
	@Column(name="FIRST_NAME")
	private String first_name;
	
	@Column(name="LAST_NAME")
	private String last_name;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="DATE_OF_BIRTH")
	private int date_of_birth;
	
	@Column(name="BIOGRAPHY")
	private String biography;
	
	@Column(name="PROFILE_IMAGE")
	private String profile_image;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	@JoinTable(name="USERS_FRIENDS",
		joinColumns={@JoinColumn(name="USER_ID")},
		inverseJoinColumns={@JoinColumn(name="FRIEND_ID")})
	private List<Users> friends;
	
	/* needed for self-join many to many */
	@ManyToMany(mappedBy="friends")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<Users> others;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	@JoinTable(name="LIKED_POSTS",
		joinColumns={@JoinColumn(name="USER_ID")},
		inverseJoinColumns={@JoinColumn(name="POST_ID")})
	private List<Post> likedPosts;

	public Users(String first_name, String last_name, String username, String password, String email, int date_of_birth,
			String biography, String profile_image) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.biography = biography;
		this.profile_image = profile_image;
	}
	
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public long getUserid() {
		return userid;
	}



	public void setUserid(long userid) {
		this.userid = userid;
	}



	public int getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(int date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getBiography() {
		return biography;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}


	public String getProfile_image() {
		return profile_image;
	}


	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {

		return "Users [userid=" + userid + ", first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", date_of_birth=" + date_of_birth + ", biography="
				+ biography + ", profile_image=" + profile_image + "]";
	}


	
	
	
}
