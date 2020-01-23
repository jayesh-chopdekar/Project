package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.INgoDao;
import com.app.pojos.NgoAdd;

@RestController
@RequestMapping("/ngo")
public class NgoController 
{
	@Autowired
	INgoDao dao;
	
	@PostMapping("/ngoadd")
	public ResponseEntity<?> addNgo(@RequestBody NgoAdd n)
	{
		NgoAdd ngo=dao.addNgo(n);
		if(ngo!=null)
			return new ResponseEntity<NgoAdd>(ngo,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
