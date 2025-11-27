package com.api.security.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.security.model.TcCategory;
import com.api.security.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("category")
    public ResponseEntity<?> store(@RequestBody TcCategory categoria, BindingResult bindingResult) {
        System.out.println("Datos de nueva categoria: " + categoria);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
        }
        try {
            categoryService.save(categoria);
            return new ResponseEntity<>("Categoria creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear categoria: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Error interno al crear la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("category/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TcCategory category,
            BindingResult bindingResult) {
        System.out.println("Datos de nueva categoria: " + category);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
        }
        if (!categoryService.findById(id)) {
            return new ResponseEntity<>("La categoria no existe", HttpStatus.NOT_FOUND);
        }
        try {
            categoryService.udpate(id, category);
            return new ResponseEntity<>("Categoria actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error al actualizar categoria: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Error interno al actualizar la categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok("Categoría eliminada exitosamente");
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategorias(@RequestParam(required = false) String nombre) {
        try {
            if (nombre != null && !nombre.isEmpty()) {
                System.out.println("Buscando categorias con el nombre: " + nombre);
                return ResponseEntity.ok(categoryService.findByNombre(nombre));
            } else {
                System.out.println("Buscando todas las categorias");
                return ResponseEntity.ok(categoryService.getAll());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener las categorías: " + e.getMessage());
        }
    }

}
