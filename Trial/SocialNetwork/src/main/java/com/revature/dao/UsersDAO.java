package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Users;


@Repository
public interface UsersDAO extends JpaRepository<Users, Long>{

	public List<Users> findUsersByUsername(String username);
	
	public List<Users> findUsersByUsernameAndPassword(String username, String password);
	
	public List<Users> findUsersByFirstName(String firstName);
	
	public List<Users> findUsersByUsernameAndEmail(String username, String email);

	
	

}