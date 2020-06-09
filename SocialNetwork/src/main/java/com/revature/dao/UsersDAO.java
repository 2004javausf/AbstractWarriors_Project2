package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;


@Repository
public interface UsersDAO extends JpaRepository<User, Long>{

	public List<User> findUsersByUsername(String username);
	
	public List<User> findUsersByEmail(String email);
	
//	public List<User> findUsersByFirstName(String first_name);
//	
//	public List<User> findUsersByLastName(String last_name);
	
//	public List<User> findUsersByFullName(String fname, String lname);
}
