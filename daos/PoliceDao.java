package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.Police;
import com.app.pojos.PoliceAdd;
import com.app.pojos.User;
import com.app.pojos.UserAdd;
import com.app.pojos.UserRole;
import com.app.pojos.Verification;
import com.app.pojos.VicAdd;
import com.app.pojos.Victim;

@Repository
@Transactional
public class PoliceDao implements IPoliceDao
{
	@Autowired
	SessionFactory sf;
	@Override
	public VicAdd registerCase(VicAdd v) 
	{
		Address add=new Address(v.getCity(), v.getState(),v.getCountry(),v.getPhno());
		Victim vic=new Victim(v.getAge(), v.getName(), v.getBgrp(), v.getCmpNo(), v.getHeight(), v.getDob(), v.getMissingDate(),v.getGender());
		sf.getCurrentSession().persist(vic);
		sf.getCurrentSession().persist(add);
		vic.addAddress(add);
		return v;
	}
	@Override
	public List<Victim> showAllCases() 
	{
		String jpql="select v from Victim v";
		List<Victim> vicList=sf.getCurrentSession().createQuery(jpql, Victim.class).getResultList();		
		return vicList;
		
	}
	@Override
	public List<Victim> searchByName(String name) 
	{
		String jpql="Select v from Victim v where name=:na";
		List<Victim> v=sf.getCurrentSession().createQuery(jpql, Victim.class).setParameter("na", name).getResultList();
		return v;
	}
	@Override
	public PoliceAdd addPolice(PoliceAdd p) 
	{
		User use= new User(p.getName(), p.getEmail(), p.getPassword(), UserRole.POLICE,Verification.NV);
		Address uAdd=new Address(p.getCity(), p.getState(), p.getCountry(), p.getPhoneno());
		Police pol=new Police(p.getDeptName());
		Address pAdd= new Address(p.getDeptCity(), p.getCountry(), p.getDeptCountry(), p.getDeptPhoneno());
		sf.getCurrentSession().persist(pol);
		sf.getCurrentSession().persist(pAdd);
		pol.addAddress(pAdd);
		sf.getCurrentSession().persist(use);
		sf.getCurrentSession().persist(uAdd);
		use.addPolice(pol);
		use.addAddress(uAdd);
		return p;
	}
	@Override
	public UserAdd editPolice(Integer id, UserAdd p) 
	{

		User u=sf.getCurrentSession().get(User.class, id);
		u.setName(p.getName());
		u.setEmail(p.getEmail());
		u.setPassword(p.getPassword());
		u.getAddId().setCity(p.getCity());
		u.getAddId().setState(p.getState());
		u.getAddId().setCountry(p.getCountry());
		u.getAddId().setPhoneno(p.getPhoneno());
		return p;
	}
	
}
