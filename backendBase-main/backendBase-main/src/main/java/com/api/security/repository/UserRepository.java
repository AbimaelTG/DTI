package com.api.security.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.security.model.TcUser;

@Repository
public interface UserRepository extends JpaRepository<TcUser, Long> {

    /**
     * consulta por correo
     * @param correo
     * @return
     */
    Optional<TcUser> findByCorreo(String correo);
    
    /**
     * consulta si existe el correo
     * @param correo
     * @return
     */
    boolean existsByCorreo(String correo);
}