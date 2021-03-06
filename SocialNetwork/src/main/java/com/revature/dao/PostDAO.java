package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Long>{
	
	public List<Post> findPostByUserId(long userId);
	
	public List<Post> findPostByOrderByDateDesc();
	
	public Post findPostByPostId (long postId);
	
}
