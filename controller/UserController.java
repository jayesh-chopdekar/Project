package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IMessageDao;
import com.app.daos.IUserDao;
import com.app.pojos.Message;
import com.app.pojos.SendMsg;
import com.app.pojos.User;
import com.app.pojos.UserAdd;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	IUserDao dao;
	@Autowired
	IMessageDao mdao;
	
	@PostMapping("/login")
	public ResponseEntity<?> validate(@RequestBody User usr)
	{
		try
		{
			User u=dao.validateUser(usr.getEmail(),usr.getPassword());
			UserAdd use=new UserAdd();
			use.setId(u.getId());
//			use.setCity(u.getAddId().getCity());
//			use.setState(u.getAddId().getState());
//			use.setCountry(u.getAddId().getCountry());
//			use.setPhoneno(u.getAddId().getPhoneno());
			use.setEmail(u.getEmail());
			use.setPassword(u.getPassword());
			use.setName(u.getName());
			use.setRole(u.getRole());
			use.setVer(u.getVer());
			return new ResponseEntity<UserAdd>(use, HttpStatus.OK);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
	}
	@GetMapping("/inbox/{id}")
	public ResponseEntity<?> inbox(@PathVariable Integer id)
	{
		List<Message> inbox = mdao.inbox(id);
		if(inbox!=null)
			return new ResponseEntity<List<Message>>(inbox,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/send")
	public ResponseEntity<?> send(@RequestBody SendMsg m)
	{
		boolean sendmsg = mdao.sendmsg(m);
		if(sendmsg==true)
			return new ResponseEntity<Boolean>(sendmsg,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
