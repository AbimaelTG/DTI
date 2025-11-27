package com.api.security.service;

import java.util.List;

import com.api.security.model.TcDependence;

public interface DependenceService {

    TcDependence guardar(TcDependence dependencia);

    TcDependence actualizar(Long id, TcDependence dependencia);

    void eliminar(Long id);

    TcDependence buscarPorId(Long id);

    List<TcDependence> listarTodos();

    boolean existePorNombre(String nombre);

    List<TcDependence> buscarPorNombre(String nombre);

    List<TcDependence> buscarPorResponsable(String responsable);

    List<TcDependence> buscarPorUbicacion(String ubicacion);

    List<TcDependence> buscarPorDepartamento(Long idDepartamento);
}
