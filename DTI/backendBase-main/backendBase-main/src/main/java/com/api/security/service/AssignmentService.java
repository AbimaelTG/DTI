package com.api.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.dto.AssignmentDto;
import com.api.security.model.TwAssignment;
import com.api.security.model.TwGood;
import com.api.security.repository.AssignmentRepository;
import com.api.security.repository.GoodRepository;
import com.api.security.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AssignmentService {

    @Autowired
    private final AssignmentRepository asignacionRepository;
    private final GoodRepository goodRepository;
    private final UserRepository userRepository;

    public AssignmentService(
            AssignmentRepository asignacionRepository,
            GoodRepository goodRepository,
            UserRepository userRepository) {
        this.asignacionRepository = asignacionRepository;
        this.goodRepository = goodRepository;
        this.userRepository = userRepository;
    }

    // ------------------------------------------------------
    // CREATE
    // ------------------------------------------------------
    public TwAssignment save(AssignmentDto dto) {

        TwGood bien = goodRepository.findById(dto.getIdBien())
                .orElseThrow(() -> new IllegalArgumentException(
                        "El bien con ID " + dto.getIdBien() + " no existe"));

        if (!userRepository.existsById(dto.getIdUsuario())) {
            throw new IllegalArgumentException(
                    "El usuario con ID " + dto.getIdUsuario() + " no existe");
        }

        // 3. Convertir DTO → entidad
        TwAssignment asignacion = new TwAssignment();
        asignacion.setBien(bien);
        asignacion.setIdUsuario(dto.getIdUsuario());
        asignacion.setFechaAsignacion(dto.getFechaAsignacion());
        asignacion.setFechaRetorno(dto.getFechaRetorno());

        // 4. Guardar
        return asignacionRepository.save(asignacion);
    }

    // ------------------------------------------------------
    // DELETE
    // ------------------------------------------------------
    public void delete(Long id) {
        if (!asignacionRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe la asignación con ID " + id);
        }
        asignacionRepository.deleteById(id);
    }

    // ------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------
    public TwAssignment update(Long id, AssignmentDto dto) {

        TwAssignment asignacion = asignacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe la asignación con ID " + id));

        // Validar bien
        TwGood bien = goodRepository.findById(dto.getIdBien().longValue())
                .orElseThrow(() -> new IllegalArgumentException(
                        "El bien con ID " + dto.getIdBien() + " no existe"));

        // Validar usuario
        if (!userRepository.existsById(Long.valueOf(dto.getIdUsuario()))) {
            throw new IllegalArgumentException(
                    "El usuario con ID " + dto.getIdUsuario() + " no existe");
        }

        asignacion.setBien(bien);
        asignacion.setIdUsuario(dto.getIdUsuario());
        asignacion.setFechaAsignacion(dto.getFechaAsignacion());
        asignacion.setFechaRetorno(dto.getFechaRetorno());

        return asignacionRepository.save(asignacion);
    }

    // ------------------------------------------------------
    // READ
    // ------------------------------------------------------
    public TwAssignment getById(Long id) {
        return asignacionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe la asignación con ID " + id));
    }

    public List<TwAssignment> getAll() {
        return asignacionRepository.findAll();
    }

    // ------------------------------------------------------
    // CONSULTAS ESPECIALES
    // ------------------------------------------------------
    public List<TwAssignment> getByUsuario(Integer idUsuario) {
        return asignacionRepository.findAllByIdUsuario(idUsuario);
    }

    public boolean existsByUsuario(Integer idUsuario) {
        return asignacionRepository.existsByIdUsuario(idUsuario);
    }

    // ------------------------------------------------------
// EXISTE POR ID
// ------------------------------------------------------
public boolean existsById(Long id) {
    if (id == null || id <= 0) return false;
    return asignacionRepository.existsById(id);
}

}
