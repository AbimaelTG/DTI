package com.api.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TwAsignacion;

@Repository
public interface AsignacionRepository extends JpaRepository<TwAsignacion, Long> {

    // Para obtener una asignación (si esperas una sola)
    Optional<TwAsignacion> findByIdUsuario(Integer idUsuario);

    // Si un usuario puede tener muchas asignaciones (mejor opción)
    List<TwAsignacion> findAllByIdUsuario(Integer idUsuario);

    // Para verificar si existe alguna asignación de ese usuario
    boolean existsByIdUsuario(Integer idUsuario);
}
