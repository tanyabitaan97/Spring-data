package com.JPA.spring.data;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.JPA.spring.data.entity.Post;
import com.JPA.spring.data.entity.PostRepository;
import com.JPA.spring.data.entity.User;
import com.JPA.spring.data.entity.UserDAOService;
import com.JPA.spring.data.entity.UserRepository;

@Component
public class UserRepositoryServiceCommandLineRunner implements CommandLineRunner {


	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository po;
	
	@Override
	public void run(String... args) throws Exception 
	{
		User user =new User("Jack","Admin");
		User user1 =new User("saloni","Admin");
		Post post1=new Post("ddd",user);
		Post post2=new Post("aaaa",user);

		userRepository.save(user1);
		userRepository.save(user);
		
	po.save(post1);
	po.save(post2);
		userRepository.findById(1L);
		userRepository.findAll();
		System.out.println(user1);
		
		
	}

}
