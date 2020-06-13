package com.revature.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.entity.Post;
import com.revature.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService ps;
	
    @PostMapping(value = "/addpost")
    @ResponseBody()
    public String insertPost (@RequestParam("message") String message, @RequestParam("postImage") MultipartFile image, @RequestParam("userId") int userId) {
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
    
    @RequestMapping(value = "/findallposts", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Post> up () {
    	System.out.println("In findallposts Controller Method");
    	return this.ps.findAllPosts();
    }
    
}
