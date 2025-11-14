package com.api.security.service;

import java.util.List;

import com.api.security.model.TcDependencia;

public interface DependenciaService {

    TcDependencia guardar(TcDependencia dependencia);

    TcDependencia actualizar(Long id, TcDependencia dependencia);

    void eliminar(Long id);

    TcDependencia buscarPorId(Long id);

    List<TcDependencia> listarTodos();

    boolean existePorNombre(String nombre);

    List<TcDependencia> buscarPorNombre(String nombre);

    List<TcDependencia> buscarPorResponsable(String responsable);

    List<TcDependencia> buscarPorUbicacion(String ubicacion);

    List<TcDependencia> buscarPorDepartamento(Long idDepartamento);
}
