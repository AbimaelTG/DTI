package com.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.security.model.TcUsuario;
import com.api.security.model.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	
	public UserDetails loadUserByUsername(String sUsuario) throws UsernameNotFoundException {
		TcUsuario usuario = usuarioServiceImp.getByNombreUsuario(sUsuario).get();
		return UsuarioPrincipal.build(usuario);
	}  

}
