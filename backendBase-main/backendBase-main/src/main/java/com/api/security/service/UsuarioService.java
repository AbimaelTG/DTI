package com.api.security.service;

import java.util.List;

import com.api.security.model.TcUsuario;

public interface UsuarioService {

    TcUsuario guardar(TcUsuario usuario);

    TcUsuario actualizar(Long id, TcUsuario usuario);

    void eliminar(Long id);

    TcUsuario buscarPorId(Long id);

    List<TcUsuario> listarTodos();

    TcUsuario buscarPorCorreo(String correo);

    boolean existeCorreo(String correo);
}
