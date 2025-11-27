package com.api.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TcDependence;
import com.api.security.repository.DependenceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DependenceServiceImpl implements DependenceService {

    @Autowired
    private DependenceRepository dependenciaRepository;

    @Override
    public TcDependence guardar(TcDependence dependencia) {
        return dependenciaRepository.save(dependencia);
    }

    @Override
    public TcDependence actualizar(Long id, TcDependence dependencia) {
        TcDependence existente = dependenciaRepository.findById(id)
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
    public TcDependence buscarPorId(Long id) {
        return dependenciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dependencia no encontrada con ID: " + id));
    }

    @Override
    public List<TcDependence> listarTodos() {
        return dependenciaRepository.findAll();
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return dependenciaRepository.existsByNombre(nombre);
    }

    @Override
    public List<TcDependence> buscarPorNombre(String nombre) {
        return dependenciaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<TcDependence> buscarPorResponsable(String responsable) {
        return dependenciaRepository.findByResponsableContainingIgnoreCase(responsable);
    }

    @Override
    public List<TcDependence> buscarPorUbicacion(String ubicacion) {
        return dependenciaRepository.findByUbicacionContainingIgnoreCase(ubicacion);
    }

    @Override
    public List<TcDependence> buscarPorDepartamento(Long idDepartamento) {
        return dependenciaRepository.findByDepartamentoId(idDepartamento);
    }
}
