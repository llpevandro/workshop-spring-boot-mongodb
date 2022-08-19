package com.llpevandro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llpevandro.workshopmongo.domain.Users;
import com.llpevandro.workshopmongo.dto.UsersDTO;
import com.llpevandro.workshopmongo.repository.UsersRepository;
import com.llpevandro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;	

	public List<Users> findAll() {
		return repo.findAll();
	}

	public Users findById(String id) {
		Optional<Users> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public Users insert(Users obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		repo.deleteById(id);		
	}
	
	public Users fromDTO(UsersDTO objDto) {
		return new Users(objDto.getId(), objDto.getEmail(), objDto.getName());
	}
}
