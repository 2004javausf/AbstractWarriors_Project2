package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService us;
    @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public User iu (@RequestBody User user) {
        return this.us.insertUser(user);
    }
    
    @RequestMapping(value = "/findbyusername", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<User> uu (@RequestBody User username) {
    	System.out.println(username);
    	User u = new User();
    	u = username;
    	return this.us.findUsersByUsername(u.getUsername());
    }
    
    @RequestMapping(value = "/findbyemail", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<User> ue (@RequestBody User email) {
    	System.out.println(email);
    	User u = new User();
    	u = email;
    	return this.us.findUsersByEmail(u.getEmail());
    }
    
//    @RequestMapping(value = "/findbyfirstname", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody()
//    public List<User> uf (@RequestBody User first_name) {
//    	System.out.println(first_name);
//    	User u = new User();
//    	u = first_name;
//    	return this.us.findUsersByFirstName(u.getFirst_name());
//    }
//    
//    @RequestMapping(value = "/findbylastname", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody()
//    public List<User> ul (@RequestBody User last_name) {
//    	System.out.println(last_name);
//    	User u = new User();
//    	u = last_name;
//    	return this.us.findUsersByLastName(u.getLast_name());
//    }
//    
//    @RequestMapping(value = "/findbyfullname", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody()
//    public List<User> ufull (@RequestBody User fullname) {
//    	System.out.println(fullname);
//    	User u = new User();
//    	u = fullname;
//    	return this.us.findUsersByFullName(u.getFirst_name(),u.getLast_name());
//    }
}

