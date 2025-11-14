package com.api.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TcDependencia;
import com.api.security.service.DependenciaService;

@RestController
@RequestMapping("/api/dependencias")
@CrossOrigin(origins = "*")
public class DependenciaController {

    @Autowired
    private DependenciaService dependenciaService;

    @PostMapping
    public ResponseEntity<TcDependencia> guardar(@RequestBody TcDependencia dependencia) {
        return ResponseEntity.ok(dependenciaService.guardar(dependencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TcDependencia> actualizar(
            @PathVariable Long id,
            @RequestBody TcDependencia dependencia) {
        return ResponseEntity.ok(dependenciaService.actualizar(id, dependencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        dependenciaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TcDependencia> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(dependenciaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TcDependencia>> listarTodos() {
        return ResponseEntity.ok(dependenciaService.listarTodos());
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<TcDependencia>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(dependenciaService.buscarPorNombre(nombre));
    }

    @GetMapping("/buscar/responsable")
    public ResponseEntity<List<TcDependencia>> buscarPorResponsable(@RequestParam String responsable) {
        return ResponseEntity.ok(dependenciaService.buscarPorResponsable(responsable));
    }

    @GetMapping("/buscar/ubicacion")
    public ResponseEntity<List<TcDependencia>> buscarPorUbicacion(@RequestParam String ubicacion) {
        return ResponseEntity.ok(dependenciaService.buscarPorUbicacion(ubicacion));
    }

    @GetMapping("/buscar/departamento/{idDepartamento}")
    public ResponseEntity<List<TcDependencia>> buscarPorDepartamento(@PathVariable Long idDepartamento) {
        return ResponseEntity.ok(dependenciaService.buscarPorDepartamento(idDepartamento));
    }
}
