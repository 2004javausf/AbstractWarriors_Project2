package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkApplication.class, args);
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		addSomeUsers(ac);
		

	}
	
//	static void addSomeUsers(ApplicationContext ac) {
//		Users u1= new Users("Jordan", "Parker", "jpark1914","password", "parkerj4321@gmail.com", 7241992, "autobiorgaphy by me", "an image");
//		Users u2= new Users("Veenay", "Patel", "vinnyP","password", "veeMeagain@gmail.com", 3441992, "autobiorgaphy by vee", "an image of vee");
//	
//	
//		UsersDAO gd=(UsersDAO)ac.getBean("usersDAO");
//		gd.save(u1);
//		gd.save(u2);
//	}

}
