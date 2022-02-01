package com.blogPessoal.BlogPessoal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.BlogPessoal.models.Postagem;
import com.blogPessoal.BlogPessoal.repositories.PostagemRepository;

@RestController
@RequestMapping ("/postagens")
@CrossOrigin ("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity <List <Postagem>> findAllPostagem() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity <Postagem> findByIDPostagem (@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo (@PathVariable String titulo) {
		return ResponseEntity.ok(repository.getByTituloContainingIgnoreCase(titulo));
	}
	
}
