package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.User;
import com.app.pojos.UserAdd;
import com.app.pojos.Verification;


@Repository
@Transactional
public class AdminDao implements IAdminDao 
{
	@Autowired
	SessionFactory sf;
	@Override
	public UserAdd addUser(UserAdd u) 
	{
		User user= new User(u.getName(), u.getEmail(), u.getPassword(), u.getRole(),Verification.NV);
		Address add=new Address(u.getCity(), u.getState(), u.getCountry(), u.getPhoneno());
		sf.getCurrentSession().persist(add);
		sf.getCurrentSession().persist(user);
		user.addAddress(add);
		return u;
	}
	@Override
	public List<User> showAllUsers() 
	{
		String jpql="Select u from User u";
		List<User> uList=sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
		return uList;
	}
	@Override
	public void remUser(Integer id) 
	{
		User user = sf.getCurrentSession().get(User.class, id);
		sf.getCurrentSession().delete(user.getAddId());
		user.remAddress(user.getAddId());
		sf.getCurrentSession().delete(user);
	}
	@Override
	public UserAdd editUser(Integer id,UserAdd u)
	{
		User user= sf.getCurrentSession().get(User.class, id);
		user.setName(u.getName());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		user.getAddId().setCity(u.getCity());
		user.getAddId().setState(u.getState());
		user.getAddId().setCountry(u.getCountry());
		user.getAddId().setPhoneno(u.getPhoneno());
		return u;
	}
	@Override
	public List<User> searchUser(String name) 
	{
		String jpql="select u from User u where u.name=:na";
		List<User> u=sf.getCurrentSession().createQuery(jpql, User.class).setParameter("na", name).getResultList();
		return u;
	}
	@Override
	public void verifyUser(Integer id) 
	{
		User user = sf.getCurrentSession().get(User.class, id);
		user.setVer(Verification.V);
		
	}
	@Override
	public List<User> getRequest() 
	{
		String jpql="select u from User u where u.ver=:ver";
		List<User> u = sf.getCurrentSession().createQuery(jpql, User.class).setParameter("ver", Verification.NV).getResultList();
		return u;
	}
	
	
}
