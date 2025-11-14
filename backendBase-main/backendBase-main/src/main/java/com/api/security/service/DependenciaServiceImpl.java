package com.api.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TcDependencia;
import com.api.security.repository.DependenciaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DependenciaServiceImpl implements DependenciaService {

    @Autowired
    private DependenciaRepository dependenciaRepository;

    @Override
    public TcDependencia guardar(TcDependencia dependencia) {
        return dependenciaRepository.save(dependencia);
    }

    @Override
    public TcDependencia actualizar(Long id, TcDependencia dependencia) {
        TcDependencia existente = dependenciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dependencia no encontrada con ID: " + id));

        existente.setNombre(dependencia.getNombre());
        existente.setUbicacion(dependencia.getUbicacion());
        existente.setResponsable(dependencia.getResponsable());
        existente.setDepartamento(dependencia.getDepartamento());

        return dependenciaRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        dependenciaRepository.deleteById(id);
    }

    @Override
    public TcDependencia buscarPorId(Long id) {
        return dependenciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dependencia no encontrada con ID: " + id));
    }

    @Override
    public List<TcDependencia> listarTodos() {
        return dependenciaRepository.findAll();
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return dependenciaRepository.existsByNombre(nombre);
    }

    @Override
    public List<TcDependencia> buscarPorNombre(String nombre) {
        return dependenciaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<TcDependencia> buscarPorResponsable(String responsable) {
        return dependenciaRepository.findByResponsableContainingIgnoreCase(responsable);
    }

    @Override
    public List<TcDependencia> buscarPorUbicacion(String ubicacion) {
        return dependenciaRepository.findByUbicacionContainingIgnoreCase(ubicacion);
    }

    @Override
    public List<TcDependencia> buscarPorDepartamento(Long idDepartamento) {
        return dependenciaRepository.findByDepartamentoId(idDepartamento);
    }
}
