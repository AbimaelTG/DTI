package com.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TrRolUser;
import com.api.security.model.TrRolUser.TrRolUsuarioId;

@Repository
public interface RolUsuarioRepository extends JpaRepository<TrRolUser, TrRolUsuarioId> {

    boolean existsById(TrRolUsuarioId id);
}
