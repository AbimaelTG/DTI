package com.api.security.service;

import java.util.List;
import java.util.Optional;

import com.api.security.dto.Usuario;
import com.api.security.model.TcUsuario;

public interface UsuarioService {

    TcUsuario guardar(TcUsuario usuario);

    TcUsuario actualizar(Long id, TcUsuario usuario);

    void eliminar(Long id);

    TcUsuario buscarPorId(Long id);

    List<TcUsuario> listarTodos();

    TcUsuario buscarPorCorreo(String correo);

    boolean existeCorreo(String correo);

    // 🔥 AGREGA ESTOS MÉTODOS PARA COINCIDIR CON UsuarioServiceImp
    Optional<TcUsuario> getByCorreo(String correo);

    boolean existsByCorreo(String correo);

    void save(Usuario nuevoUsuario);

    boolean existsById(Long id);
}
