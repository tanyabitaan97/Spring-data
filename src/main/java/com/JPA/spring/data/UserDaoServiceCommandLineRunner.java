package com.JPA.spring.data;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.JPA.spring.data.entity.Post;
import com.JPA.spring.data.entity.User;
import com.JPA.spring.data.entity.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {


	@Autowired
	UserDAOService userDAOService;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 * User user =new User("Jack","Admin"); User user1 =new User("saloni","Admin");
		 * Post post1=new Post("ddd",user); Post post2=new Post("aaaa",user);
		 * 
		 * userDAOService.insert(user); userDAOService.insert(user1);
		 * userDAOService.insert(post1); userDAOService.insert(post2);
		 * 
		 * System.out.println(user);
		 */
		
	}

}
