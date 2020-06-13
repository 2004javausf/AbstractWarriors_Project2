package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LikesDAO;
import com.revature.entity.Likes;

@Service
public class LikesService {
	
	@Autowired
	LikesDAO ld;
	
	public Likes insertLikes(Likes like) {
		return this.ld.save(like);
	}
	
	public Optional<Likes> findLikesByPostIdAndUserId (long postId, long userId) {
		return ld.findLikesByPostIdAndUserId(postId, userId);
	}
}
