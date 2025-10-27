package com.api.security.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.enums.RolNombre;
import com.api.security.dto.NuevoUsuario;
import com.api.security.model.TcRol;
import com.api.security.model.TcUsuario;
import com.api.security.repository.UsuariosRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class UsuarioServiceImp  {

	@Autowired
	public UsuariosRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolServiceImpl rolServiceImpl;
	


	
	
	//nuevos métodos para authenticacion

	
	public Optional<TcUsuario> getByNombreUsuario(String usuario) {
		return usuarioRepository.findBysUsuario(usuario);
	}

	
	public boolean existsByNombreUsuario(String usuario) {
		return usuarioRepository.existsBysUsuario(usuario);
	}

	
	public void save(NuevoUsuario nuevoUsuario) {
		
		TcUsuario usuario = new TcUsuario(nuevoUsuario.getsClaveUser(), nuevoUsuario.getsUsuario(), passwordEncoder.encode(nuevoUsuario.getsPassword()), nuevoUsuario.getsNombreUsuario(), nuevoUsuario.getnEstatus() );
		
		usuario.setRoles(asignaRol(nuevoUsuario));
		
		usuarioRepository.save(usuario); 	
	}
	
	private Set<TcRol> asignaRol(NuevoUsuario nuevoUsuario){
		
		Set<TcRol> roles = new HashSet<>();	
		
		//roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		
		if (nuevoUsuario.getRoles().contains("admin")){
			roles.add(rolServiceImpl.getByRolNombre(RolNombre.ADMINISTRADOR).get());
		}
		
		return roles;
		
	}

}
