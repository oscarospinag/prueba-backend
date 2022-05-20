package com.oospina.pruebabackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
public @Data
class TareaDto {
    private String nombre;
    private String descripcion;
    private LocalDate fecha;

    public TareaDto() {
    }
}
