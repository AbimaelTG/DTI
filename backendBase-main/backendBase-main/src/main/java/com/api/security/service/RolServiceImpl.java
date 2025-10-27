package com.api.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.enums.RolNombre;
import com.api.security.model.TcRol;
import com.api.security.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolServiceImpl{
	
	@Autowired
	private RolRepository rolRepository;

	
	public Optional<TcRol> getByRolNombre(RolNombre sRol) {
		return rolRepository.findBysRol(sRol);
	}

}
