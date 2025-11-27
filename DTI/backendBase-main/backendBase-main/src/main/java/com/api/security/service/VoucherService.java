package com.api.security.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.dto.VoucherDto;
import com.api.security.model.TwVoucher;
import com.api.security.repository.VoucherRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    // Guardar desde DTO
    public TwVoucher save(VoucherDto dto) {

        // ===== VALIDACIONES =====

        if (dto == null) {
            throw new IllegalArgumentException("El objeto voucher no puede ser nulo");
        }

        // Validar ID si viene para actualización
        if (dto.getId() != null && dto.getId() <= 0) {
            throw new IllegalArgumentException("El ID del voucher debe ser mayor a cero");
        }

        // Validar idAsignacion
        if (dto.getIdAsignacion() == null || dto.getIdAsignacion() <= 0) {
            throw new IllegalArgumentException("El ID de asignación es obligatorio y debe ser mayor a cero");
        }

        // Validar si ya existe un voucher asociado a esa asignación (si la regla lo exige)
        if (existsByIdAsignacion(dto.getIdAsignacion())) {
            throw new IllegalArgumentException("Ya existe un voucher asociado a esta asignación");
        }

        // Validar fecha de emisión
        if (dto.getFechaEmision() == null) {
            throw new IllegalArgumentException("La fecha de emisión es obligatoria");
        }

        if (dto.getFechaEmision().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de emisión no puede ser futura");
        }

        // Construcción de la entidad
        TwVoucher entity = new TwVoucher();
        entity.setId(dto.getId());
        entity.setIdAsignacion(dto.getIdAsignacion());
        entity.setFechaEmision(dto.getFechaEmision());

        return voucherRepository.save(entity);
    }

    // Guardar desde entity (para update)
    public TwVoucher saveEntity(TwVoucher voucher) {

        if (voucher == null) {
            throw new IllegalArgumentException("El voucher no puede ser nulo");
        }

        if (voucher.getIdAsignacion() == null || voucher.getIdAsignacion() <= 0) {
            throw new IllegalArgumentException("El ID de asignación es obligatorio");
        }

        if (voucher.getFechaEmision() == null) {
            throw new IllegalArgumentException("La fecha de emisión es obligatoria");
        }

        return voucherRepository.save(voucher);
    }

    public Optional<TwVoucher> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID debe ser válido");
        }
        return voucherRepository.findById(id);
    }

    public List<TwVoucher> findAll() {
        return voucherRepository.findAll();
    }

    public void deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID a eliminar no puede ser nulo o menor a 1");
        }
        if (!voucherRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe un voucher con el ID proporcionado");
        }
        voucherRepository.deleteById(id);
    }

    public List<TwVoucher> findByIdAsignacion(Long idAsignacion) {
        if (idAsignacion == null || idAsignacion <= 0) {
            throw new IllegalArgumentException("El ID de asignación debe ser válido");
        }
        return voucherRepository.findByIdAsignacion(idAsignacion);
    }

    public boolean existsByIdAsignacion(Long idAsignacion) {
        return voucherRepository.existsByIdAsignacion(idAsignacion);
    }
}
