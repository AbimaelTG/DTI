package com.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TwBien;

@Repository
public interface BienRepository extends JpaRepository<TwBien, Long> {

    // Buscar por descripción (lo que estabas intentando hacer)
    boolean existsByDescripcion(String descripcion);

    List<TwBien> findByDescripcionContainingIgnoreCase(String descripcion);

    // Buscar por código de inventario (muy útil)
    boolean existsByCodigoInventario(String codigoInventario);

    TwBien findByCodigoInventario(String codigoInventario);
}
