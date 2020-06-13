package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Comment;
import com.revature.entity.Post;
import com.revature.service.CommentService;


@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService cs;
    @RequestMapping(value = "/addcomment", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Comment ic (@RequestBody Comment comment) {
        return this.cs.insertComment(comment);
    }
    
    @RequestMapping(value = "/findcomments", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public List<Comment> up (@RequestBody Comment postId) {
    	System.out.println(postId);
    	Comment c = new Comment();
    	c = postId;
    	System.out.println(c);
    	return this.cs.findCommentsByPostId(c.getPostId());
    }
}
