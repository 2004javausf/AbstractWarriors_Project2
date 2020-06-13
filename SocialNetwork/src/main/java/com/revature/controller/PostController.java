package com.revature.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Post;
import com.revature.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService ps;
	
    @RequestMapping(value = "/addpost", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Post ip (@RequestBody Post p) {
		Date date = new Date();
		System.out.println(date);
		p.setDate(date);
		
        return this.ps.insertPost(p);
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
    	return this.ps.findAllPosts();
    }
    
}
