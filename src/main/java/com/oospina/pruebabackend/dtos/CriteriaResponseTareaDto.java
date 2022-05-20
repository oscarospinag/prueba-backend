package com.oospina.pruebabackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
public @Data
class CriteriaResponseTareaDto {
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private Long idUsuario;

    public CriteriaResponseTareaDto() {
    }

}
