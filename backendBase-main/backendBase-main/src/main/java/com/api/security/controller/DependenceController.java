package com.api.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TcDependence;
import com.api.security.service.DependenceService;

@RestController
@RequestMapping("/api/dependencias")
@CrossOrigin(origins = "*")
public class DependenceController {

    @Autowired
    private DependenceService dependenciaService;

    @PostMapping
    public ResponseEntity<TcDependence> guardar(@RequestBody TcDependence dependencia) {
        return ResponseEntity.ok(dependenciaService.guardar(dependencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TcDependence> actualizar(
            @PathVariable Long id,
            @RequestBody TcDependence dependencia) {
        return ResponseEntity.ok(dependenciaService.actualizar(id, dependencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        dependenciaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TcDependence> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(dependenciaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TcDependence>> listarTodos() {
        return ResponseEntity.ok(dependenciaService.listarTodos());
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<TcDependence>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(dependenciaService.buscarPorNombre(nombre));
    }

    @GetMapping("/buscar/responsable")
    public ResponseEntity<List<TcDependence>> buscarPorResponsable(@RequestParam String responsable) {
        return ResponseEntity.ok(dependenciaService.buscarPorResponsable(responsable));
    }

    @GetMapping("/buscar/ubicacion")
    public ResponseEntity<List<TcDependence>> buscarPorUbicacion(@RequestParam String ubicacion) {
        return ResponseEntity.ok(dependenciaService.buscarPorUbicacion(ubicacion));
    }

    @GetMapping("/buscar/departamento/{idDepartamento}")
    public ResponseEntity<List<TcDependence>> buscarPorDepartamento(@PathVariable Long idDepartamento) {
        return ResponseEntity.ok(dependenciaService.buscarPorDepartamento(idDepartamento));
    }
}
