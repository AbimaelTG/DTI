package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.enums.RolNombre;
import com.api.security.model.TcRol;
import com.api.security.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolServiceImpl {

    @Autowired
    private RolRepository rolRepository;

    /**
     * Obtener todos los roles
     */
    public List<TcRol> getAll() {
        return rolRepository.findAll();
    }

    /**
     * Obtener rol por ID
     */
    public Optional<TcRol> getById(Long id) {
        return rolRepository.findById(id);
    }

    /**
     * Obtener rol por enum
     */
    public Optional<TcRol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByNombre(rolNombre);
    }

    /**
     * Guardar un rol
     */
    public TcRol save(TcRol rol) {
        return rolRepository.save(rol);
    }

    /**
     * Verificar si existe por ID
     */
    public boolean existsById(Long id) {
        return rolRepository.existsById(id);
    }

    /**
     * Eliminar por ID
     */
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
}
