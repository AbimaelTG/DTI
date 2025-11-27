package com.api.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TrRolUser;
import com.api.security.service.RolUserService;

@RestController
@RequestMapping("/api/rol-usuario")
@CrossOrigin(origins = "http://localhost:4200/")
public class RolUsuarioController {

    @Autowired
    private RolUserService service;

    // Obtener todos
    @GetMapping("/list")
    public ResponseEntity<List<TrRolUser>> listAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Obtener uno por ID compuesto
    @GetMapping("/{idRol}/{idUsuario}")
    public ResponseEntity<?> getOne(@PathVariable Integer idRol, @PathVariable Integer idUsuario) {
        return service.getById(idRol, idUsuario)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body("No existe esa relación rol-usuario"));
    }

    // Crear relación rol-usuario
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TrRolUser trRolUsuario) {
        Integer idRol = trRolUsuario.getId().getIdRol();
        Integer idUsuario = trRolUsuario.getId().getIdUsuario();

        if (service.exists(idRol, idUsuario)) {
            return ResponseEntity.badRequest().body("La relación ya existe");
        }

        return ResponseEntity.ok(service.save(trRolUsuario));
    }

    // Eliminar relación
    @DeleteMapping("/delete/{idRol}/{idUsuario}")
    public ResponseEntity<?> delete(@PathVariable Integer idRol, @PathVariable Integer idUsuario) {
        if (!service.exists(idRol, idUsuario)) {
            return ResponseEntity.badRequest().body("No existe la relación a eliminar");
        }
        service.delete(idRol, idUsuario);
        return ResponseEntity.ok("Relación eliminada exitosamente");
    }
}
