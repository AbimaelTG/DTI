package com.api.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TwComprobante;
import com.api.security.service.ComprobanteService;

@RestController
@RequestMapping("/api/comprobantes")
@CrossOrigin(origins = "*")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    // Crear comprobante
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TwComprobante comprobante) {
        TwComprobante nuevo = comprobanteService.save(comprobante);
        return ResponseEntity.ok(nuevo);
    }

    // Obtener todos
    @GetMapping
    public ResponseEntity<List<TwComprobante>> getAll() {
        return ResponseEntity.ok(comprobanteService.findAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<TwComprobante> comp = comprobanteService.findById(id);

        if (comp.isEmpty()) {
            return ResponseEntity.status(404).body("Comprobante no encontrado");
        }

        return ResponseEntity.ok(comp.get());
    }

    // Buscar por idAsignacion
    @GetMapping("/asignacion/{idAsignacion}")
    public ResponseEntity<List<TwComprobante>> getByIdAsignacion(@PathVariable Long idAsignacion) {
        return ResponseEntity.ok(comprobanteService.findByIdAsignacion(idAsignacion));
    }

    // Actualizar comprobante
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TwComprobante datos) {
        Optional<TwComprobante> optional = comprobanteService.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Comprobante no encontrado");
        }

        TwComprobante comprobante = optional.get();

        comprobante.setIdAsignacion(datos.getIdAsignacion());
        comprobante.setFechaEmision(datos.getFechaEmision());

        return ResponseEntity.ok(comprobanteService.save(comprobante));
    }

    // Eliminar comprobante
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<TwComprobante> comp = comprobanteService.findById(id);

        if (comp.isEmpty()) {
            return ResponseEntity.status(404).body("Comprobante no encontrado");
        }

        comprobanteService.deleteById(id);
        return ResponseEntity.ok("Comprobante eliminado correctamente");
    }
}
