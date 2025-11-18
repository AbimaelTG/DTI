package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TrRolUser;
import com.api.security.model.TrRolUser.TrRolUsuarioId;
import com.api.security.repository.RolUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolUserService {

    @Autowired
    private RolUsuarioRepository repository;

    public List<TrRolUser> getAll() {
        return repository.findAll();
    }

    public Optional<TrRolUser> getById(Integer idRol, Integer idUsuario) {
        return repository.findById(new TrRolUsuarioId(idRol, idUsuario));
    }

    public TrRolUser save(TrRolUser trRolUsuario) {
        return repository.save(trRolUsuario);
    }

    public boolean exists(Integer idRol, Integer idUsuario) {
        return repository.existsById(new TrRolUsuarioId(idRol, idUsuario));
    }

    public void delete(Integer idRol, Integer idUsuario) {
        repository.deleteById(new TrRolUsuarioId(idRol, idUsuario));
    }
}
