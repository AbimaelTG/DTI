
package com.api.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.api.security.dto.GoodDto;
import com.api.security.model.TwGood;
import com.api.security.service.GoodsService;

@RestController
@RequestMapping("good")
@CrossOrigin(origins = "http://localhost:4200/")
public class GoodsController {

    @Autowired
    private GoodsService goodService;

    // Crear bien
    @PostMapping
    public ResponseEntity<?> store(@RequestBody GoodDto good, BindingResult bindingResult) {

      System.out.println("Datos de nueva categoria: " + good);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
        }
        try {
            goodService.save(good);
            return new ResponseEntity<>("Categoria creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GoodDto good, BindingResult bindingResult) {
        System.out.println("Datos de nueva categoria: " + good);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
        }
        try {
            goodService.update(id, good);
            return new ResponseEntity<>("Categoria actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<TwGood>> getAll() {
        return ResponseEntity.ok(goodService.findAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<TwGood> bien = goodService.findById(id);

        if (bien.isEmpty()) {
            return ResponseEntity.status(404).body("Bien no encontrado");
        }

        return ResponseEntity.ok(bien.get());
    }
    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBien(@PathVariable Long id) {
        Optional<TwGood> bien = goodService.findById(id);

        if (bien.isEmpty()) {
            return ResponseEntity.status(404).body("Bien no encontrado");
        }

        goodService.deleteById(id);
        return ResponseEntity.ok("Bien eliminado correctamente");
    }

    // Buscar por descripción
    @GetMapping("/buscar/{descripcion}")
    public ResponseEntity<List<TwGood>> findByDescripcion(@PathVariable String descripcion) {
        return ResponseEntity.ok(goodService.findByDescripcion(descripcion));
    }
}
