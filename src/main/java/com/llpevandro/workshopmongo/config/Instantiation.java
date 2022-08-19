package com.llpevandro.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.llpevandro.workshopmongo.domain.Users;
import com.llpevandro.workshopmongo.repository.UsersRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsersRepository usersRepository;	
	
	@Override
	public void run(String... args) throws Exception {		
		
		usersRepository.deleteAll();
		
		Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
		Users alex = new Users(null, "Alex Green", "alex@gmail.com");
		Users bob = new Users(null, "Bob Grey", "bob@gmail.com");
		
		usersRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
