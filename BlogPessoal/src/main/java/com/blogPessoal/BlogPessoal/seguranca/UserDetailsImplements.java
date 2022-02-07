package com.blogPessoal.BlogPessoal.seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blogPessoal.BlogPessoal.models.Usuario;

public class UserDetailsImplements implements UserDetails {

	private static final long serialVersionUID = 1l;

	private String userName;
	private String password;
	private List <GrantedAuthority> authorities;

	public UserDetailsImplements (Usuario user) {
	    this.userName = user.getUsuario();
	    this.password = user.getSenha();
	  }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}