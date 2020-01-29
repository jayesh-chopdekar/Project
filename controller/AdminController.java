package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IAdminDao;
import com.app.pojos.User;
import com.app.pojos.UserAdd;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	IAdminDao dao;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody UserAdd u)
	{
		UserAdd use=dao.addUser(u);
		if(use!=null)
			return new ResponseEntity<UserAdd>(use,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);	
	}
	
	@GetMapping("/showusers")
	public ResponseEntity<?> showUsers()
	{
		List<User> ul=dao.showAllUsers();
		if(ul.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(ul,HttpStatus.OK);
	}

	@CrossOrigin(methods = RequestMethod.DELETE)
	 @DeleteMapping("/deluser/{id}")
	 public ResponseEntity<?> deleteUser(@PathVariable Integer id)
	 { 
		 try 
		 {
			 dao.remUser(id);
			 return new ResponseEntity<Void>(HttpStatus.OK);
		 }
		 catch(Exception e) 
		 {
			 e.printStackTrace();
			 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 } 
	}
	 
	 @PutMapping("/edituser/{id}")
	 public ResponseEntity<?> editUser(@PathVariable Integer id,@RequestBody UserAdd u) 
	 { 
		 UserAdd user = dao.editUser(id, u);
		 if(user!=null) 
			 return new ResponseEntity<UserAdd>(u,HttpStatus.OK); 
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
	 }
	
	 @GetMapping("/searchuser/{name}")
	 public ResponseEntity<?> searchUser(@PathVariable String name)
	 {
		 List<User> u=dao.searchUser(name);
		 if(u.isEmpty())
			 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 return new ResponseEntity<List<User>>(u,HttpStatus.OK);
	 }
	 @GetMapping("/request")
	 public ResponseEntity<?> request()
	 {
		 List<User> u=dao.getRequest();
		 if(u.isEmpty())
			 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 return new ResponseEntity<List<User>>(u,HttpStatus.OK);
	 }
	 @GetMapping("/verify/{uid}")
	 public ResponseEntity<?> verify(@PathVariable Integer uid)
	 {
		 try
		 {
			 dao.verifyUser(uid);
			 return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		 }
		 catch (Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 }
	 }
}
