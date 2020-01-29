package com.app.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.Ngo;
import com.app.pojos.NgoAdd;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.pojos.Verification;

@Transactional
@Repository
public class NgoDao implements INgoDao 
{

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public NgoAdd addNgo(NgoAdd n) 
	{
		Ngo ngo=new Ngo(n.getNgoName());
		Address nAdd= new Address(n.getNgoCity(), n.getNgoState(), n.getCountry(), n.getNgoPhoneno());
		User use= new User(n.getName(), n.getEmail(), n.getPassword(), UserRole.NGO,Verification.NV);
		Address uAdd= new Address(n.getCity(), n.getState(), n.getCountry(), n.getPhoneno());
		sf.getCurrentSession().persist(ngo);
		sf.getCurrentSession().persist(nAdd);
		ngo.addAddress(nAdd);
		sf.getCurrentSession().persist(use);
		sf.getCurrentSession().persist(uAdd);
		ngo.addAddress(nAdd);
		return n;
	}

}
