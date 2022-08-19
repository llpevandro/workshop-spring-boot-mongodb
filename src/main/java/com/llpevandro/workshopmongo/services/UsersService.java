package com.llpevandro.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llpevandro.workshopmongo.domain.Users;
import com.llpevandro.workshopmongo.repository.UsersRepository;

@Service
public class UsersService {
	
		@Autowired
	private UsersRepository repo;
		
		
	public List<Users> findAll(){
		return repo.findAll();		
	}
}
