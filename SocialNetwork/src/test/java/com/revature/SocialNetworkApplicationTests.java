package com.revature;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.CommentController;
import com.revature.controller.UsersController;
import com.revature.entity.Comment;
import com.revature.entity.Users;

@SpringBootTest
@RunWith(SpringRunner.class)
class SocialNetworkApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	@Autowired
	UsersController uc;
	
	@Autowired
	CommentController cc;
	
	@Test
	public void testLogin() throws Exception {
	String username = "Vee";
	String password = "pass";
	Users user = new Users();
	
	user.setUsername(username);
	user.setPassword(password);
	Optional<Users> ou = uc.login(user);
	
    assertTrue(ou.isPresent()==true);
	}
	
	@Test
	public void testFindUsername() throws Exception {
		Users user = new Users();
		user.setUsername("Vee");
		Users user1 = uc.uu(user);
		assertTrue(user1.getUsername().equals(user.getUsername()));
	}
	
	@Test
	public void findCommentByPostId() throws Exception{
		Comment comment = new Comment();
		List<Comment> comm;
		comment.setPostId(6);
		comm = cc.up(comment);
		assertTrue(comm.size() != 0);
	}


}
