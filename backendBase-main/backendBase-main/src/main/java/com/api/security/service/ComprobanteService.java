package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TwComprobante;
import com.api.security.repository.ComprobanteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    public TwComprobante save(TwComprobante comprobante) {
        return comprobanteRepository.save(comprobante);
    }

    public Optional<TwComprobante> findById(Long id) {
        return comprobanteRepository.findById(id);
    }

    public List<TwComprobante> findAll() {
        return comprobanteRepository.findAll();
    }

    public void deleteById(Long id) {
        comprobanteRepository.deleteById(id);
    }

    public List<TwComprobante> findByIdAsignacion(Long idAsignacion) {
        return comprobanteRepository.findByIdAsignacion(idAsignacion);
    }

    public boolean existsByIdAsignacion(Long idAsignacion) {
        return comprobanteRepository.existsByIdAsignacion(idAsignacion);
    }
}
