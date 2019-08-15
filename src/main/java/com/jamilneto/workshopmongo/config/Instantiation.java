package com.jamilneto.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamilneto.workshopmongo.domain.User;
import com.jamilneto.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userREpository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userREpository.deleteAll();		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userREpository.saveAll(Arrays.asList(maria, alex,bob));
		
	}

}
