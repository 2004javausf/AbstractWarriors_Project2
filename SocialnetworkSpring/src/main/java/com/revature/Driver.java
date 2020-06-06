package com.revature;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

public class Driver {
static UserRepository up  = new UserRepositoryImpl();
	public static void main(String[] args) {
		
		UserServiceImpl usi = new UserServiceImpl(up);
		
		User me  = new User("Vee", "Patel", "it.veenaypatel@gmail.com", "vee", "Vee@123", "1994-10-19");		

		System.out.println(me);
		
		usi.registerUser(me);
//		System.out.println(up.findByUserEmail("it.veenaypatel@gmail.com").getfirst_name());
	}

}
