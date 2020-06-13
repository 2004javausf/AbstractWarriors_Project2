package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Comment;



@Repository
public interface CommentDAO extends JpaRepository<Comment, Long>{
	
	public List<Comment> findCommentByPostId(long postId);
}
