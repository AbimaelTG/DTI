package com.api.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TwBien;
import com.api.security.service.GoodsService;

@RestController
@RequestMapping("/api/bienes")
@CrossOrigin(origins = "*")
public class GoodsController {

    @Autowired
    private GoodsService bienService;

    // Crear bien
    @PostMapping
    public ResponseEntity<?> createBien(@RequestBody TwBien bien) {

        if (bienService.existsByCodigoInventario(bien.getCodigoInventario())) {
            return ResponseEntity.badRequest().body("Error: El código de inventario ya existe.");
        }

        TwBien nuevo = bienService.save(bien);
        return ResponseEntity.ok(nuevo);
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<TwBien>> getAll() {
        return ResponseEntity.ok(bienService.findAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<TwBien> bien = bienService.findById(id);

        if (bien.isEmpty()) {
            return ResponseEntity.status(404).body("Bien no encontrado");
        }

        return ResponseEntity.ok(bien.get());
    }

    // Actualizar bien
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBien(@PathVariable Long id, @RequestBody TwBien datos) {
        Optional<TwBien> bienOptional = bienService.findById(id);

        if (bienOptional.isEmpty()) {
            return ResponseEntity.status(404).body("Bien no encontrado");
        }

        TwBien bien = bienOptional.get();

        bien.setDescripcion(datos.getDescripcion());
        bien.setMarca(datos.getMarca());
        bien.setModelo(datos.getModelo());
        bien.setNoSerie(datos.getNoSerie());
        bien.setEstado(datos.getEstado());
        bien.setCategoria(datos.getCategoria());
        bien.setDependencia(datos.getDependencia());
        bien.setFechaAlta(datos.getFechaAlta());
        bien.setFechaBaja(datos.getFechaBaja());

        return ResponseEntity.ok(bienService.save(bien));
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBien(@PathVariable Long id) {
        Optional<TwBien> bien = bienService.findById(id);

        if (bien.isEmpty()) {
            return ResponseEntity.status(404).body("Bien no encontrado");
        }

        bienService.deleteById(id);
        return ResponseEntity.ok("Bien eliminado correctamente");
    }

    // Buscar por descripción
    @GetMapping("/buscar/{descripcion}")
    public ResponseEntity<List<TwBien>> findByDescripcion(@PathVariable String descripcion) {
        return ResponseEntity.ok(bienService.findByDescripcion(descripcion));
    }
}
