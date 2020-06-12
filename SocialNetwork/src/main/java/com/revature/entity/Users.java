package com.revature.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	 @Column(name = "USERNAME", nullable=false, unique=true)
	 private String username;
	 @Column(name = "PASSWORD")
	 private String password;
	 @Column(name = "EMAIL", nullable=false, unique=true)
	 private String email;
	 @Temporal(TemporalType.DATE)
	 @Column(name = "DATE_OF_BIRTH")
	 private Date dateOfBirth;
	 @Column(name = "PROFILE_IMAGE", nullable = true, columnDefinition="BLOB")
	 private byte[] profileImage;
	 

	 @OneToMany
	 @JoinTable(name="Users_Post")
//	 @JsonIgnore
	 private List<Post> likedPosts;
	 
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String firstName, String lastName, String username, String password, String email, Date dateOfBirth,
			byte[] profileImage) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.profileImage = profileImage;
	}
	
	


	public Users(String firstName, String lastName, String username, String password, String email, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	

	public Users(String username) {
		super();
		this.username = username;
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

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", profileImage="
				+ Arrays.toString(profileImage) + "]";
	}
	
}