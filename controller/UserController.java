package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IUserDao;
import com.app.pojos.User;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	IUserDao dao;
	
	@PostMapping("/login")
	public ResponseEntity<?> validate(@RequestBody User usr)
	{
		User u=dao.validateUser(usr.getEmail(),usr.getPassword());
		if(u!=null)
			return new ResponseEntity<User>(u, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
