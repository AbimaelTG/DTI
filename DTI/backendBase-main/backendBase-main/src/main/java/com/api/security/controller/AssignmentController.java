package com.api.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.api.security.dto.AssignmentDto;
import com.api.security.service.AssignmentService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")

public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // ------------------------------------------------------
    //                     CREATE
    // ------------------------------------------------------
    @PostMapping("/assignment")
public ResponseEntity<?> store(@RequestBody AssignmentDto asignacion, BindingResult bindingResult) {
    System.out.println("Datos de nueva asignación: " + asignacion);

    if (bindingResult.hasErrors()) {
        return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
    }

    try {
        assignmentService.save(asignacion);
        return new ResponseEntity<>("Asignación creada exitosamente", HttpStatus.CREATED);

    } catch (IllegalArgumentException e) {
        // Aquí entran tus validaciones personalizadas
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    } catch (Exception e) {
        // Errores inesperados
        e.printStackTrace();
        return new ResponseEntity<>("Error interno al crear la asignación", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    // ------------------------------------------------------
    //                     UPDATE
    // ------------------------------------------------------
    @PutMapping("assignment/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody AssignmentDto datos,
            BindingResult bindingResult) {

        System.out.println("Datos para actualizar asignación: " + datos);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos incorrectos", HttpStatus.BAD_REQUEST);
        }

        try {
            assignmentService.update(id, datos);
            return new ResponseEntity<>("Asignación actualizada exitosamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("La asignación no existe", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.err.println("Error al actualizar asignación: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Error interno al actualizar la asignación", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ------------------------------------------------------
    //                     DELETE
    // ------------------------------------------------------
    @DeleteMapping("assignment/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            assignmentService.delete(id);
            return ResponseEntity.ok("Asignación eliminada exitosamente");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("La asignación no existe", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno al eliminar la asignación", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ------------------------------------------------------
    //                     GET ALL
    // ------------------------------------------------------
    @GetMapping("assignments")
    public ResponseEntity<?> getAsignaciones(@RequestParam(required = false) Integer idUsuario) {
        try {
            if (idUsuario != null) {
                System.out.println("Buscando asignaciones del usuario: " + idUsuario);
                return ResponseEntity.ok(assignmentService.getByUsuario(idUsuario));
            } else {
                System.out.println("Buscando todas las asignaciones");
                return ResponseEntity.ok(assignmentService.getAll());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener las asignaciones: " + e.getMessage());
        }
    }

    // ------------------------------------------------------
    //               GET ONE
    // ------------------------------------------------------
    @GetMapping("assignment/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(assignmentService.getById(id));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("La asignación no existe", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno al obtener la asignación", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
