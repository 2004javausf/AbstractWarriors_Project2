package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Post;

@Repository
public interface PostDAO extends CrudRepository<Post, String>, JpaRepository<Post, String>{
	
	
	@SuppressWarnings("unchecked")
	public Post save(Post post);
}
