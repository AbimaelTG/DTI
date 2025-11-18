package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TwVoucher;
import com.api.security.repository.VoucherRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComprobanteService {

    @Autowired
    private VoucherRepository comprobanteRepository;

    public TwVoucher save(TwVoucher comprobante) {
        return comprobanteRepository.save(comprobante);
    }

    public Optional<TwVoucher> findById(Long id) {
        return comprobanteRepository.findById(id);
    }

    public List<TwVoucher> findAll() {
        return comprobanteRepository.findAll();
    }

    public void deleteById(Long id) {
        comprobanteRepository.deleteById(id);
    }

    public List<TwVoucher> findByIdAsignacion(Long idAsignacion) {
        return comprobanteRepository.findByIdAsignacion(idAsignacion);
    }

    public boolean existsByIdAsignacion(Long idAsignacion) {
        return comprobanteRepository.existsByIdAsignacion(idAsignacion);
    }
}
