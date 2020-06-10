package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UsersDAO;
import com.revature.entity.Users;

@Service
public class UsersService {
	
	@Autowired
	UsersDAO ud;
	
	public Users insertUser (Users user) {
		return this.ud.save(user);
	}
	
	public List<Users> findByUsername (String username) {
		return ud.findUsersByUsername(username);
	}
	
	public List<Users> login (String username, String password){
		return ud.findUsersByUsernameAndPassword(username, password);
	}
	
	public List<Users> findUserByName(String firstName){
		return ud.findUsersByFirstName(firstName);
	}
	
	public List<Users> altLogin (String username, String email) {
		return ud.findUsersByUsernameAndEmail(username, email);
	}
	
	public Users proImg (long id, String profileImage) {
		System.out.println(id);
		Users user1 = ud.getOne(id);
		user1.setProfileImage(profileImage);
		return this.ud.save(user1);
	}
}
