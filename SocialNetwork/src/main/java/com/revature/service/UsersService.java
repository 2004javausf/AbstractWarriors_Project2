package com.revature.service;

import java.util.ArrayList;
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
	
	public Users findByUsername (String username) {
		return ud.findUsersByUsername(username);
	}
	
	public Users login (String username, String password){
		return ud.findUsersByUsernameAndPassword(username, password);
	}
	
	public List<Users> findUserByName(String firstName){
		return ud.findUsersByFirstName(firstName);
	}
	
	
	public Users changepassword (Users userFromRest) {
		Optional<Users> userFromDb = ud.findById(userFromRest.getId());
		Users user = userFromDb.get();
		user.setPassword(userFromRest.getPassword());
		return this.ud.save(user);
	}
	
	public Users forgetpassword (Users userFromRest) {
		Users userFromDb = ud.findUsersByUsernameAndEmail(userFromRest.getUsername(), userFromRest.getEmail());
		Users user = userFromDb;
		user.setPassword(userFromRest.getPassword());
		return this.ud.save(user);
	}
	
	public List<byte[]> getProfilePic(String username){
		List<byte[]> images = new ArrayList<byte[]>();
		Users user = this.ud.findUsersByUsername(username);
		images.add(user.getProfileImage());
		return images;
	}

}
