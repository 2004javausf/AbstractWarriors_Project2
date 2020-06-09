package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UsersDAO;
import com.revature.model.User;

@Service
public class UsersService {
	
	@Autowired
	UsersDAO ud;
	
	public User insertUser (User user) {
		return this.ud.save(user);
	}
	
	public List<User> findUsersByUsername (String username) {
		return ud.findUsersByUsername(username);
	}
		
	public List<User> findUsersByEmail(String email){
		return ud.findUsersByEmail(email);
	}
	
//	public List<User> findUsersByFirstName(String first_name){
//		return ud.findUsersByFirstName(first_name);
//	}
//	
//	public List<User> findUsersByLastName(String last_name){
//		return ud.findUsersByLastName(last_name);
//	}
//	
//	public List<User> findUsersByFullName(String fname, String lname){
//		return ud.findUsersByFullName(fname,lname);
//	}
}
