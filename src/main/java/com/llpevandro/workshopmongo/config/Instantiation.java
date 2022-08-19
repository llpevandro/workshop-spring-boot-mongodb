package com.llpevandro.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.llpevandro.workshopmongo.domain.Post;
import com.llpevandro.workshopmongo.domain.Users;
import com.llpevandro.workshopmongo.dto.AuthorDTO;
import com.llpevandro.workshopmongo.repository.PostRepository;
import com.llpevandro.workshopmongo.repository.UsersRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsersRepository usersRepository;	
	
	@Autowired
	private PostRepository postRepository;	
	
	@Override
	public void run(String... args) throws Exception {		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usersRepository.deleteAll();
		postRepository.deleteAll();
		
		Users maria = new Users(null, "Maria Brown", "maria@gmail.com");
		Users alex = new Users(null, "Alex Green", "alex@gmail.com");
		Users bob = new Users(null, "Bob Grey", "bob@gmail.com");
		
		usersRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
