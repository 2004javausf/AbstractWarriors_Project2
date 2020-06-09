package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.UsersDAO;
import com.revature.entity.Users;
import com.revature.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService us;
    @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users iu (@RequestBody Users user) {
        return this.us.insertUser(user);
    }
    
    @RequestMapping(value = "/finduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Users> uu (@RequestBody Users username) {
    	System.out.println(username);
    	Users u = new Users();
    	u = username;
    	System.out.println(u);
    	return this.us.findByUsername(u.getUsername());
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Users> login (@RequestBody Users username, Users password){
    	Users u = new Users();
    	u = username;
    	return this.us.login(u.getUsername(), u.getPassword());
    }
    
    @RequestMapping(value ="/search", method = RequestMethod.POST, 
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Users> findUserByName (@RequestBody Users firstName) {
    	Users u = new Users();
    	u = firstName;
    	return this.us.findUserByName(u.getFirstName());
    }
    
    @RequestMapping(value ="/altlogin", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Users> altLogin (@RequestBody Users username, Users email){
    	Users u = new Users();
    	u = username;
    	return this.us.altLogin(u.getUsername(), u.getEmail());
    }
    
    @RequestMapping(value ="/proimg", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users proimg (@RequestBody long id, String profileImage) {
    	long id1 = id;
    	System.out.println(id1);
    	System.out.println(profileImage);
    	return this.us.proImg(id1, profileImage);
    }
}
