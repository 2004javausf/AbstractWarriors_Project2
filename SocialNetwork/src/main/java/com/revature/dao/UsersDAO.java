package com.revature.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.Users;


@Repository
public interface UsersDAO extends JpaRepository<Users, Long>{

	public Users findUsersByUsername(String username);
	
	public Users findUsersByUsernameAndPassword(String username, String password);
	
	public List<Users> findUsersByFirstName(String firstName);
	
	public Users findUsersByUsernameAndEmail(String username, String email);


}
