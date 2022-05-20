package com.oospina.pruebabackend.controllers;

import com.oospina.pruebabackend.dtos.CriteriaDto;
import com.oospina.pruebabackend.services.ITareaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    private final ITareaService service;

    public TareaController(ITareaService service) {
        this.service = service;
    }

    @ApiOperation( value = "Encargado de buscar una tares en criterio de fecha y por el id")
    @GetMapping
    public ResponseEntity<Object> buscarTarea(
            @RequestParam(value = "from_fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromFecha,
            @RequestParam(value = "to_fecha")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toFecha,
            @RequestParam(value = "id_usuario", required = false) Long idUsuario) {
        try {
            CriteriaDto criteria = new CriteriaDto(fromFecha, toFecha, idUsuario);
            return ResponseEntity.ok(this.service.buscarPorCriterio(criteria));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
