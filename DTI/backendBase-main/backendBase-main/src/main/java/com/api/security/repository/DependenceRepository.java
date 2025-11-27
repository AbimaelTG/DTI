package com.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TcDependence;

@Repository
public interface DependenceRepository extends JpaRepository<TcDependence, Long> {

    boolean existsByNombre(String nombre);

    List<TcDependence> findByNombreContainingIgnoreCase(String nombre);

    List<TcDependence> findByResponsableContainingIgnoreCase(String responsable);

    List<TcDependence> findByUbicacionContainingIgnoreCase(String ubicacion);

    List<TcDependence> findByDepartamentoId(Long idDepartamento);
}
