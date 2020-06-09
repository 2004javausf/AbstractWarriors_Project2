package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	
	 @Column(name = "ID")
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 @Column(name = "USERNAME")
	 private String username;
	 @Column(name = "PASSWORD")
	 private String password;
	 
	 
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Users(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	 
	 
	 
}