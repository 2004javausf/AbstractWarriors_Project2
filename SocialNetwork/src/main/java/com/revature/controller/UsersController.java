package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
import com.revature.repos.UsersDAO;

@RestController
@RequestMapping("/users/")
public class UsersController {
	
	private UsersDAO ud;
	
	@Autowired
	public UsersController(UsersDAO u) {
		this.ud = u;
	}
	
	
	@PostMapping("addUser.app")
	public void addUser(@RequestBody Users user) {
		ud.save(user);
	}

}


//@GetMapping("/id.app")
//public @ResponseBody ConfusedClowns getById(){
//	return cd.findById(2);
//}