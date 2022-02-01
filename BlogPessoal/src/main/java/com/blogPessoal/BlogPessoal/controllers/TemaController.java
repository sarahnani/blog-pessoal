package com.blogPessoal.BlogPessoal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogPessoal.BlogPessoal.models.Tema;
import com.blogPessoal.BlogPessoal.repositories.TemaRepository;

@RestController
@RequestMapping ("/tema")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Tema>> findAllTema() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Tema> findByIDTema (@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> findByDescricaoPostagem (@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findByDescricaoPostagemIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity <Tema> postTema (@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity <Tema> putTema (@RequestBody Tema tema) {
		return ResponseEntity.ok(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTema (@PathVariable long id) {
		repository.deleteById(id);
	}
}
