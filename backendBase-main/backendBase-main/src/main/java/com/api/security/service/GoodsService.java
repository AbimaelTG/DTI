package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TwBien;
import com.api.security.repository.BienRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GoodsService {

    @Autowired
    private BienRepository bienRepository;

    // Verificar si existe un código de inventario
    public boolean existsByCodigoInventario(String codigo) {
        return bienRepository.existsByCodigoInventario(codigo);
    }

    // Buscar por ID
    public Optional<TwBien> findById(Long id) {
        return bienRepository.findById(id);
    }

    // Guardar bien
    public TwBien save(TwBien bien) {
        return bienRepository.save(bien);
    }

    // Eliminar
    public void deleteById(Long id) {
        bienRepository.deleteById(id);
    }

    // Listar todos
    public List<TwBien> findAll() {
        return bienRepository.findAll();
    }

    // Buscar por descripción
    public List<TwBien> findByDescripcion(String descripcion) {
        return bienRepository.findByDescripcionContainingIgnoreCase(descripcion);
    }
}
