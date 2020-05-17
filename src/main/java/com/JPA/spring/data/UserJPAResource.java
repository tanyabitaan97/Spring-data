package com.JPA.spring.data;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.JPA.spring.data.entity.Post;
import com.JPA.spring.data.entity.PostRepository;
import com.JPA.spring.data.entity.User;
import com.JPA.spring.data.entity.UserDAOService;
import com.JPA.spring.data.entity.UserRepository;

import net.bytebuddy.implementation.attribute.AnnotationAppender.Target.OnMethod;

@RestController
public class UserJPAResource {

	@Autowired
	UserDAOService userdao;
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	PostRepository porepo;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers()
	{
		
		return repo.findAll();
		
	}
	
	@PostMapping("/jpa/users/{id}")
	
	public ResponseEntity<User> retrieveUserById( @PathVariable Long id) 
	{
		
		Optional<User> user=repo.findById(id);
		
		/*
		 * EntityModel<User> model=new EntityModel<>(user.get()); WebMvcLinkBuilder
		 * wb=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		 * model.add(wb.withRel("all-users"));
		 * 
		 * return model;
		 */
		
		
		  HttpHeaders headers = new HttpHeaders(); headers.add("Responded",
		  "UserJPAResource"); return
		  ResponseEntity.accepted().headers(headers).body(user.get());
		 
		
	}
	
	@DeleteMapping("/jpa/delete/{id}")
	public void deleteUserById( @PathVariable Long id) 
	{
		
		repo.deleteById(id);
		
		
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User userBody) 
	{
		
		User user=repo.save(userBody);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping("/jpa/{id}/posts")
	public List<Post> saveUser(@PathVariable Long id) 
	{
		
		Optional<User> user=repo.findById(id);
		return user.get().getPosts();
		
	}
	
	@PostMapping("/jpa/{id}/posts/users")
	public Post saveUser(@PathVariable Long id, @RequestBody Post post) 
	{
		
		Optional<User> user=repo.findById(id);
		User user1=user.get();
		post.setUser(user1);
		
		Post post2=porepo.save(post);
		
		return post2;
		
		
		
	}
	
	
	
	
}
