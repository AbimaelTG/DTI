package com.api.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.security.dto.VoucherDto;
import com.api.security.model.TwVoucher;
import com.api.security.service.AssignmentService;
import com.api.security.service.VoucherService;

@RestController
@RequestMapping("/api/comprobante")
@CrossOrigin(origins = "http://localhost:4200/")
public class VoucherController {

    @Autowired
    private VoucherService comprobanteService;

    @Autowired
    private AssignmentService asignacionService; // Servicio para validar asignaciones

    // Crear comprobante
    @PostMapping
    public ResponseEntity<?> create(@RequestBody VoucherDto comprobante) {
        // Validaciones
        if (comprobante.getFechaEmision() == null) {
            return ResponseEntity.badRequest().body("La fecha de emisión es obligatoria");
        }

        if (comprobante.getIdAsignacion() == null || 
            !asignacionService.existsById(comprobante.getIdAsignacion())) {
            return ResponseEntity.badRequest().body("La asignación no existe");
        }

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
    public ResponseEntity<?> getByIdAsignacion(@PathVariable Long idAsignacion) {
        if (!asignacionService.existsById(idAsignacion)) {
            return ResponseEntity.status(404).body("Asignación no encontrada");
        }

        List<TwVoucher> vouchers = comprobanteService.findByIdAsignacion(idAsignacion);
        return ResponseEntity.ok(vouchers);
    }

    // Actualizar comprobante
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TwVoucher datos) {
        Optional<TwVoucher> optional = comprobanteService.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Comprobante no encontrado");
        }

        // Validaciones
        if (datos.getFechaEmision() == null) {
            return ResponseEntity.badRequest().body("La fecha de emisión es obligatoria");
        }

        if (datos.getIdAsignacion() == null || 
            !asignacionService.existsById(datos.getIdAsignacion())) {
            return ResponseEntity.badRequest().body("La asignación no existe");
        }

        TwVoucher comprobante = optional.get();
        comprobante.setIdAsignacion(datos.getIdAsignacion());
        comprobante.setFechaEmision(datos.getFechaEmision());

        return ResponseEntity.ok(comprobanteService.saveEntity(comprobante));
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
