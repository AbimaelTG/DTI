package com.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TwVoucher;

@Repository
public interface VoucherRepository extends JpaRepository<TwVoucher, Long> {

    // Buscar comprobantes por id de asignación
    List<TwVoucher> findByIdAsignacion(Long idAsignacion);

    // Verificar si existe un comprobante para esa asignación
    boolean existsByIdAsignacion(Long idAsignacion);
}
