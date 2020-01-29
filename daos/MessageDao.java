package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.app.pojos.Message;
import com.app.pojos.SendMsg;
import com.app.pojos.User;

@Repository
@Transactional
public class MessageDao implements IMessageDao {

	@Autowired
	SessionFactory sf;
	@Override
	public List<Message> inbox(Integer id) 
	{
		String jpql="select u from User u where u.id=:id";
		User u=sf.getCurrentSession().createQuery(jpql, User.class).setParameter("id", id).getSingleResult();
		return u.getMsg();
	}
	@Override
	public boolean sendmsg(SendMsg m) 
	{
		try
		{
			String jpql="select u from User u where u.email=:em";
			User u = sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", m.getTo()).getSingleResult();
			if(u!=null)
			{
				String msg="From: "+m.getFrom()+"\n"+"Message: "+m.getMsg();
				Message message=new Message(msg);
				sf.getCurrentSession().persist(message);
				u.addMsg(message);
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
