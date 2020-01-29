package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IPoliceDao;
import com.app.pojos.PoliceAdd;
import com.app.pojos.UserAdd;
import com.app.pojos.VicAdd;
import com.app.pojos.Victim;

@CrossOrigin
@RestController
@RequestMapping("/police")
public class PoliceController
{
	@Autowired
	IPoliceDao dao;
	
	@PostMapping("/regcase")
	public ResponseEntity<?> regCase(@RequestBody VicAdd v)
	{
		VicAdd vic=dao.registerCase(v);
		if(vic!=null)
			return new ResponseEntity<VicAdd>(v,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/showcases")
	public ResponseEntity<?> showCases()
	{
		List<Victim> allCases = dao.showAllCases();
		if(allCases.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Victim>>(allCases,HttpStatus.OK);
	}
	@GetMapping("/search/{name}")
	public ResponseEntity<?> search(@PathVariable String name)
	{
		List<Victim> v=dao.searchByName(name);
		if(!v.isEmpty())
			return new ResponseEntity<List<Victim>>(v,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/poladd")
	public ResponseEntity<?> addPolice(@RequestBody PoliceAdd p)
	{
		PoliceAdd pol=dao.addPolice(p);
		if(pol!=null)
			return new ResponseEntity<PoliceAdd>(p,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/editpol/{id}")
	public ResponseEntity<?> editPolice(@PathVariable Integer id,@RequestBody UserAdd p)
	{
		UserAdd pol=dao.editPolice(id, p);
		if(pol!=null)
			return new ResponseEntity<UserAdd>(p,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
