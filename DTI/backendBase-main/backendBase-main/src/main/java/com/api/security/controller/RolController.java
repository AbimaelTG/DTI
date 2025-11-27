package com.api.security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.enums.RolNombre;
import com.api.security.model.TcRol;
import com.api.security.service.RolServiceImpl;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200/")
public class RolController {

    @Autowired
    private RolServiceImpl rolService;

    /**
     * Obtener todos los roles
     */
    @GetMapping
    public ResponseEntity<?> listarRoles() {
        return ResponseEntity.ok(rolService.getAll());
    }

    /**
     * Obtener rol por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<TcRol> rol = rolService.getById(id);
        return rol.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Obtener rol por nombre
     */
    @GetMapping("/nombre/{rolNombre}")
    public ResponseEntity<?> obtenerPorNombre(@PathVariable String rolNombre) {
        try {
            RolNombre nombreEnum = RolNombre.valueOf(rolNombre.toUpperCase());
            Optional<TcRol> rol = rolService.getByRolNombre(nombreEnum);
            return rol.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                                 .body("Rol inválido: " + rolNombre);
        }
    }

    /**
     * Crear rol
     */
    @PostMapping
    public ResponseEntity<?> crearRol(@RequestBody TcRol rol) {
        TcRol nuevoRol = rolService.save(rol);
        return ResponseEntity.ok(nuevoRol);
    }

    /**
     * Eliminar rol
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!rolService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rolService.deleteById(id);
        return ResponseEntity.ok("Rol eliminado correctamente");
    }
}
