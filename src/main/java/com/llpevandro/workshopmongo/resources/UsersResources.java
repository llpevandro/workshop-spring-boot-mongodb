package com.llpevandro.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.llpevandro.workshopmongo.domain.Users;
import com.llpevandro.workshopmongo.services.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

	@Autowired
	private UsersService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Users>> findAll() {
		
		List <Users> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
