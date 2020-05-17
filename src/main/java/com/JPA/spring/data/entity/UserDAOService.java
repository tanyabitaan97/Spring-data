package com.JPA.spring.data.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class UserDAOService {

	public UserDAOService()
	{
	System.out.println("call service");
	}
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//To save the user
	public long insert(User user)
	{
		entityManager.persist(user);
		return user.getId();
	}

}
