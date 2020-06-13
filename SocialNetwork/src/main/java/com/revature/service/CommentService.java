package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CommentDAO;
import com.revature.entity.Comment;

@Service
public class CommentService {
	
	@Autowired
	CommentDAO cd;
	
	public Comment insertComment (Comment comment) {
		return this.cd.save(comment);
	}
	
	public List<Comment> findCommentsByPostId(long postId) {
		return cd.findCommentByPostId(postId);
	}
	

}
