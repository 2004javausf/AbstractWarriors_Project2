package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Post;
import com.revature.entity.Users;
import com.revature.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService ps;
	
    @RequestMapping(value = "/addpost", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Post ip (@RequestBody Post post) {
        return this.ps.insertPost(post);
    }
    
    @RequestMapping(value = "/findposts", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Post> up (@RequestBody Users user) {
    	System.out.println(user);
    	Users u = new Users();
    	u = user;
    	System.out.println(u);
    	return this.ps.findPostsByUserID(u.getId());
    }
    
}
