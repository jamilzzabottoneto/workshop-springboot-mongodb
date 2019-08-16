package com.jamilneto.workshopmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamilneto.workshopmongo.domain.Post;
import com.jamilneto.workshopmongo.repository.PostRepository;
import com.jamilneto.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao Encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {

		maxDate = new Date(maxDate.getTime() + 4 * 60 * 60 * 1000);
		return repo.fullsearch(text, minDate, maxDate);
	}

}
