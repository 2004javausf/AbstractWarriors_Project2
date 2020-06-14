package com.revature.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Likes;

@Repository
public interface LikesDAO extends JpaRepository<Likes, Long> {
	
	public Optional<Likes> findLikesByPostIdAndUserId(long postId, long userId);
}
