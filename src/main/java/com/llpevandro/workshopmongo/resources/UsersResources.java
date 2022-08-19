package com.llpevandro.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.llpevandro.workshopmongo.domain.Users;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Users>> findAll() {
		Users maria = new Users("1", "Maria Brown", "maria@gmail.com");
		Users alex = new Users("1", "Alex Green", "alex@gmail.com");
		List <Users> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
}
