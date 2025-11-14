package com.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TrRolUsuario;
import com.api.security.model.TrRolUsuario.TrRolUsuarioId;

@Repository
public interface RolUsuarioRepository extends JpaRepository<TrRolUsuario, TrRolUsuarioId> {

    boolean existsById(TrRolUsuarioId id);
}
