package com.revature.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Users;

@Repository
public interface UsersDAO extends CrudRepository<Users, String>{
	public List<Users> findUserByUsername(String username);
	
	@SuppressWarnings("unchecked")
	public Users save(Users user);
	
}
