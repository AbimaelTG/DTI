package com.api.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.dto.GoodDto;
import com.api.security.model.TcCategory;
import com.api.security.model.TcDependence;
import com.api.security.model.TwGood;
import com.api.security.repository.CategoryRepository;
import com.api.security.repository.DependenceRepository;
import com.api.security.repository.GoodRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GoodsService {

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private CategoryRepository tcCategoryRepository;

    @Autowired
    private DependenceRepository tcDependenceRepository;

    // Verificar si existe un código de inventario
    public boolean existsByCodigoInventario(String codigo) {
        return goodRepository.existsByCodigoInventario(codigo);
    }

    // Buscar por ID
    public Optional<TwGood> findById(Long id) {

        if (id != null) {
            return goodRepository.findById(id);
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }

    }

    public void save(GoodDto bienDTO) {
        TcCategory categoria = tcCategoryRepository.findById(bienDTO.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        TcDependence dependencia = tcDependenceRepository.findById(bienDTO.getIdDependencia())
                .orElseThrow(() -> new RuntimeException("Dependencia no encontrada"));

        TwGood bien = new TwGood();
        bien.setCodigoInventario(bienDTO.getCodigoInventario());
        bien.setDescripcion(bienDTO.getDescripcion());
        bien.setMarca(bienDTO.getMarca());
        bien.setModelo(bienDTO.getModelo());
        bien.setNoSerie(bienDTO.getNoSerie());
        bien.setEstado(bienDTO.getEstado());
        bien.setCategoria(categoria);
        bien.setDependencia(dependencia);
        bien.setFechaAlta(bienDTO.getFechaAlta());
        bien.setFechaBaja(bienDTO.getFechaBaja());
        goodRepository.save(bien);
    }

    public void update(Long id, GoodDto goodDto) {
        TwGood existBien = goodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bien no encontrado"));
        TcCategory categoria = tcCategoryRepository.findById(goodDto.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        TcDependence dependencia = tcDependenceRepository.findById(goodDto.getIdDependencia())
                .orElseThrow(() -> new RuntimeException("Dependencia no encontrada"));

        existBien.setCodigoInventario(goodDto.getCodigoInventario());
        existBien.setDescripcion(goodDto.getDescripcion());
        existBien.setMarca(goodDto.getMarca());
        existBien.setModelo(goodDto.getModelo());
        existBien.setNoSerie(goodDto.getNoSerie());
        existBien.setEstado(goodDto.getEstado());
        existBien.setCategoria(categoria);
        existBien.setDependencia(dependencia);
        existBien.setFechaAlta(goodDto.getFechaAlta());
        existBien.setFechaBaja(goodDto.getFechaBaja());
        goodRepository.save(existBien);
    }

    // Eliminar
    public void deleteById(Long id) {
        goodRepository.deleteById(id);
    }

    // Listar todos
    public List<TwGood> findAll() {
        return goodRepository.findAll();
    }

    // Buscar por descripción
    public List<TwGood> findByDescripcion(String descripcion) {
        return goodRepository.findByDescripcionContainingIgnoreCase(descripcion);
    }
}
