package com.blogPessoal.BlogPessoal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogPessoal.BlogPessoal.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	public List<Usuario> findAll();

	public Optional <Usuario> findByUsuario(String usuario);
	
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
