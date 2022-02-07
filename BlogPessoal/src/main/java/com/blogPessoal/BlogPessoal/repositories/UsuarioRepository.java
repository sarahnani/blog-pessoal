package com.blogPessoal.BlogPessoal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.blogPessoal.BlogPessoal.models.Usuario;

@Repository
public interface UsuarioRepository {

	public List<Usuario> findAll();

	public Optional <Usuario> findByUsuario(String usuario);
	
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);

	public Optional<Usuario> findById(long id);
}
