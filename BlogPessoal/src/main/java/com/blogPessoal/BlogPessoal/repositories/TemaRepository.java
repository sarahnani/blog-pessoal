package com.blogPessoal.BlogPessoal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogPessoal.BlogPessoal.models.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> {

	public List <Tema> findAll();
	
	public List <Tema> findByDescricaoPostagemIgnoreCase (String descricao);
}
