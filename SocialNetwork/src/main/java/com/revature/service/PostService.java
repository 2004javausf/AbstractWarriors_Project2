package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDAO;
import com.revature.entity.Post;


@Service
public class PostService {

	@Autowired
	PostDAO pd;
	
	public Post insertPost (Post post) {
		return this.pd.save(post);
	}
	
	public List<Post> findPostByUserId (long userId) {
		return pd.findPostByUserId(userId);
	
	}
	
	public List<Post> findAllPosts(){
		return pd.findAll();
	}
 }