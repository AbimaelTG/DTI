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
    public ResponseEntity<TcUsuario> crear(@RequestBody TcUsuario usuario) {
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TcUsuario> actualizar(@PathVariable Long id, @RequestBody TcUsuario usuario) {
        return ResponseEntity.ok(usuarioService.actualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TcUsuario> obtenerPorId(@PathVariable Long id) {
        TcUsuario usuario = usuarioService.buscarPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TcUsuario>> listar() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<TcUsuario> buscarPorCorreo(@PathVariable String correo) {
        TcUsuario usuario = usuarioService.buscarPorCorreo(correo);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }
}
