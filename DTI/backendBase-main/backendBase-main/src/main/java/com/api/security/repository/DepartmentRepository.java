package com.api.security.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.api.security.model.TcDepartament;

import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface DepartmentRepository extends JpaRepository<TcDepartament, Long> {
    Optional<TcDepartament> findByNombre(String name);
    Optional<TcDepartament> findById(Long id);
    List<TcDepartament> findByNombreContainingIgnoreCase(String name);
    boolean existsByNombre(String name);
}