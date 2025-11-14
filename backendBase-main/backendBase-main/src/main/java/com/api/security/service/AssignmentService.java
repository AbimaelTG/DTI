package com.api.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TwAsignacion;
import com.api.security.repository.AsignacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AssignmentService {

    private final AsignacionRepository asignacionRepository;

    @Autowired
    public AssignmentService(AsignacionRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    // ------------------------------------------------------
    //                     CRUD
    // ------------------------------------------------------

    public TwAsignacion save(TwAsignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    public void delete(Long id) {
        if (!asignacionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe la asignación con ID " + id);
        }
        asignacionRepository.deleteById(id);
    }

    public TwAsignacion update(Long id, TwAsignacion datos) {

        TwAsignacion asignacion = asignacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la asignación con ID " + id));

        // Actualización de los campos verdaderos
        asignacion.setBien(datos.getBien());
        asignacion.setIdUsuario(datos.getIdUsuario());
        asignacion.setFechaAsignacion(datos.getFechaAsignacion());
        asignacion.setFechaRetorno(datos.getFechaRetorno());

        return asignacionRepository.save(asignacion);
    }

    public TwAsignacion getById(Long id) {
        return asignacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la asignación con ID " + id));
    }

    public List<TwAsignacion> getAll() {
        return asignacionRepository.findAll();
    }

    // ------------------------------------------------------
    //            CONSULTAS POR ID USUARIO
    // ------------------------------------------------------

    // Obtener asignaciones por usuario
    public List<TwAsignacion> getByUsuario(Integer idUsuario) {
        return asignacionRepository.findAllByIdUsuario(idUsuario);
    }

    // Verificar si un usuario tiene asignaciones
    public boolean existsByUsuario(Integer idUsuario) {
        return asignacionRepository.existsByIdUsuario(idUsuario);
    }
}
