package com.oospina.pruebabackend.controllers;

import com.oospina.pruebabackend.dtos.UsuarioDto;
import com.oospina.pruebabackend.services.IUsuariosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuariosService service;

    public UsuarioController(IUsuariosService service) {
        this.service = service;
    }

    @ApiOperation( value = "Encargado de crear un usuario")
    @PostMapping
    public ResponseEntity<Object> crear(@RequestBody UsuarioDto dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation( value = "Encargado de actualizar un usuario")
    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizar(
            @PathVariable("id") Long id, @RequestBody UsuarioDto dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.actualizar(id, dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation( value = "Encargado de buscar por el id de un usuario")
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaPorId(
            @PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation( value = "Obtiene todos los  usuarios")
    @GetMapping
    public ResponseEntity<Object> buscaTodo() {
        try {
            return ResponseEntity.ok(service.listar());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation( value = "Encargado de eliminar un usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(
            @PathVariable("id") Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Usuario eliminado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
    }
}
