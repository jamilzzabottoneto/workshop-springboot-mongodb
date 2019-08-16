package com.jamilneto.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamilneto.workshopmongo.domain.Post;
import com.jamilneto.workshopmongo.domain.User;
import com.jamilneto.workshopmongo.repository.PostRepository;
import com.jamilneto.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
		
	@Autowired
	private UserRepository userREpository;
	
	@Autowired
	private PostRepository postREpository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userREpository.deleteAll();	
		postREpository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viajem", "Vou viajar para São Paulo, Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/08/2018"), "Bom Dia", "Acordei feliz hoje!", maria);		
		
		userREpository.saveAll(Arrays.asList(maria, alex,bob));
		postREpository.saveAll(Arrays.asList(post1, post2));
		
	}

}
