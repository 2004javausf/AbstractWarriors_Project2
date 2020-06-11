package com.revature.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="USERS")
public class Users {
	
	 @Column(name = "USER_ID")
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 @Column(name = "FIRST_NAME")
	 private String firstName;
	 @Column(name = "LAST_NAME")
	 private String lastName;
	 @Column(name = "USERNAME")
	 private String username;
	 @Column(name = "PASSWORD")
	 private String password;
	 @Column(name = "EMAIL")
	 private String email;

	 @Temporal(TemporalType.DATE)
	 @Column(name = "DATE_OF_BIRTH")
	 private Date dateOfBirth;
	 @Column(name = "PROFILE_IMAGE")
	 private String profileImage;
	 
	 @ManyToMany
	 @JoinTable(name="Users_Post")
//	 @JsonIgnore
	 private List<Post> likedPosts;
	 
	 public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(String firstName, String lastName, String username, String password, String email, Date dateOfBirth,
			String profileImage) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
	}



	public Users(long id, String firstName, String lastName, String username, String password, String email,
			Date dateOfBirth, String profileImage) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", profileImage="
				+ profileImage + "]";
	}
	
	
	 
	 
	
	 


	
	 
}