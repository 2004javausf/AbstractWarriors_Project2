package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.entity.Message;
import com.revature.entity.Users;
import com.revature.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService us;
	
	@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users iu (@RequestBody Users user) {
        return this.us.insertUser(user);
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/finduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users uu (@RequestBody Users username) {
    	System.out.println(username);
    	Users u = new Users();
    	u = username;
    	System.out.println(u);
    	return this.us.findByUsername(u.getUsername());
    }
    

	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users login (@RequestBody Users username, Users password) {
    	Users u = new Users();
    	u = username;
    	return this.us.login(u.getUsername(), u.getPassword());
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/search", method = RequestMethod.POST, 
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Users> findUserByName (@RequestBody Users firstName) {
    	Users u = new Users();
    	u = firstName;
    	return this.us.findUserByName(u.getFirstName());
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/altlogin", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users altLogin (@RequestBody Users username, Users email){
    	Users u = new Users();
    	u = username;
    	return this.us.altLogin(u.getUsername(), u.getEmail());
    }
    

	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/changepassword", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users changepassword (@RequestBody Users userFromRest) {
    	System.out.println(userFromRest);
    	return this.us.changepassword(userFromRest);
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/forgetpassword", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users forgetpassword (@RequestBody Users userFromRest) {
    	System.out.println(userFromRest);
    	return this.us.forgetpassword(userFromRest);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public Message handleException(NullPointerException e) {
		return new Message("SORRY! UNABLE TO PROCESS YOUR REQUEST!");
		
	}
	
    @ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/uploadimg")
	public List<String> uploadProfilePic(@RequestParam("username") String username, @RequestParam("profileImage") MultipartFile file) throws IOException{
		List<String> rtrn = new ArrayList<String>();
		Users user = this.us.findByUsername(username);
		System.out.println(username);
        user.setProfileImage(file.getBytes());
		this.us.insertUser(user);
		rtrn.add("Successfully updated profile img");
		return rtrn;
	}
	
    @ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/getimg", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<byte[]> getProfilePic(@RequestBody Users username) {
    	return this.us.getProfilePic(username.getUsername());
    }
	
}
