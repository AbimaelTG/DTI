package com.api.security.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.security.model.TcDepartament;
import com.api.security.repository.DepartmentRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    public DepartmentRepository departmentRepository;

    public boolean existsByNombre(String nombre) {
        return departmentRepository.existsByNombre(nombre);
    }

    public List<TcDepartament> findByNombre(String name) {
        return departmentRepository.findByNombreContainingIgnoreCase(name);
    }

    public boolean findById(Long id) {
        if (id != null) {
            return departmentRepository.existsById(id);
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    }

    public void save(TcDepartament newDepartment) {
        TcDepartament department = new TcDepartament();
        department.setNombre(newDepartment.getNombre());
        departmentRepository.save(department);
    }

    public void update(Long id, TcDepartament department) {
        if (id != null) {
            TcDepartament updateDepartment = departmentRepository.findById(id).get();
            updateDepartment.setNombre(department.getNombre());
            departmentRepository.save(updateDepartment);
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    }

    public void delete(Long id) {
        if (id != null) {
            departmentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
    }

    public List<TcDepartament> getAll() {
        return departmentRepository.findAll();
    }

}