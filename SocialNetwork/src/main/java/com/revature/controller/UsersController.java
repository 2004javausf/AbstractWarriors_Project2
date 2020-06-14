package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.revature.entity.Likes;
import com.revature.entity.Message;
import com.revature.entity.Post;
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
    public Users uu (@RequestBody Users user) {
    	System.out.println(user);
    	return this.us.findByUsername(user.getUsername());
    }
    

	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Optional<Users> login (@RequestBody Users user) {
		Optional<Users> ou = us.login(user.getUsername(), user.getPassword());
    	if(ou.isPresent()== true) {
    		return ou;
    	}
    	else {
    	
    		return null;
    	}
    	
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/search", method = RequestMethod.POST, 
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Users> findUserByName (@RequestBody Users user) {
    	return this.us.findUserByName(user.getFirstName());
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/altlogin", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users altLogin (@RequestBody Users user){
		return this.us.altLogin(user.getUsername(), user.getEmail());
    }
    

	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/changepassword", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users changepassword (@RequestBody Users user) {
    	System.out.println(user);
    	return this.us.changepassword(user);
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/forgetpassword", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Users forgetpassword (@RequestBody Users user) {
    	System.out.println(user);
    	return this.us.forgetpassword(user);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public Message handleException(NullPointerException e) {
		return new Message("SORRY! UNABLE TO PROCESS YOUR REQUEST!");
		
	}
	
    @ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/uploadimage")
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
	@RequestMapping(value = "/getimage", method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<byte[]> getProfilePic(@RequestBody Users username) {
    	return this.us.getProfilePic(username.getUsername());
    }
	
}
