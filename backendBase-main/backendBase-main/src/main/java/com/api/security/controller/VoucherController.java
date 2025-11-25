package com.api.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TwVoucher;
import com.api.security.service.VoucherService;

@RestController
@RequestMapping("/api/comprobante")
@CrossOrigin(origins = "*")
public class VoucherController {

    @Autowired
    private VoucherService comprobanteService;

    // Crear comprobante
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TwVoucher comprobante) {
        TwVoucher nuevo = comprobanteService.save(comprobante);
        return ResponseEntity.ok(nuevo);
    }

    // Obtener todos
    @GetMapping
    public ResponseEntity<List<TwVoucher>> getAll() {
        return ResponseEntity.ok(comprobanteService.findAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<TwVoucher> comp = comprobanteService.findById(id);

        if (comp.isEmpty()) {
            return ResponseEntity.status(404).body("Comprobante no encontrado");
        }

        return ResponseEntity.ok(comp.get());
    }

    // Buscar por idAsignacion
    @GetMapping("/asignacion/{idAsignacion}")
    public ResponseEntity<List<TwVoucher>> getByIdAsignacion(@PathVariable Long idAsignacion) {
        return ResponseEntity.ok(comprobanteService.findByIdAsignacion(idAsignacion));
    }

    // Actualizar comprobante
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TwVoucher datos) {
        Optional<TwVoucher> optional = comprobanteService.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Comprobante no encontrado");
        }

        TwVoucher comprobante = optional.get();

        comprobante.setIdAsignacion(datos.getIdAsignacion());
        comprobante.setFechaEmision(datos.getFechaEmision());

        return ResponseEntity.ok(comprobanteService.save(comprobante));
    }

    // Eliminar comprobante
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<TwVoucher> comp = comprobanteService.findById(id);

        if (comp.isEmpty()) {
            return ResponseEntity.status(404).body("Comprobante no encontrado");
        }

        comprobanteService.deleteById(id);
        return ResponseEntity.ok("Comprobante eliminado correctamente");
    }
}
