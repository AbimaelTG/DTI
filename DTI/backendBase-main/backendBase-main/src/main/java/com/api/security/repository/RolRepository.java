package com.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.enums.RolNombre;
import com.api.security.model.TcRol;

@Repository
public interface RolRepository extends JpaRepository<TcRol, Long> {
    
    Optional<TcRol> findByNombre(RolNombre nombre);
}