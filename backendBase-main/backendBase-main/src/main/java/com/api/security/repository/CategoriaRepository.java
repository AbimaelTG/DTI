package com.api.security.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TcCategoria;

@Repository
public interface CategoriaRepository extends JpaRepository<TcCategoria, Long> {
    Optional<TcCategoria> findByNombre(String nombre);

    List<TcCategoria> findByNombreContainingIgnoreCase(String nombre);
    
    boolean existsByNombre(String nombre);

}