package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Comment;


@Repository
public interface CommentDAO extends CrudRepository<Comment, String>, JpaRepository<Comment, String>{

	@SuppressWarnings("unchecked")
	public Comment save(Comment comment);
}
