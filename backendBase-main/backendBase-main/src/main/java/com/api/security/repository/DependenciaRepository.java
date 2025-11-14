package com.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TcDependencia;

@Repository
public interface DependenciaRepository extends JpaRepository<TcDependencia, Long> {

    boolean existsByNombre(String nombre);

    List<TcDependencia> findByNombreContainingIgnoreCase(String nombre);

    List<TcDependencia> findByResponsableContainingIgnoreCase(String responsable);

    List<TcDependencia> findByUbicacionContainingIgnoreCase(String ubicacion);

    List<TcDependencia> findByDepartamentoId(Long idDepartamento);
}
