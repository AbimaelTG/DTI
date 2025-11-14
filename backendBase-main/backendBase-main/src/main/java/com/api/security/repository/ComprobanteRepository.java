package com.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TwComprobante;

@Repository
public interface ComprobanteRepository extends JpaRepository<TwComprobante, Long> {

    // Buscar comprobantes por id de asignación
    List<TwComprobante> findByIdAsignacion(Long idAsignacion);

    // Verificar si existe un comprobante para esa asignación
    boolean existsByIdAsignacion(Long idAsignacion);
}
