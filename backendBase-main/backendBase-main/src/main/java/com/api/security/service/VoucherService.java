package com.api.security.service;

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

        TwVoucher entity = new TwVoucher();
        entity.setId(dto.getId());
        entity.setIdAsignacion(dto.getIdAsignacion());
        entity.setFechaEmision(dto.getFechaEmision());

        return voucherRepository.save(entity);
    }

    // Guardar desde entity (para update)
    public TwVoucher saveEntity(TwVoucher voucher) {
        return voucherRepository.save(voucher);
    }

    public Optional<TwVoucher> findById(Long id) {
        return voucherRepository.findById(id);
    }

    public List<TwVoucher> findAll() {
        return voucherRepository.findAll();
    }

    public void deleteById(Long id) {
        voucherRepository.deleteById(id);
    }

    public List<TwVoucher> findByIdAsignacion(Long idAsignacion) {
        return voucherRepository.findByIdAsignacion(idAsignacion);
    }

    public boolean existsByIdAsignacion(Long idAsignacion) {
        return voucherRepository.existsByIdAsignacion(idAsignacion);
    }
}
