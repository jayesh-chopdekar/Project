package com.app.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;

@Repository
@Transactional
public class UserDao implements IUserDao 
{	
	@Autowired
	SessionFactory sf;
	@Override
	public User validateUser(String email, String pass) 
	{
		String jpql="select u from User u where u.email=:email and u.password=:pass";
		User usr=sf.getCurrentSession().createQuery(jpql, User.class).setParameter("email", email).setParameter("pass", pass).getSingleResult();
		return usr;
	}
	
}
