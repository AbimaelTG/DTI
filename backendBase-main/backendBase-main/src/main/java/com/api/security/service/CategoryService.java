package com.api.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.security.model.TcCategory;
import com.api.security.repository.CategoryRepository;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    public boolean existsByNombre(String nombre) {
        return categoryRepository.existsByNombre(nombre);
    };
    public List<TcCategory> findByNombre(String nombre) {
        return categoryRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public boolean findById(Long id) {
        if (id != null) {
            return categoryRepository.existsById(id);
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }

    }

    public void save(TcCategory nuevaCategoria) {
        TcCategory categoria = new TcCategory();
        categoria.setNombre(nuevaCategoria.getNombre());
        categoria.setDescripcion(nuevaCategoria.getDescripcion());
        categoryRepository.save(categoria);
    };

    public void delete(@NonNull Long id) {
        if (id != null) {
            categoryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    };

    public void udpate(Long id, TcCategory category) {
        if (id != null) {
            TcCategory updateCategory = categoryRepository.findById(id).get();
            System.out.println(updateCategory);
            updateCategory.setNombre(category.getNombre());
            updateCategory.setDescripcion(category.getDescripcion());
            categoryRepository.save(updateCategory);
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    };

    public List<TcCategory> getAll() {
        return categoryRepository.findAll();
    };

}
