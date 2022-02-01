package com.blogPessoal.BlogPessoal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogPessoal.BlogPessoal.models.Postagem;

public interface PostagemRepository extends JpaRepository <Postagem, Long> {
	
	public List <Postagem> findAll();
	
	public List <Postagem> getByTituloContainingIgnoreCase (String titulo);
	
}
