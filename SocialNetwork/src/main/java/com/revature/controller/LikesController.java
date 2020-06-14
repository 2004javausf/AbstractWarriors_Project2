package com.revature.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Likes;
import com.revature.entity.Message;
import com.revature.entity.Post;
import com.revature.service.LikesService;
import com.revature.service.PostService;


@RestController
@RequestMapping("/likes")
public class LikesController {
	
	@Autowired
	LikesService ls;
	
	@Autowired
	PostService ps;
	
	@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/addlike", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Likes ic (@RequestBody Likes like) {
    	Optional<Likes> ol = ls.findLikesByPostIdAndUserId(like.getPostId(), like.getUserId());
    	
    	if(ol.isPresent()== true) {
    		return null;
    	}
    	else {
    	
    		Post p = ps.findPostByPostId(like.getPostId());
    		int nl = p.getNumOfLikes();
    		p.setNumOfLikes(nl+1);
    		ps.updatePost(p);
    		return this.ls.insertLikes(like);
    	}
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findlikes", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Optional<Likes> lup (@RequestBody Likes like) {
    	System.out.println(like);
    	return this.ls.findLikesByPostIdAndUserId(like.getPostId(), like.getUserId());
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public Message handleException(NullPointerException e) {
		return new Message("SORRY! UNABLE TO PROCESS YOUR REQUEST!");
		
	}
	
}
