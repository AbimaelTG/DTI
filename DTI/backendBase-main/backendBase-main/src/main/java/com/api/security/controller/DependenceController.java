package com.api.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TcDependence;
import com.api.security.service.DependenceService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")

public class DependenceController {

    @Autowired
    private DependenceService dependenceService;

    // ---------------- CREAR ----------------
    @PostMapping("dependence")
    public ResponseEntity<?> store(@RequestBody TcDependence dependencia, BindingResult bindingResult) {

        System.out.println("Datos de nueva dependencia: " + dependencia);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
        }

        try {
            dependenceService.guardar(dependencia);
            return new ResponseEntity<>("Dependencia creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear dependencia: " + e.getMessage());
            return new ResponseEntity<>("Error interno al crear la dependencia", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ---------------- ACTUALIZAR ----------------
    @PutMapping("dependence/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TcDependence dependencia,
            BindingResult bindingResult) {

        System.out.println("Datos para actualizar dependencia: " + dependencia);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
        }

        TcDependence existente = dependenceService.buscarPorId(id);

        if (existente == null) {
            return new ResponseEntity<>("La dependencia no existe", HttpStatus.NOT_FOUND);
        }

        try {
            dependenceService.actualizar(id, dependencia);
            return new ResponseEntity<>("Dependencia actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error al actualizar dependencia: " + e.getMessage());
            return new ResponseEntity<>("Error interno al actualizar la dependencia", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ---------------- ELIMINAR ----------------
    @DeleteMapping("/dependence/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        try {
            dependenceService.eliminar(id);
            return ResponseEntity.ok("Dependencia eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la dependencia: " + e.getMessage());
        }
    }

    // ---------------- CONSULTAR ----------------
    @GetMapping("/dependences")
    public ResponseEntity<?> getDependencias(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String responsable,
            @RequestParam(required = false) String ubicacion,
            @RequestParam(required = false) Long idDepartamento) {

        try {
            // Búsqueda por nombre
            if (nombre != null && !nombre.isEmpty()) {
                System.out.println("Buscando dependencias por nombre: " + nombre);
                return ResponseEntity.ok(dependenceService.buscarPorNombre(nombre));
            }

            // Búsqueda por responsable
            if (responsable != null && !responsable.isEmpty()) {
                System.out.println("Buscando dependencias por responsable: " + responsable);
                return ResponseEntity.ok(dependenceService.buscarPorResponsable(responsable));
            }

            // Búsqueda por ubicación
            if (ubicacion != null && !ubicacion.isEmpty()) {
                System.out.println("Buscando dependencias por ubicación: " + ubicacion);
                return ResponseEntity.ok(dependenceService.buscarPorUbicacion(ubicacion));
            }

            // Búsqueda por departamento
            if (idDepartamento != null) {
                System.out.println("Buscando dependencias por departamento ID: " + idDepartamento);
                return ResponseEntity.ok(dependenceService.buscarPorDepartamento(idDepartamento));
            }

            // Si no hay filtros, lista todo
            System.out.println("Listando todas las dependencias");
            return ResponseEntity.ok(dependenceService.listarTodos());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener dependencias: " + e.getMessage());
        }
    }

    // ---------------- BUSCAR POR ID INDIVIDUAL ----------------
    @GetMapping("/dependence/{id}")
    public ResponseEntity<?> getDependenciaById(@PathVariable Long id) {

        try {
            TcDependence dependencia = dependenceService.buscarPorId(id);

            if (dependencia == null) {
                return new ResponseEntity<>("Dependencia no encontrada", HttpStatus.NOT_FOUND);
            }

            return ResponseEntity.ok(dependencia);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener la dependencia: " + e.getMessage());
        }
    }
}
