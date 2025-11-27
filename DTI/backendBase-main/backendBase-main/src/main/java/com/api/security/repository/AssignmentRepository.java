package com.api.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TwAssignment;

@Repository
public interface AssignmentRepository extends JpaRepository<TwAssignment, Long> {

    // Para obtener una asignación (si esperas una sola)
    Optional<TwAssignment> findByIdUsuario(Integer idUsuario);

    // Si un usuario puede tener muchas asignaciones (mejor opción)
    List<TwAssignment> findAllByIdUsuario(Integer idUsuario);

    // Para verificar si existe alguna asignación de ese usuario
    boolean existsByIdUsuario(Integer idUsuario);
}
