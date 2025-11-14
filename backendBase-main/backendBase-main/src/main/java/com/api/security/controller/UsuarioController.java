package com.api.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.security.model.TcUsuario;
import com.api.security.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<TcUsuario> guardar(@RequestBody TcUsuario usuario) {
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TcUsuario> actualizar(
            @PathVariable Long id,
            @RequestBody TcUsuario usuario) {
        return ResponseEntity.ok(usuarioService.actualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TcUsuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TcUsuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/correo")
    public ResponseEntity<TcUsuario> buscarPorCorreo(@RequestParam String correo) {
        return ResponseEntity.ok(usuarioService.buscarPorCorreo(correo));
    }

    @GetMapping("/existe-correo")
    public ResponseEntity<Boolean> existeCorreo(@RequestParam String correo) {
        return ResponseEntity.ok(usuarioService.existeCorreo(correo));
    }
}
