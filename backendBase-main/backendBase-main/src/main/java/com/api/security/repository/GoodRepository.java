package com.api.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TwGood;

@Repository
public interface GoodRepository extends JpaRepository<TwGood, Long> {

    // Buscar por descripción (lo que estabas intentando hacer)
    boolean existsByDescripcion(String descripcion);

    List<TwGood> findByDescripcionContainingIgnoreCase(String descripcion);

    // Buscar por código de inventario (muy útil)
    boolean existsByCodigoInventario(String codigoInventario);

    TwGood findByCodigoInventario(String codigoInventario);
}
