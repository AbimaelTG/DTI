package com.api.security.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TcCategory;

@Repository
public interface CategoryRepository extends JpaRepository<TcCategory, Long> {
    Optional<TcCategory> findByNombre(String nombre);

    List<TcCategory> findByNombreContainingIgnoreCase(String nombre);
    
    boolean existsByNombre(String nombre);

}