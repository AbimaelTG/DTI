package com.api.security.service;

import java.util.Optional;

import com.api.security.dto.User;
import com.api.security.model.TcUser;

public interface UserService {

    boolean existsById(Long id);

    Optional<TcUser> getById(Long id);

    Optional<TcUser> getByCorreo(String correo);

    boolean existsByCorreo(String correo);

    Optional<TcUser> getByNombreUsuario(String usuario);

    boolean existsByNombreUsuario(String usuario);

    void save(User nuevoUsuario);

    void update(Long id, User nuevoUsuario);

    void delete(Long id);
}
