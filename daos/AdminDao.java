package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.User;
import com.app.pojos.UserAdd;


@Repository
@Transactional
public class AdminDao implements IAdminDao 
{
	@Autowired
	SessionFactory sf;
	@Override
	public UserAdd addUser(UserAdd u) 
	{
		User user= new User(u.getName(), u.getEmail(), u.getPassword(), u.getRole());
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
		String jpql="select a from Address a where uId=:id";
		Address  add= sf.getCurrentSession().createQuery(jpql, Address.class).setParameter("id", id).getSingleResult();
		sf.getCurrentSession().delete(add);
		sf.getCurrentSession().delete(user);
		user.remAddress(add);
	}
	@Override
	public UserAdd editUser(Integer id,UserAdd u)
	{
		User user= sf.getCurrentSession().get(User.class, id);
		user.setName(u.getName());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		String jpql="select a from Address a where uId=:id";
		Address  add= sf.getCurrentSession().createQuery(jpql, Address.class).setParameter("id", id).getSingleResult();
		add.setCity(u.getCity());
		add.setState(u.getState());
		add.setCountry(u.getCountry());
		add.setPhoneno(u.getPhoneno());
		sf.getCurrentSession().saveOrUpdate(user);
		sf.getCurrentSession().saveOrUpdate(add);
		return u;
	}
}
