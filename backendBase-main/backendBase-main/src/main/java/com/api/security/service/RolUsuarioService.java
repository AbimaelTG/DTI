package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TrRolUsuario;
import com.api.security.model.TrRolUsuario.TrRolUsuarioId;
import com.api.security.repository.RolUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolUsuarioService {

    @Autowired
    private RolUsuarioRepository repository;

    public List<TrRolUsuario> getAll() {
        return repository.findAll();
    }

    public Optional<TrRolUsuario> getById(Integer idRol, Integer idUsuario) {
        return repository.findById(new TrRolUsuarioId(idRol, idUsuario));
    }

    public TrRolUsuario save(TrRolUsuario trRolUsuario) {
        return repository.save(trRolUsuario);
    }

    public boolean exists(Integer idRol, Integer idUsuario) {
        return repository.existsById(new TrRolUsuarioId(idRol, idUsuario));
    }

    public void delete(Integer idRol, Integer idUsuario) {
        repository.deleteById(new TrRolUsuarioId(idRol, idUsuario));
    }
}
