package com.api.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TwAssignment;
import com.api.security.repository.AssignmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AssignmentService {

    private final AssignmentRepository asignacionRepository;

    @Autowired
    public AssignmentService(AssignmentRepository asignacionRepository) {
        this.asignacionRepository = asignacionRepository;
    }

    // ------------------------------------------------------
    //                     CRUD
    // ------------------------------------------------------

    public TwAssignment save(TwAssignment asignacion) {
        return asignacionRepository.save(asignacion);
    }

    public void delete(Long id) {
        if (!asignacionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe la asignación con ID " + id);
        }
        asignacionRepository.deleteById(id);
    }

    public TwAssignment update(Long id, TwAssignment datos) {

        TwAssignment asignacion = asignacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la asignación con ID " + id));

        // Actualización de los campos verdaderos
        asignacion.setBien(datos.getBien());
        asignacion.setIdUsuario(datos.getIdUsuario());
        asignacion.setFechaAsignacion(datos.getFechaAsignacion());
        asignacion.setFechaRetorno(datos.getFechaRetorno());

        return asignacionRepository.save(asignacion);
    }

    public TwAssignment getById(Long id) {
        return asignacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la asignación con ID " + id));
    }

    public List<TwAssignment> getAll() {
        return asignacionRepository.findAll();
    }

    // ------------------------------------------------------
    //            CONSULTAS POR ID USUARIO
    // ------------------------------------------------------

    // Obtener asignaciones por usuario
    public List<TwAssignment> getByUsuario(Integer idUsuario) {
        return asignacionRepository.findAllByIdUsuario(idUsuario);
    }

    // Verificar si un usuario tiene asignaciones
    public boolean existsByUsuario(Integer idUsuario) {
        return asignacionRepository.existsByIdUsuario(idUsuario);
    }
}
