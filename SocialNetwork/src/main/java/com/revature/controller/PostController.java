package com.revature.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.entity.Message;
import com.revature.entity.Post;
import com.revature.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService ps;
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/addpost")
    @ResponseBody()
    public String insertPost (@RequestPart("message") String message, @RequestPart("postImage") MultipartFile image, @RequestPart("userId") int userId) {
    	String rtrn = null;
    	try {
			Post p = new Post();
			p.setMessage(message);
			p.setPostImages(image.getBytes());
			p.setUserId(userId);
			
			Date date = new Date();
			System.out.println(date);
			p.setDate(date);
			
			this.ps.insertPost(p);
			rtrn="Post created successfully";
			
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtrn;
		
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findposts", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Post> up (@RequestBody Post userId) {
    	System.out.println(userId);
    	Post p = new Post();
    	System.out.println(p);
    	p=userId;
    	return this.ps.findPostByUserId(p.getUserId());
    }
    
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findallposts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Post> up () {
    	System.out.println("In findallposts Controller Method");
    	return this.ps.findAllPosts();
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public Message handleException(NullPointerException e) {
		return new Message("SORRY! UNABLE TO PROCESS YOUR REQUEST!");
		
	}
    
}
