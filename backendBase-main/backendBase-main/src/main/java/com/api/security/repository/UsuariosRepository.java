package com.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TcUsuario;

@Repository
public interface UsuariosRepository extends JpaRepository<TcUsuario, Long> {

    Optional<TcUsuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo);
}
